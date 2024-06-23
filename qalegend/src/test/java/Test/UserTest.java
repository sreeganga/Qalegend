package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.HomePage;
import Page.LoginPage;
import Page.UserPage;
import Utility.ExelUtility;
import constants.Constants;
import constants.Messages;

public class UserTest extends Base {
	@Test(description = "Verify Search By Field Functionality")
	public void verifyUsersSearchField() throws IOException
	{
		String username=ExelUtility.readStringData(0,0,Constants.USERS_PAGE);
		String password=ExelUtility.readIntegerData(0,1, Constants.USERS_PAGE);
		String expected_name = ExelUtility.readStringData(0, 3,Constants.USERS_PAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.getPPlicationTour();
		home.getUsermanagement();
		home.getUser();
		UserPage user=new UserPage(driver);
		user.enterSearchValue(expected_name);
		String actual_name = user.getTextOfName();
        Assert.assertEquals(actual_name, expected_name,Messages.SEARCHBYFIELD_ERROR);
        	
	}
}
