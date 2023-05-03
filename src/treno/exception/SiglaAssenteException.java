package treno.exception;

public class SiglaAssenteException extends RuntimeException {
	public SiglaAssenteException() {
		super("Sigla del treno assente");
	}
}
