package builder.FR;

import builder.TrenoBuilder;
import vagoni.Carrozza;
import vagoni.Vagone;

public class FRBuilder extends TrenoBuilder {

	@Override
	protected FRLocomotiva costruisciLocomotiva() {
		return new FRLocomotiva();
	}

	@Override
	protected Vagone costruisciPasseggeri() {
		return new FRPasseggeri();
	}

	@Override
	protected Vagone costruisciRistorante() {
		return new FRRistorante();
	}

	@Override
	protected Vagone costruisciCargo() {
		return new FRCargo();
	}

}
