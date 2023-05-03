package treno.vagoni;

public class Ristorante implements Vagone{
	
	private String sigla="R";
	private int numCoperti;
	private int numPersonale;
	
	public Ristorante(int numCoperti, int numPersonale) {
		super();
		this.numCoperti = numCoperti;
		this.numPersonale = numPersonale;
	}

	@Override
	public double getPeso() {
		
		return 79.000+this.numCoperti*50+this.numPersonale*50;
	}

	@Override
	public String getSigla() {
		
		return this.sigla;
	}

	@Override
	public double getPrezzo() {
		
		return 4800.00;
	}

	public int getNumCoperti() {
		return numCoperti;
	}

	public int getNumPersonale() {
		return numPersonale;
	}

	@Override
	public String toString() {
		return "Ristorante [sigla=" + sigla + ", numCoperti=" + numCoperti + ", numPersonale=" + numPersonale + "]";
	}
	
	
}
