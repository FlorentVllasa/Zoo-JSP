<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="de">
    <head>
        <title>Gehege von ${compoundName}</title>
        <link rel="stylesheet" href="<c:url value="css/style.css"></c:url>" />
    </head>

    <body>
        <h1>Sie sind hier: ${compoundName}</h1>
        <h2>Sie sehen diese Tiere:</h2>
        <form method="POST" action="<c:url value='/animal'/>">
            <input type="hidden" name="compoundName" value="${compoundName}" />
            <div style="display: inline-block">
                <%-- Zeige alle Tiere, die nicht versteckt sind --%>
                <c:forEach items="${animals}" var="animal">
                    <c:if test="${animal.hidden == false}">
                        <input type="radio" id="${animal.getAnimalName()}" name="chosenAnimal" value="${animal.getAnimalName()}">
                        <label for="${animal.getAnimalName()}"> ${animal.getAnimalName()}</label>
                        <br/>
                    </c:if>
                </c:forEach>
                <button type="submit"> Gehe zum ausgewählten Tier</button>
            </div>
        </form>
        <h2>Diese Tiere verstecken sich: </h2>
        <ul>
            <%-- Zeige alle Tiere, die versteckt sind --%>
            <c:forEach items="${animals}" var="animal">
                <c:if test="${animal.hidden == true}">
                    <li>${animal.getAnimalName()}</li>
                </c:if>
            </c:forEach>
        </ul>

        <a href="/"> Zurück zur Karte</a>
        <%-- Gebe Fehler aus, wenn kein Tier ausgewählt --%>
        <c:choose>
            <c:when test="${not empty noDecision}">
                <p>
                    <span class="error">Bitte entscheide Dich für ein Tier!</span><br/>
                    <span class="warning">Hinweis: In der Zeit sind andere Tiere zum Vorschein getreten.</span>
                </p>
            </c:when>
        </c:choose>
    </body>
</html>