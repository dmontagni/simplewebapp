<<<<<<< HEAD
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="it.webapp.User"%>
<html>
<body>
    <h2>LISTA</h2>
    <table border="1">
    <tr> <th> Username </th><th> Password</th></tr>
    <%
    java.util.List<User> users=(java.util.List<User>)request.getAttribute("usersList");
    for (User user: users) {
    %>
    <tr>
    <td><%=user.getUsername()%></td>
    <td><%=user.getPassword()%></td>
    </tr>
    <%}%>
    </table>
</body>
=======
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="it.webapp.User"%>
<html>
<body>
    <h2>LISTA</h2>
    <table border="1">
    <tr> <th> Username </th><th> Password</th></tr>
    <%
    java.util.List<User> users=(java.util.List<User>)request.getAttribute("usersList");
    for (User user: users) {
    %>
    <tr>
    <td><%=user.getUsername()%></td>
    <td><%=user.getPassword()%></td>
    </tr>
    <%}%>
    </table>
</body>
>>>>>>> branch 'main' of git@github.com:dmontagni/simplewebapp.git
</html>