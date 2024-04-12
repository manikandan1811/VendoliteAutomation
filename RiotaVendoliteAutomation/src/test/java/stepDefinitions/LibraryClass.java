package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryClass {

	public LibraryClass() {
	}

	public void waitForVisibilityOfElement(WebDriver driver, By visbleElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(visbleElement));
	}

	public void waitForInVisibilityOfElement(WebDriver driver, By visbleElement, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(visbleElement));
	}

	public void waitForInVisibilityOfElement(WebDriver driver, By visbleElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(visbleElement));
	}

	public void waitForVisibilityOfElement(WebDriver driver, By visbleElement, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOfElementLocated(visbleElement));
	}

	public void waitForVisibilityOfElement(WebDriver driver, WebElement visbleElement, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(visbleElement));
	}

	public void enterValueon(WebDriver driver, By element, String value) {
		driver.findElement(element).sendKeys(value);
	}

	public void clickOn(WebDriver driver, By element) {
		waitForVisibilityOfElement(driver, element);
		driver.findElement(element).click();
	}

	public void clickJSEon(WebDriver driver, By element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(element));

	}

	public void scrollToElement(WebDriver driver, By element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}

	public void clearText(WebDriver driver, By element) {
		waitForVisibilityOfElement(driver, element);
		driver.findElement(element).clear();

	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
	}

	public void scrollDown(WebDriver driver, String value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + value + ")", "");
	}

}
