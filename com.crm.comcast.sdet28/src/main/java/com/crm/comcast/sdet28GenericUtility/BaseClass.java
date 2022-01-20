package com.crm.comcast.sdet28GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * Base class which contains all configurations for annotations
 * @author Kavya
 *
 */

public class BaseClass {
	
	 
	public WebDriver driver;
	
	//Object creation for utilities
	
	public FileUtility fUtil=new FileUtility();
    WebDriverUtility wUtil=new WebDriverUtility();
    
    
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBs() {
		
		//Connect to db
		
		System.out.println("=======connect to db=======");
	}
	
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	
	//Launching the browser
	
	public void configBc() throws Throwable {
		
		//Getting data from property file
		
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		
		if(browser.equals("chrome")) {
			
			System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			
			System.setProperty(IPathConstants.FIREFOX_KEY, IPathConstants.FIREFOX_PATH);
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser is not supported");
		}
	
	
	   driver.manage().window().maximize();
	   wUtil.waitforPageToLoad(driver);
	   driver.get(url);
	}
		
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	
	//Getting data from property file
	
	public void configBm() throws Throwable {
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		LoginPage login = new LoginPage(driver);
		login.logintoApplication(username, password);
		
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAm() {
		
		//Logout Action
		
		HomePage homePage = new HomePage(driver);
		homePage.logout();
		
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAc() {
		
		//closing the browser
		
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAs() {
		
	//Closing the database connection
		
		System.out.println("=========Database connection is closed==========");
	}

}
