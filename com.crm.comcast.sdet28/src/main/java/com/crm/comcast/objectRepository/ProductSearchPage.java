package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28GenericUtility.WebDriverUtility;

/**
 * 
 * @author Kavya
 *
 */

public class ProductSearchPage extends WebDriverUtility {
	
	
    //Initialization of elements 
	
	public ProductSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration of elements
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchTextField;
	
	@FindBy(id="bas_searchfield")
	private WebElement inTextField;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(linkText="Test")
	private WebElement productNameLink;
	
	//Getters Methods

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getInTextField() {
		return inTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getTestLinkProductName() {
		return productNameLink;
	}
	
	//Business Logic
	
	/**
	 * This method will send data to search for Product 
	 * @param Product
	 * @param Product_Name1
	 */
	public void searchforProductName(String Product_Name) {
		searchTextField.sendKeys(Product_Name);
	}
		/**
		 * This method will select product name from the dropdown
		 * @param text
		 * @param element
		 */
	public void selectfromDropdown(String Product, WebElement element) {
		selectOption(Product, element);
	}
		
	/**
	 * This method will click on searchnow button and ProductName link
	 */
	public void searchnowClick() {
		searchButton.click();
	}
	
	public void clickonProductName() {
		productNameLink.click();
	}

	
		
	}



	
	


