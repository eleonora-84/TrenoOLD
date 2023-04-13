package treno;

import java.util.List;

import vagoni.Carrozza;
import vagoni.Motrice;

public class Treno {

	public Motrice motrice;
	public List<Carrozza> listaVagoni;

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

	@Override
	public String toString() {
		return "Treno [" + motrice + ", lista vagoni: " + listaVagoni + "]";
	}

}
