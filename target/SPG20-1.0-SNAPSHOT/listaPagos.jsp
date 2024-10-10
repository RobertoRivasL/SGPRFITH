<%--
  Created by IntelliJ IDEA.
  User: Ganon
  Date: 25-07-2023
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<%String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");%>
<% if (usuarioConectado != null && usuarioConectado && tipoSelec.equals("Administrativo")) { %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Lista Pagos</title>
</head>
<body>
<h1 class="text-center">Lista de Pagos</h1>
<div class="text-center">
    <button type="button" class="btn btn-success mb-3">Crear Pago</button>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
<% } else { %>
<% response.sendRedirect("login.jsp"); %>
<% } %>
</html>
