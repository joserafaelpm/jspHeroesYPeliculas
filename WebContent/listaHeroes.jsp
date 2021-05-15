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
<jsp:useBean class="Modelo.HeroeDAO" id = "heroeDAO" ></jsp:useBean>
<h1><b>Heroes</b></h1>
  	<table class="table">
  <thead>
    <tr>
    <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Heroe</th>
      <th scope="col">fecha de Nacimiento</th>
      <th scope="col">Fecha de Aparicion</th>
      <th scope="col">Genero</th>
      <th scope="col">Estado</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Arma</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${heroeDAO.list()}" var = "heroe" >
    <tr>
      <th scope="row"> <c:out value="${heroe.id}" /></th>
      <td><c:out value="${heroe.nombre}" /></td>
      <td><c:out value="${heroe.heroe}" /></td>
      <td><c:out value="${heroe.nombre}" /></td>
      <td><c:out value="${heroe.fechanacimiento}" /></td>
      <td><c:out value="${heroe.fechaaparicion}" /></td>
      <td><c:out value="${heroe.generoBean.getDescripcion()}" /></td>
      <td><c:out value="${heroe.estadoBean.getDescripcion()}" /></td>
      <td><c:out value="${heroe.descripcion}" /></td>
      <td><c:out value="${heroe.arma}" /></td>
      <td><a href="HeroesServlet?action=eliminar&id=${heroe.id}">Eliminar</a></td>
      <td><a href="HeroesServlet?action=mostrar&id=${heroe.id}">Editar</a></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>