package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageElements.HomePage;
import pageElements.LoginPage;
import pageElements.ProfilePage;

public class StepDefinitions {

	private LibraryClass library;
	private BaseClass base;
	private HomePage homePageElements;
	private LoginPage loginPageElements;
	private ProfilePage profilePageElements;
	public WebDriver driver;
	private String emailID;
	private String username;

	public StepDefinitions(LibraryClass library, HomePage homePageElements, LoginPage loginPageElements,
			ProfilePage profilePageElements, BaseClass base) {
		this.library = library;
		this.base = base;
		this.homePageElements = homePageElements;
		this.loginPageElements = loginPageElements;
		this.profilePageElements = profilePageElements;
	}

	@Before
	public void lauchDriver() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	@Given("Launch the url")
	public void launch_the_url() throws IOException {
		driver.get(base.getConfigData("AppUrl"));

	}

	@When("Select the module as {string}")
	public void selectTheModule(String module) {
		By modeule = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'" + module + "')]");
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.clickOn(driver, modeule);

	}

	@When("Enter the {string} and {string}")
	public void enterTheLoginuserNameAndPassword(String userName, String password) {
		library.enterValueon(driver, loginPageElements.usernameTxt, userName);
		setUsername(userName);
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.enterValueon(driver, loginPageElements.passwordTxt, password);

	}

	public enum Button {
	    login, ForgotPassword, RequestReset, menu, profile, save ,edit,HelpAndSupport, logout
	}

	@Given("Click on {string} button")
	public void clickOnButton(String button) throws Exception {
		By btnType = null;
		Button enumDay = Button.valueOf(button);
		switch (enumDay) {

		case login:
			btnType = loginPageElements.loginBtn;
			break;

		case ForgotPassword:
			btnType = loginPageElements.forgotPasswordBtn;
			break;

		case RequestReset:
			library.enterValueon(driver, loginPageElements.usernameTxt, getUsername());
			btnType = loginPageElements.resetRequestBtn;
			break;

		case menu:
			btnType = homePageElements.menuBtn;
			break;

		case profile:
			btnType = homePageElements.profileBtn;
			break;

		case edit:
			btnType = profilePageElements.editBtn;
			break;

		case save:
			btnType = profilePageElements.saveBtn;
			break;

		case HelpAndSupport:
			btnType = homePageElements.helpAndSupportLbl;
			break;

		case logout:
			btnType = homePageElements.logoutBtn;
			break;

		default:
			fail("Given Buttontype not available for selection");
		}

		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.clickOn(driver, btnType);

	}

	@Then("Check the time span dropdown")
	public void checkTheTimeSpanDropdown() {
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.scrollDown(driver, "500");
		library.clickJSEon(driver, homePageElements.timeSpanDrp);

		try {
			library.waitForVisibilityOfElement(driver, homePageElements.timeSpanValues);
			driver.findElement(homePageElements.timeSpanValues).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			fail("Time Span Dropdown not works");
		}
	}

	@Then("Check the search Type dropdown")
	public void checkTheSearchTypeDropdown() {
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.scrollDown(driver, "450");
		library.clickJSEon(driver, homePageElements.searchTypeDrp);
		try {
			library.waitForVisibilityOfElement(driver, homePageElements.searchTypeValues);
			driver.findElement(homePageElements.searchTypeValues).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			fail("Search Type Dropdown not works");
		}
	}

	@Then("Check the Type dropdown")
	public void checkTheTypeDropdown() {
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.scrollDown(driver, "650");
		library.clickJSEon(driver, homePageElements.typeDrp);
		try {
			library.waitForVisibilityOfElement(driver, homePageElements.typeValue);
			driver.findElement(homePageElements.typeValue).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			fail("Type Dropdown not works");
		}
	}

	@Then("check the page is navigate to homepage")
	public void checkThePageIsNavigateToHomepage() {
		try {
			library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
			library.waitForVisibilityOfElement(driver, homePageElements.welcomeUserLbl);
		} catch (Exception e) {
			fail("HomePage not loading");
		}
	}

	@Then("check the error message as {string}")
	public void checkTheErrorMessageAsValidation(String errorMsg) {
		By msgElement = By.xpath("//span[text()='" + errorMsg + "']");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(msgElement));
			if (driver.findElements(msgElement).size() > 0) {
				System.out.println("Error Message shown");
			} else {
				fail("Error Message not shown");
			}
		} catch (Exception e) {

		}
	}

	@Then("Check the help and Support label is invisible")
	public void checkTheHelpAndSupportLabelIsInvisible() {
		try {
			library.waitForInVisibilityOfElement(driver, homePageElements.helpAndSupportInvisibleElement);
		} catch (Exception e) {
			fail("Page not respond");
		}

	}

	@Then("Enter the mobile number as {string}")
	public void enterTheMobileNumber(String mobileNo) {
		library.enterValueon(driver, profilePageElements.mobileNoTxt, mobileNo);
	}

	@Then("Change the user name as {string}")
	public void changeTheUserName(String userName) {
		library.clearText(driver, profilePageElements.userNameTxt);
		library.enterValueon(driver, profilePageElements.userNameTxt, userName);
	}

	@Then("Change the email as {string}")
	public void changeTheEmail(String userName) {
		library.waitForVisibilityOfElement(driver, profilePageElements.emailTxt);
		String emailValue = driver.findElement(profilePageElements.emailTxt).getText();
		setEmailID(emailValue);
		try {
			library.clearText(driver, profilePageElements.emailTxt);
			library.enterValueon(driver, profilePageElements.emailTxt, userName);
			library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
			library.waitForVisibilityOfElement(driver, profilePageElements.emailTxt);
			String actualValue = driver.findElement(profilePageElements.emailTxt).getText();
			assertEquals(actualValue, getEmailID(), "Mail ID not changed");
		} catch (Exception e) {
			fail("Unable to clear the email ID");
		}

	}

	@Then("Check the Frequently asked question listed")
	public void checkTheFrequentlyAskedQuestionList() {
		try {
			library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
			library.waitForVisibilityOfElement(driver, homePageElements.frequentlyAskedQuestionList);
		} catch (Exception e) {
			fail("Frequently asked question list not  shown");
		}
	}

	@Then("Check the upgrade plan page shows message as {string}")
	public void checkTheUpgradePlan(String expectedMsg) {
		library.clickOn(driver, profilePageElements.upgradePanBtn);
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.waitForVisibilityOfElement(driver, profilePageElements.upgradePlanLbl);
		String actualMsg = driver.findElement(profilePageElements.upgradePlanLbl).getText();
		assertEquals(actualMsg, expectedMsg, "Expected message mismatched");
	}

	@Then("Change the date range")
	public void changeTheDateRange() throws ParseException {
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		library.waitForVisibilityOfElement(driver, homePageElements.dateRange);
		library.clearText(driver, homePageElements.dateRange);
		Date todays = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(todays);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(date));
		calendar.add(Calendar.DATE, 30);
		String endDate = sdf.format(calendar.getTime());

		library.enterValueon(driver, homePageElements.dateRange, date + " ~ " + endDate);
	}

	@Then("Verify the application is logout")
	public void verifyTheApplicationIsLogout() throws ParseException {
		library.waitForInVisibilityOfElement(driver, homePageElements.loadingImg);
		if (driver.findElements(loginPageElements.usernameTxt).size() > 0) {
			System.out.println("Logout Successfully");
		} else {
			fail("Not able to logout the application");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
