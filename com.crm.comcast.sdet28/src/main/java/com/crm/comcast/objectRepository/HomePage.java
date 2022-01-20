package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.sdet28GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Initialization of elements
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}
	
	//Declaration of elements
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//Getters Methods

	public WebElement getProductlink() {
		return productLink;
	}

	public WebElement getOrganizationlink() {
		return organizationLink;
	}

	public WebElement getContactslink() {
		return contactsLink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitiesLink;
	}

	public WebElement getEmaillink() {
		return emailLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//Business Logics
	
	/**
	 * This method will click on product link 
	 */
	public void clickProductLink() {
		productLink.click();
	}
	
	/**
	 * This method will perform logout actions
	 */
	public void logout() {
		mousehover(driver, logoutImg);
		signOutLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
