package Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Automationcore.Base;
import Utility.ExelUtility;

public class UserManagementTest extends Base {
	@Test
	public void userManagemmentFuntion() throws IOException
	{
		driver.get("https://qalegend.com/billing/public/login");
		 WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
		 username.sendKeys(ExelUtility.readStringData(0,0, "login"));
		 WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		 password.sendKeys(ExelUtility.readIntegerData(0,1, "login"));
		 WebElement login= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		 login.click();
		 WebElement application_tour = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		    application_tour.click();
		    WebElement usermanagement_button = driver.findElement(By.xpath("//span[@class='title' and text()='User Management']"));
		    usermanagement_button.click();
		    List<WebElement> userelements = driver.findElements(By.xpath("//span[@class='title']")); 
	        for(int i= 0; i < userelements.size();i++)	
		    { 
			  String userElementText = userelements.get(i).getText();
			  System.out.println(userElementText);
		    }
		 
	}

}
