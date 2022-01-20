package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTest {

	public static void main(String[] args) throws Throwable {
		
		//Get the data from property file
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		
		//Creating object for property class 
		
		Properties property = new Properties();
		
		//Load the key and values from property object
		
		property.load(fis);
		
		//Common data from property file
		
		String browserName=property.getProperty("browser");
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		
	
		WebDriver driver=null;
		
		//Browser conditions and launching the Web driver
		
				if(browserName.equals("chrome")) {
					
					System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
					driver=new ChromeDriver();
				}
				else if(browserName.equals("firefox")) {
					
					System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
					driver=new FirefoxDriver();
				}
				else {
					System.out.println("browser is not supported");
				}
				
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("xyz")).click();
		
		driver.findElement(By.id("aidProductImageInformation:")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small edit']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		
		
		
		
		WebElement fileupload = driver.findElement(By.xpath("//input[@type='file']"));
		
		if(fileupload.isEnabled()) {
			System.out.println("Pass");
			fileupload.click();
		}
		
		else
		{
			System.out.println("Fail");
	
		}
		
		
		
		Runtime.getRuntime().exec("C:\\Users\\singh\\OneDrive\\Desktop\\Fileupload.exe");
	
	}

}
