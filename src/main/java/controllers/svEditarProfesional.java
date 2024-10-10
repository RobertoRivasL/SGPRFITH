package controllers;

import dao.ProfesionalDAOimpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Profesional;

import java.io.IOException;

public class svEditarProfesional extends HttpServlet {


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
        String nuevotitulo = request.getParameter("tituloMOD");
        String nuevaFechaIngreso = request.getParameter("fechaIngresoMOD");


        Profesional profesional = new Profesional(nuevoIDx, nuevoUsername, nuevoPassword, nuevoNombre, nuevaFecha, nuevoTipo,
                nuevotitulo, nuevaFechaIngreso);

        ProfesionalDAOimpl profesionalDAO = new ProfesionalDAOimpl();

        profesionalDAO.modificar(profesional);

        RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
        rd.forward(request, response);

    }
}
