package Serralheria;

public class Pessoa {

	private String nome;
	private String telefone;
	private String Cpf;
	
	public Pessoa() {	
		this.telefone = null;
		this.Cpf = null;
	}
	public Pessoa(String nome, String telefone, String cpf, Endereco endereco) {
		this.telefone = telefone;
		Cpf = cpf;
	}
	public String getTelefone() {
		return "Telefone: "+ telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return "CPF:"+Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getNome() {
		return  nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}