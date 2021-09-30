package Serralheria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Serralheria.ConnectionFactory;
import Serralheria.Pessoa;


public class InsertBanco {
	
	private Connection connection;
	
	public InsertBanco() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void salvarPessoa(Pessoa pessoa) {
		try {

			String sql = "INSERT INTO PESSOA (NOME, TELEFONE, CPF,ID_ENDERECO) VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getTelefone());
			stmt.setString(3, pessoa.getCpf());
			stmt.setInt(4, pessoa.getEndereco().getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
