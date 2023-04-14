package vagoni;

public class Ristorante extends Vagone implements Carrozza{

	private int numCoperti;

	public Ristorante(int numCoperti) {
		super();
		this.numCoperti = numCoperti;
	}
	
	public int getNumCoperti() {
		return numCoperti;
	}


}
