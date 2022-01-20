package ProductTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepository.EditingProductInformation;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.ProductInformation;
import com.crm.comcast.objectRepository.ProductInformationPage;
import com.crm.comcast.objectRepository.ProductSearchPage;
import com.crm.comcast.sdet28GenericUtility.BaseClass;
import com.crm.comcast.sdet28GenericUtility.ExcelUtility;
import com.crm.comcast.sdet28GenericUtility.FileUtility;
import com.crm.comcast.sdet28GenericUtility.IPathConstants;
import com.crm.comcast.sdet28GenericUtility.JavaUtility;
import com.crm.comcast.sdet28GenericUtility.WebDriverUtility;

/**
 * Test script to edit the description information for product
 * @author Kavya
 *
 */

public class EditDescriptionInformationTest extends BaseClass {

	@Test(groups= {"regressionTest"})
	public void editDesctiptionInformationTest() throws Throwable {
		
		      
		
		       //Create object for utilities
		       
		        ExcelUtility eUtil = new ExcelUtility();
		        WebDriverUtility wUtil = new WebDriverUtility();
		      			
				
				//Click on Product link
				
				HomePage homePage = new HomePage(driver);
				homePage.clickProductLink();
				
				//Fectching the data from Excel File for search for
				
				String product = eUtil.getStringCellData("Sheet1", 1, 0);
				
			    driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(product);
			    
			    //Fetching the data for dropdown
			    
			    String product_Name = eUtil.getStringCellData("Sheet1", 1, 2);	
			   		    
	     		WebElement dropdownopt = driver.findElement(By.id("bas_searchfield"));
	     		wUtil.selectOption(product_Name, dropdownopt);
				
				ProductSearchPage productSearch = new ProductSearchPage(driver);
				productSearch.searchnowClick();
				productSearch.clickonProductName();
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,5000)");
				
			    //Click on Edit
				ProductInformation productInformation = new ProductInformation(driver);
				productInformation.clickEdit();
				
				
				
				String desc1 = eUtil.getStringCellData("Sheet1", 1, 1);
				
				EditingProductInformation editingproductinformation = new EditingProductInformation(driver);
				editingproductinformation.descriptionInformation(desc1);
				
				editingproductinformation.saveButtonClick();
				
				
				//Verification
				
			    ProductInformationPage productinfopage = new ProductInformationPage(driver);
				
				String actualProductInformation = productinfopage.productInformationText();
				if(actualProductInformation.contains("Test")) {
					System.out.println("Pass: Edit description was successfull");
				}
				else
				{
					System.out.println("Fail: Edit description was successfull");
				}						
	}
}