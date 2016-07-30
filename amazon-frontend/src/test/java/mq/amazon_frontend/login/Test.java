package mq.amazon_frontend.login;

import java.util.Map;

public class Test {

	
	@org.testng.annotations.Test
	public void test01(){
		Map<String, String> env = System.getenv();
		env.put("QA", "https://www.amazon.com");
		
		System.out.println(System.getenv("QA"));
	}
}
