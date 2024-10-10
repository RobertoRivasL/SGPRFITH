package idao;

import models.Profesional;

import java.util.List;

public interface IProfesionalDAO {


    public boolean registrar(Profesional profesional);

    public boolean eliminar(Profesional profesional);

    public boolean modificar(Profesional profesional);

    public List<Profesional> listarProfesionales();


}
