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


public class HomePageTest extends Base
{
	@Test
	public void verifyhomepgetitle() throws IOException
	  {
		String username=ExelUtility.readStringData(0,0,Constants.LOGIN_PAGES);
		String password=ExelUtility.readIntegerData(0,1, Constants.LOGIN_PAGES);
		String Expected_result=ExelUtility.readStringData(0,0, Constants.HOMEPAGES);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.getPPlicationTour();
		String actualresult=driver.getTitle();
		System.out.println(actualresult);
		
		Assert.assertEquals(actualresult,Expected_result,"invalid title");
	  }
	@Test
public void userLoginDate() throws IOException
{
		String username=ExelUtility.readStringData(0,0,Constants.LOGIN_PAGES);
		String password=ExelUtility.readIntegerData(0,1, Constants.LOGIN_PAGES);
		String Expected_result=ExelUtility.readStringData(0,0, Constants.HOMEPAGES);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.getPPlicationTour();
		String  date_fieldtext = home.getLoginDate();
		String system_date = home.getCurrentDate();
        Assert.assertEquals(date_fieldtext, system_date,Messages.DATE_MISMATCH);
	}
}

