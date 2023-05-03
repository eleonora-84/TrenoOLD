package treno.exception;

public class LocomotivaAssenteException extends RuntimeException {
    private String sigla;

    public LocomotivaAssenteException(String message, String sigla) {
        super(message);
        this.sigla = sigla;
        while(this.sigla.indexOf(72) > 0) {
            String nuovasigla = this.sigla.substring(0, this.sigla.lastIndexOf(72)) + this.sigla.substring(this.sigla.lastIndexOf(72) + 1, this.sigla.length());
            this.sigla = nuovasigla;
        }
        Errori e=new Errori(this.sigla);
    }

    public String siglaSuggerita() {
        while(this.sigla.indexOf(72) > 0) {
            String nuovasigla = this.sigla.substring(0, this.sigla.lastIndexOf(72)) + this.sigla.substring(this.sigla.lastIndexOf(72) + 1, this.sigla.length());
            this.sigla = nuovasigla;
        }

        return 'H' + this.sigla;
    }
}