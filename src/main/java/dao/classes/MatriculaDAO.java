package dao.classes;

import dao.interfaces.IMatriculaDAO;
import domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    public Matricula excluirMatricula(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Matricula matriculas) {
        return null;
    }

    @Override
    public List<Matricula> buscarTodasMatriculas(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        return null;
    }

    @Override
    public Matricula buscarMatriculaPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        return null;
    }

    @Override
    public void excluirMatriculaPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {

    }
}