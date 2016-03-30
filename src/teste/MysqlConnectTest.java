package teste;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.MysqlConnect;

public class MysqlConnectTest {
	private Connection conn;
	private MysqlConnect db;

	@Test
	public void testObterConexao() throws SQLException {
		this.db = new MysqlConnect();
		this.conn = db.getConnection();

		assertNotNull("testa se a conexao nao e nula", this.conn);
	}

}
