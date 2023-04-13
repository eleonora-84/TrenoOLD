package exception;

public class PesoEccedenteException extends RuntimeException{
	
	public PesoEccedenteException() {
		super("Peso eccessivo");
	}
}
