<%--
  Created by IntelliJ IDEA.
  User: Ganon
  Date: 25-07-2023
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html lang="es">
<%String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");%>
<% if (usuarioConectado != null && usuarioConectado && tipoSelec.equals("Profesional")) { %>
<head>
    <title>Lista Visitas</title>
</head>
<body>
<h1 class="text-center">Lista de Visitas</h1>
<div class="text-center">
    <button type="button" class="btn btn-outline-primary btn-dark mb-3">Responder CheckList</button>
</div>
<div class="container">
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault1">
        <label class="form-check-label" for="flexCheckDefault1">
            Chulito
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault2">
        <label class="form-check-label" for="flexCheckDefault2">
            Chulito
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault3">
        <label class="form-check-label" for="flexCheckDefault3">
            Chulito
        </label>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

<% } else { %>
<% response.sendRedirect("login.jsp"); %>
<% } %>
</html>
