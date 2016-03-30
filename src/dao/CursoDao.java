package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entidade.CursoEntidade;

public class CursoDao {
	private Connection conn;
	private PreparedStatement st;
	private MysqlConnect db;

	public CursoDao() {
		this.db = new MysqlConnect();
		this.conn = db.getConnection();
	}

	// incluir curso no banco
	public boolean incluir(CursoEntidade curso) {
		boolean sucesso = false;
		try {
			String sql = "INSERT INTO curso (curso, dataIni, dataFim, horaIni, horaFim, qtdVagas, livros, materiais, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, curso.getCurso());
			st.setString(2, curso.getDataIni());
			st.setString(3, curso.getDataFim());
			st.setString(4, curso.getHoraIni());
			st.setString(5, curso.getHoraFim());
			st.setInt(6, curso.getQdtVagas());
			st.setString(7, curso.getLivros());
			st.setString(8, curso.getMateriais());
			st.setDouble(9, curso.getValor());

			st.executeUpdate();
			sucesso = true;
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}

	public boolean alterar(CursoEntidade curso) {
		boolean sucesso = false;
		try {
			String sql = "UPDATE curso SET curso= ?, dataIni= ?, dataFim= ?, horaIni= ?, horaFim= ?, qtdVagas= ?, livros= ?, materiais= ?, valor= ? WHERE codigoCurso = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, curso.getCurso());
			st.setString(2, curso.getDataIni());
			st.setString(3, curso.getDataFim());
			st.setString(4, curso.getHoraIni());
			st.setString(5, curso.getHoraFim());
			st.setInt(6, curso.getQdtVagas());
			st.setString(7, curso.getLivros());
			st.setString(8, curso.getMateriais());
			st.setDouble(9, curso.getValor());
			st.setInt(10, curso.getCodgoCurso());
			st.executeUpdate();
			sucesso = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}

	public boolean deletar(int cod) {
		boolean sucesso = false;
		try {
			String sql = "DELETE FROM curso WHERE codigoCurso LIKE ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, cod);
			st.executeUpdate();
			sucesso = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}

	// Consultar Todos cursos Cadastrados
	public ArrayList<CursoEntidade> consultarTodos() {
		ArrayList<CursoEntidade> objCur = new ArrayList<CursoEntidade>();
		ResultSet rs;
		CursoEntidade curso;

		try {
			String sql = "SELECT * FROM curso ORDER BY codigoCurso DESC";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				curso = new CursoEntidade(
						// curso, dataIni, dataFim, horaIni, horaFim, qtdVagas,
						// livros, materiais, valor
						rs.getInt("codigoCurso"), rs.getString("curso"),
						rs.getString("dataIni"), rs.getString("dataFim"),
						rs.getString("horaIni"), rs.getString("horaFim"),
						rs.getInt("qtdVagas"), rs.getString("livros"),
						rs.getString("materiais"), rs.getDouble("valor"));

				objCur.add(curso);

			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCur;

	}

	// consulta aluno por CPF
	public ArrayList<CursoEntidade> consultaPorCod(CursoEntidade cur) {
		ArrayList<CursoEntidade> objCur = new ArrayList<CursoEntidade>();
		ResultSet rs;
		CursoEntidade curso;
		try {
			String sql = "SELECT * FROM curso WHERE codigoCurso LIKE ?% ORDER BY codigoCurso DESC";
			st = conn.prepareStatement(sql);

			st.setInt(1, cur.getCodgoCurso());
			rs = st.executeQuery();
			while (rs.next()) {
				curso = new CursoEntidade(rs.getInt("codigoCurso"),
						rs.getString("curso"), rs.getString("dataIni"),
						rs.getString("dataFim"), rs.getString("horaIni"),
						rs.getString("horaFim"), rs.getInt("qtdVagas"),
						rs.getString("livros"), rs.getString("materiais"),
						rs.getDouble("valor"));
				objCur.add(curso);
			}

			st.close(); // fecha consulta
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCur;
	}

}
