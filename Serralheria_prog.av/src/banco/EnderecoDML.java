package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serralheria.Endereco;

public class EnderecoDML {
	private Connection banco;
	Endereco endereco = new Endereco();

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

	private Endereco montarObjeto(ResultSet rs) throws SQLException {

		endereco.setId(rs.getInt("ID_ENDERECO"));
		endereco.setRua(rs.getString("RUA"));
		endereco.setPontRefe(rs.getString("PONTO_REFERENCIA"));
		endereco.setEstado(rs.getString("ESTADO"));
		endereco.setCidade(rs.getString("CIDADE"));
		endereco.setBairro(rs.getString("BAIRRO"));
		endereco.setNumero(rs.getString("NUMERO"));
		endereco.setCep(rs.getString("CEP"));

		return endereco;
	}

	public void insertEndereco(Endereco dados) {
		try {
			String sql = "INSERT INTO ENDERECO(ESTADO,CIDADE,BAIRRO,RUA,PONTO_REFERENCIA,NUMERO,CEP) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pc = banco.prepareStatement(sql);
			pc.setString(1, dados.getEstado());
			pc.setString(2, dados.getCidade());
			pc.setString(3, dados.getBairro());
			pc.setString(4, dados.getRua());
			pc.setString(5, dados.getPontRefe());
			pc.setString(6, dados.getNumero());
			pc.setString(7, dados.getCep());

			pc.execute(); 
			pc.close();
			System.out.println("Dados inseridos com sucesso");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public Endereco selectEndereco(String id) {
		try {

			PreparedStatement stmt = this.banco.prepareStatement("SELECT * FROM ENDERECO where ID_ENDERECO = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				endereco = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			banco.close();

			return endereco;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deleteEndereco(int var) {

		try {
			String sql = "DELETE FROM ENDERECO where ID_ENDERECO = ?";
			PreparedStatement deleta = banco.prepareStatement(sql);
			deleta.setInt(1, var);

			deleta.executeUpdate();
			deleta.close();

		} catch (SQLException x) {
			throw new RuntimeException(x);
		}

	}
	public Endereco buscarPorId(int id) {
		try {

			PreparedStatement stmt = banco.prepareStatement("SELECT * FROM ENDERECO where ID_ENDERECO = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Endereco endereco = null;
			if(rs.next()) {
				endereco = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			banco.close();
			return endereco;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
