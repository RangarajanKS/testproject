package test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriverException;

import pageobjects.Browserbase;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import pageobjects.PimPage;
import pageobjects.SearchEmployeePage;

public class EmployeeListTest extends Browserbase {
	static WebDriver driver;
	LoginPage LoginPg;
	PimPage PimPg;
	SearchEmployeePage SearchEmpPg;
	private boolean flag = false;
	private boolean expectedValue = true;
	LogoutPage LogoutPg;

	private static boolean employeeNameflag = false;
	private static boolean jobTitleflag = false;
	private static boolean employeeStatusflag = false;
	private static boolean subUnitflag = false;
	private static boolean costCenterflag = false;

	private static boolean SystemAdministratorflag = false;
	private static boolean Administratorflag = false;
	private static boolean ESSUserflag = false;
	private static boolean Supervisorflag = false;
	private static boolean ClickonDifferentloginflag = false;
	@BeforeMethod(alwaysRun = true)

	private void beforeMethod() throws InterruptedException {
		{
			System.out.println("Beforemethod  execution");
			StartBrowser("Chrome");
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			waits();
			LoginPg = PageFactory.initElements(driver, LoginPage.class);

			LoginPg.loadPage("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");

			maximize();
			System.out.println(" before Test Method----> " + this.getClass().getSimpleName());
		}
	}

	@Test(priority = 1, description ="This test  Method is used  for  opening  different login of admins ")
	public void DifferentAdminTest() throws Exception, WebDriverException {

		waits();
		LoginPg = PageFactory.initElements(driver, LoginPage.class);
		
		ClickonDifferentloginflag =LoginPg.ClickonDifferentlogin();
		waits();
		SystemAdministratorflag = LoginPg.openDifferentAdmin("System Administrator");
		Administratorflag = LoginPg.openDifferentAdmin("Administrator");
		ESSUserflag = LoginPg.openDifferentAdmin("ESS User");
		Supervisorflag = LoginPg.openDifferentAdmin("1st Level Supervisor");
		
		Assert.assertEquals(ClickonDifferentloginflag, expectedValue, " Different login  is not able to handle");
		Assert.assertEquals(SystemAdministratorflag, expectedValue, "SystemAdministrator is not able to handle");
		Assert.assertEquals(Administratorflag, expectedValue, "Administratorflag is not able to handle");
		Assert.assertEquals(ESSUserflag, expectedValue, "ESSUserflag is not able to handle");
		Assert.assertEquals(Supervisorflag, expectedValue, "Supervisorflag is not able to handle");

	}

	@Test(dependsOnMethods = { "DifferentAdminTest" }, priority = 2, description ="This test  Method is used  for Login ")
	public void loginTest() throws Exception, WebDriverException {

		waits();
		LoginPg = PageFactory.initElements(driver, LoginPage.class);

		LoginPg.LogIn_Action("admin", "admin123");

	}

	@Test(dependsOnMethods = { "loginTest" }, priority = 3 , description ="This test  Method is used  for Fetching the Employee Details")
	public void FetchEmployeeDetailsTest() throws Exception, WebDriverException {

		PimPg = PageFactory.initElements(driver, PimPage.class);
		waits();
		PimPg.ClickonPIM("PIM");
		PimPg.ClickonEmployeeList();

		SearchEmpPg = PageFactory.initElements(driver, SearchEmployeePage.class);

		waits();
		flag = SearchEmpPg.EnterEmployee();

		Assert.assertEquals(employeeNameflag, expectedValue, "Not able to search and enter employee name");

		employeeNameflag = SearchEmpPg.RetriveDetailsText("Brody Alan ");
		jobTitleflag = SearchEmpPg.RetriveDetailsText("Technical Support Manager ");
		employeeStatusflag = SearchEmpPg.RetriveDetailsText("Full-Time Probation");
		subUnitflag = SearchEmpPg.RetriveDetailsText("QA Team");
		costCenterflag = SearchEmpPg.RetriveDetailsText("0001 - Cost Center (IT)");

		Assert.assertEquals(employeeNameflag, expectedValue, "Employee name is not present in Employee detail page");
		Assert.assertEquals(jobTitleflag, expectedValue, "Job Title  is not present in Employee detail page");
		Assert.assertEquals(employeeStatusflag, expectedValue,	"Employee Status  is not present in Employee detail page");
		Assert.assertEquals(subUnitflag, expectedValue, "Sub Unit name is not present in Employee detail page");
		Assert.assertEquals(costCenterflag, expectedValue, "Cost Center name is not present in Employee detail page");
		waits();

	}

	@Test(dependsOnMethods = { "FetchEmployeeDetailsTest" }, priority = 4, description ="This test  Method is used  for Logout")
	public void logoutTest() throws Exception, WebDriverException {

		LogoutPg = PageFactory.initElements(driver, LogoutPage.class);
		
		waits();
		flag = LogoutPg.ClickLogout();
		Assert.assertEquals(flag, expectedValue, "No logoutTest Functionality  ");

	}

	@AfterMethod(alwaysRun = true)
	private void afterMethod(ITestResult testResult) {

		System.out.println("afterMethod" + testResult.getName());
	}

}
