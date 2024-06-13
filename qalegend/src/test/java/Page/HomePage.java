package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.DateUtility;

public class HomePage {
 WebDriver driver;
 public HomePage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
 @FindBy(xpath="//h1")
 WebElement headercontent;
 @FindBy(xpath="//button[@class='btn btn-default btn-sm']")
 WebElement application_tour;
 @FindBy(xpath="//span[@class='title' and text()='User Management']")
 WebElement usermanagement_button;
 @FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']")
 WebElement user_button;
 @FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
 WebElement date_field;
 @FindBy(xpath = "//a[@class='dropdown-toggle']")
 WebElement signout_dashboard;

 @FindBy(xpath = "//a[@class='btn btn-default btn-flat'and@href='https://qalegend.com/billing/public/logout']")
 WebElement signout_button;
 @FindBy(xpath="//section[@class='content-header']")
 WebElement welcome_user;
  public String getTextLoginUser()
  {
	  String user=headercontent.getText();
	  return user;
  }
 public String getLoginDate()
 {
	String logindate=date_field.getText();
	return logindate;
 }
 public String getCurrentDate()
 {
	 String currentdate= DateUtility.getUserLoginDate("dd-MM-YYY");
	 return currentdate;
 }
 public void getPPlicationTour()
 {
	 application_tour.click(); 
 }
 public void getUsermanagement()
 {
	 usermanagement_button.click();
	
 }
 public UserPage getUser()
 {
	 user_button.click();
	return new UserPage(driver);
 }
 public void clickOnSignoutDashBoad() 
 {
 	  signout_dashboard.click();
 }
 public void clickOnSignoutButton() 
 {
 	  signout_button.click();
 }
 public String getTextofProfile() 
 {
 	String text = welcome_user.getText();
 	return text;
 	
 }
}
