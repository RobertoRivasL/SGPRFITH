<%@ page import="models.Capacitacion" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.CapacitacionDAOimpl" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title></title>
</head>
<body>
<% String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");
    System.out.println(tipoSelec);
%>
<% if (usuarioConectado != null && usuarioConectado && tipoSelec.equals("Cliente")) { %>
<h1 class="text-center">Capacitaciones</h1>
<hr class="hr" style="height: 20px"/>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Identificador</th>
        <th scope="col">Rut Cliente</th>
        <th scope="col">Dia</th>
        <th scope="col">Hora</th>
        <th scope="col">Lugar</th>
        <th scope="col">Duracion</th>
        <th scope="col">Cantidad Asistentes</th>
        <th scope="col">Creacion</th>
        <th scope="col"></th>
    </tr>
    </thead>

    <%
        CapacitacionDAOimpl CapacitacionDAO = new CapacitacionDAOimpl();
        List<Capacitacion> capacitaciones = CapacitacionDAO.listarCapacitacion();
        ;
        for (Capacitacion capacitacion : capacitaciones) {
    %>
    <tbody>
    <tr>
        <td><%= capacitacion.getIdentificador()%>
        </td>
        <td><%= capacitacion.getRutCliente()%>
        </td>
        <td><%= capacitacion.getDia()%>
        </td>
        <td><%= capacitacion.getHora()%>
        </td>
        <td><%= capacitacion.getLugar()%>
        </td>
        <td><%= capacitacion.getDuracion()%>
        </td>
        <td><%= capacitacion.getCantidadAsistentes()%>
        </td>
        <td><%= capacitacion.getCreated_at()%>
        </td>
        <td>
            <form method="post" action="svEliminarCap">
                <input type="hidden" name="identificador" value="<%= capacitacion.getIdentificador()%>">
                <button class="btn btn-sm btn-danger" type="button"
                        onclick="confirmarEliminacion('<%= capacitacion.getIdentificador()%>')">Eliminar
                </button>
            </form>
        </td>
    </tr>
    </tbody>
    <%}%>

</table>

<% } else { %>
<% response.sendRedirect("login.jsp"); %>
<% } %>

<script>
    /*Funcion confirmar la eliminacion de una capacitacion*/
    function confirmarEliminacion(identificador) {
        if (confirm("¿Estás seguro de que deseas eliminar esta capacitación?")) {
            document.querySelector('form[action="svEliminarCap"] input[name="identificador"]').value = identificador;
            document.querySelector('form[action="svEliminarCap"]').submit();
        }
    }


</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>
