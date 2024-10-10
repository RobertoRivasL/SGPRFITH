package controllers;

import dao.ClienteDAOimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cliente;

import java.io.IOException;

import static java.lang.System.out;

public class svEliminarCliente extends HttpServlet {

    /**
     * Maneja las solicitudes GET, actualmente no implementado.
     *
     * @param request  El objeto HttpServletRequest que contiene la solicitud del cliente.
     * @param response El objeto HttpServletResponse que contiene la respuesta al cliente.
     * @throws ServletException Si ocurre un error en el manejo del servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implementar si es necesario
    }

    /**
     * Maneja las solicitudes POST para eliminar un cliente.
     *
     * @param request  El objeto HttpServletRequest que contiene la solicitud del cliente.
     * @param response El objeto HttpServletResponse que contiene la respuesta al cliente.
     * @throws ServletException Si ocurre un error en el manejo del servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el identificador del cliente desde los parámetros de la solicitud
        int identificadorCliente = Integer.parseInt(request.getParameter("identificadorCliente"));

        // Crear una instancia del DAO y del objeto Cliente
        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        Cliente cliente = new Cliente();
        cliente.setId(identificadorCliente);

        // Eliminar el cliente y capturar el resultado de la operación
        boolean eliminado = clienteDAO.eliminar(cliente);

        // Redireccionar o mostrar un mensaje según el resultado de la operación
        if (eliminado) {
            response.sendRedirect("listaUsuarios.jsp"); // Redirigir a la lista de usuarios si se eliminó correctamente
        } else {
            out.print("No se pudo eliminar"); // Mostrar mensaje de error si no se eliminó
        }
    }
}
