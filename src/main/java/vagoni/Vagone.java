package vagoni;

public abstract class Vagone implements Carrozza{

	private double peso;

	public Vagone() {
		super();
	}
	
	public Vagone(double peso) {
		super();
		this.peso = peso;
	}
	
	public char getTipo() {
		return this.getClass().getSimpleName().charAt(2);
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Vagone tipo=" + getTipo();
	}

}
