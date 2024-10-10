package controllers;

import dao.AdministrativoDAOimpl;
import dao.ClienteDAOimpl;
import dao.ProfesionalDAOimpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Administrativo;
import models.Cliente;
import models.Profesional;

import java.io.IOException;
import java.util.List;

public class svCrearUsuario extends HttpServlet {
    public svCrearUsuario() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String nuevoTipo = request.getParameter("Tipo");
        String nuevoUsername = request.getParameter("nuevoUsuario");
        boolean usuarioEncontradoCliente = false;
        boolean usuarioEncontradoProfesional = false;
        boolean usuariosEncontradoAdministrativo = false;
        boolean usuarioEncontrado = false;
        String name = "";

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        ProfesionalDAOimpl profesionalDAO = new ProfesionalDAOimpl();
        AdministrativoDAOimpl administrativoDAO = new AdministrativoDAOimpl();
        List<Cliente> listadoCliente = clienteDAO.listarClientes();
        List<Profesional> listadoProfesional = profesionalDAO.listarProfesionales();
        List<Administrativo> listadoAdministrativo = administrativoDAO.listarAdministrativos();


        for (Cliente cliente : listadoCliente) {
            if (cliente.getUsername().equals(nuevoUsername)) {
                usuarioEncontradoCliente = true;
                name = cliente.getNombre();
                break;
            }

        }
        for (Profesional profesional : listadoProfesional) {
            if (profesional.getUsername().equals(nuevoUsername)) {
                usuarioEncontradoProfesional = true;
                name = profesional.getNombre();
                break;
            }

        }
        for (Administrativo administrativo : listadoAdministrativo) {
            if (administrativo.getUsername().equals(nuevoUsername)) {
                usuariosEncontradoAdministrativo = true;
                name = administrativo.getNombre();
                break;
            }

        }

        if (usuarioEncontradoCliente || usuarioEncontradoProfesional || usuariosEncontradoAdministrativo) {
            usuarioEncontrado = true;
        }

        if (usuarioEncontrado) {
            request.getSession().setAttribute("usuarioRegistrado", true);
            request.getSession().setAttribute("error", true);
            RequestDispatcher rd = request.getRequestDispatcher("/crearUsuario.jsp");
            rd.forward(request, response);
        } else {
            request.getSession().setAttribute("usuarioRegistrado", false);
            request.getSession().setAttribute("nombre", name);

            if (nuevoTipo.equals("Cliente")) {

                String nuevoPassword = request.getParameter("nuevoPassword");
                String nuevoNombre = request.getParameter("nombre");
                String nuevaFecha = request.getParameter("fechaNacimiento");

                String nuevorutCliente = request.getParameter("rutCL");
                String nuevoNombres = request.getParameter("nombres");
                String nuevoApellidos = request.getParameter("apellidos");
                String nuevoTelefono = request.getParameter("telefono");
                int telefonox = Integer.parseInt(nuevoTelefono);
                String nuevaAFP = request.getParameter("afp");
                String nuevaSalud = request.getParameter("salud");
                String nuevaDireccionCliente = request.getParameter("direccionCliente");
                String nuevaComuna = request.getParameter("comuna");
                String nuevaEdad = request.getParameter("edad");
                int edadx = Integer.parseInt(nuevaEdad);

                Cliente cliente = new Cliente(nuevoUsername, nuevoPassword, nuevoNombre, nuevaFecha, nuevoTipo, nuevorutCliente, nuevoNombres
                        , nuevoApellidos, telefonox, nuevaAFP, nuevaSalud, nuevaDireccionCliente, nuevaComuna, edadx);

                request.getSession().setAttribute("usuarioRegistrado", false);
                clienteDAO.registrar(cliente);
                RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
                rd.forward(request, response);


            } else if (nuevoTipo.equals("Profesional")) {

                String nuevoPassword = request.getParameter("nuevoPassword");
                String nuevoNombre = request.getParameter("nombre");
                String nuevaFecha = request.getParameter("fechaNacimiento");

                String nuevoTitulo = request.getParameter("titulo");
                String nuevaFechaIngreso = request.getParameter("fechaIngreso");

                Profesional profesional = new Profesional(nuevoUsername, nuevoPassword, nuevoNombre, nuevaFecha, nuevoTipo,
                        nuevoTitulo, nuevaFechaIngreso);

                request.getSession().setAttribute("usuarioRegistrado", false);
                profesionalDAO.registrar(profesional);
                RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
                rd.forward(request, response);


            } else if (nuevoTipo.equals("Administrativo")) {

                String nuevoPassword = request.getParameter("nuevoPassword");
                String nuevoNombre = request.getParameter("nombre");
                String nuevaFecha = request.getParameter("fechaNacimiento");

                String nuevaArea = request.getParameter("area");
                String nuevaExp = request.getParameter("expPrevia");

                Administrativo administrativo = new Administrativo(nuevoUsername, nuevoPassword, nuevoNombre, nuevaFecha, nuevoTipo
                        , nuevaArea, nuevaExp);

                administrativoDAO.registrar(administrativo);

                request.getSession().setAttribute("usuarioRegistrado", false);

                RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
                rd.forward(request, response);

            }
        }

    }
}
