package src.main.java.com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingProductInformation {
	
	
		//Initialization of elements

	    public EditingProductInformation(WebDriver driver) { 
			PageFactory.initElements(driver, this);
		}
		
		//Declaration of elements
		
		@FindBy(name="description")
		private WebElement descriptionTextField;
		
		@FindBy(name="button")
		private WebElement saveButton;
		
		//Getter Methods
		
		   public WebElement getDescriptionTextField() {
				return descriptionTextField;
			}

			public WebElement getSaveButton() {
				return saveButton;
			}
		
		//Business Logic
			/**
			 * This method will send data for description information 
			 * @param desc1
			 */
			
			public void descriptionInformation(String desc1) {
				descriptionTextField.sendKeys(desc1);
			}
			
			/**
			 * This method will click on save button
			 */
			public void saveButtonClick() {
				saveButton.click();
			}
			}
	


