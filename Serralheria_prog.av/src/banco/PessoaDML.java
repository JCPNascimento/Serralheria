package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serralheria.Endereco;
import Serralheria.Pessoa;

public class PessoaDML {
	private Connection banco;
	Pessoa pessoa = new Pessoa();

	public Connection Conecta() {
		ConnectionFactory conexao = new ConnectionFactory();
		try {
			banco = conexao.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return banco;
	}

	private Pessoa montarObjeto(ResultSet rs) throws SQLException {
		
		pessoa.setId(rs.getInt("ID_PESSOA"));
		pessoa.setNome(rs.getString("NOME"));
		pessoa.setCpf(rs.getString("CPF"));
		pessoa.setTelefone(rs.getString("TELEFONE"));
		


		return pessoa;
	}

	public void InsertPessoa(Pessoa dados, int i) {

		try {
			String sql = "INSERT INTO PESSOA(NOME,CPF,TELEFONE,ID_ENDERECO) VALUES(?,?,?,?)";
			PreparedStatement pc = banco.prepareStatement(sql);
			
			pc.setString(1, dados.getNome());
			pc.setString(2, dados.getCpf());
			pc.setString(3, dados.getTelefone());
			pc.setInt(4, i);
			pc.execute();
			dados.setId(selectPessoa(dados).getId());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public Pessoa selectPessoa(Pessoa pessoa) {
		try {

			PreparedStatement stmt = this.banco.prepareStatement("SELECT * FROM PESSOA");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				pessoa = montarObjeto(rs);
			}

			return pessoa;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deletePessoa(int id) {
		try {
			String sql = "DELETE FROM PESSOA where ID_PESSOA = ?";
			PreparedStatement deleta = banco.prepareStatement(sql);
			deleta.setInt(1, id);

			deleta.executeUpdate();
			//deleta.close();

		} catch (SQLException x) {
			throw new RuntimeException(x);
		}

	}

	public Pessoa buscarPorId(int id) {

		try {
			PreparedStatement stmt = banco.prepareStatement("SELECT * FROM PESSOA WHERE ID_PESSOA = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Pessoa pessoa = null;
			if (rs.next()) {
				pessoa = montarObjeto(rs);
			}

			return pessoa;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
