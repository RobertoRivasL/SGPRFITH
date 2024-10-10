package controllers;

import dao.ProfesionalDAOimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Profesional;

import java.io.IOException;

import static java.lang.System.out;

public class svEliminarProfesional extends HttpServlet {

    /**
     * Método no implementado para manejar solicitudes GET.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implementar si es necesario
    }

    /**
     * Maneja las solicitudes POST para eliminar un profesional.
     *
     * @param request  El objeto HttpServletRequest que contiene la solicitud del cliente.
     * @param response El objeto HttpServletResponse que contiene la respuesta al cliente.
     * @throws ServletException Si ocurre un error de la servlet.
     * @throws IOException      Si ocurre un error de I/O.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el identificador del profesional desde los parámetros de la solicitud
        int identificadorProfesional = Integer.parseInt(request.getParameter("identificadorProfesional"));

        // Crear una instancia del DAO y del objeto Profesional
        ProfesionalDAOimpl profesionalDAO = new ProfesionalDAOimpl();
        Profesional profesional = new Profesional();
        profesional.setId(identificadorProfesional);

        // Eliminar el profesional y capturar el resultado de la operación
        boolean eliminado = profesionalDAO.eliminar(profesional);

        // Redireccionar o mostrar un mensaje según el resultado de la operación
        if (eliminado) {
            response.sendRedirect("listaUsuarios.jsp"); // Redirigir si la eliminación fue exitosa
        } else {
            out.print("No se pudo eliminar"); // Mostrar un mensaje de error si no se eliminó
        }
    }
}
