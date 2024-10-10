package controllers;

import dao.AdministrativoDAOimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Administrativo;

import java.io.IOException;

import static java.lang.System.out;

public class svEliminarAdministrativo extends HttpServlet {

    /**
     * Método no implementado para manejar solicitudes GET.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Implementar si es necesario
    }

    /**
     * Maneja las solicitudes POST para eliminar un administrativo.
     *
     * @param request  El objeto HttpServletRequest que contiene la solicitud del cliente.
     * @param response El objeto HttpServletResponse que contiene la respuesta al cliente.
     * @throws ServletException En caso de un error de la servlet.
     * @throws IOException      En caso de un error de I/O.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el identificador del administrativo desde los parámetros de la solicitud
        int identificadorAdministrativo = Integer.parseInt(request.getParameter("identificadorAdministrativo"));

        // Crear una instancia del DAO y del objeto Administrativo
        AdministrativoDAOimpl administrativoDAO = new AdministrativoDAOimpl();
        Administrativo administrativo = new Administrativo();
        administrativo.setId(identificadorAdministrativo);

        // Eliminar el administrativo y capturar el resultado de la operación
        boolean eliminado = administrativoDAO.eliminar(administrativo);

        // Redireccionar o mostrar un mensaje según el resultado de la operación
        if (eliminado) {
            response.sendRedirect("listaUsuarios.jsp"); // Redirigir a la lista de usuarios si se eliminó correctamente
        } else {
            out.print("No se pudo eliminar"); // Mostrar mensaje de error si no se eliminó
        }
    }
}
