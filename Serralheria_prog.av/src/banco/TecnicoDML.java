package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serralheria.Pessoa;
import Serralheria.Tecnico;

public class TecnicoDML {
	private Connection banco;
	Pessoa pessoa = new Pessoa();;
	Tecnico tecnico = new Tecnico();;

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

	private Tecnico montarObjeto(ResultSet rs) throws SQLException {

		int idPessoa = rs.getInt("ID_PESSOA");
		PessoaDML dao = new PessoaDML();
		Pessoa pessoa = dao.buscarPorId(idPessoa);
		tecnico.setPessoa(pessoa);

			
		tecnico.setId(rs.getInt("ID_TECNICO"));
		tecnico.setCodcesso(rs.getInt("CODIGO_ACESSO"));
		
		return tecnico;
	}

	public void insertTecnico(Tecnico dados) {

		try {
			String sql = "INSERT INTO TECNICO(ID_PESSOA,CODIGO_ACESSO) VALUES(?,?)";
			PreparedStatement pc = banco.prepareStatement(sql);
			pc.setInt(1, dados.getPessoa().getId());
			pc.setDouble(2, dados.getCodcesso());
			pc.execute();
			pc.close();
			System.out.println("Dados inseridos com sucesso");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public Tecnico selectTecnico(int id) {
		try {

			PreparedStatement stmt = this.banco.prepareStatement("SELECT * FROM TECNICO where ID_TECNICO = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				tecnico = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			banco.close();

			return tecnico;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public void deleteTecnico(int id){

		try {
			String sql = "DELETE FROM TECNICO where ID_TECNICO = ?";
			PreparedStatement deleta = banco.prepareStatement(sql);
			deleta.setInt(1, id);
			
			deleta.executeUpdate();
			deleta.close();
			
			
		} catch (SQLException x) {
			throw new RuntimeException(x);
		}
	
	
	}
}
