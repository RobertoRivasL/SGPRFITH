package idao;

import models.Capacitacion;

import java.util.List;

public interface ICapacitacionDAO {


    public boolean registrar(Capacitacion capacitacion);

    public boolean eliminar(Capacitacion capacitacion);

    public boolean modificar(Capacitacion capacitacion);

    public List<Capacitacion> listarCapacitacion();


}
