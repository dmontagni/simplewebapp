<html>
<body>
    <h2>UTENTE TROVATO</h2>
    ________________________________________________
    <p>utente <b>ecco i dati del utente: <%=request.getAttribute("username")%></b></p>
    <p>utente <b>nome: <%=request.getAttribute("nome")%></b></p>
    <p>utente <b>cognome: <%=request.getAttribute("cognome")%></b></p>
    <p>utente <b>data di nascita: <%=request.getAttribute("data_nascita")%></b></p>
    <p>utente <b>telefono: <%=request.getAttribute("telefono")%></b></p>
    <p>utente <b>email: <%=request.getAttribute("email")%></b></p>
    ________________________________________________
    <a href="searchUser.jsp">torna alla ricerca</a>
    <a href="index.jsp">torna alla homepage</a>
</body>
</html>