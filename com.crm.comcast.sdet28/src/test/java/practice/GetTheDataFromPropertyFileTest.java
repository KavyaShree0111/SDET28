package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetTheDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		
		//Java Object representation of physical file
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		
		
		//Create an object for property class
		
		Properties property = new Properties();
		
		//load the key and values from property object
		
		property.load(fis);
		
		//Fetch the values using respective keys
		
		String browser=property.getProperty("browser");
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
		
		
	}

}
