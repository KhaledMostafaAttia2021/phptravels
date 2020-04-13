package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="username")
	WebElement emailTxtBox ; 

	@FindBy(name="password")
	WebElement passwordTxtBox ; 
	
	@FindBy(className="custom-control-label")
	WebElement RememberMe_ChBox ; 
	
	
	@FindBy(xpath ="//button[@type='submit' and  @class ='btn btn-primary btn-lg btn-block loginbtn']")
	WebElement loginBtn ; 
	
	public void UserLogin(String email , String password) 
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(RememberMe_ChBox);
		clickButton(loginBtn);
	}

}