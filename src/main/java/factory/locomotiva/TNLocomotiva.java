package factory.locomotiva;

import vagoni.*;

public class TNLocomotiva extends Locomotiva implements InterfaceLocomotiva {
	
	public TNLocomotiva() {
		super(100);
		super.setPeso(20);
	}

}
