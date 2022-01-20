package ProductTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.IPMT;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepository.CreateFilterProductPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.NewCustomViewPage;
import com.crm.comcast.objectRepository.ProductInformationPage;
import com.crm.comcast.objectRepository.ProductsPage;
import com.crm.comcast.sdet28GenericUtility.BaseClass;
import com.crm.comcast.sdet28GenericUtility.ExcelUtility;
import com.crm.comcast.sdet28GenericUtility.FileUtility;
import com.crm.comcast.sdet28GenericUtility.IPathConstants;
import com.crm.comcast.sdet28GenericUtility.JavaUtility;
import com.crm.comcast.sdet28GenericUtility.WebDriverUtility;

/**
 * 
 * @author Kavya
 *
 */
public class SelectProductFromQuickCreateDropdownTest extends BaseClass {

	@Test(groups= {"regressionTest"})
	public void selectProductFromQuickCreateDropdownTest() throws Throwable	{
		
		   //Create object for Utiities
		    FileUtility fUtil = new FileUtility();
		    JavaUtility jUtil = new JavaUtility();
		    ExcelUtility eUtil = new ExcelUtility();
		    WebDriverUtility wUtil = new WebDriverUtility();

			
    		//Click on Products
			
			HomePage homepage = new HomePage(driver);
			homepage.clickProductLink();
			
				
			//Fetching data from excel sheet for quick create dropdowm
			
			String quickcreate = eUtil.getStringCellData("Sheet1", 2, 0);
			
			WebElement dropdownopt = driver.findElement(By.xpath("//select[@class='small']"));
			wUtil.verifyDropdown(dropdownopt, "quickcreate");
			
			
			
		    // Clicking on createfilter link
			
			CreateFilterProductPage createfilter = new CreateFilterProductPage(driver);
			createfilter.clickCreateFilter();
			
		    // Fetching data from excel for view name
			
			String viewname = eUtil.getStringCellData("Sheet1", 1, 3);
			driver.findElement(By.name("viewName")).sendKeys(viewname);
			
			//
			
			NewCustomViewPage newcustomviewpage = new NewCustomViewPage(driver);
			newcustomviewpage.clickSetAsDefault();
			
			newcustomviewpage.clickListInMetrics();
			
			newcustomviewpage.clickSetAsPublic();
			
			newcustomviewpage.clickSaveButton();
			
			//Verification
			
		     ProductsPage prodPage = new ProductsPage(driver);
			
			String actualProductInformation = prodPage.productText();
			if(actualProductInformation.contains("Test")) {
				System.out.println("Pass: Edit description was successfull");
			}
			else
			{
				System.out.println("Fail: Edit description was successfull");
			}						
}
			
	}
			
	

