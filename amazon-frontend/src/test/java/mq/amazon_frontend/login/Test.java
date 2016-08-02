package mq.amazon_frontend.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.Assert;

import antlr.collections.List;
import mq.amazon_frontend.framework.persistance.AccountProfile;
import mq.amazon_frontend.framework.util.Utils;

public class Test{

	//http://api.openweathermap.org/data/2.5/weather?APPID=013f7e07d808de9061a24fb1760b6f62&q=London
	@org.testng.annotations.Test
	public void myTest(){
		
		
		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = new URIBuilder();
		CloseableHttpResponse response ;
		
		builder.setScheme("http");
		builder.setHost("api.openweathermap.org");
		builder.setPath("//data//2.5//weather");
		builder.addParameter("APPID", "013f7e07d808de9061a24fb1760b6f62");
		builder.addParameter("q", "London");
		
		
		try {
			HttpGet get = new HttpGet(builder.build());
			
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String line;
			StringBuilder sbuilder = new StringBuilder();
			while((line=reader.readLine())!=null){
				sbuilder.append(line);
			}
			
			System.out.println(sbuilder.toString());
			
			
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		
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
