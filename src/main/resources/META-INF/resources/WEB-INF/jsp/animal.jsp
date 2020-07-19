<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="de">
    <head>
        <title>Sie beobachten ${animal.getAnimalName()}</title>
        <link rel="stylesheet" href="<c:url value="css/style.css"></c:url>" />
    </head>

    <body>
        <h1>Sie beobachten ${animal.getAnimalName()} und ${animal.getAnimalName()} beobachtet zurück</h1>
        <img src='<c:url value="images/${animal.getImage()}.jpg"></c:url>'/>
        <p>
            <strong>Hunger: ${animal.getHunger()}</strong>
        </p>
        <%-- Wenn das Tier keinen Hunger hat, dann Fehlermeldung anzeigen; ansonsten Füttern-Button anzeigen --%>
        <c:choose>
            <c:when test="${animal.getHunger() < 1}">
                <p>
                    <span class="error">Das Tier ${animal.getAnimalName()} hat keinen Hunger mehr.</span><br/>
                </p>
            </c:when>
            <c:otherwise>
        <form method="POST" action="<c:url value='/animal'/>">
            <input name="chosenAnimal" type="hidden" value="${animal.getAnimalName()}" />
            <input name="compoundName" type="hidden" value="${compoundName}" />
            <button type="submit" name="feed">Füttern</button>
        </form>
            </c:otherwise>
        </c:choose>
        <form method="POST" action="<c:url value='/compound'/>">
            <input name="chosenCompound" type="hidden" value="${compoundName}" />
            <button type="submit">Zurück zum Gehege</button>
        </form>
    </body>

</html>