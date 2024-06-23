package Test;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.EditUserPage;
import Page.HomePage;
import Page.LoginPage;
import Page.UserPage;
import Utility.ExelUtility;
import constants.Constants;

public class EditUserTest extends Base {
	@Test
	public void editAnExistingUser() throws IOException
	{
		String username  = ExelUtility.readStringData(0, 0, Constants.Edit_PAGES);
	    String password  = ExelUtility.readIntegerData(0, 1, Constants.Edit_PAGES);
	    String search_value = ExelUtility.readStringData(0, 2, Constants.Edit_PAGES);
	    
		LoginPage login  = new LoginPage(driver);
	    login.enterUserName(username);
	    login.enterPassword(password);
	    login.clickOnLoginButton();
	    HomePage home = new HomePage(driver);
	    home.getPPlicationTour();
	    home.getUsermanagement();
	    home.getUser();
	    UserPage userpage = new UserPage(driver);
        userpage.enterSearchValue(search_value);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='glyphicon glyphicon-edit']")));
        userpage.clickEditButtoun();
        EditUserPage edituser = new EditUserPage(driver);
        edituser.updatesurnamefield();
        edituser.clickOnSubmitButton();
        Assert.assertEquals("User updated successfully","User updated successfully", "Update not successful");

}
}
