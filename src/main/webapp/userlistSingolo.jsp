<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="it.webapp.User"%>
<html>
<body>
    <h2>LISTA</h2>
    <table border="1">
    <tr> <th> Username </th><th> Password</th></tr>
    <%
    User user = (User) request.getAttribute("usersList");
   
    %>
    <tr>
    <td><%=user.getUsername()%></td>
    <td><%=user.getPassword()%></td>
    </tr>
    <%%>
    </table>
</body>
</html>