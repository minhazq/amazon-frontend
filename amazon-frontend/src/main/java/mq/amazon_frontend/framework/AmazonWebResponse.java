package mq.amazon_frontend.framework;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AmazonWebResponse {

	private CloseableHttpResponse response ;
	private InputStream is;
	private HttpEntity entity;
	protected String description;
	
	public AmazonWebResponse(CloseableHttpResponse response){
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
		
		private boolean descriptionOpenTag = false;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
	
			super.startElement(uri, localName, qName, attributes);
			
			if(qName.equalsIgnoreCase("description")){
				descriptionOpenTag = true;
			}
		}
		
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			
			super.endElement(uri, localName, qName);
			if(qName.equalsIgnoreCase("description")){
				descriptionOpenTag = false;
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			
			super.characters(ch, start, length);
			
			if(descriptionOpenTag){
				description = (new String(ch,start,length));
			}
		}
		
		
	}
	
	
}
