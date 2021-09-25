package Serralheria;

public class Cliente extends Pessoa{

	private Endereco endereco;
	
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
}