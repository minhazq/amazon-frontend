package mq.amazon_frontend.framework;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class AmazonWebService {

	private CloseableHttpClient client;
	private URIBuilder builder ;
	private HttpGet get;
	private CloseableHttpResponse response;
	
	public AmazonWebService(){
		client = HttpClients.createDefault();
		builder = new URIBuilder();
	}
	
	public AmazonWebService setScheme(){
		builder.setScheme("http");
		return this;
	}
	
	public AmazonWebService setHost(){
		builder.setHost("api.openweathermap.org/");
		return this;
	}
	
	public AmazonWebService setPath(){
		builder.setPath("data/2.5/weather?APPID=013f7e07d808de9061a24fb1760b6f62&");
		return this;
	}
	
	public AmazonWebService addAppId(){
		builder.addParameter("APPID", "013f7e07d808de9061a24fb1760b6f62");
		return this;
	}
	
	public AmazonWebService addLocation(String location){
		builder.addParameter("q", location);
		return this;
	}
	
	public AmazonWebResponse executeGetAndParse(){
		try {
			
			get = new HttpGet(builder.build());
			response = client.execute(get);
			
			
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		
		return new AmazonWebResponse(response);
		
	}
	
	
	
	
	
}
