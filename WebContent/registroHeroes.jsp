<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%--  --%>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  </script>
<title> Registrar Heroes</title>
</head>
<body>
<jsp:useBean class="Modelo.GeneroDAO" id="generoDAO"></jsp:useBean>
<jsp:useBean class="Modelo.EstadoDAO" id="estadoDAO"></jsp:useBean>
<h1><b>Registrar Heroes</b></h1>
<c:if test="${heroe != null}">
                           <%--  <form action="${pageContext.request.contextPath}/ActualizarEmpleado?accion=edita&codigo=${empleado.codigo}"  method="post"> --%>
                           <form action="HeroesServlet?action=actualizar&id=${heroe.id}"  method="POST">
                        </c:if>
                        <c:if test="${heroe == null}">
                           <%--  <form action="${pageContext.request.contextPath}/AgregarEmpleado?accion=agregar&codigo=${empleado.codigo}"  method="POST"> --%>
                            <form action="HeroesServlet?action=registrar"  method="POST">
                        </c:if>

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Nombre:</label>
    <div class="col-sm-10">
      <input type="text" name="nombre" value="${heroe.nombre}"  class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Heroe:</label>
    <div class="col-sm-10">
      <input type="text" name="heroe" value="${heroe.heroe}"  class="form-control" id="inputEmail3">
    </div>
  </div>
   
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Fecha Nacimiento:</label>
    <div class="col-sm-10">
    <input type="Date" name="fechaNacimiento" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${heroe.fechanacimiento}' />" >
    </div>
  </div>
  
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Fecha Aparicion:</label>
    <div class="col-sm-10">
     <input type="Date" name="fechaAparicion" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${heroe.fechaaparicion}' />"  >
    </div>
  </div>
  
  <fieldset class="form-group">
					<label>genero</label> <select class="form-control"
						id="exampleFormControlSelect1" name="genero">
						<option selected value="${heroe.generoBean.getId()} ">
							<c:out value="${heroe.generoBean.getDescripcion()} " />
						</option>
						<c:forEach items="${generoDAO.list()}" var="genero">
							<option value="${genero.id} ">
								<c:out value="${genero.descripcion} " />
							</option>
						</c:forEach>
					</select>
				</fieldset>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Estado:</label>
    <div class="col-sm-10">
      <input type="text" name="estado" value="${heroe.estadoBean.getId()}"  class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Descripcion:</label>
    <div class="col-sm-10">
      <input type="text" name="descripcion" value="${heroe.descripcion}"  class="form-control" id="inputEmail3">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Arma:</label>
    <div class="col-sm-10">
      <input type="text" name="arma" value="${heroe.arma}"  class="form-control" id="inputEmail3">
    </div>
  </div>
  
  
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Registrar</button>
     <a href="${pageContext.request.contextPath}/buscarHeroes.jsp" class="btn btn-primary">Volver</a>
    </div>
    </div>
    
 <%--    <c:if test="${empleado != null}">
                            <form action="${pageContext.request.contextPath}/ActualizarEmpleado?accion=edita&codigo=${empleado.codigo}"  method="post">
                           <form action="ActualizarEmpleado"  method="POST">
                        </c:if>
                        <c:if test="${empleado == null}">
                            <form action="${pageContext.request.contextPath}/AgregarEmpleado?accion=agregar&codigo=${empleado.codigo}"  method="POST">
                            <form action="AgregarEmpleado"  method="POST">
                        </c:if> --%>
    
  
</form>
</body>
</html>