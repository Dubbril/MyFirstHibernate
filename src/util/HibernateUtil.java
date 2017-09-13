package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	private static SessionFactory sessionFactory;

	static {
		try {
//			sessionFactory = new Configuration().configure().buildSessionFactory();
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addResource("users/User.hbm.xml");
			sessionFactory = cfg.buildSessionFactory();
		}catch(Throwable ex) {
			ex.printStackTrace();
			System.err.println("Can not Initial SessionFactory!!!"+ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
