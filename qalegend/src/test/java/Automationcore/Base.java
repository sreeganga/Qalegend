package Automationcore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utility.WaitUtility;

public class Base {
	protected WebDriver driver;
	public  void intialiseBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("edge"))
		{
			driver =new EdgeDriver();
			
		}
		else if(browser.equals("Firefox"))
		{
			driver =new FirefoxDriver();
			
		}
		else {
			throw new RuntimeException("invalid browser received");
		}
		driver.manage().window().maximize();;
		
		
	}
@BeforeMethod
@Parameters({"browser","baseurl"})
	public void setup(String browsername , String url)
	{
		intialiseBrowser("String browsername , String url");
		driver.get(url);
		WaitUtility.waitUsingImplicitWait(driver);
	}
@AfterMethod
   public void closeBrowser(ITestResult result) throws IOException
   {
	if(result.getStatus()==ITestResult.FAILURE)
	{
		takeScreenshort(result);
	}
	driver.quit();
   }
  public void takeScreenshort(ITestResult result) throws IOException//screen short nte name adukanula interface
  {
	  TakesScreenshot takescreenshot= (TakesScreenshot)driver;//interface create chythu

		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("./ScreenShort/"+result.getName()+".png"));
  }

}
