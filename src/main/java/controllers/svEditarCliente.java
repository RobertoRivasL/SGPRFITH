package controllers;

import dao.ClienteDAOimpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cliente;

import java.io.IOException;

public class svEditarCliente extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String nuevoID = request.getParameter("nuevoID");
        int nuevoIDx = Integer.parseInt(nuevoID);
        String nuevoUsername = request.getParameter("nuevoUsuarioMOD");
        String nuevoPassword = request.getParameter("nuevoPasswordMOD");
        String nuevoNombre = request.getParameter("nombreMOD");
        String nuevaFecha = request.getParameter("fechaNacimientoMOD");
        String nuevoTipo = request.getParameter("TipoMOD");
        String nuevorutCliente = request.getParameter("rutCLMOD");
        String nuevoNombres = request.getParameter("nombresMOD");
        String nuevoApellidos = request.getParameter("apellidosMOD");
        String nuevoTelefono = request.getParameter("telefonoMOD");
        int telefonox = Integer.parseInt(nuevoTelefono);
        String nuevaAFP = request.getParameter("afpMOD");
        String nuevaSalud = request.getParameter("saludMOD");
        String nuevaDireccionCliente = request.getParameter("direccionClienteMOD");
        String nuevaComuna = request.getParameter("comunaMOD");
        String nuevaEdad = request.getParameter("edadMOD");
        int edadx = Integer.parseInt(nuevaEdad);

        Cliente cliente = new Cliente(nuevoIDx, nuevoUsername, nuevoPassword, nuevoNombre, nuevaFecha, nuevoTipo, nuevorutCliente, nuevoNombres
                , nuevoApellidos, telefonox, nuevaAFP, nuevaSalud, nuevaDireccionCliente, nuevaComuna, edadx);

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();

        clienteDAO.modificar(cliente);

        RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
        rd.forward(request, response);

    }
}
