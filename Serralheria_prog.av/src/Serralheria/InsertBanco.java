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
	
	public void salvarEndereco(Endereco endereco) {
		try {

			String sql = "INSERT INTO ENDERECO (RUA,PONTO_REFERENCIA,ESTADO,CIDADE,BAIRRO,NUMERO,CEP) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getPontRefe());
			stmt.setString(3, endereco.getEstado());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getBairro());
			stmt.setString(6, endereco.getNumero());
			stmt.setString(7, endereco.getCep());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvarCliente(Cliente cliente) {
		try {

			String sql = "INSERT INTO CLIENTE (CPF,TELEFONE,ID_ENDERECO) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getTelefone());
			stmt.setInt(3, cliente.getEndereco().getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvarTecnico(Tecnico tecnico) {
		try {

			String sql = "INSERT INTO TECNICO (NOME,TELEFONE,CPF,CODIGO_ACESSO) VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tecnico.getNome());
			stmt.setString(2, tecnico.getTelefone());
			stmt.setString(3, tecnico.getCpf());
			stmt.setDouble(4, tecnico.getCodcesso());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void salvarOrcamento(Orcamento orcamento) {
		try {

			String sql = "INSERT INTO ORCAMENTO (ALUMINIO,ALTURA,LARGURA,METROS,TIPO_MATERIAL,TOTAL) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, orcamento.get$aluminio());
			stmt.setDouble(2, orcamento.getAltura());
			stmt.setDouble(3, orcamento.getLargura());
			stmt.setDouble(4, orcamento.getMetrosqd());
			stmt.setInt(5, orcamento.getTipmaterial());
			stmt.setDouble(6, orcamento.getTotal());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvarPagamento(FormaPagamento pagamento) {
		try {

			String sql = "INSERT INTO PAGAMENTO (TIPO_PAGAMENTO,TOTAL_PARCELAS,VALOR_TOTAL,VALOR_JUROS) VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, pagamento.getTipopagamento());
			stmt.setInt(2, pagamento.getVezes());
			stmt.setDouble(3, pagamento.getValortot());
			stmt.setDouble(4, pagamento.getCredito(0, 0));
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
