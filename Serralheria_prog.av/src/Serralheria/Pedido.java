package Serralheria;

public class Pedido {
	private int tipopedido;

	public Pedido() {
		super();
	}
	public Pedido(int tipopedido) {
		this.tipopedido = tipopedido;
	}
	public void tipopedido (int tipopedido) {
		settipopedido(this.tipopedido);
	}
	public Object gettipopedido() {
		return (retorno(tipopedido));
	}
	public void  settipopedido(int tipopedido) {
		this.tipopedido = tipopedido; 
	}
	public static Object retorno(int tipopedido) {
		if(tipopedido==1) {
			System.out.println("JANELA");
		}
		if(tipopedido==2) {
			System.out.println("PORTA");
		}
		if(tipopedido==3) {
			System.out.println("PORT�O");
		}
		if(tipopedido==4) {
			System.out.println("TOLDO");
		}
		return "";
	}
	@Override
	public String toString() {
		return ""+this.tipopedido ;
	}
}