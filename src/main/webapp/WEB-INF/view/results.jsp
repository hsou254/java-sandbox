<%-- 
    Document   : results
    Created on : Jun 22, 2020, 1:08:05 PM
    Author     : Hy Sou
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.demo.api.Event "%>
<% ArrayList<Event> eventList = (ArrayList<Event>)request.getAttribute("eventList"); %>
<% Event event; %>
<!DOCTYPE html>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Github Event Search Results:</h1><br>
            <h3>${message}</h3>
            <table>
                <thead>
                    <th>Actor Id</th>
                    <th>Login</th>
                    <th>Display Login</th>
                    <th>Timestamp</th>
                    <th>Event Type</th>
                    <th>Gravatar Id</th>
                    <th>URL</th>
                    <th>Avatar URL</th>
                </thead>
                <% for (int i = 0; i < eventList.size(); i++) { %>
                    <% event = (Event)eventList.get(i); %>
                <tr>
                    <td><%= event.getId() %></td>
                    <td><%= event.getLogin() %></td>
                    <td><%= event.getDisplayLogin() %></td>
                    <td><%= event.getTimeStamp() %></td>
                    <td><%= event.getEventType() %></td>
                    <td><%= event.getGravatarId() %></td>
                    <td><%= event.getURL() %></td>
                    <td><%= event.getAvatarURL() %></td>
                </tr>
                <% } %>
            </table><br><br>
            Click on this <strong><a href="./">link</a></strong> to visit search page.
        </div>
    </div>
</body>
</html>