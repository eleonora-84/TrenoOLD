package treno.vagoni;

public class Cargo implements Vagone{
	
	private String tipoMerce;
	private String sigla="C";
	private double quantitaMerce;
	
	

	public Cargo(String tipoMerce, double quantitaMerce) {
		super();
		this.tipoMerce = tipoMerce;
		this.quantitaMerce = quantitaMerce;
	}

	@Override
	public double getPeso() {
		
		return 30.000+getPesoMerce()*quantitaMerce;
	}

	@Override
	public String getSigla() {
		
		return this.sigla;
	}

	@Override
	public double getPrezzo() {
		
		return 0;
	}

	public String getTipoMerce() {
		return tipoMerce;
	}
	
	public double getPesoMerce(){
		double pf=0;
		switch(getTipoMerce()) {
		case "Carbone":
			pf=50.00;
		
		case "Ferro":
			pf=100.20;
			
		case "Legno":
			pf=75.50;
		}
		return pf;
	}

	@Override
	public String toString() {
		return "Cargo [tipoMerce=" + tipoMerce + ", sigla=" + sigla + ", quantitaMerce=" + quantitaMerce + "]";
	}
	
}
