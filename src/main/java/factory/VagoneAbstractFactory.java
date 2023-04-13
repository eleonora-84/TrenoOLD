package factory;

import vagoni.Vagone;

public interface VagoneAbstractFactory {
	public Vagone costruisciLocomotiva();
	public Vagone costruisciPasseggeri();
	public Vagone costruisciRistorante();
	public Vagone costruisciCargo();	
}
