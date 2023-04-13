import org.springframework.context.support.ClassPathXmlApplicationContext;

import treno.*;
import builder.*;
import builder.FR.*;
import builder.TN.*;
import exception.*;

public class TrenoTest {

	public static void main(String[] args) {
		testSenzaSpring();
	}
	
	public static void testSenzaSpring() {
		String siglaTrenord = "HRPPP";
		TrenoBuilder builderTN = new TNBuilder();
		Treno trenoTN = builderTN.costruisci(siglaTrenord);
		System.out.println(trenoTN);

		String siglaFrecciaRossa = "HRPPP";
		TrenoBuilder builderFR = new FRBuilder();
		Treno trenoFR = builderFR.costruisci(siglaFrecciaRossa);
		System.out.println(trenoFR);
	}
	
	public static void testSpring() {
		String siglaTrenord = "HPPRP";
		String siglaFrecciaRossa = "HRPPP";
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		try {
			TrenoBuilder builderTN = (TrenoBuilder) context.getBean("tn");
			Treno trenoTN = builderTN.costruisci(siglaTrenord);
			System.out.println(trenoTN);
		}
		catch(SiglaAssenteException e) {
			e.printStackTrace();
		}
		catch(VagoneFuoriPostoException e) {
			System.out.println(e.getMessage());
			System.out.println("\nSi suggerisce di spostare il ristorante al centro del treno.\n");
		}
		catch(VagoniIncompatibiliException e) {
			System.out.println(e.getMessage());
			String nuovaSigla = siglaTrenord.substring(0 , siglaTrenord.lastIndexOf(e.getVagone2()))
					+ siglaTrenord.substring(siglaTrenord.lastIndexOf(e.getVagone2()) + 1, siglaTrenord.length());
			System.out.println("\nSi suggerisce di rimuovere un vagone e di usare questa sigla " + nuovaSigla + "\n");
		}
		
		catch(PesoEccedenteException e) {
			System.out.println(e.getMessage());
			System.out.println("\nSi suggerisce di rimuovere vagoni fino a raggiungere il peso consentito.");
		}
		
		TrenoBuilder builderFR = (TrenoBuilder) context.getBean("fr");
		System.out.println(builderFR.costruisci(siglaFrecciaRossa));
	}

}
