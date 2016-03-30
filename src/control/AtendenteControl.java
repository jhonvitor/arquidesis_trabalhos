package control;

import java.util.ArrayList;

import model.entidade.AlunoEntidade;
import model.entidade.CursoEntidade;
import model.service.AlunoService;
import model.service.CursoService;

public class AtendenteControl {

	public AtendenteControl() {

	}

	// CADASTRAR ALUNO
	public String setCadAluno(int cod, String nome, String end, String num,
			String comp, String dataNasc, String email, String telRes,
			String telCel, String rg, String cpf) throws Exception {

		String result = new AlunoService().setCadastroDeAluno(cod, nome, end,
				num, comp, dataNasc, email, telRes, telCel, rg, cpf);
		return result;
	}

	// ALTERAR CADASTRO DE ALUNO
	public String setAlterarAluno(int cod, String nome, String end, String num,
			String comp, String dataNasc, String email, String telRes,
			String telCel, String rg, String cpf) throws Exception {

		String result = new AlunoService().setAlterarAluno(cod, nome, end, num,
				comp, dataNasc, email, telRes, telCel, rg, cpf);
		return result;
	}

	// BUSCA DE TODOS OS ALUNOS
	public ArrayList<AlunoEntidade> setBuscAlunoAll() {
		ArrayList<AlunoEntidade> alunos = new AlunoService()
				.setBuscarTodosAlunos();
		return alunos;
	}

	// BUSCA ALUNO POR CPF
	public ArrayList<AlunoEntidade> setBuscAlunoCpf(String cpf) {
		ArrayList<AlunoEntidade> alunos = new AlunoService()
				.setBuscarAlunosPorCpf(cpf);
		return alunos;
	}

	// DELETA ALUNO
	public boolean setDelAlunoCpf(String cpf) {
		boolean result = new AlunoService().setDeletarAlunoPorCpf(cpf);
		return result;
	}

	// CADASTRAR CURSO
	public boolean setCadCurso(int codgoCurso, String curso, String dataIni,
			String dataFim, String horaIni, String horaFim, int qdtVagas,
			String livros, String materiais, double valor) throws Exception {

		boolean result = new CursoService().setCadastroDeCurso(codgoCurso,
				curso, dataIni, dataFim, horaIni, horaFim, qdtVagas, livros,
				materiais, valor);
		return result;
	}

	// ALTERAR Curso
	public boolean setAlterarCurso(int codgoCurso, String curso, String dataIni,
			String dataFim, String horaIni, String horaFim, int qdtVagas,
			String livros, String materiais, double valor) throws Exception {

		boolean result = new CursoService().setAlterarCurso(codgoCurso, curso,
				dataIni, dataFim, horaIni, horaFim, qdtVagas, livros,
				materiais, valor);
		return result;
	}
	
	public boolean setDelCurso(int cod){
		boolean result = new CursoService().setDeletarCurso(cod);
		return result;
	}
	
	// BUSCA DE TODOS OS ALUNOS
		public ArrayList<CursoEntidade> setBuscCursoAll() {
			ArrayList<CursoEntidade> cursos = new CursoService()
					.setBuscarTodosCursos();
			return cursos;
		}

		// BUSCA ALUNO POR CPF
		public ArrayList<CursoEntidade> setBuscCursoCod(int cod) {
			ArrayList<CursoEntidade> cursos = new CursoService()
					.setBuscarCursosPorCod(cod);
			return cursos;
		}
}
