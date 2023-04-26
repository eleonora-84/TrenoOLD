package treno;

import java.util.List;
import java.util.ArrayList;

import vagoni.Carrozza;
import vagoni.Locomotiva;
import vagoni.Vagone;

public class Treno {
	

	private Locomotiva locomotiva;

	private List<Vagone> listaVagoni;

	public Treno() {}
	
	public Treno(Locomotiva locomotiva, List<Vagone> listaVagoni) {
		super();
		this.locomotiva = locomotiva;
		this.listaVagoni = listaVagoni;
	}
	
	public String getSigla() {
		
		List<String> listaString = new ArrayList<>();
		
		System.out.println();
		if (this.locomotiva != null) {
			listaString.add("H");
		}
		
		for (Vagone v : this.listaVagoni) {
			switch(v.getTipo()) {
			case 'C': {
				listaString.add("C");
				break;
				}
			case 'P':{
				listaString.add("P");
				break;
				}
			case 'R':{
				listaString.add("R");
				break;
				}
			}
		}	
		String lista = "";
		for (String s : listaString) {
			lista += s;
		}
		return lista;
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
	
	public void setListaVagoni(List<Vagone> newListaVagoni) {
		this.listaVagoni = newListaVagoni;
	}
	
	public void setLocomotiva(Locomotiva newLocomotiva) {
		this.locomotiva = newLocomotiva;
	}

	@Override
	public String toString() {
		return "Treno [" + locomotiva + ", lista vagoni: " + listaVagoni + "]";
	}

}
