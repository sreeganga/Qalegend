package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.HomePage;
import Page.LoginPage;
import Utility.ExelUtility;
import constants.Constants;

public class UserTest extends Base {
	@Test
	public void verifyUsersSearchField() throws IOException
	{
		String username=ExelUtility.readStringData(0,0,Constants.LOGIN_PAGES);
		String password=ExelUtility.readIntegerData(0,1, Constants.LOGIN_PAGES);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.getPPlicationTour();
		home.getUsermanagement();
		home.getUser();
	}
}
