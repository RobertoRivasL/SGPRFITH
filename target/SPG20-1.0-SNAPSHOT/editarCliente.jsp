<%@ page import="dao.ClienteDAOimpl" %>
<%@ page import="models.Cliente" %>
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
<h1 class="text-center">Editar Cliente</h1>
<% usuarioConectado = (Boolean) session.getAttribute("usuarioConectado");%>
<% if (usuarioConectado != null && usuarioConectado) { %>
<form action="svEditarCliente" method="post">
    <%-- Obtener el identificador del cliente de la URL --%>
    <%
        int clienteId = Integer.parseInt(request.getParameter("id"));
        Cliente clienteEncontrado = null;
        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            if (clienteId == cliente.getId()) {
                clienteEncontrado = cliente;
                break;
            }
        }
    %>
    <%
        if (clienteEncontrado != null) {
    %>
    <hr class="hr" style="height: 100px"/>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 col-sm-8">
                <form action="svEditarCliente" method="post">
                    <div class="form-group">
                        <label class="mb-3" for="nuevoID">ID</label>
                        <input name="nuevoID" type="text" id="nuevoID" class="form-control"
                               placeholder="Ingresa Usuario" value="<%= clienteEncontrado.getId() %>" minlength="4"
                               required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="Usuariox">Nombre de Usuario</label>
                        <input name="nuevoUsuarioMOD" type="text" id="Usuariox" class="form-control"
                               placeholder="Ingresa Usuario" value="<%= clienteEncontrado.getUsername() %>"
                               minlength="4" required>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="mb-3" for="passwordy">Contraseña</label>
                        <input name="nuevoPasswordMOD" type="password" id="passwordy" class="form-control"
                               placeholder="Ingresa tu contraseña" value="<%= clienteEncontrado.getPassword() %>"
                               minlength="6" required>
                    </div>

                    <div class="form-group">
                        <label class="mb-3" for="nombre">Nombre</label>
                        <input name="nombreMOD" type="text" id="nombre" class="form-control"
                               placeholder="Ingresa tu nombre" minlength="3"
                               value="<%= clienteEncontrado.getNombre() %>" required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="fechaNacimiento">Fecha de Nacimiento</label>
                        <input name="fechaNacimientoMOD" type="text" id="fechaNacimiento" class="form-control"
                               placeholder="Ingresa tu fecha de nacimiento "
                               value="<%= clienteEncontrado.getFechaNacimiento() %>" required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="Tipo">Tipo</label>
                        <select name="TipoMOD" class="form-control" id="Tipo">
                            <option>Cliente</option>
                            <option>Profesional</option>
                            <option>Administrativo</option>
                        </select>
                    </div>
                    <div id="camposCliente">
                        <h3 class="text-center">Datos Cliente</h3>
                        <div class="form-group">
                            <div class="form-group">
                                <label class="mb-3" for="rutCL">Rut del Cliente</label>
                                <input name="rutCLMOD" type="text" id="rutCL" class="form-control"
                                       placeholder="Ingresa el RUT de Cliente" value="<%= clienteEncontrado.getRut() %>"
                                       minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="nombres">Nombres</label>
                                <input name="nombresMOD" type="text" id="nombres" class="form-control"
                                       placeholder="Ingresa tus nombres" value="<%= clienteEncontrado.getNombres() %>"
                                       minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="apellidos">Apellidos</label>
                                <input name="apellidosMOD" type="text" id="apellidos" class="form-control"
                                       placeholder="Ingresa tus apellidos"
                                       value="<%= clienteEncontrado.getApellidos() %>" minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="telefono">Telefono</label>
                                <input name="telefonoMOD" type="number" id="telefono" class="form-control"
                                       placeholder="Ingresa tu telefono" value="<%= clienteEncontrado.getTelefono() %>"
                                       minlength="7">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="afp">AFP</label>
                                <input name="afpMOD" type="text" id="afp" class="form-control"
                                       placeholder="Ingresa tu afp" value="<%= clienteEncontrado.getAfp() %>"
                                       minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="salud">Seleccione su Sistema de salud</label>
                                <select name="saludMOD" class="form-control" id="salud">
                                    <option>Fonasa</option>
                                    <option>Isapre</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="direccionCliente">Direccion</label>
                                <input name="direccionClienteMOD" type="text" id="direccionCliente" class="form-control"
                                       placeholder="Ingresa tu direccion"
                                       value="<%= clienteEncontrado.getDireccion() %>" minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="comuna">Comuna</label>
                                <input name="comunaMOD" type="text" id="comuna" class="form-control"
                                       placeholder="Ingresa tu comuna" value="<%= clienteEncontrado.getComuna() %>"
                                       minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="edad">Edad</label>
                                <input name="edadMOD" type="number" id="edad" class="form-control"
                                       placeholder="Ingresa tu edad" value="<%= clienteEncontrado.getEdad() %>"
                                       minlength="3">
                            </div>
                        </div>
                    </div>
                    <div style="display: flex; justify-content: space-between;">
                        <button type="submit" class="btn btn-primary btn-dark mb-3 mt-3">Guardar Cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%}%>
</form>
</body>
<% } else { %>
<% response.sendRedirect("login.jsp"); %>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</html>
