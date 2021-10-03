package Serralheria;


public class FormaPagamento implements Calculos {

	private Pessoa pessoa ;
	private int id;
	private int tipopagamento;
	private double especie ;
	private double credito;
	private double debito;
	private double valortot;
	private int Vezes;
	double valJuros;
	double TT;

	public FormaPagamento(int tipopagamento, double especie, double credito, double debito, double valortot, int vezes) {
		super();
		this.tipopagamento = tipopagamento;
		this.especie = especie;
		this.credito = credito;
		this.debito = debito;
		this.valortot = valortot;
		Vezes = vezes;
	}
	
	public FormaPagamento() {
	}
	
	
	
	public void setTipopagamento(int tipopagamento, double total) {
		switch (tipopagamento) {
		case 1: 
			System.out.println("*************************** CREDITO ****************************");
			System.out.println("OBS: A PARTIR DE 4X NO CARTÃO ADICIONAL DE 7%");
			System.out.println("CREDITO: ATE 10X ");
			System.out.println("QUANTIDADE DE PARCELAS ?");
			break;
		case 2:
			System.out.println("DIRIJA-SE AO CAIXA POR FAVOR!");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("Debito: "+total);
			break;
		case 3:
			System.out.println("DIRIJA-SE AO CAIXA POR FAVOR!");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("Especie: "+total);
			break;
		}
		this.tipopagamento = tipopagamento;
	}
	public int getTipopagamento() {
		return tipopagamento;
	}
	public double getEspecie() {
		return especie;
	}
	public void setEspecie(double especie) {
		this.especie = especie;
	}
	public double getCredito(int Vezes, double total) {
		return credito;
	}
	public void setCredito(int Vezes, double total) {

		switch(Vezes) {
		case 1: 
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("Valor total: R$"+total);
			System.out.println("TOTAL: "+total);
			break;
		case 2:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("2X DE "+total/Vezes);
			System.out.println("TOTAL: "+total);
			break;
		case 3:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("3X DE "+ juroscredit()/Vezes);
			System.out.println("TOTAL: "+juroscredit()); //PRINTF PARA RETIRAR OS NUMEROS ADICIONAIS
			break;
		case 4:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		case 5:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		case 6:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		case 7:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		case 8:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		case 9:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		case 10:
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                         CUPOM FISCAL                         |");
			System.out.println("----------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------");
			System.out.println("|                           PARCELAS                           |");
			System.out.println("----------------------------------------------------------------");
			valJuros = juroscredit()/Vezes*Vezes;
			TT = total+valJuros;
			System.out.println("ADICIONAL PARCELAMENTO: R$ "+valJuros);
			System.out.println("TOTAL SEM JUROS: R$ "+total);
			System.out.println("TOTAL A SER PAGO: R$"+TT);
			break;
		}
		this.credito = credito;
	}
	public double getDebito() {
		return debito;
	}
	public void setDebito(double debito) {
		this.debito = debito;
	}
	public double getValortot() {
		return valortot;
	}
	public void setValortot(double valortot) {
		this.valortot = valortot;
	}
	public int getVezes() {
		return Vezes;
	}
	public void setVezes(int vezes) {
		this.Vezes = vezes;
	}
	@Override
	public String toString() {
		return" "+getValortot()+" "+getVezes()+" X DE "+getCredito(Vezes, credito)+ " DEBITO: "+getDebito()+" ESPECIE: "+ getEspecie();
	}
	@Override
	public double juroscredit() {
		if (getVezes() >= 4) {
			double jrs1 = 7;
			double jrs2 = 100;
			double tt = jrs1/jrs2 * valortot;
			valortot = tt;
			return valortot; 
		} else { 
			return valortot;
		}
	}
	@Override
	public double descontopgm() {
		if(getTipopagamento()==2) {
			double desc = 5/100;
			return valortot = valortot - desc;
		}
		if(getTipopagamento()==3) {
			double desc = 5/100;
			return valortot = valortot - desc;
		}
		else {
			return 0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}