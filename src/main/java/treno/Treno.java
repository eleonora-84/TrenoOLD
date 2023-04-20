package treno;

import java.util.List;

import vagoni.Carrozza;
import vagoni.Locomotiva;
import vagoni.Motrice;
import vagoni.Vagone;

public class Treno {
	
	private int id;

	private Locomotiva locomotiva;

	private List<Vagone> listaVagoni;

	public Treno() {}
	
	public Treno(Locomotiva locomotiva, List<Vagone> listaVagoni) {
		super();
		this.locomotiva = locomotiva;
		this.listaVagoni = listaVagoni;
	}
	
	public double getPeso() {
		double peso = locomotiva.getPeso();
		for (Carrozza v : listaVagoni) {
			peso += v.getPeso();
		}
		return peso;
	}
	
	public Locomotiva getLocomotiva() {
		return locomotiva;
	}
	
	public List<Vagone> getListaVagoni(){
		return listaVagoni;
	}
	
	public void setListaVagoni(List newListaVagoni) {
		this.listaVagoni = newListaVagoni;
	}
	
	public void setLocomotiva(Locomotiva newLocomotiva) {
		this.locomotiva = newLocomotiva;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Treno [" + locomotiva + ", lista vagoni: " + listaVagoni + "]";
	}

}
