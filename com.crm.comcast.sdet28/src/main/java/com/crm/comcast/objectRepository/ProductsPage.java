package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Kavya
 *
 */

public class ProductsPage {
	
	
	//Intialization
	
	public ProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//Declaration of elements
	
	@FindBy(name="search_type")
	private WebElement exportwithsearchRadioButton;
	
	@FindBy(name="Export")
	private WebElement exportProdutcsButton;
	
	@FindBy(linkText="Products")
	private WebElement products;
	
	//Getters Method

	public WebElement getExportwithsearchRadioButton() {
		return exportwithsearchRadioButton;
		
	}
	
	public WebElement getExportProdutcsButton() {
		return exportProdutcsButton;
	}

	public WebElement getProducts() {
		return products;
	}

	public void clickexportwithSearchRadioButton() {
		exportwithsearchRadioButton.click();
		if(exportwithsearchRadioButton.isSelected()) {
			System.out.println("Pass: User radio button is selected");
		}
		else
		{
			System.out.println("Fail: User radio button is selected");
		}
	}
	
	public void clickExportProductsButton() {
		exportProdutcsButton.click();
	}
	
	public String productText() {
		return products.getText();
	}
}