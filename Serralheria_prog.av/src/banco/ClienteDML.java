package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serralheria.Cliente;
import Serralheria.Endereco;
import Serralheria.Pessoa;

public class ClienteDML {
	private Connection banco;
	Endereco endereco = new Endereco();
	Pessoa pessoa = new Pessoa();
	Cliente cliente = new Cliente();

	public Connection Conecta() {
		ConnectionFactory conexao = new ConnectionFactory();
		try {
			banco = conexao.getConnection();
			System.out.println("Banco conectado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possivel conecta ao banco.");
		}
		return banco;
	}

	private Cliente montarObjeto(ResultSet rs) throws SQLException {

		int idEndereco = rs.getInt("ID_ENDERECO");
		EnderecoDML dao = new EnderecoDML();
		Endereco endereco = dao.buscarPorId(idEndereco);
		cliente.setEndereco(endereco);

		int idPessoa = rs.getInt("ID_PESSOA");
		PessoaDML dao2 = new PessoaDML();
		Pessoa pessoa = dao2.buscarPorId(idPessoa);
		cliente.setPessoa(pessoa);

		cliente.setId(rs.getInt("ID_CLIENTE"));

		return cliente;
	}

	public void insertCliente(Cliente dados) {
		try {
			String sql = "INSERT INTO CLIENTE(ID_PESSOA,ID_ENDERECO) VALUES(?,?)";
			PreparedStatement pc = banco.prepareStatement(sql);
			pc.setInt(1, dados.getPessoa().getId());
			pc.setInt(2, dados.getEndereco().getId());
			pc.execute();
			pc.close();
			System.out.println("Dados inseridos com sucesso");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public Cliente selectCliente(int cpf) {
		try {

			PreparedStatement stmt = this.banco.prepareStatement("SELECT * FROM CLIENTE where CPF = ?");
			stmt.setInt(1, cpf);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				cliente = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			banco.close();

			return cliente;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deleteCliente(int i) {
		try {
			String sql = "DELETE FROM Cliente where id_cliente = ?";
			PreparedStatement deleta = banco.prepareStatement(sql);
			deleta.setInt(1, i);

			deleta.executeUpdate();
			deleta.close();

		} catch (SQLException x) {
			throw new RuntimeException(x);
		}

	}
}
