package dao.interfaces;

import domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface IMatriculaDAO {
    public Matricula cadastrarMatricula(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Matricula matricula);
    public Matricula excluirMatricula(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Matricula matriculas);
    public List<Matricula> buscarTodasMatriculas(EntityManagerFactory entityManagerFactory, EntityManager entityManager);
    public Matricula buscarMatriculaPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id);
    public void excluirMatriculaPorId (EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id);
}
