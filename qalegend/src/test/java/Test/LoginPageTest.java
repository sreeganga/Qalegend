package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.HomePage;
import Page.LoginPage;
import Utility.ExelUtility;

public class LoginPageTest extends Base {
	@Test
	public void  verifyUserLoginwithValidCredential() throws IOException 
	{
		String username=ExelUtility.readStringData(0,0, "login");
		String password=ExelUtility.readIntegerData(0,1, "login");
		//String Expected_result=ExelUtility.readStringData(0,2, "login");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home =login.clickOnLoginButton();
		//String actaul_result=home.getTextLoginUser();
		//Assert.assertEquals(actaul_result, Expected_result,"invalid headercontent");
	}
	@Test
	public void verifyErrorMessageloginwithinvalidCredential() throws IOException
	{
		driver.get("https://qalegend.com/billing/public/login");
		 WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
		 username.sendKeys(ExelUtility.readStringData(0,0, "login"));
		 WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		 password.sendKeys(ExelUtility.readIntegerData(0,3, "login"));
		 WebElement login= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		 login.click();
		 WebElement errormessage= driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']"));
		 String actualresult=errormessage.getText();
		 System.out.println(actualresult);
		 String expectedresult=ExelUtility.readStringData(0,4, "login");
		 Assert.assertEquals(actualresult, expectedresult,"invalid errormessage");
	}
}
