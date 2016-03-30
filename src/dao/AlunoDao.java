package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entidade.AlunoEntidade;

public class AlunoDao {
	private Connection conn;
	private PreparedStatement st;
	private MysqlConnect db;

	public AlunoDao() {
		this.db = new MysqlConnect();
		this.conn = db.getConnection();
	}

	// Consultar Todos Alunos Cadastrados
	public ArrayList<AlunoEntidade> consultarTodos() {
		ArrayList<AlunoEntidade> objAl = new ArrayList<AlunoEntidade>();
		ResultSet rs;
		AlunoEntidade aluno;

		try {
			String sql = "SELECT * FROM aluno ORDER BY codAlu DESC";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				aluno = new AlunoEntidade(rs.getInt("codAlu"),
						rs.getString("nomeAlu"), rs.getString("endereco"),
						rs.getString("numero"), rs.getString("complemento"),
						rs.getString("dataNasc"), rs.getString("email"),
						rs.getString("telRes"), rs.getString("telCel"),
						rs.getString("rg"), rs.getString("cpf"));
				objAl.add(aluno);

			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objAl;

	}

	// consulta aluno por CPF
	public ArrayList<AlunoEntidade> consultaPorCpf(AlunoEntidade al) {
		ArrayList<AlunoEntidade> objAl = new ArrayList<AlunoEntidade>();
		ResultSet rs;
		AlunoEntidade aluno;
		try {
			String sql = "SELECT * FROM aluno WHERE cpf LIKE ?";
			st = conn.prepareStatement(sql);
			st.setString(1, al.getCpf() + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				aluno = new AlunoEntidade(rs.getInt("codAlu"),
						rs.getString("nomeAlu"), rs.getString("endereco"),
						rs.getString("numero"), rs.getString("complemento"),
						rs.getString("dataNasc"), rs.getString("email"),
						rs.getString("telRes"), rs.getString("telCel"),
						rs.getString("rg"), rs.getString("cpf"));
				objAl.add(aluno);
			}

			st.close(); // fecha consulta
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objAl;
	}
	
	// consulta Simples aluno por CPF
	public AlunoEntidade consultaPorCpfSimples(AlunoEntidade al) {
		ResultSet rs;
		AlunoEntidade aluno = null;
		try {
			String sql = "SELECT * FROM aluno WHERE cpf LIKE ?";
			st = conn.prepareStatement(sql);
			st.setString(1, al.getCpf());
			rs = st.executeQuery();
			while (rs.next()) {
			    aluno = new AlunoEntidade(rs.getInt("codAlu"),
						rs.getString("nomeAlu"), rs.getString("endereco"),
						rs.getString("numero"), rs.getString("complemento"),
						rs.getString("dataNasc"), rs.getString("email"),
						rs.getString("telRes"), rs.getString("telCel"),
						rs.getString("rg"), rs.getString("cpf"));
			}

			st.close(); // fecha consulta
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aluno;
	}

	// incluir aluno no banco
	public boolean incluir(AlunoEntidade al) {
		boolean sucesso = false;
		try {
			String sql = "INSERT INTO aluno (nomeAlu, endereco, numero, complemento, dataNasc, email, telRes, telCel, rg, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, al.getNome());
			st.setString(2, al.getEnd());
			st.setString(3, al.getNum());
			st.setString(4, al.getComp());
			st.setString(5, al.getDataNasc());
			st.setString(6, al.getEmail());
			st.setString(7, al.getTelRes());
			st.setString(8, al.getTelCel());
			st.setString(9, al.getRg());
			st.setString(10, al.getCpf());

			st.executeUpdate();
			sucesso = true;
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}

	// VERIFICA EXISTENCIA DE UM CPF
	public boolean existCpf(String cpf) {
		boolean exist = false;
		ResultSet rs;
		try {
			String sql = "SELECT cpf FROM aluno WHERE cpf LIKE ?";
			st = conn.prepareStatement(sql);
			st.setString(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//db.closeConnection();
		return exist;
	}

	// Deleta aluno por CPF
	public boolean excluirPorCpf(String cpf) {
		boolean sucesso = false;

		try {
			String sql = "DELETE FROM aluno WHERE cpf LIKE ?";
			st = conn.prepareStatement(sql);
			st.setString(1, cpf);
			st.executeUpdate();
			sucesso = true;
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;

	}
	//this.st = this.conn.prepareStatement("update aluno (nomeAlu = ?, endereco = ?, numero = ?, complemento = ?, dataNasc = ?, email = ?, telRes = ?, telCel = ?, rg = ?, cpf = ? where cpf = ?)");
	
	public boolean Alterar(AlunoEntidade al) {
		boolean sucesso = false;
		try {
			String sql = ("UPDATE aluno SET nomeAlu = ?, endereco = ?, numero = ?, complemento = ?, dataNasc = ?, email = ?, telRes = ?, telCel = ?, rg = ?, cpf = ? WHERE cpf = ?");
	
			st = conn.prepareStatement(sql);
			st.setString(1, al.getNome());
			st.setString(2, al.getEnd());
			st.setString(3, al.getNum());
			st.setString(4, al.getComp());
			st.setString(5, al.getDataNasc());
			st.setString(6, al.getEmail());
			st.setString(7, al.getTelRes());
			st.setString(8, al.getTelCel());
			st.setString(9, al.getRg());
			st.setString(10, al.getCpf());
			st.setString(11, al.getCpf());

			st.executeUpdate();
			sucesso = true;
		
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}
  
	

}
