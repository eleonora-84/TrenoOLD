package treno.vagoni;

public class Locomotiva implements Vagone{

	private String sigla="H";
	private double pesoTrainabile=1600.00;
	
	public Locomotiva() {
		super();
	}

	@Override
	public double getPeso() {
		
		return 93.800;
	}

	@Override
	public String getSigla() {
		
		return this.sigla;
	}

	@Override
	public double getPrezzo() {
		
		return 5000.00;
	}

	

	public double getPesoTrainabile() {
		return pesoTrainabile;
	}

	@Override
	public String toString() {
		return "Locomotiva [sigla=" + sigla + ", pesoTrainabile=" + pesoTrainabile + "]";
	}
	
}
