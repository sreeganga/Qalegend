package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser {
	
		WebDriver driver;//instance create chythu
		public AddUser(WebDriver driver)//classint consturtor
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);//pagefactoryclass create chynnu
		}
@FindBy(xpath="//input[@class='form-control' and@placeholder='Mr / Mrs / Miss']")
WebElement prefix_field;
@FindBy(xpath="//input[@class='form-control' and@name='first_name']")
WebElement firstname_field;
@FindBy(xpath="//input[@class='form-control' and@name='last_name']")
WebElement lastname_field;
@FindBy(xpath="//input[@class='form-control' and@name='email']")
WebElement emailfield;
@FindBy(xpath="//input[@class='form-control' and@name='username']")
WebElement usename;
@FindBy(xpath="//input[@class='form-control' and@name='password']")
WebElement passwordfield;
@FindBy(xpath="//input[@class='form-control' and@name='confirm_password']")
WebElement confirmpasswordfield;
@FindBy(xpath="//input[@class='form-control' and@name='cmmsn_percent']")
WebElement percentagefield;
@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
WebElement savebutton;
public void getprefix(String prefix)
{
	prefix_field.sendKeys(prefix);
}
public void getfirstname(String firstname)
{
	firstname_field.sendKeys(firstname);
}
public void getlastname(String lastname)
{
	lastname_field.sendKeys(lastname);
	
}
public void getemail(String email)
{
	emailfield.sendKeys(email);
	
}
public void getusename(String username)
{
	usename.sendKeys(username);
	
}
		
public void getpassword(String password)
{
	confirmpasswordfield.sendKeys(password);
	
}
public void getconfirmpassword(String confirmpassword)
{
	passwordfield.sendKeys(confirmpassword);
	
}

public void getpercentage(String percentage)
{
	percentagefield.sendKeys(percentage);
	
}
public UserPage clickonSaveButton()
{
	
	savebutton.click();
	return new UserPage(driver);
	
}
}
