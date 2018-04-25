<%-- 
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
            <h1>Add A Location</h1>
            <form action="addLoc" method="post" name="addForm">
                <table cellpadding="5" border="1">
                    <tr>
                        <th>Location name</th>
                        <td>
                            <input type="text" name="name" id="name">
                        </td>
                    </tr>
                    <tr>
                        <th>Capacity</th>
                        <td><input type="text" name="Capacity" id="Capacity"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Save"></td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
