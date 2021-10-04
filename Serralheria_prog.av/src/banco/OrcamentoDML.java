package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serralheria.Orcamento;

public class OrcamentoDML {
	private Connection banco;
	Orcamento orcamento = new Orcamento();

	public Connection Conecta() {
		ConnectionFactory conexao = new ConnectionFactory();
		try {
			banco = conexao.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return banco;
	}

	private Orcamento montarObjeto(ResultSet rs) throws SQLException {

		orcamento.setId(rs.getInt("ID_ORCAMENTO"));
		orcamento.set$aluminio(rs.getDouble("ALUMINIO"));
		orcamento.setAltura(rs.getDouble("ALTURA"));
		orcamento.setLargura(rs.getDouble("LARGURA"));
		orcamento.setMetrosqd(rs.getDouble("METROS"));
		orcamento.setTipmaterial(rs.getInt("TIPO_MATERIAL"));
		orcamento.setTotal(rs.getDouble("TOTAL"));

		return orcamento;
	}

	public void insertOrcamento(Orcamento dados, int id_pessoa) {

		try {
			String sql = "INSERT INTO ORCAMENTO(ALUMINIO,ALTURA,LARGURA,METROS,TIPO_MATERIAL,TOTAL, ID_PESSOA) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pc = banco.prepareStatement(sql);
			pc.setDouble(1, dados.get$aluminio());
			pc.setDouble(2, dados.getAltura());
			pc.setDouble(3, dados.getLargura());
			pc.setDouble(4, dados.getMetrosqd());
			pc.setDouble(5, dados.getTipmaterial());
			pc.setDouble(6, dados.getTotal());
			pc.setDouble(7, id_pessoa);
			pc.execute();
			pc.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public Orcamento selectOrcamento(int id) {
		try {

			PreparedStatement stmt = this.banco.prepareStatement("SELECT * FROM ORCAMENTO where ID_ORCAMENTO = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				orcamento = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			banco.close();

			return orcamento;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deleteOrcamento(int id) {

		try {
			String sql = "DELETE FROM ORCAMENTO where ID_ORCAMENTO = ?";
			PreparedStatement deleta = banco.prepareStatement(sql);
			deleta.setInt(1, id);

			deleta.executeUpdate();
			deleta.close();

		} catch (SQLException x) {
			throw new RuntimeException(x);
		}

	}
}
