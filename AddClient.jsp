<%-- 
    Document   : AddClient
    Created on : Apr 2, 2018, 11:00:49 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        <%@include file="/style.css" %>
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addClient" method="post" name="registerForm">
                <table cellpadding="5" border="1">
                      <tr>
                        <th>Agent Id</th>
                      <input hidden="true" type="number" name="AgentId" id="AgentId" value="${userId}" required>
                        <td>${userId}</td>
                    </tr>
                      <tr>
                        <th>First Name</th>
                        <td><input class="inputField ripple" type="text" name="FName" id="FName" required></td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><input class="inputField ripple" type="text" name="LName" id="LName" required></td>
                    </tr>
                      <tr>
                        <th>Street Number</th>
                        <td><input class="inputField ripple" type="number" name="SNum" id="SNum" required></td>
                    </tr>
                      <tr>
                        <th>Street Name</th>
                        <td><input class="inputField ripple" type="text" name="SName" id="SName" required></td>
                    </tr>
                      <tr>
                        <th>City</th>
                        <td><input class="inputField ripple" type="text" name="City" id="City" required></td>
                    </tr>
                      <tr>
                        <th>Province</th>
                        <td><input class="inputField ripple" type="text" name="Province" id="Province" required></td>
                    </tr>
                      <tr>
                        <th>Postal Code</th>
                        <td><input class="inputField ripple" type="text" name="Postal" id="Postal" required></td>
                    </tr>
                      <tr>
                        <th>Office Number</th>
                        <td><input class="inputField ripple" type="tel"  placeholder="123-457-8901" size="13" minlength="10" maxlength="13" name="ONum" id="ONum" required></td>
                    </tr>
                      <tr>
                        <th>Cell Phone Number</th>
                        <td><input class="inputField ripple" type="tel"  placeholder="123-457-8901" size="13" minlength="10" maxlength="13" name="CNum" id="CNum" required></td>
                    </tr>
                      <tr>
                        <th>Email</th>
                        <td><input class="inputField ripple" type="email" value="default@example.com"  name="Email" id="Email" required></td>
                    </tr>
                      <tr>
                        <th>Company Name</th>
                        <td><input class="inputField ripple" type="text" name="CName" id="CName" required></td>
                    </tr>
                      <tr>
                        <th>Company Type</th>
                        <td><input class="inputField ripple" type="text" name="CType" id="CType" required></td>
                    </tr>
                    <td colspan="2"><input class="button ripple" style="float:right"  type="submit" name="submit" value="Add"></td>
                </table>
            </form>
    </body>
</html>
