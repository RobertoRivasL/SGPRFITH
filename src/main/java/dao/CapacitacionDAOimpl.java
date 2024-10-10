package dao;

import conexion.Conexion;
import idao.ICapacitacionDAO;
import models.Capacitacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz ICapacitacionDAO para realizar operaciones CRUD en la tabla de capacitaciones.
 */
public class CapacitacionDAOimpl implements ICapacitacionDAO {
    private static final Logger logger = Logger.getLogger(CapacitacionDAOimpl.class.getName());

    /**
     * Registra una nueva capacitación en la base de datos.
     *
     * @param capacitacion la capacitación a registrar.
     * @return true si el registro fue exitoso, false en caso de error.
     */
    @Override
    public boolean registrar(Capacitacion capacitacion) {
        boolean registrar = false;
        String sql = "INSERT INTO capacitacion (rutCliente, dia, hora, lugar, duracion, cantidadAsistentes) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, capacitacion.getRutCliente());
            pstmt.setString(2, capacitacion.getDia());
            pstmt.setString(3, capacitacion.getHora());
            pstmt.setString(4, capacitacion.getLugar());
            pstmt.setString(5, capacitacion.getDuracion());
            pstmt.setString(6, capacitacion.getCantidadAsistentes());
            pstmt.executeUpdate();
            registrar = true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en el método registrar", e);
        }
        return registrar;
    }

    /**
     * Elimina una capacitación de la base de datos.
     *
     * @param capacitacion la capacitación a eliminar.
     * @return true si la eliminación fue exitosa, false en caso de error.
     */
    @Override
    public boolean eliminar(Capacitacion capacitacion) {
        boolean eliminar = false;
        String sql = "DELETE FROM capacitacion WHERE id = ?";
        try (Connection con = Conexion.conectar(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, capacitacion.getIdentificador());
            pstmt.executeUpdate();
            eliminar = true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en el método eliminar", e);
        }
        return eliminar;
    }

    /**
     * Modifica los detalles de una capacitación en la base de datos.
     *
     * @param capacitacion la capacitación a modificar.
     * @return true si la modificación fue exitosa, false en caso de error.
     */
    @Override
    public boolean modificar(Capacitacion capacitacion) {
        boolean modificar = false;
        // Este método necesita ser implementado correctamente
        String sql = "UPDATE capacitacion SET rutCliente = ?, dia = ?, hora = ?, lugar = ?, duracion = ?, cantidadAsistentes = ? WHERE id = ?";
        try (Connection con = Conexion.conectar(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, capacitacion.getRutCliente());
            pstmt.setString(2, capacitacion.getDia());
            pstmt.setString(3, capacitacion.getHora());
            pstmt.setString(4, capacitacion.getLugar());
            pstmt.setString(5, capacitacion.getDuracion());
            pstmt.setString(6, capacitacion.getCantidadAsistentes());
            pstmt.setString(7, capacitacion.getIdentificador());
            pstmt.executeUpdate();
            modificar = true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en el método modificar", e);
        }
        return modificar;
    }

    /**
     * Lista todas las capacitaciones almacenadas en la base de datos.
     *
     * @return una lista de capacitaciones.
     */
    @Override
    public List<Capacitacion> listarCapacitacion() {
        List<Capacitacion> listaCapacitaciones = new ArrayList<>();
        String sql = "SELECT id, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes, created_at FROM capacitacion ORDER BY id";
        try (Connection con = Conexion.conectar(); Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Capacitacion capacitacion = new Capacitacion();
                capacitacion.setIdentificador(rs.getString(1));
                capacitacion.setRutCliente(rs.getString(2));
                capacitacion.setDia(rs.getString(3));
                capacitacion.setHora(rs.getString(4));
                capacitacion.setLugar(rs.getString(5));
                capacitacion.setDuracion(rs.getString(6));
                capacitacion.setCantidadAsistentes(rs.getString(7));
                capacitacion.setCreated_at(rs.getDate(8));
                listaCapacitaciones.add(capacitacion);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en el método listar", e);
        }
        return listaCapacitaciones;
    }
}