package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPage 
{
	final WebDriver driver;
	public Boolean flag = false;
 

	@FindBy(how = How.XPATH, using = "(//i[@class='material-icons'])[1]")

	static WebElement logoutDropdown;

	@FindBy(how = How.XPATH, using = "//a[@id='logoutLink']")

	static WebElement logoutButton;

 
	
	 public LogoutPage(WebDriver driver)
	 
	 {
	 
	 this.driver = driver;
	 
	 }
	 /**
	   * Method which used for logout scenario 
	   * 
	   * 
	   */

	 public boolean ClickLogout() {
			flag = false;
			if (logoutDropdown.isDisplayed()) {
				if (logoutButton.isDisplayed()) {
				logoutDropdown.click();
					System.out.println("logoutDropdown is selected");
				 
					
					logoutButton.click();
					System.out.println("logoutButton is selected");
					return true;
					 
				} else {
					System.out.println("logout  is not  selected");
					flag = false;
				}

			}
			return flag;
		}
}
