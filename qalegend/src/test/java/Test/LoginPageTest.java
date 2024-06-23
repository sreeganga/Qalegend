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
import constants.Constants;
import constants.Messages;

public class LoginPageTest extends Base {
	@Test(groups = "Sanity")
	public void  verifyUserLoginwithValidCredential() throws IOException 
	{
		String username=ExelUtility.readStringData(0,0,Constants.LOGIN_PAGES);
		String password=ExelUtility.readIntegerData(0,1, Constants.LOGIN_PAGES);
		String Expected_result=ExelUtility.readStringData(0,2, Constants.LOGIN_PAGES);
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home =login.clickOnLoginButton();
		String actaul_result=home.getTextLoginUser();
		Assert.assertEquals(actaul_result, Expected_result,Messages.LOGINFAILURE);
	}
	@Test(groups = "Regression")
	public void verifyErrorMessageloginwithinvalidCredential() throws IOException
	{
		String username=ExelUtility.readStringData(0,0, Constants.LOGIN_PAGES);
		String password=ExelUtility.readIntegerData(0,3, Constants.LOGIN_PAGES);
		String Expected_result=ExelUtility.readStringData(0,4, Constants.LOGIN_PAGES);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterinalidPassword(password);
		login.clickOninvalidUserinButton();
		String actaul_result=login.getErrorMessage();
		Assert.assertEquals(actaul_result, Expected_result,Messages.LOGINSUCESS);
		

		
		
	}
}
