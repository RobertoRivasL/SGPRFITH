package dao;

import conexion.Conexion;
import idao.IClienteDAO;
import models.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl implements IClienteDAO {
    private static final Logger logger = LoggerFactory.getLogger(ClienteDAOimpl.class);

    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;
        String sql = "INSERT INTO clientes (username, password, nombre, fechaNacimiento, tipo, rutCliente, nombres, apellidos, telefono, afp, salud, direccion, comuna, edad) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, cliente.getUsername());
            stm.setString(2, cliente.getPassword());
            stm.setString(3, cliente.getNombre());
            stm.setString(4, cliente.getFechaNacimiento());
            stm.setString(5, cliente.getTipo());
            stm.setString(6, cliente.getRut());
            stm.setString(7, cliente.getNombres());
            stm.setString(8, cliente.getApellidos());
            stm.setInt(9, cliente.getTelefono());
            stm.setString(10, cliente.getAfp());
            stm.setString(11, cliente.getSistemaSalud());
            stm.setString(12, cliente.getDireccion());
            stm.setString(13, cliente.getComuna());
            stm.setInt(14, cliente.getEdad());

            stm.executeUpdate();
            registrar = true;
        } catch (SQLException e) {
            logger.error("Error en el método registrar de ClienteDAOimpl", e);
        }
        return registrar;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        boolean eliminar = false;
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, cliente.getId());
            stm.executeUpdate();
            eliminar = true;
        } catch (SQLException e) {
            logger.error("Error en el método eliminar de ClienteDAOimpl", e);
        }
        return eliminar;
    }

    @Override
    public boolean modificar(Cliente cliente) {
        boolean modificar = false;
        String sql = "UPDATE clientes SET username = ?, password = ?, nombre = ?, fechaNacimiento = ?, tipo = ?, rutCliente = ?, nombres = ?, apellidos = ?, telefono = ?, afp = ?, salud = ?, direccion = ?, comuna = ?, edad = ? WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setString(2, cliente.getPassword());
            preparedStatement.setString(3, cliente.getNombre());
            preparedStatement.setString(4, cliente.getFechaNacimiento());
            preparedStatement.setString(5, cliente.getTipo());
            preparedStatement.setString(6, cliente.getRut());
            preparedStatement.setString(7, cliente.getNombres());
            preparedStatement.setString(8, cliente.getApellidos());
            preparedStatement.setInt(9, cliente.getTelefono());
            preparedStatement.setString(10, cliente.getAfp());
            preparedStatement.setString(11, cliente.getSistemaSalud());
            preparedStatement.setString(12, cliente.getDireccion());
            preparedStatement.setString(13, cliente.getComuna());
            preparedStatement.setInt(14, cliente.getEdad());
            preparedStatement.setInt(15, cliente.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Actualización exitosa para el cliente con ID: {}", cliente.getId());
                modificar = true;
            } else {
                logger.warn("Ninguna fila se ha actualizado para el cliente con ID: {}", cliente.getId());
            }

        } catch (SQLException e) {
            logger.error("Error en el método modificar de ClienteDAOimpl", e);
        }
        return modificar;
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT id, username, password, nombre, fechaNacimiento, tipo, rutCliente, nombres, apellidos, telefono, afp, salud, direccion, comuna, edad, created_at FROM clientes ORDER BY id"; // Cambiado para evitar "SELECT *"

        try (Connection con = Conexion.conectar();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setUsername(rs.getString("username"));
                cliente.setPassword(rs.getString("password"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                cliente.setTipo(rs.getString("tipo"));
                cliente.setRut(rs.getString("rutCliente"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setAfp(rs.getString("afp"));
                cliente.setSistemaSalud(rs.getString("salud"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setComuna(rs.getString("comuna"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setCreated_at(rs.getDate("created_at"));

                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            logger.error("Error en el método listar de ClienteDAOimpl", e);
        }
        return listaClientes;
    }

}
