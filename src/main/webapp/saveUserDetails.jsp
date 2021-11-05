<html>
<body>
    <h2>aggiorna un utente</h2>
    <form action="insertUserDetails" method="post">
        <p>
            <label for="username">Utente da aggiornare:</label><br>
            <input type="text" name="username">
        </p>
        <p>
            <label for="nome">nome:</label><br>
            <input type="text" name="nome">
        </p>
        <p>
            <label for="cognome">cognome:</label><br>
            <input type="text" name="cognome">
        </p>
        <p>
            <label for="data_nascita">data(dd/MM/yyyy):</label><br>
            <input type="text" name="data_nascita">
        </p>
        <p>
            <label for="telefono">telefono:</label><br>
            <input type="text" name="telefono">
        </p>
        <p>
            <label for="email">email:</label><br>
            <input type="text" name="email">
        </p>
        <input type="submit" value="AGGIORNA">
    </form>
    <a href="result.jsp">HOMEPAGE</a>
</body>
</html>