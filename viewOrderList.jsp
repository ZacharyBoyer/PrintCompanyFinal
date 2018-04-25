<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Client"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <style>
        <%@include file="/style.css" %>
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Clients</title>
           <%
               if (request.getParameterMap().containsKey("res")) {
            if (request.getParameter("res").equals("0")) {%>
            <script>
               var message = "Cannot delete order!";
            alert(message);
            </script>
            <%
            } else {  %>
        <script>
               var message = "Order Deleted";
            alert(message);
            </script>
            <%
            }
        }
    %>
    </head>
    <body>
          <%
            String Vis = request.getAttribute("messageVis").toString();
                  %>
        <center>
            <a class="a button" href="${pageContext.request.contextPath}">Home</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a class="a button" <%=Vis%> href="newOrder">Add New Order</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a class="a button" href="orderList">View Orders</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a class="a button" href="logout">Logout</a>
        </center>
        <br/>
        <center>
            <h1>List of Orders</h1>
            <table cellpadding="5" border="1">
                <thead>
                    <th>Id</th>
                    <th>Agent Id</th>
                    <th>Client Id</th>
                    <th>Flyer Quantity</th>
                    <th>Personal Copies</th>
                    <th>Flyer Layout</th>
                    <th>Payment Info</th>
                    <th>Invoice Number</th>
                    <th>Comments</th>
                    <th>Flyer Art Approval</th>
                    <th>Payment received </th>
                    <th>Flyer Image</th>
                </thead>
                <tbody>
                
                <c:forEach var="order" items="${oList}">
                    <tr>
                        <td><c:out value="${order.getId()}"/></td>
                        <td><c:out value="${order.getAgentId()}"/></td>
                        <td><c:out value="${order.getClientId()}"/></td>
                        <td><c:out value="${order.getFlyerQuantity()}"/></td>
                        <td><c:out value="${order.getPersonalCopies()}"/></td>
                        <td><c:out value="${order.getFlyerLayout()}"/></td>
                        <td><c:out value="${order.getPaymentInfo()}"/></td>
                        <td><c:out value="${order.getInvoiceNum()}"/></td>
                        <td><c:out value="${order.getComments()}"/></td>
                        <td><c:out value="${order.getFlyerArtApprovl()}"/></td>
                        <td><c:out value="${order.getPaymentRecvd()}"/></td>
                        <td><img  src="data:image/jpg;base64,${order.getImg()}"/></td>
                        <%--<td><c:out value="${order.getFlyerImg()}"/></td>--%>
                        <td>
                            <a href="editOrder?id=<c:out value='${order.getId()}'/>">
                                Edit
                            </a>
                                &nbsp;&nbsp;&nbsp;
                            <a href="deleteOrder?id=<c:out value='${order.getId()}'/>">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </center>
    </body>
</html>
