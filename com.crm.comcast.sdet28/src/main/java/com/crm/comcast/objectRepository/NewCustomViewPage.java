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

     public class NewCustomViewPage {
	
	 public NewCustomViewPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 }
	 
	 //Declaration of elements
	 
	 @FindBy(xpath="//input[@class='detailedViewTextBox']")
	 private WebElement viewName;
	 
	 @FindBy(name="setDefault")
	 private WebElement setAsDefault;
	 
	 @FindBy(name="setMetrics")
	 private WebElement listInMetrics;
	 
	 @FindBy(name="setStatus")
	 private WebElement setAsPublic;
	 
	 @FindBy(name="button2")
	 private WebElement saveButton;
	 
	 
	//Getters Method

	public WebElement getViewName() {
		return viewName;
	}

	public WebElement getSetAsDefault() {
		return setAsDefault;
	}

	public WebElement getListInMetrics() {
		return listInMetrics;
	}

	public WebElement getSetAsPublic() {
		return setAsPublic;
	}

	public WebElement getSave() {
		return saveButton;
	}
	 
	 
	public void viewName(String viewname) {
		viewName.sendKeys(viewname);
	}
	 
	public void clickSetAsDefault() {
		setAsDefault.click();	
	}
	 
	public void clickListInMetrics() {
		listInMetrics.click();
	}
	 
	
	public void clickSetAsPublic() {
		setAsPublic.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
}
