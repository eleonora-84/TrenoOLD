package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import builder.TrenoBuilder;
import builder.TN.TNBuilder;
import dao.TrenoDao;
import daoImpl.TrenoDaoImpl;
import treno.Treno;
import dto.*;

public class TestJPA {

	public static void main(String[] args) {
		creaTreno();
	}
	
	public static void creaTreno() {
		System.out.println("Test 01");
		
	
		
		String siglaTrenord = "HCCCCC";
		
		TrenoBuilder builderTN = new TNBuilder();
		
		Treno trenoTN = builderTN.costruisci(siglaTrenord);
		Treno trenoTN2 = builderTN.costruisci("HPPPRPPP");
		Treno trenoTN3 = builderTN.costruisci("HRPPP");
		Treno trenoTN4 = builderTN.costruisci("HCCCC");
		
		TrenoDao trenoDao = TrenoDaoImpl.getInstance();
		
		trenoDao.add(trenoTN);
		trenoDao.add(trenoTN2);
		trenoDao.add(trenoTN3);
		trenoDao.add(trenoTN4);
		System.out.println(trenoTN);
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(trenoDao.add(trenoTN));
		entitymanager.persist(trenoDao.add(trenoTN2));
		entitymanager.persist(trenoDao.add(trenoTN3));
		entitymanager.persist(trenoDao.add(trenoTN4));
		
		
		TrenoDTO trenoID2 = entitymanager.find(TrenoDTO.class, 9);
		
		System.out.println(trenoID2);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emFactory.close();
		
	}

}
