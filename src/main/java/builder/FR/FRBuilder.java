package builder.FR;

import builder.TrenoBuilder;
import vagoni.Carrozza;

public class FRBuilder extends TrenoBuilder {

	@Override
	protected FRLocomotiva costruisciLocomotiva() {
		return new FRLocomotiva();
	}

	@Override
	protected Carrozza costruisciPasseggeri() {
		return new FRPasseggeri();
	}

	@Override
	protected Carrozza costruisciRistorante() {
		return new FRRistorante();
	}

	@Override
	protected Carrozza costruisciCargo() {
		return new FRCargo();
	}

}
