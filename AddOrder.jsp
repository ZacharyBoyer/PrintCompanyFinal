<%-- 
    Document   : AddClient
    Created on : Apr 2, 2018, 11:00:49 PM
    Author     : Zach
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
        <form action="addOrder" method="post" name="registerForm">
                <table cellpadding="5" border="1">
                      <tr>
                        <th>Agent Id</th>
                        <input hidden="true" type="number" name="AgentId" id="AgentId" value="${userId}" required>
                        <td>${userId}</td>
                    </tr>
                    <tr>
                        <th>Client</th>
                        <td>
                        <select id="clientId" name="clientId">
                       <c:forEach var="client" items="${clientNames}">
                           <option value="<c:out value="${client.id}"/>"><c:out value="ID ${client. id} Name: ${client.firstName} ${client.lastName} "/></option>
                        </c:forEach>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Flyer Quantity</th>
                        <td><input class="inputField ripple" type="number" name="flyerQty" id="flyerQty" required></td>
                    </tr>
                      <tr>
                        <th>Flyer Layout</th>
                        <td><input class="inputField ripple" type="text" name="flyerLayout" id="flyerLayout" required></td>
                    </tr>
                      <tr>
                        <th>Flyer Image</th>
                        <td><input class="inputField ripple" type="file" name="FlyerImg" id="FlyerImg" required></td>
                    </tr>
                      <tr>
                        <th>Personal Copies</th>
                        <td><input class="inputField ripple" type="number" name="personalCopy" id="personalCopy" required></td>
                    </tr>
                      <tr>
                        <th>Payment Information</th>
                        <td><input class="inputField ripple" type="text" name="paymentInformation" id="paymentInformation" required></td>
                    </tr>
                      <tr>
                        <th>Invoice Number</th>
                        <td><input class="inputField ripple" type="text" name="invoiceNumber" id="invoiceNumber" required></td>
                    </tr>
                      <tr>
                        <th>Comments</th>
                        <td><input class="inputField ripple" type="text" name="comments" id="comments" required></td>
                    </tr>
                      <tr>
                        <th>Flyer Art Approval</th>
                        <td><input class="inputField ripple" type="checkbox" name="isFlyerArtApproved" id="isFlyerArtApproved" ></td>
                    </tr>
                      <tr>
                        <th>Payment Recived </th>
                        <td><input class="inputField ripple" type="checkbox" name="isPaymentRecived" id="isPaymentRecived" ></td>
                        </tr>
                      <tr>
                        <th>Location</th>
                        <td>
                            <select id="loc" name="loc" multiple>
                       <c:forEach var="location" items="${LocNames}">
                           <option value="<c:out value="${location.id}"/>"><c:out value="${location.locationName}"/></option>
                        </c:forEach>
                        </select>
                            </br>
                            To Select Multiple Locations </br>
                             Use CTRL or CMD + button click
                        </td>
                    </tr>
                    <td colspan="2"><input class="button ripple" style="float:right" type="submit" name="submit" value="Add"></td>
                </table>
            </form>
    </body>
</html>
