package model.service;

import java.util.ArrayList;

import model.entidade.CursoEntidade;
import dao.CursoDao;

public class CursoService {

	public CursoService() {
		// TODO Auto-generated constructor stub
	}

	// CADASTAR CURSOS
	public boolean setCadastroDeCurso(int codgoCurso, String curso,
			String dataIni, String dataFim, String horaIni, String horaFim,
			int qdtVagas, String livros, String materiais, double valor)
			throws Exception {

		CursoEntidade cursos = new CursoEntidade(codgoCurso, curso, dataIni,
				dataFim, horaIni, horaFim, qdtVagas, livros, materiais, valor);

		if (new CursoDao().incluir(cursos)) {
			return true;
		}
		return false;
	}

	// ALTERAR CADASTRO DE CURSO
	public boolean setAlterarCurso(int codgoCurso, String curso,
			String dataIni, String dataFim, String horaIni, String horaFim,
			int qdtVagas, String livros, String materiais, double valor)
			throws Exception {

		CursoEntidade cursos = new CursoEntidade(codgoCurso, curso, dataIni,
				dataFim, horaIni, horaFim, qdtVagas, livros, materiais, valor);

		if (new CursoDao().alterar(cursos)) {
			return true;
		}
		return false;
	}

	// DELETAR CURSO
	public boolean setDeletarCurso(int codgoCurso) {

		if (new CursoDao().deletar(codgoCurso)) {
			return true;
		}
		return false;
	}

	// BUSCA DE TODOS OS ALUNOS DO BANCO
	public ArrayList<CursoEntidade> setBuscarTodosCursos() {

		ArrayList<CursoEntidade> curso = new CursoDao().consultarTodos();
		return curso;
	}

	// BUSCA DE ALUNO POR CPF
	public ArrayList<CursoEntidade> setBuscarCursosPorCod(int cod) {

		CursoEntidade curso = new CursoEntidade(cod, "", "", "", "", "", 0, "",
				"", 0.0);

		ArrayList<CursoEntidade> cursos = new CursoDao().consultaPorCod(curso);
		return cursos;
	}
}
