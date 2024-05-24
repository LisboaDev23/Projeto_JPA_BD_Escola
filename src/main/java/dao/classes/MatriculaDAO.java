package dao.classes;

import dao.interfaces.IMatriculaDAO;
import domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MatriculaDAO implements IMatriculaDAO {
    @Override
    public Matricula cadastrarMatricula(Matricula matricula) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPA-System");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();
        return matricula;
    }

    @Override
    public Matricula excluirMatricula(Matricula matriculas) {
        return null;
    }

    @Override
    public List<Matricula> buscarTodasMatriculas() {
        return null;
    }

    @Override
    public Matricula buscarMatriculaPorId(Long id) {
        return null;
    }

    @Override
    public void excluirMatriculaPorId(Long id) {

    }
    @Override
    public void fecharConexao(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        entityManager.close();
        entityManagerFactory.close();
    }
}