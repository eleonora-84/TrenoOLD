package vagoni;

public class Passeggeri extends Vagone implements Carrozza{
	
	private int numPasseggeri;
	private double peso;
	
	public Passeggeri(int numPasseggeri, double peso) {
		super();	
		this.numPasseggeri = numPasseggeri;
		this.peso = peso;
	}
	
	public int getNumPasseggeri() {
		return numPasseggeri;
	}



}
