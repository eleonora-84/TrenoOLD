package factory.ristorante;

import vagoni.Ristorante;

public class TNRistorante extends Ristorante implements InterfaceRistorante{
	
	public TNRistorante() {
		super(20);
		super.setPeso(20);
	}

}
