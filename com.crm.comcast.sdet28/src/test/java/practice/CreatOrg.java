package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatOrg {
	
	@BeforeClass
	public void bc() {
		System.out.println("Launch the browser");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("Quit the browser");
	}
	
    @BeforeMethod
    public void bm() {
    	System.out.println("Login to application");
    }
    
    
    @AfterMethod
    public void am() {
    	System.out.println("Logout from application");
    }
    
    
	@Test(priority=1)
	public void org() {
		System.out.println("Navigate to organization");
		System.out.println("Create organization");
		System.out.println("verify organization");
	}
		
	@Test(priority=2)
	public void Contacts() {
		System.out.println("Navigate to contacts");
		System.out.println("Create contacts");
		System.out.println("verify contacts");
	}
	
	@Test(priority=3)
	public void Products() {
		System.out.println("Navigate to products");
		System.out.println("Create products");
		System.out.println("verify products");
	
	
	}

}
