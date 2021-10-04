package Serralheria;

public class Pessoa {

	private int id;
	private String nome;
	private String telefone;
	private String Cpf;
	private Endereco endereco;
	
	public Pessoa() {	
		this.telefone = null;
		this.Cpf = null;
	}
	public Pessoa(int id, String nome, String telefone, String cpf, Endereco endereco) {
		this.telefone = telefone;
		Cpf = cpf;
	}
	public String getTelefone() {
	//	return "Telefone: "+ telefone;
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		//return "CPF:"+Cpf;
		return Cpf;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}