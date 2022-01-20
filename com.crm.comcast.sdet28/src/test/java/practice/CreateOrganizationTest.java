package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		
		//Get the data from property file
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String browserName=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		
		
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("TY Software Solutions");
		driver.findElement(By.name("button")).click();
		
	
		//organization name verification
		
		String actualOrgName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrgName.contains("TY")){
			System.out.println("Organization is created");
		}
			
			else
			{
				System.out.println("Organization is not created");
			}
		
		
			
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
