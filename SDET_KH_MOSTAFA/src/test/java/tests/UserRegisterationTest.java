package tests;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class UserRegisterationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject ; 

	String FN = "Khaled";
	String LN = "Mostafa";
	String PhNo = "00971557117194";
	String Em = "wsfsvbkopraee@gmail.com";
	String Password = "KFDSADsdfdger4534534^&%^&";
	
	String endpoint = "https://www.phptravels.net/register";

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);

		// Check whether the first name starts with Upper Case Letter
		Character FCH_FN = FN.charAt(0);
		boolean x = FCH_FN.isUpperCase(FCH_FN);
		System.out.print(x);
		Assert.assertTrue(x);

		// Check whether the last name starts with Upper Case Letter & is not equal to
		// the first name
		Character FCH_LN = FN.charAt(0);
		boolean y = FCH_LN.isUpperCase(FCH_LN);
		System.out.print(y);
		Assert.assertTrue(y);

		boolean z = LN.equals(FN);
		System.out.print(z);
		Assert.assertFalse(z);

		// Check whether the password have capital letter, small letter, with a limit of
		// 8 characters
		boolean p = Password.matches(".*[A-Z].*") && Password.matches(".*[a-z].*") && (Password.length() >= 8);
		System.out.print(p);
		Assert.assertTrue(p);

		registerObject.userRegistration(FN, LN, PhNo, Em, Password);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Hi, Khaled Mostafa"));

	}
	
	@Test(dependsOnMethods= {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(Em, Password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Hi, Khaled Mostafa"));
	}

	
	
	
	
	
	@Test
	public void getResponseSignUP() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(endpoint);
		HttpResponse response = client.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);

		}
		System.out.println(response.getStatusLine());
		PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "//Response//signUP.html");
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	}
	
	
	
	
	
	
	
}
