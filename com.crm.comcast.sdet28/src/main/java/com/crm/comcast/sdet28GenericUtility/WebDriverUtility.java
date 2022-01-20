package com.crm.comcast.sdet28GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Kavya
 *
 */

public class WebDriverUtility {
	
	/**
	 * This method will wait 20 seconds till the element load in DOM
	 * @param driver
	 */
	
	public void waitforPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method wil wait until the element is visible
	 * @param driver
	 * @param element
	 */
	public void waitforVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait till  element is clickable
	 * @param element
	 * @throws Throwable
	 */
		
	public void waitAndClick(WebElement element) throws Throwable {
	int count=0;
	while(count<50){
		try {
			element.click();
		} 
		catch (Exception e) {
			Thread.sleep(3000);
			count++;
		}
	}
	}
	
	public void selectOption(WebElement element, int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectOption(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectOption(String text, WebElement element){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public WebElement verifyDropdown(WebElement element, String expectedOption) {
		Select select = new Select(element);
		List<WebElement> dropdownopt = select.getOptions();
		for(WebElement ele:dropdownopt)
		{
			if(dropdownopt.equals(expectedOption))
			{
				System.out.println("Expected option is present");
				return ele;
			}
			else
			{
				System.out.println("Expected option is not present");
				return ele;
			}
			
			
		}
		return null;
		
	}
	
	/**
	 * This method is used to perform mouse hovering
	 * @param driver
	 * @param element
	 */
	
	public void mousehover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", element);
	}
	
	public void enterDataUsingJs(WebDriver driver, String valueToEnter,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+valueToEnter+"'", element);
			
		}
	
	public void switchWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		while(it.hasNext()) {
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWindowTitle)) {
				break;
			}
			
		}
	

	}
	
	public String screenShot(WebDriver driver,String testcaseName) {
		JavaUtility jutil = new JavaUtility();
		String filePath="./errorshot"+testcaseName+jutil.systemDateAndTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		//Files.copy(source, destination);
		return filePath;
	}
	
	
	public void switchFrames(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	
	public void switchFrames(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	
	public void switchFrames(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}	
		
		
		
		
}	
	


