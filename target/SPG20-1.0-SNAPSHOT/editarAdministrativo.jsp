<%@ page import="java.util.List" %>
<%@ page import="models.Administrativo" %>
<%@ page import="dao.AdministrativoDAOimpl" %>
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
<%
    // Obtenemos el tipo de usuario seleccionado de la sesión
    String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");

    // Verificación del estado de sesión y del tipo de usuario
    if (usuarioConectado != null && usuarioConectado && "Administrativo".equals(tipoSelec)) {
%>
<h1 class="text-center">Editar Administrativo</h1>
<form action="svEditarAdministrativo" method="post">
        <%
    int administrativoId = Integer.parseInt(request.getParameter("id"));
    Administrativo administrativoEncontrado = null;
    AdministrativoDAOimpl administrativoDAO = new AdministrativoDAOimpl();
    List<Administrativo> administrativos = administrativoDAO.listarAdministrativos();
    for (Administrativo administrativo: administrativos){
      if (administrativoId == administrativo.getId()){
        administrativoEncontrado = administrativo;
        break;
      }
    }
  %>
        <%
    if (administrativoEncontrado != null){
  %>
    <hr class="hr" style="height: 100px"/>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 col-sm-8">
                <form action="svEditarAdministrativo" method="post">
                    <div class="form-group">
                        <label class="mb-3" for="nuevoID">ID</label>
                        <input name="nuevoID" type="text" id="nuevoID" class="form-control"
                               placeholder="Ingresa Usuario" value="<%= administrativoEncontrado.getId() %>"
                               minlength="4" required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="Usuariox">Nombre de Usuario</label>
                        <input name="nuevoUsuarioMOD" type="text" id="Usuariox" class="form-control"
                               placeholder="Ingresa Usuario" value="<%= administrativoEncontrado.getUsername() %>"
                               minlength="4" required>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="mb-3" for="passwordy">Contraseña</label>
                        <input name="nuevoPasswordMOD" type="password" id="passwordy" class="form-control"
                               placeholder="Ingresa tu contraseña" value="<%= administrativoEncontrado.getPassword() %>"
                               minlength="6" required>
                    </div>

                    <div class="form-group">
                        <label class="mb-3" for="nombre">Nombre</label>
                        <input name="nombreMOD" type="text" id="nombre" class="form-control"
                               placeholder="Ingresa tu nombre" minlength="3"
                               value="<%= administrativoEncontrado.getNombre() %>" required>
                    </div>
                    <div class="form-group">
                        <label class="mb-3" for="fechaNacimiento">Fecha de Nacimiento</label>
                        <input name="fechaNacimientoMOD" type="text" id="fechaNacimiento" class="form-control"
                               placeholder="Ingresa tu fecha de nacimiento "
                               value="<%= administrativoEncontrado.getFechaNacimiento() %>" required>
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
                        <h3 class="text-center">Datos Administrativo</h3>
                        <div class="form-group">
                            <div class="form-group">
                                <label class="mb-3" for="areaMOD">Area</label>
                                <input name="areaMOD" type="text" id="areaMOD" class="form-control"
                                       placeholder="Ingresa Area" value="<%= administrativoEncontrado.getArea() %>"
                                       minlength="3">
                            </div>
                            <div class="form-group">
                                <label class="mb-3" for="expPreviaMOD">Experiencia Previa</label>
                                <input name="expPreviaMOD" type="text" id="expPreviaMOD" class="form-control"
                                       placeholder="Ingresa Experiencia Previa"
                                       value="<%= administrativoEncontrado.getExpPrevia() %>" minlength="3">
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
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
<%
    } else {
        // Si el usuario no está conectado o no es un "Administrativo", redirigimos al login
        response.sendRedirect("login.jsp");
    }
%>
</html>
