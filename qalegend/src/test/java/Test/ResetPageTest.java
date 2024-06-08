package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automationcore.Base;
import Utility.ExelUtility;

public class ResetPageTest extends Base {
	@Test
public void verifyErrorMessagewithIvalidEmailid() throws IOException
{
		driver.get("https://qalegend.com/billing/public/login");
		WebElement forgotepassword= driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotepassword.click();
		WebElement validemailid= driver.findElement(By.xpath("//input[@id='email']"));
		validemailid.sendKeys(ExelUtility.readStringData(0,0, "reset"));
		WebElement resetlink= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		resetlink.click();
		WebElement errormessage= driver.findElement(By.xpath("//strong"));
		String actualresult=errormessage.getText();
		String expectedresult=(ExelUtility.readStringData(0,1, "reset"));
		Assert.assertEquals(actualresult, expectedresult,"invalidmessage");
		
		
		
}
}
