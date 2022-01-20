package ProductTestCases;

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
import org.openqa.selenium.support.ui.Select;

public class ImportProductLookUpTest {

	
	public static void main(String[] args) throws IOException {

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
				driver.findElement(By.xpath("//img[@src='themes/softed/images/tbarImport.gif']")).click();
				
				 WebElement uploadelement = driver.findElement(By.name("import_file"));
				 uploadelement.click();
				
				driver.findElement(By.id("auto_merge")).click();
				
				WebElement drpdwn = driver.findElement(By.xpath("//option[@value='productname']"));
				
				Select select = new Select(drpdwn);
				select.selectByVisibleText("Product Name");
				select.getAllSelectedOptions();
				
               driver.findElement(By.name("next")).click();
				
				
				
				}
	}


