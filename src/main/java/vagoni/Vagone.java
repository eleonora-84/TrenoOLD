package vagoni;

public abstract class Vagone implements Carrozza{
	
	private double peso;
	
	public char getTipo() {
		return this.getClass().getSimpleName().charAt(2);
	}
	
	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Vagone tipo=" + getTipo();
	}

}
