package view;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel ;


import model.entidade.CursoEntidade;
public class ViewTabelaCurso extends AbstractTableModel 
{
	private static final long serialVersionUID = 1L;

	private ArrayList<CursoEntidade> arCurso;

	// construtor

	public ViewTabelaCurso() {
		this.arCurso = null;
	}

	public ViewTabelaCurso(ArrayList<CursoEntidade> arCurso) {
		setArCurso(arCurso);
	}

	public void setArCurso(ArrayList<CursoEntidade> arCurso) {
		this.arCurso = arCurso;
	}

	// poem nome na coluna
	public String getColumnName(int col)
	{
		String[] a = {"Código", "Curso", "Data de inicio", "Data de fim", "Hora inicial", "Hora final", 
				"Quantidade de vagas", "Livros", "Materiais", "Valor" };
		return (col < 10 ? a[col] : "");
	}

	// tamanho de colunas
	public int getColumnCount() {
		return 10;
	}

	// tamanho de linhas
	public int getRowCount() {

		return arCurso.size();
	}

	// pega objeto aluno
	public CursoEntidade getCurso(int rowIndex) {
		CursoEntidade cur = new CursoEntidade();
		cur = arCurso.get(rowIndex);
		return cur;
	}

	public String getValueAt(int rowIndex, int columnIndex) {

		int i = 0;
		CursoEntidade cur = new CursoEntidade();
		while (i < arCurso.size()) {
			cur = this.arCurso.get(i);

			if (columnIndex == 0 && rowIndex == i) {
				return String.valueOf(cur.getCodgoCurso());
			}
			if (columnIndex == 1 && rowIndex == i) {
				return String.valueOf(cur.getCurso());
			}
			if (columnIndex == 2 && rowIndex == i) {
				return String.valueOf(cur.getDataIni());
			}
			if (columnIndex == 3 && rowIndex == i) {
				return String.valueOf(cur.getDataFim());
			}
			if (columnIndex == 4 && rowIndex == i) {
				return String.valueOf(cur.getHoraIni());
			}
			if (columnIndex == 5 && rowIndex == i) {
				return String.valueOf(cur.getHoraFim());
			}
			if (columnIndex == 6 && rowIndex == i) {
				return String.valueOf(cur.getQdtVagas());
			}
			if (columnIndex == 7 && rowIndex == i) {
				return String.valueOf(cur.getLivros());
			}
			if (columnIndex == 8 && rowIndex == i) {
				return String.valueOf(cur.getMateriais());
			}
			if (columnIndex == 9 && rowIndex == i) {
				return String.valueOf(cur.getValor());
			}
			

			i++;
		}

		return "";
	}

	
	
	
}
