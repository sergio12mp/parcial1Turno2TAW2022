<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.Pelicula" %><%--
  Created by IntelliJ IDEA.
  User: sergio
  Date: 31/05/2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
%>
<head>
    <title>Datos de la pelicula</title>
</head>
<body>
<form:form modelAttribute="pelicula" action="guardar" method="post">
    <table border="2">
        <tr>
            <form:hidden path="peliculaId" value="<%=pelicula.getPeliculaId()%>"></form:hidden>
            <td>Titulo<form:input path="titulo" value="<%=pelicula.getTitulo()%>" size="30"></form:input><br></td>
            <td> Ano<form:input path="anyo" value="<%=pelicula.getAnyo()%>" size="30"></form:input><br></td>
            <td> Texto de apertura<form:textarea path="textoApertura" value="<%=pelicula.getTextoApertura()%>"
                                                 size="200"></form:textarea><br></td>
        </tr>
        <tr>
            <td>
                Personajes:<br>
                <form:select multiple="true" path="personajeList" items="${listaPersonajes}" itemLabel="nombre" size="auto"></form:select></td>
            <td><a href="/">VOLVER</a></td>
        </tr>
       <td> <form:button>GUARDAR</form:button></td>
    </table>
</form:form>

</body>
</html>
