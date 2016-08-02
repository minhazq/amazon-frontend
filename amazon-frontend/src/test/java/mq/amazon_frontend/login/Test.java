package mq.amazon_frontend.login;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.Assert;

import antlr.collections.List;
import mq.amazon_frontend.framework.persistance.AccountProfile;
import mq.amazon_frontend.framework.util.Utils;

public class Test{

	
	@org.testng.annotations.Test
	public void myTest(){
		
		
		try{
			Assert.assertEquals("test", "test1");
		}catch(AssertionError a){
			System.out.println("assertion error brother....");
		}
		
		Assert.assertEquals("modon", "modna");
		
		
		/*Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		AccountProfile ap = s.get(AccountProfile.class, 1);
		System.out.println(ap.getUser_fullname());
		
		Query q = s.createQuery("from AccountProfile");
		java.util.List list = q.list();
		
		AccountProfile a = (AccountProfile) list.get(0);
		System.out.println(a.getUser_city());
		s.getTransaction().commit();
		s.close();
		sf.close();// Without this java app keep running
*/
		
		
	}
}
