package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.ui.Model;

import dao.UtenteDao;
import dto.UtenteDTO;
import exception.UtenteGiaRegistratoException;

public class UtenteDaoImpl implements UtenteDao {
	private static UtenteDaoImpl instance = null;
	
	private UtenteDaoImpl() {
	}

	public static UtenteDaoImpl getInstance() {
		if (instance==null) 
			return new UtenteDaoImpl();
		else return instance;
	}
	

	public void add(String username, String password) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		if(findByUsername(username)==null)
			entitymanager.persist(new UtenteDTO(username, password));
			else throw new UtenteGiaRegistratoException("Utente già registrato");
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emFactory.close();
	}
	
	public UtenteDTO findByID(int id) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		
		UtenteDTO utenteDto = entitymanager.find(UtenteDTO.class, id);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emFactory.close();
		return utenteDto;
	}
	
	public UtenteDTO findByUsername(String username) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
	    List<UtenteDTO> listaUtentiDTO = listaUtenti();
    
	    UtenteDTO utenteFinal = new UtenteDTO();
	    
	    for (UtenteDTO u : listaUtentiDTO) {
	    	if (u.getUsername().equals(username)) {

	    		return u;
	    	}
	    } return null;
	    
	}
	
	public UtenteDTO findByUsernameEPassword(String username, String password) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
	    List<UtenteDTO> listaUtentiDTO = listaUtenti();
    
	    UtenteDTO utenteFinal = new UtenteDTO();
	    
	    for (UtenteDTO u : listaUtentiDTO) {
	    	if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
	    		
	    		return u;
	    	}
	    } return null;
	    
	}

	public UtenteDTO findByPassword(String password) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
	    List<UtenteDTO> listaUtentiDTO = listaUtenti();
	    
    UtenteDTO utenteFinal = new UtenteDTO();
	    
	    for (UtenteDTO u : listaUtentiDTO) {
	    	if (u.getPassword().equals(password)) {

    		
	    		return u;
	    	}
	    } return null;
	    
	}
	public UtenteDTO updateUtente(UtenteDTO utente) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUtente() {
		// TODO Auto-generated method stub

	}

	public List<UtenteDTO> listaUtenti() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		CriteriaBuilder builder = entitymanager.getCriteriaBuilder();
	    CriteriaQuery<UtenteDTO> query = builder.createQuery(UtenteDTO.class);


	    Root<UtenteDTO> variableRoot = query.from(UtenteDTO.class);
	    query.select(variableRoot);

		return entitymanager.createQuery(query).getResultList();
	}
	
	

}
