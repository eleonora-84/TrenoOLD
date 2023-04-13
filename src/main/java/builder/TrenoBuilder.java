package builder;

import java.util.List;
import java.util.ArrayList;
import treno.Treno;
import exception.*;
import vagoni.*;

public abstract class TrenoBuilder {
	public final Treno costruisci(String sigla) {
		
		List<Carrozza> listaVagoni = new ArrayList();
		
		if (sigla == null || sigla.length() < 1 )
			throw new SiglaAssenteException();
		
		if (sigla.indexOf('R') != sigla.lastIndexOf('R'))
			throw new VagoniIncompatibiliException(sigla, 'R', 'R', "Troppi ristoranti");
		
		if (sigla.indexOf('C')>=0 && sigla.indexOf('P')>=0)
			throw new VagoniIncompatibiliException(sigla, 'P', 'C', "Cargo e passeggeri non sono compatibili");
		
		if (sigla.indexOf('C')>=0 && sigla.indexOf('R')>=0)
			throw new VagoniIncompatibiliException(sigla, 'C', 'R', "Cargo e ristorante non sono compatibili");
		
		if (sigla.indexOf('R') == 0 || sigla.indexOf('R') == sigla.length()-1)
			throw new VagoneFuoriPostoException(sigla, 'R', "Il vagone ristorante non può essere agli estremi del treno");
		
		if (sigla.indexOf('H') != 0 && sigla.indexOf('H') != sigla.length())
			throw new VagoneFuoriPostoException(sigla, 'H', "La locomotiva può essere solo agli estremi del treno " + sigla.indexOf('H'));
			
		Motrice m = null;
		for(int i = 0; i<sigla.length(); i++) {
			switch(sigla.charAt(i)) {
				case('H'):
					m = costruisciLocomotiva();
					break;
				case('P'): 
					listaVagoni.add(costruisciPasseggeri());
					break;
				case('R'): 
					listaVagoni.add(costruisciRistorante());
					break;
				case('C'): 
					listaVagoni.add(costruisciCargo());
					break;
			}
		}
		Treno t = new Treno(m, listaVagoni);
		
		if (m.getMassaTrainata() < t.getPeso()) {
			throw new PesoEccedenteException();
		}
		return t;
	}

	
	protected abstract Motrice costruisciLocomotiva();

	protected abstract Carrozza costruisciPasseggeri();
	
	protected abstract Carrozza costruisciRistorante();

	protected abstract Carrozza costruisciCargo();
}
