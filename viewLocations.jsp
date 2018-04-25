<%-- 
    Created on : Apr 22, 2018
    Author     : Alessandro S
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Location"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
         <a href="">Home</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
         <a href="newLoc">Add new Location</a>
         &nbsp;&nbsp;&nbsp;&nbsp;
         <a href="locList">View Locations</a>
         &nbsp;&nbsp;&nbsp;&nbsp;
         <a href="logout">Logout</a>
        </center>
    </br>
         <h1>List of locations</h1>
            <table cellpadding="5" border="1">
                <thead>
                    <th>id</th>
                    <th>name</th>
                    <th>cap</th>
                </thead>
                 <tbody>
        <c:forEach var="location" items="${locList}">
                    <tr>
                        <td><c:out value="${location.id}"/></td>
                        <td><c:out value="${location.locationName}"/></td>
                        <td><c:out value="${location.distrCap}"/></td>
                         <td><a href="editLoc?id=<c:out value='${location.id}'/>">
                                Edit
                            </a>
                                &nbsp;&nbsp;&nbsp;
                            <a href="deleteLoc?id=<c:out value='${location.id}'/>">
                                Delete
                            </a>
</tr>
        </c:forEach>
</tbody>
    </table>
</body>
</html>
