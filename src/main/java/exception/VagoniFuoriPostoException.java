package exception;

public class VagoniFuoriPostoException extends RuntimeException {
	private String sigla;
	public VagoniFuoriPostoException(String sigla,String nuovaSigla) {
		super("Ricorda:\nIl vagone Ristorante non può stare in coda al treno\n"+"--Sigla Suggerita= "+ nuovaSigla);
		this.sigla = sigla;
	}
	public String siglaSuggerita() {
		sigla = sigla.substring(0,sigla.length()-1);
		return sigla;
	};
}
