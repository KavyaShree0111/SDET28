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

public class ExportProductImage {
	
	//Element initialization
		public ExportProductImage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
		
	//Declaration of elements
		
		@FindBy(xpath=" //img[@src='themes/softed/images/tbarExport.gif']")
		private WebElement exportImg;
	
		//Getters Method

		public WebElement getExportImg() {
			return exportImg;
		}
	
		//Business Logic
		
		public void clickExportImage() {
			exportImg.click();
		}

}
