package controllers;

import dao.AdministrativoDAOimpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Administrativo;

import java.io.IOException;

/**
 * Servlet encargado de manejar la edición de datos de un administrativo.
 * Extiende de HttpServlet y maneja las peticiones POST para actualizar los datos.
 */
public class svEditarAdministrativo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Método no utilizado. Se puede implementar si se requiere manejo de peticiones GET.
    }

    /**
     * Maneja las peticiones POST para actualizar los datos de un Administrativo.
     *
     * @param request  HTTP request que contiene los parámetros enviados desde el formulario.
     * @param response HTTP response para redirigir o enviar información de vuelta al cliente.
     * @throws ServletException Si ocurre un error con el servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nuevoID = request.getParameter("nuevoID");
        int nuevoIDx = Integer.parseInt(nuevoID);

        // Obtener parámetros desde la solicitud HTTP
        String nuevoUsername = request.getParameter("nuevoUsuarioMOD");
        String nuevoPassword = request.getParameter("nuevoPasswordMOD");
        String nuevoNombre = request.getParameter("nombreMOD");
        String nuevaFecha = request.getParameter("fechaNacimientoMOD");
        String nuevoTipo = request.getParameter("TipoMOD");
        String nuevaArea = request.getParameter("areaMOD");
        String nuevaExpPrevia = request.getParameter("expPreviaMOD");

        // Crear un objeto Administrativo con los datos recibidos
        Administrativo administrativo = new Administrativo(nuevoIDx, nuevoUsername, nuevoPassword, nuevoNombre, nuevaFecha, nuevoTipo, nuevaArea, nuevaExpPrevia);

        // Usar el DAO para modificar los datos del administrativo en la base de datos
        AdministrativoDAOimpl administrativoDAO = new AdministrativoDAOimpl();
        administrativoDAO.modificar(administrativo);

        // Redireccionar o reenviar a la página listaUsuarios.jsp
        RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
        rd.forward(request, response);
    }
}