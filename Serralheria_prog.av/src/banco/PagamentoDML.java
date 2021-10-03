package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serralheria.FormaPagamento;
import Serralheria.Pessoa;

public class PagamentoDML {
	private Connection banco;
	FormaPagamento pagamento = new FormaPagamento();

	private FormaPagamento montarObjeto(ResultSet rs) throws SQLException {

		int idPessoa = rs.getInt("ID_PESSOA");
		PessoaDML dao = new PessoaDML();
		Pessoa pessoa = dao.buscarPorId(idPessoa);
		pagamento.setPessoa(pessoa);

		pagamento.setId(rs.getInt("ID_PAGAMENTO"));
		pagamento.setTipopagamento(rs.getInt("TIPO_PAGAMENTO"), rs.getDouble("VALOR_TOTAL"));
		pagamento.setValortot(rs.getDouble("VALOR_TOTAL"));

		return pagamento;
	}

	public void insertPagamento(FormaPagamento dados) {

		try {
			String sql = "INSERT INTO PAGAMENTO(TIPO_PAGAMENTO,VALOR_TOTAL,ID_PESSOA) VALUES(?,?,?)";
			PreparedStatement pc = banco.prepareStatement(sql);
			pc.setDouble(1, dados.getTipopagamento());
			pc.setDouble(2, dados.getValortot());
			pc.setInt(3, dados.getPessoa().getId());
			pc.execute();
			pc.close();
			System.out.println("Dados inseridos com sucesso");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public FormaPagamento selecionar(int id) {
		try {

			PreparedStatement stmt = this.banco.prepareStatement("SELECT * FROM PAGAMENTO where ID_PAGAMENTO = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				pagamento = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			banco.close();

			return pagamento;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deletePagamento(int id) {

		try {
			String sql = "DELETE FROM PAGAMENTO where ID_PAGAMENTO = ?";
			PreparedStatement deleta = banco.prepareStatement(sql);
			deleta.setInt(1, id);

			deleta.executeUpdate();
			deleta.close();

		} catch (SQLException x) {
			throw new RuntimeException(x);
		}

	}
}
