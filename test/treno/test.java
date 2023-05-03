package treno;

import treno.builder.TNBuilder;
import org.springframework.context.support.*;



import treno.builder.TrenoBuilder;
import treno.exception.*;
import treno.vagoni.*;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		TNBuilder bt =  (TNBuilder) context.getBean("bt"); 
		try {
			System.out.println(bt.costruisci("HPPPPPH"));
			System.out.println(bt.costruisci("HPPPPH"));
		} catch (VagoniIncompatibiliException | VagoneFuoriPostoException | LocomotivaAssenteException e) {
			
			e.printStackTrace();
		}
		
		//testEccezioni();
	}
	
	
	public static void testEccezioni() {
		String sigla = "HPRHPH";
		TrenoBuilder builder = new TNBuilder();
		try {
			Treno treno = builder.costruisci(sigla);
		}
		
		catch (VagoniIncompatibiliException e) {
			System.out.println(e.getMessage());
			String nuovasigla = sigla.substring(0 , sigla.lastIndexOf(e.getVagone2()))
					+ sigla.substring(sigla.lastIndexOf(e.getVagone2()) + 1, sigla.length());
			System.out.println("Si suggerisce di rimuovere un vagone e di usare questa sigla " + nuovasigla);
		}
		catch (SiglaAssenteException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(sigla);
	}
	public void rimuoviSigla() {
		
	}
	
	
	}