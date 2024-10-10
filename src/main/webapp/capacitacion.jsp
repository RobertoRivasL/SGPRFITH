<%@ page import="models.Capacitacion" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Capacitación</title>
</head>
<body>
<%
    // Obtener el tipo de selección del usuario desde la sesión.
    String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");
%>
<% if (usuarioConectado != null && usuarioConectado && "Cliente".equals(tipoSelec)) { %>
<h1 class="text-center">Capacitación</h1>
<div class="b-example-divider mt-5"></div>
<form id="formulario" action="svCapacitacion" method="POST" style="max-width: 40%; margin-left: 30%">
    <div class="container">
        <!-- Campo para el Rut del Cliente -->
        <div class="form-outline mb-4">
            <label class="form-label" for="rut_cliente">Rut Cliente</label>
            <input name="rutCliente" type="number" id="rut_cliente" class="form-control" minlength="8" maxlength="9"
                   required/>
            <label class="d-none text-danger" id="alertaRut_cliente">Falta agregar el rut del cliente</label>
        </div>
        <div class="form-group">
            <label for="Dia">Dia</label>
            <select name="dia" class="form-control" id="Dia" required>
                <%
                    // Utilizando Arrays.asList para inicializar la lista de días de la semana.
                    List<String> listaDias = Arrays.asList("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo");
                    for (String dia : listaDias) {
                %>
                <option><%= dia %>
                </option>
                <%}%>
            </select>
        </div>
        <div class="form-group">
            <label for="Hora">Hora</label>
            <select name="hora" class="form-control" id="Hora" required>
                <%
                    // Ciclo para generar las opciones de horas.
                    for (int j = 10; j < 24; j++) {
                %>
                <option><%= j %>:00</option>
                <%}%>
            </select>
        </div>
        <!-- Campo para el Lugar -->
        <div class="form-outline mb-4">
            <label class="form-label" for="lugar">Lugar</label>
            <input name="lugar" type="text" id="lugar" class="form-control" minlength="10" maxlength="50" required/>
            <label class="d-none text-danger" id="alertaLugar">Falta agregar el lugar</label>
        </div>
        <!-- Campo para la Duración -->
        <div class="form-outline mb-4">
            <label class="form-label" for="duracion">Duracion</label>
            <input name="duracion" type="text" id="duracion" class="form-control" maxlength="70" required/>
            <label class="d-none text-danger" id="alertaDuracion">Falta agregar la Duracion</label>
        </div>
        <!-- Campo para la Cantidad de Asistentes -->
        <div class="form-outline mb-4">
            <label class="form-label" for="cantidadAsistentes">Cantidad de Asistentes</label>
            <input name="cantidadAsistentes" type="number" id="cantidadAsistentes" class="form-control" maxlength="1000"
                   required/>
            <label class="d-none text-danger" id="alertaCantidadAsistentes">Falta agregar la cantidad de
                Asistentes</label>
        </div>
        <!-- Botón de Enviar -->
        <button id="botonCrear" type="submit" class="btn btn-dark btn-block mb-4">Crear</button>
        <div class="center" style="margin-top:10px; margin-bottom: 20px;">
            <label class="d-none text-success " id="capCreada">Su capacitación ha sido creada</label>
        </div>
    </div>
</form>
<script>
    // Script para manejar la validación del formulario.
    const myForm = document.getElementById("formulario");
    const rutClienteInput = document.getElementById("rut_cliente");
    const alertaRutCliente = document.getElementById("alertaRut_cliente");
    const capCreada = document.getElementById("capCreada");

    myForm.addEventListener("submit", function (event) {
        if (rutClienteInput.validity.valid) {
            capCreada.classList.remove("d-none");
            alertaRutCliente.classList.add("d-none");
        } else {
            capCreada.classList.add("d-none");
            alertaRutCliente.classList.remove("d-none");
            event.preventDefault(); // Prevenir envío de formulario en caso de error.
        }
    });
</script>
<%
    } else {
        // Si el usuario no está conectado o no es un "Cliente", redirigimos al login
        response.sendRedirect("login.jsp");
    }
%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>