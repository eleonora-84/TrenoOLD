package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.*;
import treno.Treno;
import dto.*;

public class TrenoDaoImpl implements TrenoDao {
	
	private static TrenoDaoImpl instance = null;
	
	private TrenoDaoImpl() {
	}

	public static TrenoDaoImpl getInstance() {
		if (instance==null) 
			return new TrenoDaoImpl();
		else return instance;
	}
	
	@Override
	public TrenoDTO add(Treno treno, UtenteDTO utente) {
		
		TrenoDTO trenoDTO = new TrenoDTO(treno.getSigla(), 0, utente); // treno.getPeso() 
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		entitymanager.persist(trenoDTO);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emFactory.close();

		return trenoDTO;
	}

	@Override
	public Treno updateTreno(Treno treno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTreno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Treno> listaTreni() {
		// TODO Auto-generated method stub
		return null;
	}


}
	

