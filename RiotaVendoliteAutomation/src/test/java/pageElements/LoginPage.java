package pageElements;

import org.openqa.selenium.By;

public class LoginPage {

	public By usernameTxt=By.cssSelector("[name='username']");
	public By passwordTxt=By.cssSelector("[name='password']");
	public By loginBtn=By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']");
	public By companyLoginFailedMsg=By.xpath("//span[text()='Error Logging in : COMPANY_LOGGIN_FAILED']");
	public By clientLoginFailedMsg=By.xpath("//span[text()='Error Logging in : COMPANY_LOGGIN_FAILED']");
	public By forgotPasswordBtn=By.xpath("//span[contains(text(),'Forgot Password')]");
	public By resetRequestBtn=By.xpath("//button//span[text()=' Create Reset Request ']");
	
}
