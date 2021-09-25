package Serralheria;

public class Endereco {
	
	private String rua;
	private String PontRefe;
	private String estado;
	private String cidade;
	private String bairro;
	private String numero;
	private String cep;
	
	
	public Endereco() {
		super();
	}
	
	public Endereco(String rua, String pontRefe, String estado, String cidade, String bairro, String numero, String cep) {
		super();
		this.rua = rua;
		PontRefe = pontRefe;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
	}	
	
	public String getRua() {
		return "Rua: "+rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getPontRefe() {
		return "Ponto de Referencia: "+PontRefe;
	}

	public void setPontRefe(String pontRefe) {
		PontRefe = pontRefe;
	}

	public String getEstado() {
		return "Estado: "+estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return "Cidade: "+cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return "Bairro: "+bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return "Numero: "+numero;
	}

	public void setNumero(String string) {
		this.numero = string;
	}

	public String getCep() {
		return "CEP: "+cep;
	}

	public void setCep(String d) {
		this.cep = d;
	}
	@Override
	public String toString() {
		return"[ "+getCep()+" "+getEstado()+" "+getCidade()+" "+getBairro()+" "+getNumero()+" "+getPontRefe();
	}
}

