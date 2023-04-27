package builder.TN;

import builder.TrenoBuilder;
import vagoni.Locomotiva;
import vagoni.Vagone;

public class TNBuilder extends TrenoBuilder {

	@Override
	protected Locomotiva costruisciLocomotiva() {
		return new TNLocomotiva();
	}

	@Override
	protected Vagone costruisciPasseggeri() {
		return new TNPasseggeri();
	}

	@Override
	protected Vagone costruisciRistorante() {
		return new TNRistorante();
	}

	@Override
	protected Vagone costruisciCargo() {
		return new TNCargo();
	}

}
