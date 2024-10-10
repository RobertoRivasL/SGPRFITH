<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html lang="es">
<%
    // Obtenemos el tipo de usuario seleccionado de la sesión
    String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");

    // Verificación del estado de sesión y del tipo de usuario
    if (usuarioConectado != null && usuarioConectado && "Administrativo".equals(tipoSelec)) {
%>
<head>
    <title>Administrar Chequeos</title>
</head>
<body>
<h1 class="text-center">Administrar Chequeos</h1>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

<%
    } else {
        // Si el usuario no está conectado o no es un "Administrativo", redirigimos al login
        response.sendRedirect("login.jsp");
    }
%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</html>
