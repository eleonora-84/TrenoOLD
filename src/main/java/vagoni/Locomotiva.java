package vagoni;

import treno.Treno;

public class Locomotiva extends Vagone implements Carrozza, Motrice{

	private int id;
	
	private double massaTrainata;



	public Locomotiva() {}
	
	public Locomotiva(double massaTrainata) {
		super();
		this.massaTrainata = massaTrainata;

	}
	
	public void setMassaTrainata(double massaTrainata) {
		this.massaTrainata = massaTrainata;
	}


	public double getMassaTrainata() {
		return massaTrainata;
	}
	
	public double getPeso(){
		return super.getPeso();
	}
	
	@Override
	public String toString() {
		return "Locomotiva [" + super.toString() + ", massaTrainata=" + massaTrainata + "]";
	}

	
	@Override
	public char getTipo() {
		return 'H';
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
