package dao.classes;

import dao.interfaces.ICursoDAO;
import domain.Cliente;
import domain.Curso;
import domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CursoDAO implements ICursoDAO {

    @Override
    public Curso cadastrarCurso(EntityManagerFactory entityManagerFactory, EntityManager entityManager, Curso curso) {
        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();
        return curso;
    }

    @Override
    public Boolean excluirCurso(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Curso curso) {
        entityManager.getTransaction().begin();
        entityManager.remove(curso);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<Curso> buscarTodosCursos(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {

        CriteriaBuilder construtorCriteria = entityManager.getCriteriaBuilder();//crie um construtor da ferramenta criteria
        CriteriaQuery<Curso> consultaCriteria = construtorCriteria.createQuery(Curso.class);//crie uma consulta tipada através do método do construtor critéria
        Root<Curso> selectFromCurso = consultaCriteria.from(Curso.class); //definindo a rota do select, para dizer em qual entidade ele deve fazer o select
        consultaCriteria.select(selectFromCurso); //faça o select na rota definida

        TypedQuery<Curso> consultaTipada =
                entityManager.createQuery(consultaCriteria);
        List<Curso> cursoList = consultaTipada.getResultList();
        return cursoList;
    }

    @Override
    public Curso buscarCursoPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        return entityManager.find(Curso.class, id);
    }

    @Override
    public Boolean excluirCursoPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        entityManager.getTransaction().begin();
        Curso cursoSeraExcluido = entityManager.find(Curso.class, id);
        entityManager.remove(cursoSeraExcluido);
        entityManager.getTransaction().commit();
        return true;
    }
}
