package idao;

import models.Cliente;

import java.util.List;

public interface IClienteDAO {


    public boolean registrar(Cliente cliente);

    public boolean eliminar(Cliente cliente);

    public boolean modificar(Cliente cliente);

    public List<Cliente> listarClientes();

}
