package dao.classes;

import dao.interfaces.IClienteDAO;
import domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPA-System");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        fecharConexao(entityManagerFactory, entityManager);
        return cliente;
    }

    @Override
    public Cliente excluirCliente(Cliente cliente) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return null;
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return null;
    }

    @Override
    public void excluirClientePorId(Long id) {

    }
    @Override
    public void fecharConexao(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        entityManager.close();
        entityManagerFactory.close();
    }
}
