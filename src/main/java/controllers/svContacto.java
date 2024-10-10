package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class svContacto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public svContacto() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String mensaje = request.getParameter("mensaje");

        request.setAttribute("nombre", nombre);
        request.setAttribute("correo", correo);
        request.setAttribute("mensaje", mensaje);

        // Muestra los atributos por consola
        System.out.print("Nombre: " + nombre + " Correo: " + correo + " Mensaje: " + mensaje);

        RequestDispatcher rd = request.getRequestDispatcher("/contacto.jsp");
        rd.forward(request, response);


    }

}

