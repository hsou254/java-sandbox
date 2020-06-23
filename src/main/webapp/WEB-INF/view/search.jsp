<%-- 
    Document   : index
    Created on : Jun 20, 2020, 1:05:32 PM
    Author     : Hy
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search For Repository Events by Type (This sucks!)</title>
        <style>
            table.center {
                margin-left: auto;
                margin-right: auto;
                margin-top: auto;
                margin-bottom: auto;
            }
            td {
                text-align: left;
            }
            th {
                text-align: right;
                background-color: aquamarine;
            }
        </style>
    </head>
    <body>
        <div>
            <div>
                <form action="results"><br><br>
                    <table class="center">
                        <thead>
                            <tr>
                                <td colspan="2">Search for GIT activities in repository:</td>
                            </tr>
                        </thead>
                        <tr>
                            <th><label for="owner">Owner:</label></th>
                            <td><input type="text" id="owner" name="owner"/><br></td>
                        </tr>
                        <tr>
                            <th><label for="reposname">Repository:</label></th>
                            <td><input type="text" id="reposname" name="reposname"/><br></td>
                        </tr>
                        <tr>
                            <th><label for="giteventtypes">Choose an event type:</label></th>
                            <td>
                                <select id="giteventtypes" name="giteventtypes">
                                    <option value="CommitComment">Commit Comment</option>
                                    <option value="Create">Create</option>
                                    <option value="Delete">Delete</option>
                                    <option value="Fork">Fork</option>
                                    <option value="Gollum">Gollum</option>
                                    <option value="IssueComment">Issue Comment</option>
                                    <option value="Issues">Issues</option>
                                    <option value="Member">Member</option>
                                    <option value="Public">Public</option>
                                    <option value="PullRequest">Pull Request</option>
                                    <option value="PullRequestReviewComment">Pull Request Review Comment</option>
                                    <option value="Push">Push</option>
                                    <option value="Release">Release</option>
                                    <option value="Sponsorship">Sponsorship</option>
                                    <option value="Watch">Watch</option>
                                </select>
                            </td>
                        </tr>
                        <tr><td colspan="2">&nbsp;</td></tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Search"/><br></td>
                        </tr>
                    </table>
                    <br><br>
                </form>
            </div>
        </div>
    </body>
</html>
