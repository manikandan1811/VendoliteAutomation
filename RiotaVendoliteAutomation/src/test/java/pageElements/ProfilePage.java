package pageElements;

import org.openqa.selenium.By;

public class ProfilePage {

	public By mobileNoTxt=By.cssSelector("input[name='phone']");
	public By emailTxt=By.cssSelector("input[name='email']");
	public By userNameTxt=By.cssSelector("input[name='name']");
	public By editBtn=By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/parent::div");
	public By saveBtn=By.xpath("//button//span[text()=' Save ']");
	public By upgradePanBtn=By.xpath("//button//span[text()=' Upgrade Plan ']");
	public By upgradePlanLbl=By.xpath("//div[text()=' No upgradable plans available. Please contact your system admin. ']");
	public By upgradeLblTxt=By.xpath("//table/following-sibling::div");
	

}
