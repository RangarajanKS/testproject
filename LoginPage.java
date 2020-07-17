package pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.TestNGException;

public class LoginPage extends Browserbase {
	final WebDriver driver;
	 
	public Boolean flag = false;


	@FindBy(how = How.XPATH, using = "(//*[@id='txtUsername'])[1]")

	static WebElement username;

	@FindBy(how = How.XPATH, using = "(//*[@id='txtPassword'])[1]")

	static WebElement password;

	@FindBy(how = How.XPATH, using = "(//*[@id='btnLogin'])[1]")

	static WebElement login;
	
	@FindBy(how = How.XPATH, using = "//div[@id='loginAsButtonGroup']")

	static WebElement Differentlogin;
	
 
	
	 public LoginPage(WebDriver driver)
	 
	 {
	 
	 this.driver = driver;
	 
	 }
 
	public void LogIn_Action(String sUserName, String sPassword) throws InterruptedException
	{
	 
		username.sendKeys(sUserName);
	waits();
		password.sendKeys(sPassword);
		waits();
		login.click();
	 
	}
	

	public void loadPage(String url) 
	{

		driver.get(url);

	}
	
	/**
	   * Method which opens  different login of admins 
	   * 
	   * 
	   */
	  public boolean openDifferentAdmin(String  AdminData) {

	    boolean flag = false;
 
	    List<WebElement> list = driver.findElements(By.xpath("//*[@class='dropdown-menu']/li"));
 
	    for (WebElement courseListResults : list) 
	    {
	        WebElement title = courseListResults.findElement(By.className("login-as"));
 
	      if (title.getText().contains(AdminData))
	     
	      {
	     
	        title.click();
	        flag = true;
	        break;
	      }
	    }
	    if (!flag) {
	      throw new TestNGException(
	          "Unable to open AdminData " + AdminData + " as its not available in the   list");
	    }
		return flag;
	  }
	
	  
	  /**
	   * Method which checks different login of admins 
	   * 
	   * 
	   */
	public boolean ClickonDifferentlogin() 
	{
		flag = false;
		if (Differentlogin.isDisplayed()) 
		{
			if (Differentlogin.isEnabled()) 
			{
				Differentlogin.click();
				System.out.println("Login as a Different Role is selected");
				return true;
				 
			}
			else 
			{
				System.out.println("Login as a Different Role is not selected");
				flag = false;
			}

		}
		return flag;
		
}
	}