package dao.classes;

import dao.interfaces.IClienteDAO;
import domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Cliente cadastrarCliente(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        return cliente;
    }

    @Override
    public Cliente excluirCliente(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Cliente cliente) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodosClientes(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        return null;
    }

    @Override
    public Cliente buscarClientePorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        return null;
    }

    @Override
    public void excluirClientePorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {

    }
}
