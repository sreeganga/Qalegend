package Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.HomePage;
import Page.LoginPage;
import Page.UserMangementPage;
import Utility.ExelUtility;
import constants.Constants;

public class UserMangementTest extends Base {
	@Test(groups = "Sanity", description = "Verify Selection and Printing of list of elements under UserMangement")
	public void verifyPoolElementinUserMangement() throws IOException {
		String username = ExelUtility.readStringData(0, 0, Constants.LOGIN_PAGES);
		String password = ExelUtility.readIntegerData(0, 1, Constants.LOGIN_PAGES);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage home = new HomePage(driver);
		home.getPPlicationTour();
		home.getUsermanagement();
		home.getUser();
		UserMangementPage usrmgntpage = new UserMangementPage(driver);
		List<WebElement> elementsnew = usrmgntpage.getProductPoolElements();
		for (WebElement element : elementsnew) {
			Assert.assertTrue(element.isDisplayed());

		}

	}
}
