package Automationcore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
import constants.Constants;

public class Base {
	protected WebDriver driver;
	public Properties prop;
	public FileInputStream fs;
	public  void intialiseBrowser(String browser) throws IOException
	{
		try 
		{
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
	} 
		catch (FileNotFoundException e) 
		{
		e.printStackTrace();
	}
		
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
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser","baseurl"})
	  public void setup(String browsername , String url) throws IOException 
	  { 
		
		  intialiseBrowser(browsername); 
		  driver.get(url);
		  WaitUtility.waitUsingImplicitWait(driver);
		  
	  }
@AfterMethod(alwaysRun = true)
   public void closeBrowser(ITestResult result) throws IOException
   {
	if(result.getStatus()==ITestResult.FAILURE)
	{
		takeScreenshort(result);
	}
	driver.quit();
   }
  public void takeScreenshort(ITestResult result) throws IOException                              //screen short nte name adukanula interface
  {
	  TakesScreenshot takescreenshot= (TakesScreenshot)driver;                            //interface create chythu

		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("./ScreenShort/"+result.getName()+".png"));
  }

}
