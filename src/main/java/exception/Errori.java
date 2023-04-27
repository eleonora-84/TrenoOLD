package treno.exception;

public class Errori {
	private RuntimeException vi;
	private String sigla;
	public Errori(String sigla) {
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) {
			vi = new VagoniIncompatibili2Exception("Cargo e Passeggeri sono incompatibili", sigla, 'C', 'P');
		}
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) {
			vi = new VagoniIncompatibili2Exception("Cargo e Ristorante non sono compatibili", sigla,'R','C');
		}
		if (sigla.indexOf('R') != sigla.lastIndexOf("R")) {
			vi = new VagoniIncompatibiliException("Troppi Ristoranti",sigla,'R','R');
		}
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1) {
			vi = new VagoniFuoriPostoException(sigla);
		}
		if (sigla.indexOf('H') != 0) {
			vi = new LocomotivaAssenteException("La locomotiva deve stare in testa al treno: ", sigla);
		}
	}
	public String controlloErrore(String sigla) {
		
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) {
			vi = new VagoniIncompatibili2Exception("Cargo e Passeggeri sono incompatibili", sigla, 'C', 'P');
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniIncompatibili2Exception) vi).siglaSuggerita();
		}
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) {
			vi = new VagoniIncompatibili2Exception("Cargo e Ristorante non sono compatibili", sigla,'R','C');
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniIncompatibili2Exception) vi).siglaSuggerita();
		}
		if (sigla.indexOf('R') != sigla.lastIndexOf("R")) {
			vi = new VagoniIncompatibiliException("Troppi Ristoranti",sigla,'R','R');
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniIncompatibiliException) vi).siglaSuggerita();
		}
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1) {
			vi = new VagoniFuoriPostoException(sigla);
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniFuoriPostoException) vi).siglaSuggerita();
		}
		if (sigla.indexOf('H') != 0) {
			vi = new LocomotivaAssenteException("La locomotiva deve stare in testa al treno: ", sigla);
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((LocomotivaAssenteException) vi).siglaSuggerita();
		}
		return sigla;
	}
	public String siglaSuggerita(String sigla) {
		if (sigla.indexOf('H') != 0) {
			return ((LocomotivaAssenteException) vi).siglaSuggerita();}
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1)
			return ((VagoniFuoriPostoException) vi).siglaSuggerita();
		if (sigla.indexOf('R') != sigla.lastIndexOf("R"))
		return ((VagoniIncompatibiliException) vi).siglaSuggerita();
		if ((sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) || (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) )
			return ((VagoniIncompatibili2Exception) vi).siglaSuggerita();
		return null;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getSigla() {
		return sigla;
	}
	public String getMessage(String sigla) {
		if (sigla.indexOf('H') != 0)
			return ((LocomotivaAssenteException) vi).getMessage();
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1)
			return ((VagoniFuoriPostoException) vi).getMessage();
		if (sigla.indexOf('R') != sigla.lastIndexOf("R"))
		return ((VagoniIncompatibiliException) vi).getMessage();
		if ((sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) || (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) )
			return ((VagoniIncompatibili2Exception) vi).getMessage();
		return null;
	}
}
