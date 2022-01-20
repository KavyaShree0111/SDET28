package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation {

	
	//Initialization of elements
	
	public ProductInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration of elements
	
	@FindBy(name="Edit")
	private WebElement editButton;
	
	
	//Getters Method

	public WebElement getEditButton() {
		return editButton;
	}
	
	//Business Logic
	
	/**
	 * This method is used to click on Edit button
	 */
	public void clickEdit() {
	editButton.click();
}
}