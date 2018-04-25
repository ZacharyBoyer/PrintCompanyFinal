<%-- 
    Document   : AddClient
    Created on : Apr 2, 2018, 11:00:49 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.MarketingAgent"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
             <form action="updateOrder" method="post" name="registerForm">
                <table cellpadding="5" border="1">
                    <tr>
                        <th>Order Id</th>
                        <td>
                            <input type="hidden" readonly="true" name="id" id="id" value="${order.id}"/>
                            ${order.id}
                        </td>
                    </tr>
                      <tr>
                        <th>Agent Id</th>
                        <td><select id="clientId" name="clientId">
                       <c:forEach var="agents" items="${agents}">
                           <option value="<c:out value='${agents.id}'/>"><c:out value="ID ${agents. id} Name: ${agents.firstName} ${agents.lastName} "/></option>
                        </c:forEach>
                        </select>
                           </td>
                    </tr>
                      <tr>
                        <th>Client Id</th>
                        <td><input class="inputField ripple" type="text" name="clientId" id="clientId" required value="${order.clientId}"></td>
                    </tr>
                    <tr>
                        <th>Flyer Quantity</th>
                        <td><input class="inputField ripple" type="number" name="flyerQty" id="flyerQty" required value="${order.flyerQuantity}"></td>
                    </tr>
                      <tr>
                        <th>Flyer Layout</th>
                        <td><input class="inputField ripple" type="text" name="flyerLayout" id="flyerLayout" required value="${order.flyerLayout}"></td>
                    </tr>
                      <tr>
                          <th>Flyer Image</th>
                          <td>Current Image</br>
                              <img  src="data:image/jpg;base64,${order.getImg()}"/></br>
                              <input class="inputField ripple" type="file" accept="image/*" name="FlyerImg" id="FlyerImg" value="${order.file}"></td>
                    </tr>
                      <tr>
                        <th>Personal Copies</th>
                        <td><input class="inputField ripple" type="number" name="personalCopy" id="personalCopy" required value="${order.personalCopies}"></td>
                    </tr>
                      <tr>
                        <th>Payment Infromation</th>
                        <td><input class="inputField ripple" type="text" name="paymentInformation" id="paymentInformation" required value="${order.paymentInfo}"></td>
                    </tr>
                      <tr>
                        <th>Invoice Number</th>
                        <td><input class="inputField ripple" type="text" name="invoiceNumber" id="invoiceNumber" required value="${order.invoiceNum}"></td>
                    </tr>
                      <tr>
                        <th>Comments</th>
                        <td><input class="inputField ripple" type="text" name="comments" id="comments" required value="${order.comments}"></td>
                    </tr>
                      <tr>
                        <th>Flyer Art Approval</th>
                        <td><input class="inputField ripple" type="checkbox" name="isFlyerArtApproved" id="isFlyerArtApproved" value="${order.flyerArtApprovl}"></td>
                    </tr>
                      <tr>
                        <th>Payment Recived </th>
                        <td><input class="inputField ripple" type="checkbox" name="isPaymentRecived" id="isPaymentRecived" value="${order.paymentRecvd}"></td>
                    </tr>
                    <td colspan="2"><input class="button ripple" style="float:right" type="submit" name="submit" value="Update"></td>
                </table>
            </form>
    </body>
</html>
