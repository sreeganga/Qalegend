package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	WebDriver driver;
	public UserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 
			 this.driver=driver;
			 PageFactory.initElements(driver,this);
		 }
	 @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	 WebElement add_button;
	 public AddUser getAddbutton()
	 {
		 add_button.click(); 
		 return new AddUser(driver);
	 }
	 
		 
	}


