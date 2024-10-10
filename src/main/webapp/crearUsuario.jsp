<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<%
    // Obtenemos el tipo de usuario seleccionado de la sesión
    String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");

    // Verificación del estado de sesión y del tipo de usuario
    if (usuarioConectado != null && usuarioConectado && "Administrativo".equals(tipoSelec)) {
%>
<head>
    <meta charset="UTF-8">
    <title>Crear Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body style="background-color: bisque">
<!-- Formulario para el registro -->
<hr class="hr" style="height: 100px"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-6 col-sm-8">
            <form class="register-form" action="svCrearUsuario" method="POST" id="passwordForm"
                  onsubmit="return validateForm()">
                <h2 class="text-center mb-4">Crear Usuario</h2>
                <div class="form-group">
                    <label class="mb-3" for="Usuariox">Nombre de Usuario</label>
                    <input name="nuevoUsuario" type="text" id="Usuariox" class="form-control"
                           placeholder="Ingresa Usuario" minlength="4" required>
                </div>
                <br>
                <div class="form-group">
                    <label class="mb-3" for="passwordy">Contraseña</label>
                    <input name="nuevoPassword" type="password" id="passwordy" class="form-control"
                           placeholder="Ingresa tu contraseña" minlength="6" required>
                </div>

                <div class="form-group">
                    <label class="mb-3" for="confirmPassword">Confirmar contraseña</label>
                    <input name="confirmarPassword" type="password" id="confirmPassword" class="form-control"
                           placeholder="Confirma tu contraseña" required>
                </div>

                <div class="form-group">
                    <label class="mb-3" for="nombre">Nombre</label>
                    <input name="nombre" type="text" id="nombre" class="form-control" placeholder="Ingresa tu nombre"
                           minlength="3" required>
                </div>
                <div class="form-group">
                    <label class="mb-3" for="fechaNacimiento">Fecha de Nacimiento</label>
                    <input name="fechaNacimiento" type="text" id="fechaNacimiento" class="form-control"
                           placeholder="Ingresa tu fecha de nacimiento " required>
                </div>
                <div class="form-group">
                    <label class="mb-3" for="Tipo">Tipo</label>
                    <select name="Tipo" class="form-control" id="Tipo">
                        <option disabled selected>Seleccione</option>
                        <option>Cliente</option>
                        <option>Profesional</option>
                        <option>Administrativo</option>
                    </select>
                </div>
                <div id="camposCliente" style="display: none">
                    <h3 class="text-center">Datos Cliente</h3>
                    <div class="form-group">
                        <div class="form-group">
                            <label class="mb-3" for="rutCL">Rut del Cliente</label>
                            <input name="rutCL" type="text" id="rutCL" class="form-control"
                                   placeholder="Ingresa el RUT de Cliente" minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="nombres">Nombres</label>
                            <input name="nombres" type="text" id="nombres" class="form-control"
                                   placeholder="Ingresa tus nombres" minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="apellidos">Apellidos</label>
                            <input name="apellidos" type="text" id="apellidos" class="form-control"
                                   placeholder="Ingresa tus apellidos" minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="telefono">Telefono</label>
                            <input name="telefono" type="number" id="telefono" class="form-control"
                                   placeholder="Ingresa tu telefono" minlength="7">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="afp">AFP</label>
                            <input name="afp" type="text" id="afp" class="form-control" placeholder="Ingresa tu afp"
                                   minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="salud">Seleccione su Sistema de salud</label>
                            <select name="salud" class="form-control" id="salud">
                                <option disabled selected>Seleccione</option>
                                <option>Fonasa</option>
                                <option>Isapre</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="direccionCliente">Direccion</label>
                            <input name="direccionCliente" type="text" id="direccionCliente" class="form-control"
                                   placeholder="Ingresa tu direccion" minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="comuna">Comuna</label>
                            <input name="comuna" type="text" id="comuna" class="form-control"
                                   placeholder="Ingresa tu comuna" minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="edad">Edad</label>
                            <input name="edad" type="number" id="edad" class="form-control"
                                   placeholder="Ingresa tu edad">
                        </div>
                    </div>
                </div>
                <!-- Campos Adicionales para "Profesional" -->
                <div id="camposProfesional" style="display: none">
                    <h3 class="text-center">Datos Profesional</h3>
                    <div class="form-group">
                        <div class="form-group">
                            <label class="mb-3" for="titulo">Titulo</label>
                            <input name="titulo" type="text" id="titulo" class="form-control"
                                   placeholder="Ingresa tu titulo profesional" minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="fechaIngreso">Fecha de Ingreso</label>
                            <input name="fechaIngreso" type="text" id="fechaIngreso" class="form-control"
                                   placeholder="Ingresa tu fecha de ingreso" minlength="3">
                        </div>
                    </div>
                </div>
                <!-- Campos Adicionales para "Administrativo" -->
                <div id="camposAdministrativo" style="display: none">
                    <h3 class="text-center">Datos Administrativo</h3>
                    <div class="form-group">
                        <div class="form-group">
                            <label class="mb-3" for="area">Area</label>
                            <input name="area" type="text" id="area" class="form-control" placeholder="Ingresa tu area"
                                   minlength="3">
                        </div>
                        <div class="form-group">
                            <label class="mb-3" for="expPrevia">Experiencia</label>
                            <input name="expPrevia" type="text" id="expPrevia" class="form-control"
                                   placeholder="Ingresa tu Experiencia Previa" minlength="3">
                        </div>
                    </div>
                </div>

                <br>
                <div style="display: flex; justify-content: space-between;">
                    <button type="submit" class="btn btn-primary btn-dark mb-3">Crear Usuario</button>
                </div>
                <% Boolean usuarioRegistrado = (Boolean) session.getAttribute("usuarioRegistrado");

                    if (usuarioRegistrado != null && usuarioRegistrado) { %>
                <div id="alertReg" class="alert alert-danger" style="display: none">
                    El Usuario que intenta registrar ya existe!
                </div>
                <% } %>
            </form>
        </div>
    </div>
</div>


<script>

    // Valida si el password con el confirmPassword son validos
    function validateForm() {
        var password = document.getElementById("passwordy").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
            return false;
        }

        return true;
    }
</script>

<script>
    document.getElementById("Tipo").addEventListener("change", function () {
        var selectedOption = this.value;

        // Esconde los campos
        document.getElementById("camposCliente").style.display = "none";
        document.getElementById("camposProfesional").style.display = "none";
        document.getElementById("camposAdministrativo").style.display = "none";

        // Muestra los correspondientes campos

        if (selectedOption === "Cliente") {
            document.getElementById("camposCliente").style.display = "block";
        } else if (selectedOption === "Profesional") {
            document.getElementById("camposProfesional").style.display = "block";
        } else if (selectedOption === "Administrativo") {
            document.getElementById("camposAdministrativo").style.display = "block";
        }

    });
</script>
<script>
    <% Boolean error = (Boolean)request.getSession().getAttribute("error");%>

    <% if(error != null && error){ %>
    var alertElement = document.getElementById('alertReg');
    alertElement.style.display = 'block';
    var tiempoOcultar = 3000; // 3 segundos

    // Función para ocultar el elemento después del tiempo especificado
    function ocultarElemento() {
        alertElement.style.display = 'none';
    }

    // Configurar el temporizador con setTimeout
    setTimeout(ocultarElemento, tiempoOcultar);
    <%}%>
</script>


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
</html>
