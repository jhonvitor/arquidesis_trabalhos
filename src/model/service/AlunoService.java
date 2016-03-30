package model.service;

import java.util.ArrayList;

import model.entidade.AlunoEntidade;
import dao.AlunoDao;

public class AlunoService {

	public AlunoService() {
	}

	// CADASTAR ALUNOS
	public String setCadastroDeAluno(int cod, String nome, String end,
			String num, String comp, String dataNasc, String email,
			String telRes, String telCel, String rg, String cpf)
			throws Exception {
		if (!new AlunoDao().existCpf(cpf)) {
			AlunoEntidade aluno = new AlunoEntidade(cod, nome, end, num, comp,
					dataNasc, email, telRes, telCel, rg, cpf);
			String us = null;

			if (new AlunoDao().incluir(aluno)) {
				String arq = "login.txt";
				us = new UsuarioService().setWriteFile(arq, aluno, "Aluno");
			}
			return us;
		}
		return "exist";
	}

	// ALTERAR CADASTRO DE ALUNO
	public String setAlterarAluno(int cod, String nome, String end,
			String num, String comp, String dataNasc, String email,
			String telRes, String telCel, String rg, String cpf)
			throws Exception {
		
		if (new AlunoDao().existCpf(cpf)) {
			AlunoEntidade aluno = new AlunoEntidade(cod, nome, end, num, comp,
					dataNasc, email, telRes, telCel, rg, cpf);
			String us = null;

			if (new AlunoDao().Alterar(aluno)) {
				String arq = "login.txt";
				us = new UsuarioService().setWriteFile(arq, aluno, "Aluno");
			}
			return us;
		}
		return "exist";
	}
	
	// BUSCA DE TODOS OS ALUNOS DO BANCO
	public ArrayList<AlunoEntidade> setBuscarTodosAlunos() {

		ArrayList<AlunoEntidade> alunos = new AlunoDao().consultarTodos();
		return alunos;
	}

	// BUSCA DE ALUNO POR CPF
	public ArrayList<AlunoEntidade> setBuscarAlunosPorCpf(String cpf) {

		AlunoEntidade aluno = new AlunoEntidade(0, "", "", "", "", "", "", "",
				"", "", cpf);
		ArrayList<AlunoEntidade> alunos = new AlunoDao().consultaPorCpf(aluno);
		return alunos;
	}

	// APAGA ALUNO POR CPF
	public boolean setDeletarAlunoPorCpf(String cpf) {
		boolean result = false;
		if (new AlunoDao().existCpf(cpf)) {
			result = new AlunoDao().excluirPorCpf(cpf);
		}
		return result;
	}
	
	// BUSCA SIMPLES DE ALUNO POR CPF
		public AlunoEntidade setBuscarAlunosPorCpfSimples(String cpf) {

			AlunoEntidade aluno = new AlunoEntidade(0, "", "", "", "", "", "", "",
					"", "", cpf);
			AlunoEntidade result = new AlunoDao().consultaPorCpfSimples(aluno);
			return result;
		}
	
}
