package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.LoginPage;
import Page.ResetPage;
import Utility.ExelUtility;
import constants.Constants;
import constants.Messages;

public class ResetPageTest extends Base {
	@Test
public void verifyErrorMessagewithInvalidEmailid() throws IOException
{
		String emailid=ExelUtility.readStringData(0,0,Constants.RESETPAGE);
		String Expected_result=ExelUtility.readStringData(0,1, Constants.RESETPAGE);
		LoginPage login=new LoginPage(driver);
		login.clikOnForgotePassword();
		ResetPage reset=new ResetPage(driver);
		reset.enterinValidEmailId(emailid);
		reset.clikOnReseLink();
		String actaul_result=reset.getErrorMessage();
       Assert.assertEquals(actaul_result,Expected_result ,Messages.ERROR_MSGMISMATCH);
		
		
		
}
	@Test
	public void verifyErrorMessagewithvalidEmailid() throws IOException
	{
		String emailid=ExelUtility.readStringData(0,2, Constants.RESETPAGE);
		String Expected_result=ExelUtility.readStringData(0,3, Constants.RESETPAGE);
		LoginPage login=new LoginPage(driver);
		login.clikOnForgotePassword();
		ResetPage reset=new ResetPage(driver);
		reset.enterinValidEmailId(emailid);
		reset.clikOnReseLink();
		String actaul_result=reset.getvalidMessage();
       Assert.assertEquals(actaul_result,Expected_result ,Messages.SUCCESS_MSGMISMATCH);
		
		
	}
}
