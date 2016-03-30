package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.entidade.AlunoEntidade;

public class ViewTabelaAluno extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private ArrayList<AlunoEntidade> arAluno;

	// construtor

	public ViewTabelaAluno() {
		this.arAluno = null;
	}

	public ViewTabelaAluno(ArrayList<AlunoEntidade> arAluno) {
		setArAluno(arAluno);
	}

	public void setArAluno(ArrayList<AlunoEntidade> arAluno) {
		this.arAluno = arAluno;
	}

	// poem nome na coluna
	public String getColumnName(int col) {
		String[] a = { "Código", "Nome", "Endereço", "Numero", "Complemento",
				"Data de Nascimento", " Email", "Telefone Res.",
				"Telefone Cel.", "RG", "CPF" };
		return (col < 11 ? a[col] : "");
	}

	// tamanho de colunas
	public int getColumnCount() {
		return 11;
	}

	// tamanho de linhas
	public int getRowCount() {

		return arAluno.size();
	}

	// pega objeto aluno
	public AlunoEntidade getAluno(int rowIndex) {
		AlunoEntidade al = new AlunoEntidade();
		al = arAluno.get(rowIndex);
		return al;
	}

	public String getValueAt(int rowIndex, int columnIndex) {

		int i = 0;
		AlunoEntidade al = new AlunoEntidade();
		while (i < arAluno.size()) {
			al = this.arAluno.get(i);

			if (columnIndex == 0 && rowIndex == i) {
				return String.valueOf(al.getCod());
			}
			if (columnIndex == 1 && rowIndex == i) {
				return String.valueOf(al.getNome());
			}
			if (columnIndex == 2 && rowIndex == i) {
				return String.valueOf(al.getEnd());
			}
			if (columnIndex == 3 && rowIndex == i) {
				return String.valueOf(al.getNum());
			}
			if (columnIndex == 4 && rowIndex == i) {
				return String.valueOf(al.getComp());
			}
			if (columnIndex == 5 && rowIndex == i) {
				return String.valueOf(al.getDataNasc());
			}
			if (columnIndex == 6 && rowIndex == i) {
				return String.valueOf(al.getEmail());
			}
			if (columnIndex == 7 && rowIndex == i) {
				return String.valueOf(al.getTelRes());
			}
			if (columnIndex == 8 && rowIndex == i) {
				return String.valueOf(al.getTelCel());
			}
			if (columnIndex == 9 && rowIndex == i) {
				return String.valueOf(al.getRg());
			}
			if (columnIndex == 10 && rowIndex == i) {
				return String.valueOf(al.getCpf());
			}

			i++;
		}

		return "";
	}

}
