package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {

		String nomeBanco = "serralheria"; // Nome do banco
		String usuario = "root"; // Nome do usuario my sql
		String senha = ""; // senha do usuario do my sql

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/" + nomeBanco + "?useTimezone=true&serverTimezone=UTC", usuario, senha);
	}

}
