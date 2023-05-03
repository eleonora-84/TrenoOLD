package treno.vagoni;

import java.util.List;

public class Treno {
	
	private List<Vagone> treno;
	private double pesoTrainabile=1600.00;
	
	
	
	public Treno(List<Vagone> treno) {
		super();
		this.treno = treno;
		
	}

	public String cambioSensoDiMarcia() {
		String finale="";
		for(int i=treno.size()-1;i>=0;i--) {
			finale=finale+treno.get(i).getSigla();
		}
		return finale;
	}
	
	public String inserisciVagone(String aggiunta,int posto) {
		String finale="";
		if (posto==0) {
			throw new Error("Non puoi aggiungere all'inizio del treno");
		}
		for(int i=0;i<treno.size();i++) {
			if(posto==i) {
				
				finale=finale+aggiunta+treno.get(i).getSigla();
			}else {
				finale=finale+treno.get(i).getSigla();
			}
		}
		
		return finale;
	}
	
	public String togliVagone(int posto) {
		String finale="";
		for(int i=0;i<treno.size();i++) {
			if(posto==i) {
				
			}else {
				finale=finale+treno.get(i).getSigla();
			}
		}
		return finale;
	}
	
	public String cambioVagone(String cambio,int posto) {
		String finale="";
		for(int i=0;i<treno.size();i++) {
			if(posto==i) {
				finale=finale+cambio;
			}else {
				finale=finale+treno.get(i).getSigla();
			}
		}
		return finale;
	}
	
	public boolean pesoTrasporto(double pesoTotale) {
		if(this.pesoTrainabile<pesoTotale) return false;
		return true;
	}

	@Override
	public String toString() {
		return treno.toString();
	}
}
