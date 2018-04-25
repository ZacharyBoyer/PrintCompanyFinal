<%-- 
    Document: EditLocation
    Created on : Apr 22, 2018
    Author     : Alessandro S
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <center>
            <h2>Edit Location</h2>
            <form action="updateLoc" method="post" name="editForm">
                <table cellpadding="5" border="1">
                    <tr>
                        <th>Location Id</th>
                        <td>
                            <input type="hidden" readonly="true" name="id" id="id" value="${location.id}"/>
                            ${location.id}                            
                        </td>
                    </tr>
                    <tr>
                        <th>Location name</th>
                        <td>
                            <input type="text" name="name" id="name" value="${location.locationName}">
                        </td>
                    </tr>
                    <tr>
                        <th>Capacity</th>
                        <td><input type="text" name="Capacity" id="Capacity" value="${location.distrCap}"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Save"></td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
