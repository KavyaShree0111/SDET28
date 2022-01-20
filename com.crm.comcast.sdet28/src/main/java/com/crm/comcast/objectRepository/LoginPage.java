package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Login POM Page Design
 * @author Kavya
 *
 */

public class LoginPage {

	//Element initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		}
	
	//Element identification or declaration
	
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//Getters Method
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business Logic for login action
	
	public void logintoApplication(String userName,String Password) {
		usernameTextField.sendKeys(userName);
		passwordTextField.sendKeys(Password);
		loginButton.click();
		
	}
	
}