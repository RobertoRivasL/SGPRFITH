
/**
 * @author Roberto Rivas
 * @author Billy Alvarez
 * @author Roberto Orellana
 * @author Nicolas Massot
 * @version 2.0
 */

import models.Capacitacion;
import models.Contenedor;
import models.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase Contenedor.
 *
 * @version 2.0
 */
public class ContenedorTest {

    private Contenedor contenedor;
    private Usuario usuario;
    private Capacitacion capacitacion;

    @Before
    public void setUp() {
        // Restableciendo las listas estáticas antes de cada prueba
        Contenedor.setListaCapacitacion(new ArrayList<>());
        Contenedor.setListaUsuario(new ArrayList<>());
        contenedor = new Contenedor();
        usuario = new Usuario(); // Asumiendo que Usuario tiene un constructor predeterminado
        capacitacion = new Capacitacion(); // Asumiendo que Capacitacion tiene un constructor predeterminado
    }

    @Test
    public void testAgregarCapacitacion() {
        Contenedor.agregarCapacitacion(capacitacion);
        List<Capacitacion> lista = contenedor.getListaCapacitacion();
        assertTrue("La lista de capacitaciones debería contener el objeto añadido", lista.contains(capacitacion));
    }

    @Test
    public void testGetListaUsuario() {
        Contenedor.setListaUsuario(new ArrayList<>()); // Restablecer lista de usuarios
        List<Usuario> lista = Contenedor.getListaUsuario();
        assertNotNull("La lista de usuarios no debería ser null", lista);
        assertTrue("La lista de usuarios debería estar vacía inicialmente", lista.isEmpty());
    }

    @Test
    public void testSetListaUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        Contenedor.setListaUsuario(usuarios);
        List<Usuario> lista = Contenedor.getListaUsuario();
        assertEquals("La lista de usuarios debería tener un tamaño de 1", 1, lista.size());
        assertTrue("La lista de usuarios debería contener el objeto añadido", lista.contains(usuario));
    }

    @Test
    public void testAgregarUsuario() {
        contenedor.agregarUsuario(usuario);
        List<Usuario> lista = Contenedor.getListaUsuario();
        assertTrue("La lista de usuarios debería contener el objeto añadido", lista.contains(usuario));
    }

    @Test
    public void testGetListaCapacitacion() {
        List<Capacitacion> listaInicial = contenedor.getListaCapacitacion();
        assertNotNull("La lista de capacitaciones no debería ser null", listaInicial);
        assertTrue("La lista de capacitaciones debería estar vacía inicialmente", listaInicial.isEmpty());
        // Agregar una capacitación para verificar que la lista se actualiza correctamente
        Contenedor.agregarCapacitacion(capacitacion);
        List<Capacitacion> listaActualizada = contenedor.getListaCapacitacion();
        assertEquals("La lista de capacitaciones debería tener un tamaño de 1", 1, listaActualizada.size());
        assertTrue("La lista de capacitaciones debería contener el objeto añadido", listaActualizada.contains(capacitacion));
    }

    @Test
    public void testSetListaCapacitacion() {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        capacitaciones.add(capacitacion);
        Contenedor.setListaCapacitacion(capacitaciones);
        List<Capacitacion> lista = contenedor.getListaCapacitacion();
        assertEquals("La lista de capacitaciones debería tener un tamaño de 1", 1, lista.size());
        assertTrue("La lista de capacitaciones debería contener el objeto añadido", lista.contains(capacitacion));
    }

    @Test
    public void testToString() {
        contenedor.agregarUsuario(usuario);
        String esperado = "Contenedor{listaUsuario=[models.Usuario@";
        assertTrue("El toString debería contener la representación adecuada",
                contenedor.toString().startsWith(esperado));
    }
}