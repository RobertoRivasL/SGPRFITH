package models;

import java.util.Date;

public class Administrativo extends Usuario {

    //Atributos
    private String area; //Área del administrativo
    private String expPrevia; //Experiencia previa del administrativo

    public Administrativo() {

    }

    public Administrativo(String area, String expPrevia) {
        this.area = area;
        this.expPrevia = expPrevia;
    }

    public Administrativo(String username, String password, String nombre, String fechaNacimiento, String tipo, String area, String expPrevia) {
        super(username, password, nombre, fechaNacimiento, tipo);
        this.area = area;
        this.expPrevia = expPrevia;
    }

    public Administrativo(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, String area, String expPrevia) {
        super(id, username, password, nombre, fechaNacimiento, tipo);
        this.area = area;
        this.expPrevia = expPrevia;
    }

    public Administrativo(int id, String username, String password, String nombre, String fechaNacimiento, String tipo, Date created_at, String area, String expPrevia) {
        super(id, username, password, nombre, fechaNacimiento, tipo, created_at);
        this.area = area;
        this.expPrevia = expPrevia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExpPrevia() {
        return expPrevia;
    }

    public void setExpPrevia(String expPrevia) {
        this.expPrevia = expPrevia;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "area='" + area + '\'' +
                ", expPrevia='" + expPrevia + '\'' +
                '}';
    }
}