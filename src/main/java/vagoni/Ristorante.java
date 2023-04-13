package vagoni;

public class Ristorante extends Vagone implements Carrozza{

	private int numCoperti;
	private double peso;
	
	public Ristorante(int numCoperti, double peso) {
		super();
		this.numCoperti = numCoperti;
		this.peso = peso;
	}
	
	public int getNumCoperti() {
		return numCoperti;
	}


}
