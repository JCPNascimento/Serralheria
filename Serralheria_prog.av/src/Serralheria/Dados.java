package Serralheria;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private List<String> dados = new ArrayList<>();


	public void insert(String d) {
        dados.add(d);
    }
    public List<String> find() {
        return  this.dados;
    }
   
}