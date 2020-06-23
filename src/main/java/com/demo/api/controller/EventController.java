/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.api.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.api.Event;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Hy
 */
@Controller
public class EventController {
    private final String strGitEventURI = "https://api.github.com/repos/";
    private final RestTemplate restTmpl = new RestTemplate();
    
    private boolean isStringValid( String strInput) {
        return(strInput != null && strInput.trim().length() > 0);
    }
    
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to GitHub API!");
        return "search";
    }
    
    @RequestMapping("results")
    public String results(@RequestParam("owner") String strOwner,
                          @RequestParam("reposname") String strReposname,
                          @RequestParam("giteventtypes") String strSelectedEventType, 
                          Model model) {
        
        String strFullURL = strGitEventURI + strOwner + "/" + strReposname + "/" + "events";
        String strJsonData = restTmpl.getForObject(strFullURL, String.class);
        
        List<Map> maps;
        String strActualEventType;
        try {
            ObjectMapper mapper = new ObjectMapper();
            maps = mapper.reader()
                    .forType(new TypeReference<List<Map>>() {})
                    .readValue(strJsonData);
            
            if (isStringValid(strSelectedEventType))
                strSelectedEventType = strSelectedEventType.trim() + "Event";
            else
                strSelectedEventType = "";
            
            Integer numMatchingEvents = 0;
            Map<String, Object> actorInfoMap;
            List<Event> eventList = new ArrayList();
            for(Map<String,Object> eventMap : maps) {
                strActualEventType = eventMap.get("type").toString();
                if (isStringValid(strSelectedEventType) && isStringValid(strActualEventType)) {
                    if (strSelectedEventType.equalsIgnoreCase(strActualEventType)) {
                        actorInfoMap = (Map<String,Object>)eventMap.get("actor");
                        
                        if (actorInfoMap.size() > 0) {
                            Event event = new Event();
                            event.setId((Integer)actorInfoMap.get("id"));
                            event.setLogin(actorInfoMap.get("login").toString());
                            event.setEventType(strActualEventType);
                            event.setTimeStamp(eventMap.get("created_at").toString());
                            event.setAvatarURL(actorInfoMap.get("avatar_url").toString());
                            event.setGravatarId(actorInfoMap.get("gravatar_id").toString());
                            event.setURL(actorInfoMap.get("url").toString());
                            event.setDisplayLogin(actorInfoMap.get("display_login").toString());
                            eventList.add(event);
                            numMatchingEvents++;
                        }
                    }
                }
            } //end of looping through event maps
            
            String strMessage;
            if (numMatchingEvents > 0) {
                strMessage = numMatchingEvents + " '" + strSelectedEventType + "' were found.";
            }
            else {
                strMessage = "No activities were found for the selected event type: " + strSelectedEventType + " <br>";
            }
            model.addAttribute("message", strMessage);
            model.addAttribute("eventList", eventList);
        }
        catch (IOException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "results";
    }
}
