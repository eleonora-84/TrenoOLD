//package test;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import treno.*;
//import builder.*;
//import vagoni.*;
//import builder.FR.*;
//import builder.TN.*;
//import dao.TrenoDao;
//import daoImpl.*;
//import exception.*;
//
//public class TrenoTest {
//	
//
//	
//	public static void main(String[] args) {		
//		testBuilder();
//		// testTNSenzaSpring();
//		// testFRSenzaSpring();
//		// testTNSpring();
//		// testFRSpring();
//		// testHbn();
//
//	}
//	
//	public static void testBuilder() {
//		
//		TrenoBuilder trenoTN = new TNBuilder();
//		Treno treno = trenoTN.costruisci("HPPCC");
//		System.out.println(treno);
//		
//	}
//	
//	
//	public static void testHbn() {
////		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");
////		TrenoDaoImpl trenoDao = (TrenoDaoImpl) context.getBean("trenoDao");
////		
////		Treno trenoTN = (Treno) context.getBean("trenoTN");
//		
//		TrenoDao trenoDao = TrenoDaoImpl.getInstance();
//		Vagone v1 = new Passeggeri(50);
//		Vagone v2 = new Passeggeri(50);
//		Vagone v3 = new Passeggeri(50);
//		List<Vagone> listaVagoni = new ArrayList<Vagone>();
//		listaVagoni.add(v1);
//		System.out.println(listaVagoni);
//		listaVagoni.add(v2);
//		System.out.println(listaVagoni);
//		listaVagoni.add(v3);
//		System.out.println(listaVagoni);
//		
//		Treno trenoTN = new Treno(new Locomotiva(), listaVagoni);
//		trenoDao.add(trenoTN);
//	}
//	
//	public static void testTNSenzaSpring() {
//		
//		String siglaTrenord = "HRPPP";
//		
//		try {
//			TrenoBuilder builderTN = new TNBuilder();
//			Treno trenoTN = builderTN.costruisci(siglaTrenord);
//			System.out.println(trenoTN);
//			
//			TrenoDao trenoDao = TrenoDaoImpl.getInstance();
//			trenoDao.add(trenoTN);
//			System.out.println(trenoTN);
//
//		}
//		catch(SiglaAssenteException e) {
//			e.printStackTrace();
//		}
//		catch(VagoneFuoriPostoException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di spostare il ristorante al centro del treno.\n");
//		}
//		catch(VagoniIncompatibiliException e) {
//			System.out.println(e.getMessage());
//			String nuovaSigla = siglaTrenord.substring(0 , siglaTrenord.lastIndexOf(e.getVagone2()))
//					+ siglaTrenord.substring(siglaTrenord.lastIndexOf(e.getVagone2()) + 1, siglaTrenord.length());
//			System.out.println("\nSi suggerisce di rimuovere un vagone e di usare questa sigla " + nuovaSigla + "\n");
//		}
//		
//		catch(PesoEccedenteException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di rimuovere vagoni fino a raggiungere il peso consentito.");
//		}
//	}
//	
//	public static void testFRSenzaSpring() {
//		
//		String siglaFrecciaRossa = "HRPPP";
//		
//		try {
//			TrenoBuilder builderFR = new FRBuilder();
//			Treno trenoFR = builderFR.costruisci(siglaFrecciaRossa);
//			System.out.println(trenoFR);
//		}
//		catch(SiglaAssenteException e) {
//			e.printStackTrace();
//		}
//		catch(VagoneFuoriPostoException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di spostare il ristorante al centro del treno.\n");
//		}
//		catch(VagoniIncompatibiliException e) {
//			System.out.println(e.getMessage());
//			String nuovaSigla = siglaFrecciaRossa.substring(0 , siglaFrecciaRossa.lastIndexOf(e.getVagone2()))
//					+ siglaFrecciaRossa.substring(siglaFrecciaRossa.lastIndexOf(e.getVagone2()) + 1, siglaFrecciaRossa.length());
//			System.out.println("\nSi suggerisce di rimuovere un vagone e di usare questa sigla " + nuovaSigla + "\n");
//		}
//		
//		catch(PesoEccedenteException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di rimuovere vagoni fino a raggiungere il peso consentito.");
//		}
//	}
//	
//	public static void testTNSpring() {
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");
//
//		try {
//			Treno trenoTN = (Treno) context.getBean("trenoTN");
//			System.out.println(trenoTN);
//		}
//		catch(SiglaAssenteException e) {
//			e.printStackTrace();
//		}
//		catch(VagoneFuoriPostoException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di spostare il ristorante al centro del treno.\n");
//		}
//		catch(VagoniIncompatibiliException e) {
//			System.out.println(e.getMessage());
//			// String nuovaSigla =  substring(0 , siglaTrenord.lastIndexOf(e.getVagone2()))
//			//		+ siglaTrenord.substring(siglaTrenord.lastIndexOf(e.getVagone2()) + 1, siglaTrenord.length());
//			// System.out.println("\nSi suggerisce di rimuovere un vagone e di usare questa sigla " + nuovaSigla + "\n");
//		}
//		
//		catch(PesoEccedenteException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di rimuovere vagoni fino a raggiungere il peso consentito.");
//		}
//
//	}
//	
//	public static void testFRSpring() {
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");
//
//		try {
//			Treno trenoFR = (Treno) context.getBean("trenoFR");
//			System.out.println(trenoFR);
//		}
//		catch(SiglaAssenteException e) {
//			e.printStackTrace();
//		}
//		catch(VagoneFuoriPostoException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di spostare il ristorante al centro del treno.\n");
//		}
//		catch(VagoniIncompatibiliException e) {
//			System.out.println(e.getMessage());
//			// String nuovaSigla = siglaFrecciaRossa.substring(0 , siglaFrecciaRossa.lastIndexOf(e.getVagone2()))
//			//		+ siglaFrecciaRossa.substring(siglaFrecciaRossa.lastIndexOf(e.getVagone2()) + 1, siglaFrecciaRossa.length());
//			// System.out.println("\nSi suggerisce di rimuovere un vagone e di usare questa sigla " + nuovaSigla + "\n");
//		}
//		
//		catch(PesoEccedenteException e) {
//			System.out.println(e.getMessage());
//			System.out.println("\nSi suggerisce di rimuovere vagoni fino a raggiungere il peso consentito.");
//		}
//
//	}
//
//}
