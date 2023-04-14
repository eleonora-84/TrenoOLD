import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import builder.TrenoBuilder;
import builder.FR.FRBuilder;
import builder.TN.TNBuilder;
import treno.Treno;

public class ManageTrain {

	private static SessionFactory factory;
	
	public static void main(String[] args) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
		} 
		
		ManageTrain MT = new ManageTrain();
		
		String siglaTrenord = "HRPPP";
		TrenoBuilder builderTN = new TNBuilder();
		Treno trenoTN = builderTN.costruisci(siglaTrenord);

		String siglaFrecciaRossa = "HRPPP";
		TrenoBuilder builderFR = new FRBuilder();
		Treno trenoFR = builderFR.costruisci(siglaFrecciaRossa);
		
		MT.aggiungiTreno(siglaFrecciaRossa, builderFR);
		MT.aggiungiTreno(siglaTrenord, builderTN);
		
		MT.listaTreni();
		

		
	}
	
	/* CREATE */
	public Integer aggiungiTreno(String sigla, TrenoBuilder trenoBuilder) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer trenoID = null;
		try {
			tx = session.beginTransaction();
			Treno treno = trenoBuilder.costruisci(sigla);
			trenoID = (Integer) session.save(treno);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
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
		} finally {
			session.close();
		}
	}

}
