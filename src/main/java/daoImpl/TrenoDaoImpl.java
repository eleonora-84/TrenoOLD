package daoImpl;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.*;
import daoImpl.*;

import treno.Treno;
import vagoni.Carrozza;
import vagoni.Locomotiva;
import vagoni.Passeggeri;
import vagoni.Vagone;

public class TrenoDaoImpl implements TrenoDao {
	
	private static TrenoDaoImpl instance = null;
	
	private TrenoDaoImpl() {
	
	}
	
	public static TrenoDaoImpl getInstance() {
		if (instance == null) 
			instance = new TrenoDaoImpl();
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
	public int add(Treno treno) {
		factory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer trenoID = null;
		LocomotivaDaoImpl locomotivaDao = LocomotivaDaoImpl.getInstance();
		VagoneDao vagoneDao = VagoneDaoImpl.getInstance();
		
		locomotivaDao.add((Locomotiva) treno.getLocomotiva());
		
		List<Vagone> vagoni = new ArrayList<>();
		vagoni = treno.getListaVagoni();
		
		try {
			tx = session.beginTransaction();
			trenoID = (Integer) session.save(treno);
			System.out.println("Treno id: " + trenoID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("Eccezione nel metodo add");
		} finally {
			session.close();
		}
		return trenoID;
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
