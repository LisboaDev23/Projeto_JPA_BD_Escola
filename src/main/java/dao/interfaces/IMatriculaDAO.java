package dao.interfaces;

import domain.Matricula;

import java.util.List;

public interface IMatriculaDAO {
    public Matricula cadastrarMatricula(Matricula matricula);
    public Matricula excluirMatricula(Matricula matriculas);
    public List<Matricula> buscarTodasMatriculas();
    public Matricula buscarMatriculaPorId(Long id);
    public void excluirMatriculaPorId (Long id);
}
