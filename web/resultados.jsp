<%-- 
    Document   : resultados
    Created on : Jan 30, 2022, 12:10:49 AM
    Author     : salva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="calculos.datos" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Salida de datos:</h1>
        <% 
            String base = request.getParameter("b");
            String altura = request.getParameter("h");

            datos d = new datos(base, altura);
            d.darArea();
            d.darPerimetro();

            double area_        = d.getArea();
            double perimetro_   = d.getPerimetro(); 
        %>
        <p> El area es: </p> <%= area_ %>
        <br>
        <p>El perimetro es: </p> <%= perimetro_ %>
    </body>
</html>
