package treno.exception;

public class VagoniIncompatibiliException extends RuntimeException{
	
	private String sigla;
	private String nuovasigla;
	private char vagone1;
	private char vagone2;
	public VagoniIncompatibiliException(String message, String sigla, char vagone1, char vagone2) {
		super(message + ": Errore nella costruzione del treno con sigla "+ sigla + " trovati due vagoni incompatibili di tipo " + vagone1 + "," + vagone2 + " ");
		this.vagone1 = vagone1;
		this.vagone2 = vagone2;
		this.sigla = sigla;
		while(this.sigla.indexOf(this.vagone1) != this.sigla.lastIndexOf(this.vagone2)) {
            this.nuovasigla = this.sigla.substring(0, this.sigla.lastIndexOf(this.vagone2)) + this.sigla.substring(this.sigla.lastIndexOf(this.vagone2) + 1, this.sigla.length());
            this.sigla = this.nuovasigla;
        }
		Errori e=new Errori(this.sigla);
	}
	public String siglaSuggerita() {
        while(this.sigla.indexOf(this.vagone1) != this.sigla.lastIndexOf(this.vagone2)) {
            this.nuovasigla = this.sigla.substring(0, this.sigla.lastIndexOf(this.vagone2)) + this.sigla.substring(this.sigla.lastIndexOf(this.vagone2) + 1, this.sigla.length());
            this.sigla = this.nuovasigla;
        }

        return this.nuovasigla;
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
