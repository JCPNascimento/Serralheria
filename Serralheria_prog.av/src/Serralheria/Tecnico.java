package Serralheria;


public class Tecnico extends Pessoa {
	private double codcesso = 3030;

	public Tecnico(String nome, String telefone, String cpf, int codcesso) {
		super(nome, telefone, cpf, null);
		this.codcesso = codcesso;
	}
	public Tecnico() {
		super();
	}
	public double getCodcesso() {
		return codcesso;
	}
	public void setCodcesso(int codcesso) {
		this.codcesso = codcesso;
	}
	public String getNome() {
		String nome= "jackson Nascimento";
		String nome1= "Denys Wildson";
		return nome + "\n"+nome1;
	}
	public String getCpf() {
		String Cpf= "01368457";
		String cpf1= "01380977";
		return Cpf+ "\n"+ cpf1;
	}
	public String toString() {
		return"Alunos: \n"+getNome()+"\nCPF: \n"+getCpf();
	}
}