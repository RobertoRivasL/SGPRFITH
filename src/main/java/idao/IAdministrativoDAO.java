package idao;

import models.Administrativo;

import java.util.List;

public interface IAdministrativoDAO {


    public boolean registrar(Administrativo administrativo);

    public boolean eliminar(Administrativo administrativo);

    public boolean modificar(Administrativo administrativo);

    public List<Administrativo> listarAdministrativos();
}
