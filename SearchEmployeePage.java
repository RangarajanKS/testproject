package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchEmployeePage {
	final WebDriver driver;
	public Boolean flag = false;

	@FindBy(how = How.XPATH, using = "(//input[starts-with(@id,'employee_name')])")

	static WebElement enterEmployeeName;

	@FindBy(how = How.XPATH, using = "//i[@id='quick_search_icon']")

	static WebElement clickSearchButton;

	@FindBy(how = How.XPATH, using = "//td[starts-with(@ng-click,'vm.viewProfile') and text()='Brody  Alan ']")

	static WebElement employeeName;

	@FindBy(how = How.XPATH, using = "//td[@class='hide-on-small-and-down' and  text()='Technical Support Manager '] ")

	static WebElement jobTitle;

	@FindBy(how = How.XPATH, using = "//td[@class='hide-on-small-and-down hide-on-med-and-down' and  text()='Full-Time Probation']")

	static WebElement employeeStatus;

	@FindBy(how = How.XPATH, using = "//td[@ng-if='employee.subDivision.name' and  text()='QA Team']")

	static WebElement subUnit;

	@FindBy(how = How.XPATH, using = "//td[@ng-if='vm.costCenterEnabled' and  text()='0001 - Cost Center (IT)']")

	static WebElement costCenter;

	public SearchEmployeePage(WebDriver driver)

	{

		this.driver = driver;

	}

	public boolean EnterEmployee() throws InterruptedException {
		flag = false;
 
		if (enterEmployeeName.isDisplayed()) {
			if (enterEmployeeName.isEnabled()) {
				if (clickSearchButton.isDisplayed()) {
					if (clickSearchButton.isEnabled()) {
						enterEmployeeName.sendKeys("Brody Alan ");
						clickSearchButton.click();
						flag = true;
						System.out.println("Employee Name entered ");

					} else {
						System.out.println("Employee Name is not entered");
					}

				}
			}
		}
		return flag;

	}

 

	public boolean RetriveDetailsText(String tag) throws InterruptedException {
		flag = false;
		Thread.sleep(3000);
		// 1
		if (employeeName.isDisplayed()) {

			String employeeNametext = employeeName.getText();
			if (employeeNametext.equalsIgnoreCase(tag)) {

				flag = true;
				System.out.println("employee name " + " " + employeeNametext);

			}

			else {
				flag = false;
			}

		}
		// 2
		if (jobTitle.isDisplayed()) {

			String jobTitletext = jobTitle.getText();
			if (jobTitletext.equalsIgnoreCase(tag)) {

				flag = true;
				System.out.println("job Title text   " + " " + jobTitletext);

			} else {
				flag = false;
			}

		}

		// 3
		if (employeeStatus.isDisplayed()) {

			String employeeStatustext = employeeStatus.getText();
			if (employeeStatustext.equalsIgnoreCase(tag)) {

				flag = true;
				System.out.println("The employee Status text  " + " " + employeeStatustext);

			} else {
				flag = false;
			}

		}
		 
		// 4
		if (subUnit.isDisplayed()) {

			String subUnittext = subUnit.getText();
			if (subUnittext.equalsIgnoreCase(tag)) {

				flag = true;
				System.out.println("The sub Unit text  " + " " + subUnittext);

			} else {
				flag = false;
			}

		}
		// 5
		if (costCenter.isDisplayed()) {

			String costCentertext = costCenter.getText();
			if (costCentertext.equalsIgnoreCase(tag)) {

				flag = true;
				System.out.println("The cost Center text " + " " + costCentertext);

			} else {
				flag = false;
			}

		}

		return flag;
	}
}
