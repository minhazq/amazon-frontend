package mq.amazon_frontend.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {


	public static String getProjectDirectory(){
		return System.getProperty("user.dir");
		
	}
	
	public static InputStream getAppDataPropertiesFile(){
		
		InputStream is = null ;
		File f = null;
		String env = System.getProperty("environment");
		System.out.println("Bla bla bla "+ env);
		try {
			if(env.equalsIgnoreCase("qa")){
				f = new File(getProjectDirectory()+"//src//test//resources//app-data-qa01.properties");	
			}

			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		return is;
		
	}

	public static Properties loadAppDataPropertiesFile(){
		
		Properties properties = new Properties();
		try {
			properties.load(Utils.getAppDataPropertiesFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getEnv(){
		return System.getProperty("environment");
	}
	
	public static String getBrowser(){
		return System.getProperty("browser");
	}
}
