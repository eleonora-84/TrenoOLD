package treno.factory;

import treno.vagoni.Vagone;

public interface  VagoneAbstractFactory {

	public Vagone costruisciLocomotiva();
	public Vagone costruisciCargo();
	public Vagone costruisciRistorante();
	public Vagone costruisciPasseggero();
	
}
