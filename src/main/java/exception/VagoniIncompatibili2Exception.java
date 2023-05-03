package exception;

public class VagoniIncompatibili2Exception extends RuntimeException {
	private String sigla;
	private char vagone01;
	private char vagone02;
	public VagoniIncompatibili2Exception(String message, String sigla, char vagone01, char vagone02, String nuovaSigla) {
		super(message + ": Errore nella costruzione del treno con sigla "+ sigla + " trovati due vagoni incompatibili di tipo " + vagone01 + "," + vagone02 + "--Sigla consigliata"+nuovaSigla+" ");
		this.vagone01 = vagone01;
		this.vagone02 = vagone02;
		this.sigla = sigla;		
	}
	public String siglaSuggerita() {
		while ( sigla.lastIndexOf(vagone01) >= 0) {
			String nuovasigla = sigla.substring(0 , sigla.lastIndexOf(vagone01))
					+ sigla.substring(sigla.lastIndexOf(vagone01) + 1, sigla.length());
			sigla = nuovasigla;
			}
		return sigla;
	}
	public String getSigla() {
		return sigla;
	}
	public char getVagone1() {
		return vagone01;
	}
	public char getVagone2() {
		return vagone02;
	}
}
