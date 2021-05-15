<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Heroes o Peliculas</title>
</head>
<body>
<h1><b>Heroes</b></h1>
  <div class="form-group row">
    <div class="col-sm-10">
    <a href="${pageContext.request.contextPath}/buscarHeroes.jsp" class="btn btn-primary">Buscar Heroes</a>
     <a href="${pageContext.request.contextPath}/registroHeroes.jsp" class="btn btn-primary">Registrar Heroes</a>
     <a href="${pageContext.request.contextPath}/listaHeroes.jsp" class="btn btn-primary">Lista De Heroes</a>
     <h1><b>Peliculas</b></h1>
     <a href="${pageContext.request.contextPath}/buscarPelicula.jsp" class="btn btn-primary">Buscar Pelicula</a>
     <a href="${pageContext.request.contextPath}/registrarPelicula.jsp" class="btn btn-primary">Registrar Pelicula</a>
     <a href="${pageContext.request.contextPath}/listaPelicula.jsp" class="btn btn-primary">Lista De Peliculas</a>
    </div>
</body>
</html>