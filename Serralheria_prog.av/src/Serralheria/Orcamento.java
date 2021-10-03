package Serralheria;


public class Orcamento {
	private int id;
	private double $aluminio;
	private double altura;
	private double largura;
	private double metrosqd;
	private int tipmaterial;
	private double total;
	
	public Orcamento() {
		super();
	}
	public Orcamento(double $aluminio, double altura, double largura, double metrosqd, int tipmaterial, double total) {
		super();
		this.$aluminio = $aluminio;
		this.altura = altura;
		this.largura = largura;
		this.metrosqd = metrosqd;
		this.tipmaterial = tipmaterial;
		this.total = total;
	}
	public double get$aluminio() {
		return $aluminio;
	}
	public void set$aluminio(double $aluminio) {
		this.$aluminio = $aluminio;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getMetrosqd() {
		return getAltura() * getLargura() ;
	}
	public void setMetrosqd(double metrosqd) {
		this.metrosqd = metrosqd;
	}
	public int getTipmaterial() {
		return tipmaterial;
	}
	public void setTipmaterial(int escprodut) {
		
		switch (escprodut) {
		case 1:
			int cor1=35;
			setTotal((getMetrosqd() * cor1)*5);
			this.tipmaterial = escprodut;
			break;
		case 2:
			int cor2=40;
			setTotal((getMetrosqd() * cor2)*5);
			this.tipmaterial = escprodut;
			break;
		}
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return"[ "+getAltura()+" "+getLargura()+" "+getMetrosqd()+" "+getTotal()+" ]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
