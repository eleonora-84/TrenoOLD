package builder;
import treno.Treno;
import exception.*;
import vagoni.Vagone;
public abstract class TrenoBuilder {
	
	private String nuovaSigla;
	
	public final Treno costruisci(String sigla) {
		sigla = sigla.toUpperCase();
		this.nuovaSigla = sigla;
		if (sigla == null || sigla.length() < 1  ) {
			throw new SiglaAssenteException();
		}
		Errori e1 = new Errori(sigla);
//		while (e1.controlloErrore(nuovaSigla) != nuovaSigla) {	
//			sigla = e1.controlloErrore(nuovaSigla);
//			nuovaSigla = sigla;
//			e1 = new Errori(sigla);
//		}	
//		sigla= nuovaSigla;
		if (e1.siglaSuggerita(sigla) == null) {
			Treno t = new Treno();
			for (int i = 0; i < sigla.length(); i++) {
				Vagone v;
				switch (sigla.charAt(i)) {
				case 'H':
					v = costruisciLocomotiva();
					t.aggiungiVagone(v);
					break;
				case 'P':
					v = costruisciPasseggeri();
					t.aggiungiVagone(v);
					break;
				case 'R':
					v = costruisciRistorante();
					t.aggiungiVagone(v);
					break;
				case 'C':
					v = costruisciCargo();
					t.aggiungiVagone(v);
					break;
				default:
					v = costruisciPasseggeri();
					t.aggiungiVagone(v);
				}		
			}
		return t;
		}
		return null;
	}

	protected abstract Vagone costruisciCargo() ;

	protected abstract Vagone costruisciRistorante();

	protected abstract Vagone costruisciPasseggeri();

	protected abstract Vagone costruisciLocomotiva();

}
