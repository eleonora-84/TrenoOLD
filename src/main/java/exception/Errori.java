package exception;

public class Errori {
	private RuntimeException vi;
	private String sigla;
	public Errori(String sigla) {
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) {
			vi= new VagoniIncompatibili2Exception("Cargo e Passeggeri sono incompatibili", sigla, 'C', 'P', siglaSuggerita(sigla));
		}
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) {
			vi= new VagoniIncompatibili2Exception("Cargo e Ristorante non sono compatibili", sigla,'R','C',siglaSuggerita(sigla));
		}
		if (sigla.indexOf('R') != sigla.lastIndexOf("R")) {
			vi= new VagoniIncompatibiliException("Troppi Ristoranti",sigla,'R','R', siglaSuggerita(sigla));
		}
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1) {
			vi= new VagoniFuoriPostoException(sigla, siglaSuggerita(sigla));
		}
		if (sigla.indexOf('H') != 0) {
			vi=new LocomotivaAssenteException("La locomotiva deve stare in testa al treno: ", sigla);
		}
	}
	public String controlloErrore(String sigla) {
		
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) {
			vi = new VagoniIncompatibili2Exception("Cargo e Passeggeri sono incompatibili", sigla, 'C', 'P',siglaSuggerita(sigla));
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniIncompatibili2Exception) vi).siglaSuggerita();
		}
		if (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) {
			vi = new VagoniIncompatibili2Exception("Cargo e Ristorante non sono compatibili", sigla,'R','C',siglaSuggerita(sigla));
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniIncompatibili2Exception) vi).siglaSuggerita();
		}
		if (sigla.indexOf('R') != sigla.lastIndexOf("R")) {
			vi = new VagoniIncompatibiliException("Troppi Ristoranti",sigla,'R','R',siglaSuggerita(sigla));
//			sigla = siglaSuggerita(sigla);
//			return sigla;
			return ((VagoniIncompatibiliException) vi).siglaSuggerita();
		}
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1) {
			vi = new VagoniFuoriPostoException(sigla,siglaSuggerita(sigla));
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
			while (sigla.indexOf('H') > 0) {
				String nuovasigla = sigla.substring(0 , sigla.lastIndexOf('H')) + sigla.substring(sigla.lastIndexOf('H') + 1, sigla.length());
				sigla = nuovasigla;
			}
			return siglaSuggerita("H" + sigla);
}
		if (sigla.indexOf('R') == 0 | sigla.indexOf('R') == sigla.length()-1) {
			 sigla = sigla.substring(0,sigla.length()-1);
			return siglaSuggerita(sigla);}
		
		if (sigla.indexOf('R') != sigla.lastIndexOf("R")) {
			String nuovaSigla="";
			while ( sigla.indexOf('R') != sigla.lastIndexOf('R') ) {
				
				nuovaSigla = sigla.substring(0 , sigla.lastIndexOf('R'))
						+ sigla.substring(sigla.lastIndexOf('R') + 1, sigla.length());
				sigla = nuovaSigla;
				}
			return siglaSuggerita(sigla);
		}
			
		if ((sigla.indexOf('C') >= 0 && sigla.indexOf('P') >= 0) || (sigla.indexOf('C') >= 0 && sigla.indexOf('R') >= 0) ) {
			
			while ( sigla.lastIndexOf('C') >= 0) {
				String nuovasigla = sigla.substring(0 , sigla.lastIndexOf('C'))
						+ sigla.substring(sigla.lastIndexOf('C') + 1, sigla.length());
				sigla = nuovasigla;
				}
			return siglaSuggerita(sigla);
		}
			
		return sigla;
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
