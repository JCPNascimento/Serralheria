package Serralheria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://localhost:3306/Serralheria";
	private String usuario = "root";
	private String senha = "root";
	public Connection con;

	public void conexao() {

		System.setProperty("jdbc.Drivers", driver);
		try {
			con= DriverManager.getConnection(caminho,usuario,senha);
			/*JOptionPane.showMessageDialog(null, "Conexao efetuada com sucesso!");*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*JOptionPane.showMessageDialog(null, "Erro conexao\n" + e.getMessage());*/
		}
	}
	public void desconecta() {

		try {
			con.close();
			/*JOptionPane.showMessageDialog(null, "Desconectado com sucesso");*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*JOptionPane.showMessageDialog(null, "Erro ao fechar conexao\n"+e.getMessage());*/
		}

	}

	public void executaSQl(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			/*JOptionPane.showMessageDialog(null, "Erro ao executar sql\n" + e.getMessage());*/
			e.printStackTrace();
		}

	}

}
