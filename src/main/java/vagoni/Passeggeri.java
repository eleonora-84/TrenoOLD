package vagoni;

public class Passeggeri extends Vagone implements Carrozza{
	
	private int numPasseggeri;

	public Passeggeri(int numPasseggeri) {
		super();	
		this.numPasseggeri = numPasseggeri;
	}
	
	public int getNumPasseggeri() {
		return numPasseggeri;
	}



}
