package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.VagoneDao;
import vagoni.Locomotiva;
import vagoni.Vagone;

public class VagoneDaoImpl implements VagoneDao {

	
	private static VagoneDaoImpl instance = null;
	
	private VagoneDaoImpl() {
	
	}
	
	public static VagoneDaoImpl getInstance() {
		if (instance == null) 
			instance = new VagoneDaoImpl();
		return instance;
	}
	private static SessionFactory factory;
	
	public void factory() {
	    try {
	        factory = new Configuration().configure().buildSessionFactory();
	     } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }
	}
	

	@Override
	public int add(Vagone vagone) {
		factory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer vagoneID = null;
		try {
			tx = session.beginTransaction();
			vagoneID = (Integer) session.save(vagone);
			System.out.println(vagoneID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("Eccezione nel metodo add di vagone");
		} finally {
			session.close();
		}
		return vagoneID;
	}


	@Override
	public Vagone updateVagone(Vagone vagone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVagone() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vagone> listavagoni() {
		// TODO Auto-generated method stub
		return null;
	}

}
