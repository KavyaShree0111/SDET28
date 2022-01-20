package ProductTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepository.ExportProductImage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.ProductsPage;
import com.crm.comcast.sdet28GenericUtility.BaseClass;
import com.crm.comcast.sdet28GenericUtility.ExcelUtility;
import com.crm.comcast.sdet28GenericUtility.FileUtility;
import com.crm.comcast.sdet28GenericUtility.JavaUtility;
import com.crm.comcast.sdet28GenericUtility.WebDriverUtility;


/**
 * 
 * @author Kavya
 *
 */
public class ExportProductsTestCaseTest extends BaseClass {
                
	            @Test(groups= {"regressionTest"})
	            public void exportProductsTestCaseTest() throws Throwable {

	            	
	           //Create object for utilities
	            FileUtility fUtil=new FileUtility();
	            JavaUtility jUtil = new JavaUtility();
	            ExcelUtility eUtil=new ExcelUtility();
	            WebDriverUtility wUtil=new WebDriverUtility();
				
				//Click on products link
				
				HomePage homePage = new HomePage(driver);
				homePage.clickProductLink();
				
				//Click on export image
				ExportProductImage exportImage = new ExportProductImage(driver);
				exportImage.clickExportImage();
				
				ProductsPage productpage = new ProductsPage(driver);
				productpage.clickexportwithSearchRadioButton();
				productpage.clickExportProductsButton();
				
			}
	            }
