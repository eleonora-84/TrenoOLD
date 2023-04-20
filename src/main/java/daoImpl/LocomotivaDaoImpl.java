package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.LocomotivaDao;
import vagoni.Locomotiva;

public class LocomotivaDaoImpl implements LocomotivaDao {
	
	private static LocomotivaDaoImpl instance = null;
	
	private LocomotivaDaoImpl() {
	
	}
	
	public static LocomotivaDaoImpl getInstance() {
		if (instance == null) 
			instance = new LocomotivaDaoImpl();
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
	public int add(Locomotiva locomotiva) {
		factory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer locomotivaID = null;
		try {
			tx = session.beginTransaction();
			locomotivaID = (Integer) session.save(locomotiva);
			System.out.println(locomotivaID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("Eccezione nel metodo add");
		} finally {
			session.close();
		}
		return locomotivaID;
	}
	
	@Override
	public Locomotiva get(int id) {
		factory();
		Session session = factory.openSession();
		Transaction tx = null;
		
		Locomotiva locomotiva = null;
		try {
			tx = session.beginTransaction();
			locomotiva = session.get(Locomotiva.class, id);
			System.out.println(locomotiva);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("Eccezione nel metodo get by id");
		} finally {
			session.close();
		}
		return locomotiva;
	}
	

	@Override
	public void update(Locomotiva locomotiva) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}



}
