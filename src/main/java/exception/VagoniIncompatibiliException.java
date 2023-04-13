package exception;

public class VagoniIncompatibiliException extends RuntimeException {
	
	private String sigla;
	private char vagone1;
	private char vagone2;
	
	public VagoniIncompatibiliException(String sigla, char vagone1, char vagone2, String message) {
		super(message + ": errore nella costruzione del treno con sigla " + sigla + ", trovati due vagoni incompatibili di tipo " + vagone1 + " e " + vagone2);
		this.sigla = sigla;
		this.vagone1 = vagone1;
		this.vagone2 = vagone2;
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
