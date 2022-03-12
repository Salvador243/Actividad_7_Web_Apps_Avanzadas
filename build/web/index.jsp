<%-- 
    Document   : index
    Created on : Mar 6, 2022, 8:11:41 PM
    Author     : salva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            if (request.getAttribute("flag") != null) {
                out.print("<h2><<< FLAG >>></h2>");
            }
        %>
        <c:choose>
            <c:when test="${sessionScope.username != null}">
                <c:out value = "Bienvenido ${sessionScope.username} "/> 
                <form action="resultados" method="post">
                    <label>Ingrese la base</label>
                    <br/>
                    <input type="number" name="b">
                    <br>
                    <label>Ingrese la altura</label>
                    <br>
                    <input type="number" name="h">
                    <br>
                    <button type="submit">Hacer Calculos</button>
                </form>

                <%
                    if (request.getAttribute("flag") == null) {
                %>
                <fieldset>
                    <legend>Datos del triangulo</legend>
                    <c:forEach var="item" items="${cookie}">
                        <c:if test="${item.key != 'JSESSIONID'}">
                            <c:choose>
                                <c:when test="${item.key == 'area'}">
                                    <c:out value="El area es: ${item.value.value}"/> <br> 
                                </c:when>
                                <c:when test="${item.key == 'perimetro'}">
                                    <c:out value="El perimetro es: ${item.value.value}"/> <br>
                                </c:when>
                                <c:when test="${item.key == 'base'}">
                                    <c:out value="La base es: ${item.value.value}"/> <br>
                                </c:when>
                                <c:when test="${item.key == 'altura'}">
                                    <c:out value="La altura es: ${item.value.value}"/> <br>
                                </c:when>
                            </c:choose>             
                        </c:if>
                    </c:forEach>
                </fieldset>
                <%
                    }
                %>
            </c:when>
            <c:when test="${sessionScope.username == null}">
                <form action="usuario" method="post">
                    <label>Nombre de usuario</label>
                    <br/>
                    <input type="text" name="username">
                    <br>
                    <button type="submit">Guardar Usuario</button>
                </form>
            </c:when>
        </c:choose>
    </body>
</html>