<html>
<body>
    <h2>Cerca un utente</h2>
    <form action="deleteServlet" method="get">
        <p>
            <label for="username">username:</label><br>
            <input type="text" name="cerca">
        </p>
        <input type="submit" value="SEARCH">
    </form>
    <h2>Cancella un utente</h2>
    <form action="deleteServlet" method="post">
        <p>
            <label for="username">username:</label><br>
            <input type="text" name="delete">
        </p>
        <input type="submit" value="DELETE">
    </form>
    <a href="result.jsp">HOMEPAGE</a>
    <p><a href="listUser"><input type="button" value="VISUALIZZA LISTA UTENTI" /></a></p>
</body>
</html>