<%@ page import="java.util.List" %>
<%@ page import="dao.ClienteDAOimpl" %>
<%@ page import="models.Cliente" %>
<%@ page import="models.Profesional" %>
<%@ page import="dao.ProfesionalDAOimpl" %>
<%@ page import="dao.AdministrativoDAOimpl" %>
<%@ page import="models.Administrativo" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Lista Usuarios</title>
</head>
<body>
<%String tipoSelec = (String) request.getSession().getAttribute("tipoSeleccionado");%>
<% if (usuarioConectado != null && usuarioConectado && tipoSelec.equals("Administrativo")) { %>
<h1 class="text-center">Lista de Usuarios</h1>
<hr class="hr" style="height: 20px"/>

<div class="container">
    <div class="text-center">
        <a href="crearUsuario.jsp" class="btn btn-success mb-3">Crear Usuario</a>
    </div>
    <div class="mb-3" style="display: flex; justify-content: space-between;">
        <button id="botonClientes" class="btn btn-primary btn-dark mb-3 text-center">Mostrar Clientes</button>
    </div>
    <div id="listaClientes" style="display: none">
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Identificador</th>
                <th scope="col">Usuario</th>
                <th scope="col">Nombre</th>
                <th scope="col">Fecha Nacimiento</th>
                <th scope="col">Tipo</th>
                <th scope="col">Rut Cliente</th>
                <th scope="col">Nombres</th>
                <th scope="col">Apellidos</th>
                <th scope="col">Telefono</th>
                <th scope="col">Afp</th>
                <th scope="col">Salud</th>
                <th scope="col">Direccion</th>
                <th scope="col">Comuna</th>
                <th scope="col">edad</th>
                <th scope="col">Creacion</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <%
                ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
                List<Cliente> clientes = clienteDAO.listarClientes();
                for (Cliente cliente : clientes) {
            %>
            <tbody>
            <tr>
                <td><%= cliente.getId()%>
                </td>
                <td><%= cliente.getUsername()%>
                </td>
                <td><%= cliente.getNombre()%>
                </td>
                <td><%= cliente.getFechaNacimiento()%>
                </td>
                <td><%= cliente.getTipo()%>
                </td>
                <td><%= cliente.getRut()%>
                </td>
                <td><%= cliente.getNombres()%>
                </td>
                <td><%= cliente.getApellidos()%>
                </td>
                <td><%= cliente.getTelefono()%>
                </td>
                <td><%= cliente.getAfp()%>
                </td>
                <td><%= cliente.getSistemaSalud()%>
                </td>
                <td><%= cliente.getDireccion()%>
                </td>
                <td><%= cliente.getComuna()%>
                </td>
                <td><%= cliente.getEdad()%>
                </td>
                <td><%= cliente.getCreated_at()%>
                </td>
                <td class="text-right">
                    <a href="editarCliente.jsp?id=<%= cliente.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                </td>
                <td>
                    <form method="post" action="svEliminarCliente">
                        <input type="hidden" name="identificadorCliente" value="<%= cliente.getId()%>">
                        <button class="btn btn-sm btn-danger" type="button"
                                onclick="confirmarEliminacionCliente('<%= cliente.getId()%>')">Eliminar
                        </button>
                    </form>
                </td>
            </tr>
            </tbody>
            <%}%>
        </table>
    </div>

    <div class="mb-3" style="display: flex; justify-content: space-between;">
        <button id="botonProfesionales" class="btn btn-primary btn-dark mb-3 text-center">Mostrar Profesionales</button>
    </div>
    <div id="listaProfesionales" style="display: none">
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Identificador</th>
                <th scope="col">Usuario</th>
                <th scope="col">Nombre</th>
                <th scope="col">Fecha Nacimiento</th>
                <th scope="col">Tipo</th>
                <th scope="col">Titulo</th>
                <th scope="col">Fecha Ingreso</th>
                <th scope="col">Creacion</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <%
                ProfesionalDAOimpl profesionalDAO = new ProfesionalDAOimpl();
                List<Profesional> profesionales = profesionalDAO.listarProfesionales();
                for (Profesional profesional : profesionales) {
            %>
            <tbody>
            <tr>
                <td><%= profesional.getId()%>
                </td>
                <td><%= profesional.getUsername()%>
                </td>
                <td><%= profesional.getNombre()%>
                </td>
                <td><%= profesional.getFechaNacimiento()%>
                </td>
                <td><%= profesional.getTipo()%>
                </td>
                <td><%= profesional.getTitulo()%>
                </td>
                <td><%= profesional.getFechaIngreso()%>
                </td>
                <td><%= profesional.getCreated_at()%>
                </td>
                <td class="text-right">
                    <a href="editarProfesional.jsp?id=<%= profesional.getId() %>"
                       class="btn btn-primary btn-sm">Editar</a>
                </td>
                <td>
                    <form method="post" action="svEliminarProfesional">
                        <input type="hidden" name="identificadorProfesional" value="<%= profesional.getId()%>">
                        <button class="btn btn-sm btn-danger" type="button"
                                onclick="confirmarEliminacionProfesional('<%= profesional.getId()%>')">Eliminar
                        </button>
                    </form>
                </td>
            </tr>
            </tbody>
            <%}%>
        </table>
    </div>

    <div class="mb-3" style="display: flex; justify-content: space-between;">
        <button id="botonAdministrativos" class="btn btn-primary btn-dark mb-3 text-center">Mostrar Administrativos
        </button>
    </div>
    <div id="listaAdministrativos" style="display: none">
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Identificador</th>
                <th scope="col">Usuario</th>
                <th scope="col">Nombre</th>
                <th scope="col">Fecha Nacimiento</th>
                <th scope="col">Tipo</th>
                <th scope="col">Area</th>
                <th scope="col">Experiencia Previa</th>
                <th scope="col">Creacion</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <%
                AdministrativoDAOimpl administrativoDAO = new AdministrativoDAOimpl();
                List<Administrativo> administrativos = administrativoDAO.listarAdministrativos();
                for (Administrativo administrativo : administrativos) {
            %>
            <tbody>
            <tr>
                <td><%= administrativo.getId()%>
                </td>
                <td><%= administrativo.getUsername()%>
                </td>
                <td><%= administrativo.getNombre()%>
                </td>
                <td><%= administrativo.getFechaNacimiento()%>
                </td>
                <td><%= administrativo.getTipo()%>
                </td>
                <td><%= administrativo.getArea()%>
                </td>
                <td><%= administrativo.getExpPrevia()%>
                </td>
                <td><%= administrativo.getCreated_at()%>
                </td>
                <td class="text-right">
                    <a href="editarAdministrativo.jsp?id=<%= administrativo.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                </td>
                <td>
                    <form method="post" action="svEliminarAdministrativo">
                        <input type="hidden" name="identificadorAdministrativo" value="<%= administrativo.getId()%>">
                        <button class="btn btn-sm btn-danger" type="button"
                                onclick="confirmarEliminacionAdministrativo('<%= administrativo.getId()%>')">Eliminar
                        </button>
                    </form>
                </td>
            </tr>
            </tbody>
            <%}%>
        </table>
    </div>
</div>


<% } else { %>
<% response.sendRedirect("login.jsp"); %>
<% } %>
</body>


<script>
    /*Funcion para mostrar o cerrar la informacion de administrativo*/
    var divVisibleAdministrativos = false;
    document.getElementById('botonAdministrativos').addEventListener('click', function () {
        var div = document.getElementById('listaAdministrativos');
        if (divVisibleAdministrativos) {
            div.style.display = 'none';
            divVisibleAdministrativos = false;
            document.getElementById('botonAdministrativos').textContent = 'Mostrar Administrativos'
        } else {
            div.style.display = 'block';
            divVisibleAdministrativos = true;
            document.getElementById('botonAdministrativos').textContent = 'Cerrar Administrativos'
        }

    });


</script>


<script>
    /*Funcion para mostrar o cerrar la informacion de profesional*/
    var divVisibleProfesionales = false;
    document.getElementById('botonProfesionales').addEventListener('click', function () {
        var div = document.getElementById('listaProfesionales');
        if (divVisibleProfesionales) {
            div.style.display = 'none';
            divVisibleProfesionales = false;
            document.getElementById('botonProfesionales').textContent = 'Mostrar Profesionales'
        } else {
            div.style.display = 'block';
            divVisibleProfesionales = true;
            document.getElementById('botonProfesionales').textContent = 'Cerrar Profesionales'
        }

    });

</script>


<script>
    /*Funcion para mostrar o cerrar la informacion de cliente*/
    var divVisibleClientes = false;
    document.getElementById('botonClientes').addEventListener('click', function () {
        var div = document.getElementById('listaClientes');
        if (divVisibleClientes) {
            div.style.display = 'none';
            divVisibleClientes = false;
            document.getElementById('botonClientes').textContent = 'Mostrar Clientes'
        } else {
            div.style.display = 'block';
            divVisibleClientes = true;
            document.getElementById('botonClientes').textContent = 'Cerrar Clientes'
        }

    });

</script>

<script>
    /* Funcion para confirmar la eliminacion del elemento seleccionado*/

    function confirmarEliminacionCliente(identificadorCliente) {
        if (confirm("¿Estás seguro de que deseas eliminar este Cliente?")) {
            document.querySelector('form[action="svEliminarCliente"] input[name="identificadorCliente"]').value = identificadorCliente;
            document.querySelector('form[action="svEliminarCliente"]').submit();

        }
    }

    function confirmarEliminacionProfesional(identificadorProfesional) {
        if (confirm("¿Estás seguro de que deseas eliminar este Profesional?")) {
            document.querySelector('form[action="svEliminarProfesional"] input[name="identificadorProfesional"]').value = identificadorProfesional;
            document.querySelector('form[action="svEliminarProfesional"]').submit();
        }
    }

    function confirmarEliminacionAdministrativo(identificadorAdministrativo) {
        if (confirm("¿Estás seguro de que deseas eliminar este Administrativo?")) {
            document.querySelector('form[action="svEliminarAdministrativo"] input[name="identificadorAdministrativo"]').value = identificadorAdministrativo;
            document.querySelector('form[action="svEliminarAdministrativo"]').submit();
        }
    }

</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</html>
