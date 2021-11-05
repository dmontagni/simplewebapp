<html>
<body>
    <h2>UTENTE TROVATO</h2>
    ________________________________________________
    <p>ecco i dati del utente: <b><%=request.getAttribute("username")%></b></p>
    <p>nome: <b><%=request.getAttribute("nome")%></b></p>
    <p>cognome: <b><%=request.getAttribute("cognome")%></b></p>
    <p>data di nascita: <b><%=request.getAttribute("data_nascita")%></b></p>
    <p>telefono: <b><%=request.getAttribute("telefono")%></b></p>
    <p>email: <b><%=request.getAttribute("email")%></b></p>
    ________________________________________________
    <p><a href="searchUser.jsp">torna alla ricerca</a></p>
    <p><a href="result.jsp">HOMEPAGE</a></p>
</body>
</html>