package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PimPage {
	final WebDriver driver;
	public Boolean flag = false;

	@FindBy(how = How.XPATH, using = "//*[@id='menu-content']//*[text()='PIM']")

	static WebElement clickPIM;

	@FindBy(how = How.XPATH, using = "(//*[@id='menu_pim_viewPimModule'])[1]//*[text()='Employee List']")

	static WebElement clickEmployeeList;

	public PimPage(WebDriver driver)

	{

		this.driver = driver;

	}
	

	public boolean ClickonPIM(String Type) throws InterruptedException {
		flag = false;
		 
 
		if (Type.equals("PIM")) {

			clickPIM.click();
			flag = true;
			System.out.println("PIM selected");

		} else {
			System.out.println("PIM not selected");
		}
		return flag;

	}

	public boolean ClickonEmployeeList() 
	{
		flag = false;
		if (clickEmployeeList.isDisplayed()) 
		{
			if (clickEmployeeList.isEnabled()) 
			{
				clickEmployeeList.click();
				System.out.println("EmployeeList is selected");
				return true;
				 
			}
			else 
			{
				System.out.println("EmployeeList is not  selected");
				flag = false;
			}

		}
		return flag;
	}

}
