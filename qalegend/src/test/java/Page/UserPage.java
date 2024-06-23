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
	 @FindBy(xpath="//i[@class='glyphicon glyphicon-edit']")
		WebElement edit_button;
	 @FindBy(xpath="//input[@type='search']")
		WebElement searchfield;
	 @FindBy(xpath="//i[@class='glyphicon glyphicon-trash']")
		WebElement delete_button;
	 @FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	 WebElement ok_button;
	 @FindBy(xpath = "//td[@class='sorting_1']")
		WebElement name_field;
	 public AddUser getAddbutton()
	 {
		 add_button.click(); 
		 return new AddUser(driver);
	 }
	 public void clickEditButtoun()
	  {
		
		edit_button.click();
		  
	  }
	 public void enterSearchValue(String search_value) 
	  {
		
		searchfield.sendKeys(search_value);
		  
	  } 
	 public void clickDeleteButtoun()
	  {
		
		delete_button.click();
		  
	  }
	 public void clickOkButtoun()
	 {
	 	
	 	ok_button.click();
	 	  
	 }
	 public String getTextOfName() {

			String name = name_field.getText();
			return name;

		}
	}


