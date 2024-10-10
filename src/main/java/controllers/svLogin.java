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

public class svLogin extends HttpServlet {
    public svLogin() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String rutUsuario = request.getParameter("rutUsuario");
        String password = request.getParameter("password");
        boolean usuarioEncontradoCliente = false;
        boolean usuarioEncontradoProfesional = false;
        boolean usuariosEncontradoAdministrativo = false;
        boolean usuarioEncontrado = false;
        String name = "";
        String tipoSeleccionado = "";

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        ProfesionalDAOimpl profesionalDAO = new ProfesionalDAOimpl();
        AdministrativoDAOimpl administrativoDAO = new AdministrativoDAOimpl();
        List<Cliente> listadoCliente = clienteDAO.listarClientes();
        List<Profesional> listadoProfesional = profesionalDAO.listarProfesionales();
        List<Administrativo> listadoAdministrativo = administrativoDAO.listarAdministrativos();


        for (Cliente cliente : listadoCliente) {
            if (cliente.getUsername().equals(rutUsuario) && cliente.getPassword().equals(password)) {
                usuarioEncontradoCliente = true;
                name = cliente.getNombre();
                tipoSeleccionado = cliente.getTipo();
                break;
            }

        }
        for (Profesional profesional : listadoProfesional) {
            if (profesional.getUsername().equals(rutUsuario) && profesional.getPassword().equals(password)) {
                usuarioEncontradoProfesional = true;
                name = profesional.getNombre();
                tipoSeleccionado = profesional.getTipo();
                break;
            }

        }
        for (Administrativo administrativo : listadoAdministrativo) {
            if (administrativo.getUsername().equals(rutUsuario) && administrativo.getPassword().equals(password)) {
                usuariosEncontradoAdministrativo = true;
                name = administrativo.getNombre();
                tipoSeleccionado = administrativo.getTipo();
                break;
            }

        }

        if (usuarioEncontradoCliente || usuarioEncontradoProfesional || usuariosEncontradoAdministrativo) {
            usuarioEncontrado = true;
        }

        if (usuarioEncontrado) {
            request.getSession().setAttribute("usuarioConectado", true);
            request.getSession().setAttribute("nombre", name);
            request.getSession().setAttribute("tipoSeleccionado", tipoSeleccionado);
            RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
            rd.forward(request, response);
        } else {
            request.getSession().setAttribute("usuarioConectado", false);
            request.getSession().setAttribute("errorLogin", true);
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }


    }
}