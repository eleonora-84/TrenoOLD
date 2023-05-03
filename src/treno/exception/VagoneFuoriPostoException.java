package treno.exception;

public class VagoneFuoriPostoException extends RuntimeException {
    private String sigla;

    public VagoneFuoriPostoException(String sigla, String sigla2, char c) {
        super("Ricorda:\nIl vagone Ristorante non può stare in coda al treno\n");
        this.sigla = sigla;
        this.sigla = this.sigla.substring(0, this.sigla.length() - 1);
        Errori e=new Errori(this.sigla);
    }

    public String siglaSuggerita() {
        this.sigla = this.sigla.substring(0, this.sigla.length() - 1);
        return this.sigla;
    }
}