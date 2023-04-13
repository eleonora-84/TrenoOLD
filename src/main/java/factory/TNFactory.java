package factory;


import factory.locomotiva.*;
import factory.passeggeri.*;
import factory.ristorante.*;
import factory.cargo.*;
import vagoni.*;

public class TNFactory implements VagoneAbstractFactory {

	public Vagone costruisciLocomotiva() {
		return new TNLocomotiva();
	}

	public Vagone costruisciPasseggeri() {
		return new TNPasseggeri();
	}

	public Vagone costruisciRistorante() {
		return new TNRistorante();
	}

	public Vagone costruisciCargo() {
		return new TNCargo();
	}

}
