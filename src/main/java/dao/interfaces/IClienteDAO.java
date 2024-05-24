package dao.interfaces;

import domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface IClienteDAO {
    public Cliente cadastrarCliente(Cliente cliente);
    public Cliente excluirCliente(Cliente cliente);
    public List<Cliente> buscarTodosClientes();
    public Cliente buscarClientePorId(Long id);
    public void excluirClientePorId (Long id);
    public void fecharConexao(EntityManagerFactory entityManagerFactory, EntityManager entityManager);
}
