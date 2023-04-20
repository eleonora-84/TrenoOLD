package test;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import treno.Treno;

public class ManageTrain {

	private static SessionFactory factory;
	
	public static void main(String[] args) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			System.out.println("Factory creata");
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			System.out.println("Sono nell'eccezione.");
		} 
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");
		
		ManageTrain MT = new ManageTrain();
		
		Treno trenoTN = (Treno) context.getBean("trenoTN");
		System.out.println(trenoTN);

		Treno trenoFR = (Treno) context.getBean("trenoFR");
		System.out.println(trenoFR);

		MT.aggiungiTreno(trenoTN);
		MT.aggiungiTreno(trenoFR);
		
		MT.listaTreni();
				
	}
	
	/* CREATE */
	public Integer aggiungiTreno(Treno t) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer trenoID = null;
		try {
			tx = session.beginTransaction();
			trenoID = (Integer) session.save(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("Eccezione nel metodo aggiungiTreno");
		} finally {
			session.close();
		}
		return trenoID;
	}
	
	
	
	/* READ */
	public void listaTreni() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List trains = session.createQuery("FROM treno").list();
			System.out.println("Elenco treni: ");
			for (Iterator iterator = trains.iterator(); iterator.hasNext();) {
				Treno treno = (Treno) iterator.next();
				System.out.println(treno);
			}
		} catch(HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("Eccezione nel metodo listaTreni");
		} finally {
			session.close();
		}
	}

}
