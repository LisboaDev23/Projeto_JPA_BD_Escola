package dao.interfaces;

import domain.Cliente;

import java.util.List;

public interface IClienteDAO {
    public Cliente cadastrarCliente(Cliente cliente);
    public Cliente excluirCliente(Cliente cliente);
    public List<Cliente> buscarTodosClientes();
    public Cliente buscarClientePorId(Long id);
    public void excluirClientePorId (Long id);
}
