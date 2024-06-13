package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class AddUserTest extends Base {
	@Test
 public void verifyAddNewUser() throws IOException
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
		UserPage user= new UserPage(driver);
		user.getAddbutton();
		String username1 = ExelUtility.readStringData(0, 0, Constants.AddUserpage);
	    String password1 = ExelUtility.readIntegerData(0, 1, Constants.AddUserpage);
		String first_name = RandomDataUtility.getFirstName();
		String last_name = RandomDataUtility.getLastName();
		String mailid = first_name+Constants.DOT+last_name+Constants.MAILID_EXTENSION;
		String password_new = first_name+Constants.DOT+last_name;
		String username_fieldnew = first_name;
		String expected_result = Constants.Welcome_MSG+first_name+Constants.COMMA;
		
		AddUser adduser=new AddUser(driver);
		adduser.getprefix(expected_result);
		adduser.getfirstname(expected_result);
		adduser.getlastname(last_name);
		adduser.getemail(mailid);
		adduser.getusename(username1);
		adduser.getpassword(password1);
		adduser.getconfirmpassword(password_new);
		adduser.getpercentage(expected_result);
		adduser.clickonSaveButton();
				    
 }
	@Test
	public void verifyAddNewuserLogin() throws IOException
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
		UserPage user= new UserPage(driver);
		user.getAddbutton();
		String username1 = ExelUtility.readStringData(0, 0, Constants.AddUserpage);
	    String password1 = ExelUtility.readIntegerData(0, 1, Constants.AddUserpage);
		String first_name = RandomDataUtility.getFirstName();
		String last_name = RandomDataUtility.getLastName();
		String mailid = first_name+Constants.DOT+last_name+Constants.MAILID_EXTENSION;
		String password_new = first_name+Constants.DOT+last_name;
		String username_fieldnew = first_name;
		String expected_result = Constants.Welcome_MSG+first_name+Constants.COMMA;
		
		AddUser adduser=new AddUser(driver);
		adduser.getprefix(expected_result);
		adduser.getfirstname(expected_result);
		adduser.getlastname(last_name);
		adduser.getemail(mailid);
		adduser.getusename(username1);
		adduser.getpassword(password1);
		adduser.getconfirmpassword(password_new);
		adduser.getpercentage(expected_result);
		adduser.clickonSaveButton();
		home.clickOnSignoutDashBoad();
		home.clickOnSignoutButton();
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		String actual_result = home.getTextofProfile();
	    Assert.assertEquals(actual_result, expected_result,Constants.NEWUSERLOGIN_ERROR);
	}
}
