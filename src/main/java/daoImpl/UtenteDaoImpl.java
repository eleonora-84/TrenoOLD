package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dao.UtenteDao;
import dto.UtenteDTO;

public class UtenteDaoImpl implements UtenteDao {
	private static UtenteDaoImpl instance = null;
	
	private UtenteDaoImpl() {
	}

	public static UtenteDaoImpl getInstance() {
		if (instance==null) 
			return new UtenteDaoImpl();
		else return instance;
	}
	

	@Override
	public UtenteDTO add(String username, String password) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		UtenteDTO utenteDto = new UtenteDTO(username, password);
		entitymanager.persist(utenteDto);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emFactory.close();
		return utenteDto;
	}
	
	@Override
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
	
	@Override
	public UtenteDTO findByUsername(String username) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
	    List<UtenteDTO> listaUtentiDTO = listaUtenti();
    
	    UtenteDTO utenteFinal = new UtenteDTO();
	    
	    for (UtenteDTO u : listaUtentiDTO) {
	    	if (u.getUsername().equals(username)) {
	    		utenteFinal.setId(u.getId());
	    		utenteFinal.setUsername(u.getUsername());
	    		utenteFinal.setPassword(u.getPassword());
	    		return utenteFinal;
	    	}
	    } return null;
	    
	}

	@Override
	public UtenteDTO findByPassword(String password) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
	    List<UtenteDTO> listaUtentiDTO = listaUtenti();
	    
    UtenteDTO utenteFinal = new UtenteDTO();
	    
	    for (UtenteDTO u : listaUtentiDTO) {
	    	if (u.getPassword().equals(password)) {
	    		utenteFinal.setId(u.getId());
	    		utenteFinal.setUsername(u.getUsername());
	    		utenteFinal.setPassword(u.getPassword());
    		
	    		return utenteFinal;
	    	}
	    } return null;
	    
	}
	@Override
	public UtenteDTO updateUtente(UtenteDTO utente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUtente() {
		// TODO Auto-generated method stub

	}

	@Override
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
