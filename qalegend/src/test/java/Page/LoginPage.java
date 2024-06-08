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
	
	@FindBy(xpath="//input[@id='username']")//oro element findchyan
	WebElement username_field;
    @FindBy(xpath="//input[@id='password']")
    WebElement password_field;
    @FindBy(xpath="//button[@class='btn btn-primary']")//oro element findchyan
	WebElement login_button;
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
}
