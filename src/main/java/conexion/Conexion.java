package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Conexion que se encarga de gestionar la conexión a la base de datos.
 */
public class Conexion {

    // Logger para capturar y registrar mensajes y errores
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());

    private static String driver;
    private static String url;
    private static String usuario;
    private static String password;

    // Bloque estático para cargar las propiedades de configuración y el driver
    static {
        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                LOGGER.log(Level.SEVERE, "No se puede encontrar el archivo config.properties");
                throw new ExceptionInInitializerError("Failed to find config.properties");
            }
            prop.load(input);
            driver = prop.getProperty("db.driver");
            url = prop.getProperty("db.url");
            usuario = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Error al cargar el driver o la configuración de la base de datos", ex);
            throw new ExceptionInInitializerError("Failed to load database driver or configuration.");
        }
    }

    // Constructor privado para ocultar el constructor público implícito
    private Conexion() {
        throw new UnsupportedOperationException("Esta clase no puede ser instanciada");
    }

    /**
     * Método para establecer la conexión a la base de datos.
     *
     * @return Objeto Connection o null si no se puede establecer la conexión.
     */
    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al establecer la conexión a la base de datos", e);
        }
        return con;
    }
}