package exception;

public class VagoniIncompatibiliException extends RuntimeException{
	private String sigla;
	private char vagone1;
	private char vagone2;
	private String nuovasigla=sigla;
	public VagoniIncompatibiliException(String message, String sigla, char vagone1, char vagone2) {
		super(message + ": Errore nella costruzione del treno con sigla "+ sigla + " trovati due vagoni incompatibili di tipo " + vagone1 + ","
	+ vagone2 + " \nSigla suggerita:");
		this.vagone1 = vagone1;
		this.vagone2 = vagone2;
		this.sigla = sigla;
	}
	public String siglaSuggerita() {
		while ( sigla.indexOf(vagone1) != sigla.lastIndexOf(vagone2) ) {
			
			nuovasigla = sigla.substring(0 , sigla.lastIndexOf(vagone2))
					+ sigla.substring(sigla.lastIndexOf(vagone2) + 1, sigla.length());
			sigla = nuovasigla;
			}
		return nuovasigla;
	}
	public String getSigla() {
		return sigla;
	}
	public char getVagone1() {
		return vagone1;
	}
	public char getVagone2() {
		return vagone2;
	}
}
