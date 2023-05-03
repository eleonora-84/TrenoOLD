package treno.vagoni;

public class Passeggero implements Vagone{
	
	private String sigla="P";
	private int numPasseggeri;
	
	
	
	public Passeggero(int numPasseggeri) {
		super();
		this.numPasseggeri = numPasseggeri;
	}

	@Override
	public double getPeso() {
		
		return 60.000+this.numPasseggeri*50;
	}

	@Override
	public String getSigla() {
		
		return this.sigla;
	}

	@Override
	public double getPrezzo() {
		
		return 3000.00;
	}

	
	public int getNumeroPasseggeri() {
		return this.numPasseggeri;
	}

	@Override
	public String toString() {
		return "Passeggero [sigla=" + sigla + ", numPasseggeri=" + numPasseggeri + "]";
	}
	
}
