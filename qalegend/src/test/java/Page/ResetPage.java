package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;//instance create chythu
	public ResetPage(WebDriver driver)//classint consturtor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//pagefactoryclass create chynnu
		
	}

	@FindBy(xpath="//input[@id='email']")
	WebElement invalidemailid;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement resetlink;
	@FindBy(xpath="//strong")
	WebElement error_message;
	@FindBy(xpath="//div[@class='alert alert-success']")
	
	WebElement validmessage;
	
	public void enterinValidEmailId(String emailid)
	{
		invalidemailid.sendKeys(emailid);
	}
	public void clikOnReseLink() {
		resetlink.click();
		return;
	}
	public String getErrorMessage()
    {
  	  String user=error_message.getText();
  	  return user  ;
    }
	public String getvalidMessage()
    {
  	  String user=validmessage.getText();
  	  return user  ;
    }
}
