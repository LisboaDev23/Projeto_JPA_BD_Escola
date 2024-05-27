package dao.interfaces;

import domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface IClienteDAO {
    public Cliente cadastrarCliente(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Cliente cliente);
    public Boolean excluirCliente(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Cliente cliente);
    public List<Cliente> buscarTodosClientes(EntityManagerFactory entityManagerFactory, EntityManager entityManager);
    public Cliente buscarClientePorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id);
    public Boolean excluirClientePorId (EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id);
}
