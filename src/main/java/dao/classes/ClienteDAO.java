package dao.classes;

import dao.interfaces.IClienteDAO;
import domain.Cliente;
import domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public Boolean excluirCliente(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<Cliente> buscarTodosClientes(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        CriteriaBuilder construtorCriteria = entityManager.getCriteriaBuilder();//crie um construtor da ferramenta criteria
        CriteriaQuery<Cliente> consultaCriteria = construtorCriteria.createQuery(Cliente.class);//crie uma consulta tipada através do método do construtor critéria
        Root<Cliente> selectFromCliente = consultaCriteria.from(Cliente.class); //definindo a rota do select, para dizer em qual entidade ele deve fazer o select
        consultaCriteria.select(selectFromCliente); //faça o select na rota definida

        TypedQuery<Cliente> consultaTipada =
                entityManager.createQuery(consultaCriteria);
        List<Cliente> clienteList = consultaTipada.getResultList();
        return clienteList;
    }

    @Override
    public Cliente buscarClientePorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public Boolean excluirClientePorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        entityManager.getTransaction().begin();
        Cliente clienteSeraExcluido = entityManager.find(Cliente.class, id);
        entityManager.remove(clienteSeraExcluido);
        entityManager.getTransaction().commit();
        return true;
    }
}
