package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(name="firstname")
	WebElement fnTxtBox; 
	
	@FindBy(name="lastname")
	WebElement lnTxtBox; 
	
	@FindBy(name="phone")
	WebElement phoneTxtBox ; 
	
	@FindBy(name="email")
	WebElement emailTxtBox ; 
	
	@FindBy(name="password")
	WebElement passwordTxtBox ; 
	
	@FindBy(name="confirmpassword")
	WebElement confirmPasswordTxtBox ; 
	
	@FindBy(xpath ="//button[@type='submit' and  @class ='signupbtn btn_full btn btn-success btn-block btn-lg']")
	WebElement signupBtn ; 
	
	@FindBy(css="h3.text-align-left")
	public WebElement successMessage ; 
	
	
	@FindBy(xpath="//a[@class='btn btn-text-inherit btn-interactive']//parent:: div[@class='dropdown dropdown-login dropdown-tab']")
	WebElement User_Account_Logout; 
	
	@FindBy(linkText="Account")
	WebElement accountLink ; 
	
	@FindBy(linkText="Logout")
	WebElement logoutLink; 
	
	public void userRegistration(String first_Name , String last_Name , String phone_Number , String Email , String Password) 
	{
		
		setTextElementText(fnTxtBox, first_Name);
		setTextElementText(lnTxtBox, last_Name);
		setTextElementText(phoneTxtBox, phone_Number);
		setTextElementText(emailTxtBox, Email);
		setTextElementText(passwordTxtBox, Password);
		setTextElementText(confirmPasswordTxtBox, Password);
		clickButton(signupBtn);
	}
	
	public void userLogout() 
	{
		

		clickButton(User_Account_Logout);
		clickButton(logoutLink);
	
		
	}
	
	public void openMyAccountPage() 
	{
		

		clickButton(User_Account_Logout);
		clickButton(accountLink);
	
		
	}
	
	

}
