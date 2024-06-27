package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;//instance create chythu
	public LoginPage(WebDriver driver)//classint consturtor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//pagefactoryclass create chynnu
		
	}
	
	@FindBy(xpath="//input[@id='username']")                                              //oro element findchyan
	WebElement username_field;
    @FindBy(xpath="//input[@id='password']")
    WebElement password_field;
    @FindBy(xpath="//button[@class='btn btn-primary']")                                        //oro element findchyan
	WebElement login_button;
    @FindBy(xpath="//input[@id='password']")
    WebElement invalid_password;
    @FindBy(xpath="//strong[text()='These credentials do not match our records.']")
    WebElement error_message;
    @FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotepassword;
    
    public void enterUserName(String username)
    {
    	username_field.sendKeys(username);
    }
    public void enterPassword(String password)
    {
    	password_field.sendKeys(password);
    }
    public HomePage clickOnLoginButton()
    {
    	login_button.click();
    	return new HomePage(driver);
    }
    public void enterinalidPassword(String password)
    {
    	password_field.sendKeys(password);
    }
    public void clickOninvalidUserinButton()
    {
    	login_button.click();
    	return;
    }
    public String getErrorMessage()
    {
  	  String user=error_message.getText();
  	  return user;
    }
    public ResetPage clikOnForgotePassword() {
		forgotepassword.click();
		return new ResetPage(driver);
    }
}

