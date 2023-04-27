package treno.exception;

public class LocomotivaAssenteException extends RuntimeException {
	private String sigla;
	public LocomotivaAssenteException(String message, String sigla) {
		super(message);
		this.sigla = sigla;
	}
	public String siglaSuggerita() {
		while (sigla.indexOf('H') > 0) {
			String nuovasigla = sigla.substring(0 , sigla.lastIndexOf('H')) + sigla.substring(sigla.lastIndexOf('H') + 1, sigla.length());
			sigla = nuovasigla;
		}
		return ("H" + sigla);
	};
	
}
