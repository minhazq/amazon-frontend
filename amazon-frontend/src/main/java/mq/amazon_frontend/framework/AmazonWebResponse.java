package mq.amazon_frontend.framework;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AmazonWebResponse {

	private CloseableHttpResponse response ;
	private InputStream is;
	private HttpEntity entity;
	protected String description;
	private Logger logger;
	
	public AmazonWebResponse(CloseableHttpResponse response){
		logger = LogManager.getLogger(this);
		this.response = response;
		entity = this.response.getEntity();
		try {
			is = entity.getContent();
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getResponseForDescription(){
		
		SAXParserFactory sxFactory = SAXParserFactory.newInstance();
		try {
			
			SAXParser xmlParser = sxFactory.newSAXParser();
			LocationDefaultHandler handler = new LocationDefaultHandler();
			xmlParser.parse(is, handler);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return description;
	}
	
	
	
	class LocationDefaultHandler extends DefaultHandler{
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
	
			super.startElement(uri, localName, qName, attributes);
			
			if(qName.equalsIgnoreCase("weather")){
				description = attributes.getValue("value");
			}
		}
		
	}
	
	
}
