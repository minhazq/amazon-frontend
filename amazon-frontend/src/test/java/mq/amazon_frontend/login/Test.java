package mq.amazon_frontend.login;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;

public class Test{

	
	
	public static void main(String[] args){
		
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		
		
		Query query = s.createQuery("from accountprofile where id = 1");	

		List result = (List) query.list();
		
		System.out.println(result.toString());
		
		
	}
}
