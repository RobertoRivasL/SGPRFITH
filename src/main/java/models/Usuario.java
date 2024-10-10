package models;


import java.util.Date;

public class Usuario {

    private int id;
    private String username;
    private String password;
    private String nombre;
    private String fechaNacimiento;
    private String tipo;
    private Date created_at;

    public Usuario() {

    }

    public Usuario(String username, String password, String nombre, String fechaNacimiento, String tipo) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;

    }

    public Usuario(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, Date created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.created_at = created_at;
    }

    public Usuario(int id, String username, String password, String nombre, String fechaNacimiento, String tipo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
