package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This will do the verification for edit description
 * @author Kavya
 *
 */

public class ProductInformationPage {
	
	//Element Intialization
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Element identifaction or declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productInformationText;
	
	//Getters Method

	public WebElement getProductInformationText() {
		return productInformationText;
	}
	
	//business logic
	public String productInformationText() {
	return productInformationText.getText();
	}
	
	
	
	
}
