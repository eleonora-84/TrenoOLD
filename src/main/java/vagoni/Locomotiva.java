package vagoni;

public class Locomotiva extends Vagone implements Carrozza, Motrice{

	private double massaTrainata;
	private double peso;
	
	public Locomotiva(double massaTrainata, double peso) {
		super();
		this.massaTrainata = massaTrainata;
		this.peso = peso;
	}

	public double getMassaTrainata() {
		return massaTrainata;
	}
	
	public double getPeso(){
		return peso;
	}
	
	@Override
	public String toString() {
		return "Locomotiva [" + super.toString() + ", massaTrainata=" + massaTrainata + "]";
	}

	
	@Override
	public char getTipo() {
		return 'H';
	}

	
	
}
