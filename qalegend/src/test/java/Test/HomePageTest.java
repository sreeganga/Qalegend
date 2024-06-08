package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Utility.ExelUtility;
import utilites.ExelUtilites;

public class HomePageTest extends Base
{
	@Test
	public void verifyhomepgetitle() throws IOException
	  {
		driver.get("https://qalegend.com/billing/public/login");
		 WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
		 username.sendKeys(ExelUtility.readStringData(0,0, "login"));
		 WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		 password.sendKeys(ExelUtility.readIntegerData(0,1, "login"));
		 WebElement login= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		 login.click();
		String actualresult=driver.getTitle();
		System.out.println(actualresult);
		String exceptedtitle=ExelUtilites.readStringData(0, 0,"Home");
		Assert.assertEquals(actualresult, exceptedtitle,"invalid title");
	  }

}
