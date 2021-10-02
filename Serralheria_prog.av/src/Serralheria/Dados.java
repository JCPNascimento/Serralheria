package Serralheria;

import java.util.ArrayList;
import java.util.List;



public class Dados {

    public  List<String> dados = new ArrayList<>();
    
    public  List<String> listClone = new ArrayList<>();

	public String insert(String d) {
        dados.add(d);
		return d;
    }
	

	public void remover(String vari) {
		int i = 0; //indice para remoção
		for(String dado: dados) {
			
			if(dado.equals(vari)) {
				i = dados.indexOf(dado);
				
				dados.remove(i);
				break;
			}
		}
	}
	
	public String procurar(String pesquisa) {
	    String procurado = null ;
	    for(String dado: dados) {

	            if(dado.equals(pesquisa)) {
	                procurado = dado;

	            }
	            procurado = dado;
	    }

	    return procurado;
	}
	
	
    public List<String> find() {
        return  this.dados;
    }
    
    public List<String> findd() {
        return  this.listClone;
    }
}