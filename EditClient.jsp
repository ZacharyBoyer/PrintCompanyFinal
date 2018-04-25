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
        <form action="updateClient" method="post" name="editClientForm">
                <table cellpadding="5" border="1">
                     <th>Client Id</th>
                        <td>
                            <input type="hidden" readonly="true" name="id" id="id" value="${client.getId()}"/>
                            ${client.getId()}
                        </td>  
                    <tr>
                        <th>Agent Id</th>
                        <td><input class="inputField ripple" type="number" name="AgentId" id="AgentId" required value="${client.getAgentId()}"></td>
                    </tr>
                      <tr>
                        <th>First Name</th>
                        <td><input class="inputField ripple" type="text" name="FName" id="FName" required value="${client.getFirstName()}"></td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><input class="inputField ripple" type="text" name="LName" id="LName" required value="${client.getLastName()}"></td>
                    </tr>
                      <tr>
                        <th>Street Number</th>
                        <td><input class="inputField ripple" type="number" name="SNum" id="SNum" required value="${client.getStreetNumber()}"></td>
                    </tr>
                      <tr>
                        <th>Street Name</th>
                        <td><input class="inputField ripple" type="text" name="SName" id="SName" required value="${client.getStreetName()}"></td>
                    </tr>
                      <tr>
                        <th>City</th>
                        <td><input class="inputField ripple" type="text" name="City" id="City" required value="${client.getCity()}"></td>
                    </tr>
                      <tr>
                        <th>Province</th>
                        <td><input class="inputField ripple" type="text" name="Province" id="Province" required value="${client.getProvince()}"></td>
                    </tr>
                      <tr>
                        <th>Postal Code</th>
                        <td><input class="inputField ripple"  type="text" name="Postal" id="Postal" required value="${client.getPostalCode()}"></td>
                    </tr>
                      <tr>
                        <th>Office Number</th>
                        <td><input class="inputField ripple" type="tel"  placeholder="123-457-8901" size="13" minlength="10" maxlength="13" name="ONum" id="ONum" required value="${client.getTelOffice()}"></td>
                    </tr>
                      <tr>
                        <th>Cell Phone Number</th>
                        <td><input class="inputField ripple" type="tel"  placeholder="123-457-8901" size="13" minlength="10" maxlength="13" name="CNum" id="CNum" required value="${client.getTelCell()}"></td>
                    </tr>
                      <tr>
                        <th>Email</th>
                        <td><input class="inputField ripple" type="email" value="default@example.com"  name="Email" id="Email" requiredvalue="${client.getEmail()}"></td>
                    </tr>
                      <tr>
                        <th>Company Name</th>
                        <td><input class="inputField ripple" type="text" name="CName" id="CName" required value="${client.getCompany()}"> </td>
                    </tr>
                      <tr>
                        <th>Company Type</th>
                        <td><input class="inputField ripple" type="text" name="CType" id="CType" required value="${client.getCompanyType()}"></td>
                    </tr>
                    <td colspan="2"><input class="button ripple" style="float:right" type="submit" name="submit" value="Update"></td>
                </table>
            </form>
    </body>
</html>
