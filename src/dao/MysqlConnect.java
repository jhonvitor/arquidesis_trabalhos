package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnect {

	public Connection conn;

	public MysqlConnect() {
		conn = null;
		
		String url = "jdbc:mysql://localhost/";
		String dbName = "cursopresencial";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "vitor";
		try {
			Class.forName(driver);
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			System.out.println("Erro no Banco de Dados!");
			e.printStackTrace();
		}
	}

	// fornece a conexao com o banco de dados Mysql
	public Connection getConnection() {
		return conn;
	}

	// Fecha a conexao com bco de dados
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}