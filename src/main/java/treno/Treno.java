package treno;

import java.util.List;

import vagoni.Carrozza;
import vagoni.Motrice;

public class Treno {
	
	private int id;
	
	private Motrice motrice;

	private List<Carrozza> listaVagoni;

	public Treno() {}
	
	public Treno(Motrice motrice, List<Carrozza> listaVagoni) {
		super();
		this.motrice = motrice;
		this.listaVagoni = listaVagoni;
	}
	
	public double getPeso() {
		double peso = motrice.getPeso();
		for (Carrozza v : listaVagoni) {
			peso += v.getPeso();
		}
		return peso;
	}
	
	public Motrice getMotrice() {
		return motrice;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Treno [" + motrice + ", lista vagoni: " + listaVagoni + "]";
	}

}
