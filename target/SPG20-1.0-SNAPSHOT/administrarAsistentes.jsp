<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<%@ include file="footer.jsp" %>
<!DOCTYPE html>
<html lang="es">
<%
    // Obtenemos el tipo de usuario seleccionado de la sesión
    String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");

    // Verificación del estado de sesión y del tipo de usuario
    if (usuarioConectado != null && usuarioConectado && "Cliente".equals(tipoSelec)) {
%>
<head>
    <title>Administrar Asistentes</title>
</head>
<body>
<h1 class="text-center">Administrar Asistentes</h1>

<!-- Botones de acciones de administración de asistentes -->
<div class="text-center">
    <button type="button" class="btn btn-outline-primary btn-dark mb-3">Crear Asistente</button>
    <button type="button" class="btn btn-outline-danger btn-dark mb-3">Eliminar Asistente</button>
    <button type="button" class="btn btn-outline-success btn-dark mb-3">Listar Asistentes</button>
</div>
</body>

<%
    } else {
        // Si el usuario no está conectado o no es un "Cliente", redirigimos al login
        response.sendRedirect("login.jsp");
    }
%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</html>
