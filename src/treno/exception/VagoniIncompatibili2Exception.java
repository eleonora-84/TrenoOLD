package treno.exception;

public class VagoniIncompatibili2Exception extends RuntimeException{
	private String sigla;
    private char vagone01;
    private char vagone02;
    private String nuovasigla;

    public VagoniIncompatibili2Exception(String message, String sigla, char vagone01, char vagone02) {
        super(message + ": Errore nella costruzione del treno con sigla " + sigla + " trovati due vagoni incompatibili di tipo " + vagone01 + "," + vagone02 + " ");
        this.nuovasigla = this.sigla;
        this.vagone01 = vagone01;
        this.vagone02 = vagone02;
        this.sigla = sigla;
        while(this.sigla.lastIndexOf(this.vagone01) >= 0) {
            String nuovasigla = this.sigla.substring(0, this.sigla.lastIndexOf(this.vagone01)) + this.sigla.substring(this.sigla.lastIndexOf(this.vagone01) + 1, this.sigla.length());
            this.sigla = nuovasigla;
        }
        Errori e=new Errori(this.sigla);

    }

    public String siglaSuggerita() {
        while(this.sigla.lastIndexOf(this.vagone01) >= 0) {
            String nuovasigla = this.sigla.substring(0, this.sigla.lastIndexOf(this.vagone01)) + this.sigla.substring(this.sigla.lastIndexOf(this.vagone01) + 1, this.sigla.length());
            this.sigla = nuovasigla;
        }

        return this.nuovasigla;
    }

    public String getSigla() {
        return this.sigla;
    }

    public char getVagone1() {
        return this.vagone01;
    }

    public char getVagone2() {
        return this.vagone02;
    }
}
