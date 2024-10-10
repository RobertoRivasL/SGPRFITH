package dao;

import conexion.Conexion;
import idao.IAdministrativoDAO;
import models.Administrativo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministrativoDAOimpl implements IAdministrativoDAO {

    // Logger para manejar errores y mensajes informativos
    private static final Logger logger = Logger.getLogger(AdministrativoDAOimpl.class.getName());

    /**
     * Registra un nuevo administrativo en la base de datos.
     *
     * @param administrativo El objeto Administrativo que se va a registrar.
     * @return true si se registra exitosamente, false en caso contrario.
     */
    @Override
    public boolean registrar(Administrativo administrativo) {
        boolean registrar = false;

        String sql = "INSERT INTO administrativos (username, password, nombre, fechaNacimiento, tipo, area, expPrevia) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Usamos try-with-resources para asegurar el cierre de los recursos.
        try (Connection con = Conexion.conectar();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            // Asignamos los valores en lugar de concatenar la cadena.
            preparedStatement.setString(1, administrativo.getUsername());
            preparedStatement.setString(2, administrativo.getPassword());
            preparedStatement.setString(3, administrativo.getNombre());
            preparedStatement.setString(4, administrativo.getFechaNacimiento());
            preparedStatement.setString(5, administrativo.getTipo());
            preparedStatement.setString(6, administrativo.getArea());
            preparedStatement.setString(7, administrativo.getExpPrevia());

            preparedStatement.executeUpdate();
            registrar = true;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error: clase AdministrativoDAOimpl en el metodo registrar", e);
        }
        return registrar;
    }


    /**
     * Elimina un administrativo de la base de datos.
     *
     * @param administrativo El objeto Administrativo que se va a eliminar.
     * @return true si se elimina exitosamente, false en caso contrario.
     */
    @Override
    public boolean eliminar(Administrativo administrativo) {
        boolean eliminar = false;

        String sql = "DELETE FROM administrativos WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, administrativo.getId());
            preparedStatement.executeUpdate();
            eliminar = true;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error: clase AdministrativoDAOimpl en el metodo eliminar", e);
        }
        return eliminar;
    }


    /**
     * Modifica los detalles de un administrativo en la base de datos.
     *
     * @param administrativo El objeto Administrativo con los nuevos datos.
     * @return true si se modifica exitosamente, false en caso contrario.
     */
    @Override
    public boolean modificar(Administrativo administrativo) {
        boolean modificar = false;

        String sql = "UPDATE administrativos SET " +
                "username = ?, " +
                "password = ?, " +
                "nombre = ?, " +
                "fechaNacimiento = ?, " +
                "tipo = ?, " +
                "area = ?, " +
                "expPrevia = ? " +
                "WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, administrativo.getUsername());
            preparedStatement.setString(2, administrativo.getPassword());
            preparedStatement.setString(3, administrativo.getNombre());
            preparedStatement.setString(4, administrativo.getFechaNacimiento());
            preparedStatement.setString(5, administrativo.getTipo());
            preparedStatement.setString(6, administrativo.getArea());
            preparedStatement.setString(7, administrativo.getExpPrevia());
            preparedStatement.setInt(8, administrativo.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                modificar = true;
                logger.info("Actualización exitosa");
            } else {
                logger.info("Ninguna fila se ha actualizado.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error: clase AdministrativoDAOImpl en el metodo modificar", e);
        }
        return modificar;
    }

    /**
     * Lista todos los administrativos almacenados en la base de datos.
     *
     * @return Lista de objetos Administrativo.
     */
    @Override
    public List<Administrativo> listarAdministrativos() {
        List<Administrativo> listaAdministrativos = new ArrayList<>();

        String sql = "SELECT id, username, password, nombre, fechaNacimiento, tipo, area, expPrevia, created_at FROM administrativos ORDER BY id"; // Especificar columnas

        try (Connection con = Conexion.conectar();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                Administrativo administrativo = new Administrativo();

                administrativo.setId(rs.getInt(1));
                administrativo.setUsername(rs.getString(2));
                administrativo.setPassword(rs.getString(3));
                administrativo.setNombre(rs.getString(4));
                administrativo.setFechaNacimiento(rs.getString(5));
                administrativo.setTipo(rs.getString(6));
                administrativo.setArea(rs.getString(7));
                administrativo.setExpPrevia(rs.getString(8));
                administrativo.setCreated_at(rs.getDate(9));

                listaAdministrativos.add(administrativo);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error: clase AdministrativoDAOimpl en el metodo listar", e);
        }

        return listaAdministrativos;
    }
}
