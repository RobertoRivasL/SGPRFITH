/**
 * @author Roberto Rivas
 * @author Billy Alvarez
 * @author Roberto Orellana
 * @author Nicolas Massot
 * @version 2.0
 */

/**
 * @version 2.0
 */

import controllers.svCapacitacion;
import controllers.svContacto;
import controllers.svCrearUsuario;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AccesoTest {
    @Test
    public void testAccesoSvCrearUsuario() {
        // Opción 1: Agregar un comentario explicativo
        // Método aún no implementado debido a [razón específica].

        // Opción 2: Lanzar una excepción de operación no soportada

        // Opción 3: Completar la implementación
        // Crear instancia del controlador
        svCrearUsuario controlador = new svCrearUsuario();

        // Verificar que la instancia no es nula
        assertNotNull("Controlador svCrearUsuario es nulo", controlador);
    }

    @Test
    public void testAccesoSvCapacitacion() {
        svCapacitacion controlador = new svCapacitacion();
        assertNotNull("Controlador svCapacitacion es nulo", controlador);
    }

    @Test
    public void testAccesoSvContacto() {
        svContacto controlador = new svContacto();
        assertNotNull("Controlador svContacto es nulo", controlador);
    }
}