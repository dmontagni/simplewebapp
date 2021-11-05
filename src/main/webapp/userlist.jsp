<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="it.webapp.User"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
<body>
    <h2>LISTA</h2>
    <table border="1">
    <tr> <th> Username </th>
        <th> Password</th>
        <th> Nome</th>
        <th> Cognome</th>
        <th> Data Nascita</th>
        <th> Telefono</th>
        <th> Email</th></tr>
    <%
    java.util.List<User> users=(java.util.List<User>)request.getAttribute("usersList");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    for (User user: users) {
    System.out.println(user);
    Date data = user.getData_nascita();
    String dataformattata;
    if(data != null){
    dataformattata = sdf.format(data);
    System.out.println(dataformattata);
    }
    else{
    dataformattata = "-";
    }
    %>
    <tr>
    <td><%=user.getUsername()%></td>
    <td><%=user.getPassword()%></td>
    <td><%=user.getNome()%></td>
    <td><%=user.getCognome()%></td>
    <td><%=dataformattata%></td>
    <td><%=user.getEmail()%></td>
    <td><%=user.getTelefono()%></td>
    </tr>
    <%}%>
    </table>
    <a href="result.jsp">HOMEPAGE</a>
</body>
</html>