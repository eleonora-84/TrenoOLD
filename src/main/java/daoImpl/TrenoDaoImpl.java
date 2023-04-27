package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	public List<TrenoDTO> listaTreni() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		CriteriaBuilder builder = entitymanager.getCriteriaBuilder();
	    CriteriaQuery<TrenoDTO> query = builder.createQuery(TrenoDTO.class);


	    Root<TrenoDTO> variableRoot = query.from(TrenoDTO.class);
	    query.select(variableRoot);
	    System.out.println(entitymanager.createQuery(query).getResultList());
		return entitymanager.createQuery(query).getResultList();
	}


}
	

