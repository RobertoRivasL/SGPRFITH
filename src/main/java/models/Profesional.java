package models;

import java.util.Date;

public class Profesional extends Usuario {


    // Atributos

    private String titulo;
    private String fechaIngreso;

    public Profesional() {

    }

    public Profesional(String titulo, String fechaIngreso) {
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public Profesional(String username, String password, String nombre, String fechaNacimiento, String tipo, String titulo, String fechaIngreso) {
        super(username, password, nombre, fechaNacimiento, tipo);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public Profesional(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, String titulo, String fechaIngreso) {
        super(id, username, password, nombre, fechaNacimiento, tipo);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public Profesional(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, Date created_at, String titulo, String fechaIngreso) {
        super(id, username, password, nombre, fechaNacimiento, tipo, created_at);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }
}
