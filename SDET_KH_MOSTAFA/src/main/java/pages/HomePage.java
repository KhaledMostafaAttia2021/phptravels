package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		
	}
	
	@FindBy(xpath="//a[@class='btn btn-text-inherit btn-interactive']//parent:: div[@class='dropdown dropdown-login dropdown-tab']")
	WebElement MYACCOUNT_LOGIN_SIGNUP; 
	
	
	@FindBy(linkText="Sign Up")
	WebElement registerLink ; 
	
	@FindBy(linkText="Login")
	WebElement loginLink; 
	
	
	
	
	
	public void openRegistrationPage() 
	{
	
		clickButton(MYACCOUNT_LOGIN_SIGNUP);
		clickButton(registerLink);
	}

	
	public void openLoginPage() 
	{
		clickButton(MYACCOUNT_LOGIN_SIGNUP);
		clickButton(loginLink);
	}
}
