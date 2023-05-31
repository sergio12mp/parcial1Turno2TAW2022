<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.FraseCelebre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sergio
  Date: 31/05/2023
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    List<FraseCelebre> listaFrasesCelebres = (List<FraseCelebre>) request.getAttribute("listaFrasesCelebres");
%>
<head>
    <title>Listado de Frases Celebres</title>
</head>
<body>

<form:form action="filtrar" method="post" modelAttribute="filtro">
    Pelicula <form:checkbox path="pelicula"></form:checkbox>
    Personaje <form:checkbox path="personaje"></form:checkbox>
    <forn:button>GUARDAR</forn:button>

</form:form>
<table border="1">
    <tr>
        <th>PERSONAJE</th>
        <th>PLANETA</th>
        <th>FRASE CELEBRE</th>
        <th>PELICULA</th>
    </tr>
    <%
        for (FraseCelebre f : listaFrasesCelebres) {
    %>
    <tr>
        <td><%=f.getPersonaje().getNombre()%>
        </td>
        <td><%=f.getPersonaje().getPlaneta() != null ? f.getPersonaje().getPlaneta().getNombre() : ""%>
        </td>
        <td><%=f.getFrase()%>
        </td>
        <td><a href="/editar?id=<%=f.getPelicula().getPeliculaId()%>"><%=f.getPelicula().getTitulo()%>
        </a></td>

    </tr>

    <% }%>


</table>
</body>
</html>
