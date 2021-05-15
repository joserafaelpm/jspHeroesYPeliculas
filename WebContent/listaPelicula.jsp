<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Heroes</title>
</head>
<body>
<jsp:useBean class="Modelo.PeliculaDAO" id = "peliculaDAO" ></jsp:useBean>
<h1><b>Peliculas</b></h1>
  	<table class="table">
  <thead>
    <tr>
    <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">ano de lanzamiento</th>
      <th scope="col">ano secuencia</th>
      <th scope="col">sinopsis</th>
      <th scope="col">Clasificacion</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${peliculaDAO.list()}" var = "peli" >
    <tr>
      <th scope="row"><c:out value="${peli.id}"  /> </th>
      <td><c:out value="${peli.nombre}" /></td>
      <td><c:out value="${peli.anolanzamiento}" /></td>
      <td><c:out value="${peli.anosecuencia}" /></td>
      <td><c:out value="${peli.sinopsis}" /></td>
      <td><c:out value="${peli.clasificacionBean.getDescripcion()}" /></td>
      <td><a href="PeliculaServlet?action=eliminar&id=${peli.id}">Eliminar</a></td>
      <td><a href="PeliculaServlet?action=mostrar&id=${peli.id}">Editar</a></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>