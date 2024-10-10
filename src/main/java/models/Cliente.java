package models;

import java.util.Date;

public class Cliente extends Usuario {


    //Atributos
    private String rut; //Rut cliente
    private String nombres; //Nombres cliente
    private String apellidos; //Apellidos cliente
    private int telefono; //Teléfono cliente
    private String afp; //AFP cliente
    private String sistemaSalud; //Sistema de salud cliente
    private String direccion; //Direccion cliente
    private String comuna; //Comuna cliente
    private int edad; //Edad cliente

    public Cliente() {

    }

    public Cliente(String rut, String nombres, String apellidos, int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public Cliente(String username, String password, String nombre, String fechaNacimiento, String tipo, String rut, String nombres, String apellidos, int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
        super(username, password, nombre, fechaNacimiento, tipo);
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public Cliente(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, String rut, String nombres, String apellidos, int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
        super(id, username, password, nombre, fechaNacimiento, tipo);
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public Cliente(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, Date created_at, String rut, String nombres, String apellidos, int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
        super(id, username, password, nombre, fechaNacimiento, tipo, created_at);
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(String sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}