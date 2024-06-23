package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.AddUser;
import Page.HomePage;
import Page.LoginPage;
import Page.UserPage;
import Utility.ExelUtility;
import Utility.RandomDataUtility;
import constants.Constants;
import listeners.RetryAnalyzer;

public class AddUserTest extends Base {
	@Test(retryAnalyzer = RetryAnalyzer.class)
 public void verifyAddNewUser() throws IOException
 {
		String username = ExelUtility.readStringData(0, 0, Constants.AddUserpage );
		String password = ExelUtility.readIntegerData(0, 1, Constants.AddUserpage);
		String first_name = RandomDataUtility.getFirstName();
		String last_name = RandomDataUtility.getLastName();
		String mailid = first_name+Constants.DOT+last_name+ Constants.MAILID_EXTENSION;
		String username_fieldnew = first_name;
		String password_new = first_name+Constants.DOT+last_name;
		String search_value = mailid;
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.getPPlicationTour();
		home.getUsermanagement();
		home.getUser();
		AddUser adduser = new AddUser(driver);
	    adduser.clickOnAddUserButton();
	    adduser.addFirstname(first_name);
	    adduser.addLastname(last_name);
	    adduser.addEmail(mailid);
	    adduser.addUserName(username_fieldnew);
	    adduser.addpassword(password_new);
	    adduser.addConfirmpassword(password_new);
	    adduser.clickOnSubmitButton();
	    UserPage userpage = new UserPage(driver);
        userpage.enterSearchValue(search_value);
        Assert.assertEquals("User added successfully","User added successfully", "User  not successfully added");
 }
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyDeleteingNewlyAddedUser() throws IOException 
		{
		    String username = ExelUtility.readStringData(0, 0, Constants.AddUserpage);
		    String password = ExelUtility.readIntegerData(0, 1, Constants.AddUserpage);
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+Constants.DOT+last_name+Constants.MAILID_EXTENSION;
			String password_new = first_name+Constants.DOT+last_name;
			String username_fieldnew = first_name;
			String search_value = mailid;
			LoginPage login=new LoginPage(driver);
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickOnLoginButton();
			HomePage home=new HomePage(driver);
			home.getPPlicationTour();
			home.getUsermanagement();
			home.getUser();
			AddUser adduser = new AddUser(driver);
		    adduser.clickOnAddUserButton();
		    adduser.addFirstname(first_name);
		    adduser.addLastname(last_name);
		    adduser.addEmail(mailid);
		    adduser.addUserName(username_fieldnew);
		    adduser.addpassword(password_new);
		    adduser.addConfirmpassword(password_new);
		    adduser.clickOnSubmitButton();
		    UserPage userpage = new UserPage(driver);
	        userpage.enterSearchValue(search_value);
	        userpage.clickDeleteButtoun();
	        userpage.clickOkButtoun();
	        Assert.assertEquals("User deleted successfully","User deleted successfully", "Deletion not successful");
		}		
	
}
	
