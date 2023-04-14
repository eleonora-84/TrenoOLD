package exception;

import treno.Treno;

public class PesoEccedenteException extends RuntimeException{
	
	public PesoEccedenteException(Treno t) {
		super("Peso massimo consentito: " + t.getPeso());
	}
}
