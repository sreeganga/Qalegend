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

public class ResetPageTest extends Base {
	@Test
public void verifyErrorMessagewithInvalidEmailid() throws IOException
{
		String emailid=ExelUtility.readStringData(0,0, "reset");
		String Expected_result=ExelUtility.readStringData(0,1, "reset");
		LoginPage login=new LoginPage(driver);
		login.clikOnForgotePassword();
		ResetPage reset=new ResetPage(driver);
		reset.enterinValidEmailId(emailid);
		reset.clikOnReseLink();
		String actaul_result=reset.getErrorMessage();
       Assert.assertEquals(actaul_result,Expected_result ,"validmessage");
		
		
		
}
	@Test
	public void verifyErrorMessagewithvalidEmailid() throws IOException
	{
		String emailid=ExelUtility.readStringData(0,2, "reset");
		String Expected_result=ExelUtility.readStringData(0,3, "reset");
		LoginPage login=new LoginPage(driver);
		login.clikOnForgotePassword();
		ResetPage reset=new ResetPage(driver);
		reset.enterinValidEmailId(emailid);
		reset.clikOnReseLink();
		String actaul_result=reset.getvalidMessage();
       Assert.assertEquals(actaul_result,Expected_result ,"invalidmessage");
		
		
	}
}
