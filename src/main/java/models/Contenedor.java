package models;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    public static List<Capacitacion> listaCapacitacion = new ArrayList<>();
    public static List<Usuario> listaUsuario = new ArrayList<>();

    public static void agregarCapacitacion(Capacitacion capacitacion) {
        listaCapacitacion.add(capacitacion);
    }

    public static List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public static void setListaUsuario(List<Usuario> listaUsuario) {
        Contenedor.listaUsuario = listaUsuario;
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
    }

    public List<Capacitacion> getListaCapacitacion() {
        return listaCapacitacion;
    }

    public static void setListaCapacitacion(List<Capacitacion> listaCapacitacion) {
        Contenedor.listaCapacitacion = listaCapacitacion;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "listaUsuario=" + listaUsuario +
                '}';
    }
}
