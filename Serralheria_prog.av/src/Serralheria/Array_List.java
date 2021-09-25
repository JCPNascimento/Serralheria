package Serralheria;

import java.util.ArrayList;

public class Array_List {
	
	private    ArrayList<String> Dados = new ArrayList<String>();

	public void RepositorioContasLista() {
		Dados = new ArrayList<String>();
	}
	ArrayList<String> getDados() {
		return Dados;
	}
	public void setDados(ArrayList<String> dados) {
		Dados = dados;
	}
}