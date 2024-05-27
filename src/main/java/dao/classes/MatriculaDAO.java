package dao.classes;

import dao.interfaces.IMatriculaDAO;
import domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MatriculaDAO implements IMatriculaDAO {
    @Override
    public Matricula cadastrarMatricula(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Matricula matricula) {
        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();
        return matricula;
    }

    @Override
    public Boolean excluirMatricula(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Matricula matricula) {
        entityManager.getTransaction().begin();
        entityManager.remove(matricula);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<Matricula> buscarTodasMatriculas(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        CriteriaBuilder construtorCriteria = entityManager.getCriteriaBuilder();//crie um construtor da ferramenta criteria
        CriteriaQuery<Matricula> consultaCriteria = construtorCriteria.createQuery(Matricula.class);//crie uma consulta tipada através do método do construtor critéria
        Root<Matricula> selectFromMatricula = consultaCriteria.from(Matricula.class); //definindo a rota do select, para dizer em qual entidade ele deve fazer o select
        consultaCriteria.select(selectFromMatricula); //faça o select na rota definida

        TypedQuery<Matricula> consultaTipada =
                entityManager.createQuery(consultaCriteria);
        List<Matricula> matriculaList = consultaTipada.getResultList();
        return matriculaList;
    }

    @Override
    public Matricula buscarMatriculaPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        return entityManager.find(Matricula.class, id);
    }

    @Override
    public Boolean excluirMatriculaPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        entityManager.getTransaction().begin();
        Matricula matriculaSeraExcluida = entityManager.find(Matricula.class, id);
        entityManager.remove(matriculaSeraExcluida);
        entityManager.getTransaction().commit();
        return true;
    }
}