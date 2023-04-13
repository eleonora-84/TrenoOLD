package exception;

public class VagoneFuoriPostoException extends RuntimeException {
	
	private String sigla;
	private char vagone;
	public VagoneFuoriPostoException(String sigla, char vagone, String message) {
		super(message + ": errore nella posizionamento del vagone "+ vagone + " nel treno con sigla " + sigla);
		this.sigla = sigla;
		this.vagone = vagone;
	}
	public String getSigla() {
		return sigla;
	}
	public char getVagone() {
		return vagone;
	}
	
	
}
