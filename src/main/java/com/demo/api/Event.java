/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.api;

/**
 *
 * @author Hy
 */
public class Event {
    private Integer id;
    private String login;
    private String displayLogin;
    private String gravatarId;
    private String URL;
    private String avatarURL;
    private String eventType;
    private String TimeStamp;
    
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String EventType) {
        this.eventType = EventType;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String TimeStamp) {
        this.TimeStamp = TimeStamp;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDisplayLogin() {
        return displayLogin;
    }

    public void setDisplayLogin(String displayLogin) {
        this.displayLogin = displayLogin;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    @Override
    public String toString() {
        return "Actor{" + "Id=" + id + ", login=" + login + ", displayLogin=" + displayLogin + ", gravatarId=" + gravatarId + ", URL=" + URL + ", avatarURL=" + avatarURL + '}';
    }
}
