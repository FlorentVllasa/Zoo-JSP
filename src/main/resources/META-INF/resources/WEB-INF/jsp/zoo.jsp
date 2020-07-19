<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="de">
    <head>
        <title>Willkommen im Zoo</title>
        <link rel="stylesheet" href="<c:url value="css/style.css"></c:url>" />
    </head>

    <body>
        <h1>Willkommen im Zoo</h1>
        <h2>Welches Gehege möchten Sie besuchen?</h2>
        <h3>Schauen Sie auf unsere Karte</h3>
        <form method="POST" action="<c:url value='/compound'/>" style="width: 25vw">
            <fieldset>
                <input type="radio" id="schlangen" name="chosenCompound" value="Schlangen">
                <label for="schlangen"> Schlangen</label>

                <input type="radio" id="afrika" name="chosenCompound" value="Afrika">
                <label for="afrika"> Afrika</label>

                <input type="radio" id="voegel" name="chosenCompound" value="Vögel">
                <label for="voegel"> Vögel</label>

                <input type="radio" id="pinguine" name="chosenCompound" value="Pinguine">
                <label for="pinguine"> Pinguine</label>
            </fieldset>
            <button type="submit" style="margin-top: 20px">Gehe zum Gehege</button>
        </form>
        <%-- Fehler ausgeben, wenn kein Gehege ausgewählt --%>
        <c:choose>
            <c:when test="${not empty noDecision}">
                <p><span class="error">
                    Bitte ein Gehege auswählen!</span></p>
            </c:when>
        </c:choose>
    </body>
</html>