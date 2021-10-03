package Serralheria;

public class Cliente extends Pessoa{

	private Endereco endereco;
	private Pessoa pessoa;
	
	public Cliente( String telefone, String cpf, Endereco endereco) {
		super(telefone, cpf, cpf, endereco);
		this.endereco = endereco;
	}
	public Cliente() {
		super();
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}