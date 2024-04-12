package pageElements;

import org.openqa.selenium.By;

public class HomePage {

	public By menuBtn = By.xpath("//button[@class='mat-focus-indicator example-icon mat-icon-button mat-button-base']//mat-icon[text()='menu']");
	public By powerBtn=By.xpath("//button[@class='mat-focus-indicator example-icon mat-icon-button mat-button-base']//mat-icon[text()='power_settings_new']");
	public By loadingImg=By.xpath("//div[@class='ng-tns-c172-4 ng-star-inserted']");
	public By welcomeUserLbl=By.xpath("//span[contains(text(),'Welcome')]");
	public By helpAndSupportLbl=By.xpath("//div[text()='Help & Support']");
	public By helpAndSupportInvisibleElement=By.xpath("//mat-drawer[@class='mat-drawer sidenav ng-tns-c59-86 ng-trigger ng-trigger-transform mat-drawer-side ng-star-inserted mat-drawer-opened']");
	public By profileBtn=By.xpath("//button[@class='mat-focus-indicator example-icon favorite-icon mat-icon-button mat-button-base']");
	public By timeSpanDrp=By.xpath("//div[@class='mat-select-value ng-tns-c129-23']");
	public By timeSpanValues=By.xpath("//mat-select[@aria-owns='Daily Weekly Monthly Yearly']");
	public By frequentlyAskedQuestionList=By.xpath("//mat-accordion[@class='mat-accordion']//mat-expansion-panel");
	public By dateRange=By.cssSelector("input[name='drange']");
	public By searchText=By.cssSelector("input[name='searchText']");
	public By searchTypeValues=By.xpath("//mat-select[@aria-owns='[object Object] [object Object] [object Object] [object Object] [object Object]']");
	public By searchTypeDrp=By.xpath("//mat-select[@class='mat-select ng-tns-c129-19 ng-tns-c27-18 ng-star-inserted']");
	public By typeDrp=By.xpath("//div[@class='mat-select-value ng-tns-c129-11']");
	public By typeValue=By.xpath("//mat-select[@aria-owns='mat-option-0 mat-option-1 mat-option-2 mat-option-3']");
	public By logoutBtn=By.xpath("//button[@mattooltip='Logout']");
	
}
