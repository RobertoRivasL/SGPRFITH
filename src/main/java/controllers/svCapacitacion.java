package controllers;

import dao.CapacitacionDAOimpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Capacitacion;

import java.io.IOException;

public class svCapacitacion extends HttpServlet {

    public svCapacitacion() {
        super();

        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


        String rutCliente = request.getParameter("rutCliente");
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        String lugar = request.getParameter("lugar");
        String duracion = request.getParameter("duracion");
        String cantidadAsistentes = request.getParameter("cantidadAsistentes");


        request.setAttribute("rutCliente", rutCliente);
        request.setAttribute("dia", dia);
        request.setAttribute("hora", hora);
        request.setAttribute("lugar", lugar);
        request.setAttribute("duracion", duracion);
        request.setAttribute("cantidadAsistentes", cantidadAsistentes);

        Capacitacion capacitacion = new Capacitacion(rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);

        CapacitacionDAOimpl CapacitacionDAO = new CapacitacionDAOimpl();

        CapacitacionDAO.registrar(capacitacion);

        RequestDispatcher rd = request.getRequestDispatcher("/capacitacion.jsp");
        rd.forward(request, response);


    }

}
