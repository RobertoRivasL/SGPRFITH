<%@ page import="models.Profesional" %>
<%@ page import="dao.ProfesionalDAOimpl" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Edicion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<%usuarioConectado = (Boolean) session.getAttribute("usuarioConectado");%>
<% if (usuarioConectado != null && usuarioConectado) { %>
<h1 class="text-center">Editar Profesional</h1>
<form action="svEditarProfesional" method="post">
    <%
        int profesionalId = Integer.parseInt(request.getParameter("id"));
        Profesional profesionalEncontrado = null;
        ProfesionalDAOimpl profesionalDAO = new ProfesionalDAOimpl();
        List<Profesional> profesionales = profesionalDAO.listarProfesionales();
        for (Profesional profesional : profesionales) {
            if (profesionalId == profesional.getId()) {
                profesionalEncontrado = profesional;
                break;
            }
        }
    %>
    <%
        if (profesionalEncontrado != null) {
    %>
    <hr class="hr" style="height: 100px"/>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 col-sm-8">
                <form action="svEditarProfesional" method="POST">
                    <div class="form-group">
                        <label class="mb-3" for="nuevoID">ID</label>
                        <input name="nuevoID" type="text" id="nuevoID" class="form-control"
                               placeholder="Ingresa Usuario" value="<%= profesionalEncontrado.getId() %>" minlength="4"
                               required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="Usuariox">Nombre de Usuario</label>
                        <input name="nuevoUsuarioMOD" type="text" id="Usuariox" class="form-control"
                               placeholder="Ingresa Usuario" value="<%= profesionalEncontrado.getUsername() %>"
                               minlength="4" required>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="mb-3" for="passwordy">Contraseña</label>
                        <input name="nuevoPasswordMOD" type="password" id="passwordy" class="form-control"
                               placeholder="Ingresa tu contraseña" value="<%= profesionalEncontrado.getPassword() %>"
                               minlength="6" required>
                    </div>

                    <div class="form-group">
                        <label class="mb-3" for="nombre">Nombre</label>
                        <input name="nombreMOD" type="text" id="nombre" class="form-control"
                               placeholder="Ingresa tu nombre" minlength="3"
                               value="<%= profesionalEncontrado.getNombre() %>" required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="fechaNacimiento">Fecha de Nacimiento</label>
                        <input name="fechaNacimientoMOD" type="text" id="fechaNacimiento" class="form-control"
                               placeholder="Ingresa tu fecha de nacimiento "
                               value="<%= profesionalEncontrado.getFechaNacimiento() %>" required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="Tipo">Tipo</label>
                        <select name="TipoMOD" class="form-control" id="Tipo">
                            <option>Cliente</option>
                            <option>Profesional</option>
                            <option>Administrativo</option>
                        </select>
                    </div>
                    <div>
                        <h3 class="text-center">Datos Profesional</h3>
                        <div class="form-group">
                            <div class="form-group">
                                <label class="mb-3" for="tituloMOD">Titulo</label>
                                <input name="tituloMOD" type="text" id="tituloMOD" class="form-control"
                                       placeholder="Ingresa titulo" value="<%= profesionalEncontrado.getTitulo() %>"
                                       minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="fechaIngresoMOD">Fecha Ingreso</label>
                                <input name="fechaIngresoMOD" type="text" id="fechaIngresoMOD" class="form-control"
                                       placeholder="Ingresa fecha ingreso"
                                       value="<%= profesionalEncontrado.getFechaIngreso() %>" minlength="3">
                            </div>
                            <div style="display: flex; justify-content: space-between;">
                                <button type="submit" class="btn btn-primary btn-dark mb-3 mt-3">Guardar Cambios
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%}%>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
<% } else { %>
<% response.sendRedirect("login.jsp"); %>
<% } %>
</html>
