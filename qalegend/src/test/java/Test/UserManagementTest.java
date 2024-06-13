package Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Automationcore.Base;
import Page.HomePage;
import Page.LoginPage;
import Utility.ExelUtility;
import constants.Constants;

public class UserManagementTest extends Base {
	@Test
	public void userManagemmentFuntion() throws IOException
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
		    List<WebElement> userelements = driver.findElements(By.xpath("//span[@class='title']")); 
	        for(int i= 0; i < userelements.size();i++)	
		    { 
			  String userElement = userelements.get(i).getText();
			  System.out.println(userElement);
		    }
		 
	}

}
