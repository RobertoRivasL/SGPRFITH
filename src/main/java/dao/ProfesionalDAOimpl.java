package dao;

import conexion.Conexion;
import idao.IProfesionalDAO;
import models.Profesional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDAOimpl implements IProfesionalDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProfesionalDAOimpl.class);

    @Override
    public boolean registrar(Profesional profesional) {
        boolean registrar = false;
        String sql = "INSERT INTO profesionales (username,password,nombre,fechaNacimiento,tipo,titulo,fechaIngreso) values(?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, profesional.getUsername());
            ps.setString(2, profesional.getPassword());
            ps.setString(3, profesional.getNombre());
            ps.setString(4, profesional.getFechaNacimiento());
            ps.setString(5, profesional.getTipo());
            ps.setString(6, profesional.getTitulo());
            ps.setString(7, profesional.getFechaIngreso());

            ps.execute();
            registrar = true;

        } catch (SQLException e) {
            logger.error("Error: clase ProfesionalDAOimpl en el metodo registrar", e);
        }

        return registrar;
    }

    @Override
    public boolean eliminar(Profesional profesional) {
        boolean eliminar = false;
        String sql = "DELETE from profesionales where id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, profesional.getId());
            ps.execute();
            eliminar = true;

        } catch (SQLException e) {
            logger.error("Error: clase ProfesionalDAOimpl en el metodo eliminar", e);
        }

        return eliminar;
    }

    @Override
    public boolean modificar(Profesional profesional) {
        boolean modificar = false;
        String sql = "UPDATE profesionales SET username = ?, password = ?, nombre = ?, fechaNacimiento = ?, tipo = ?, titulo = ?, fechaIngreso = ? WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, profesional.getUsername());
            ps.setString(2, profesional.getPassword());
            ps.setString(3, profesional.getNombre());
            ps.setString(4, profesional.getFechaNacimiento());
            ps.setString(5, profesional.getTipo());
            ps.setString(6, profesional.getTitulo());
            ps.setString(7, profesional.getFechaIngreso());
            ps.setInt(8, profesional.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                modificar = true;
                logger.info("Actualización exitosa");
            } else {
                logger.info("Ninguna fila se ha actualizado.");
            }

        } catch (SQLException e) {
            logger.error("Error: clase ProfesionalDAOimpl en el metodo modificar", e);
        }

        return modificar;
    }

    @Override
    public List<Profesional> listarProfesionales() {
        List<Profesional> listaProfesionales = new ArrayList<>();
        String sql = "SELECT id, username, password, nombre, fechaNacimiento, tipo, titulo, fechaIngreso, created_at FROM profesionales ORDER BY id";

        try (Connection con = Conexion.conectar();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                Profesional profesional = new Profesional();
                profesional.setId(rs.getInt(1));
                profesional.setUsername(rs.getString(2));
                profesional.setPassword(rs.getString(3));
                profesional.setNombre(rs.getString(4));
                profesional.setFechaNacimiento(rs.getString(5));
                profesional.setTipo(rs.getString(6));
                profesional.setTitulo(rs.getString(7));
                profesional.setFechaIngreso(rs.getString(8));
                profesional.setCreated_at(rs.getDate(9));

                listaProfesionales.add(profesional);
            }

        } catch (SQLException e) {
            logger.error("Error: clase ProfesionalDAOimpl en el metodo listar", e);
        }

        return listaProfesionales;
    }
}
