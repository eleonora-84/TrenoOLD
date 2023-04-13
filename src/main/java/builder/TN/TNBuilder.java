package builder.TN;

import builder.TrenoBuilder;
import vagoni.Carrozza;
import vagoni.Motrice;
import vagoni.Vagone;

public class TNBuilder extends TrenoBuilder {

	@Override
	protected Motrice costruisciLocomotiva() {
		return new TNLocomotiva();
	}

	@Override
	protected Carrozza costruisciPasseggeri() {
		return new TNPasseggeri();
	}

	@Override
	protected Carrozza costruisciRistorante() {
		return new TNRistorante();
	}

	@Override
	protected Carrozza costruisciCargo() {
		return new TNCargo();
	}

}
