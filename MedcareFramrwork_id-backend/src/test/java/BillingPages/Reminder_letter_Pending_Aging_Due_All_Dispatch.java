package BillingPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import OPDTest.ReadExcelRowWithSelenium;

public class Reminder_letter_Pending_Aging_Due_All_Dispatch {

	WebDriver driver;
	public Reminder_letter_Pending_Aging_Due_All_Dispatch(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	 
	

	By mainmenu=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By BillingMenu = By.xpath("//span[contains(text(),'Billing')]");
	By OPDBill = By.cssSelector("a[id='32']");
	By Expand = By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	By PatientName = By.cssSelector("input[ng-reflect-name='PatienName']");
	By SerachButton = By.cssSelector("button[ng-reflect-message='Search']");
	By ServiceName = By.cssSelector("input[ng-reflect-name='serviceName']");
	By add = By.xpath("//mat-icon[contains(text(),'add')]");
	By FinallBill = By.cssSelector("mat-checkbox[ng-reflect-message='Final Bill']");
	By save = By.cssSelector("mat-icon[ng-reflect-message='Save']");
	By yes = By.cssSelector("mat-icon[ng-reflect-message='Yes']");
	By ReminderLetter = By.cssSelector("a[id='30004']");
	//By  = By.cssSelector("button[id='mat-button-toggle-6-button']");
	By Pending = By.xpath("//span[contains(text(),'Pending')]");	
	By Findall = By.cssSelector("mat-select[ng-reflect-placeholder='Select Aging Due']");
	//By ALL = By.cssSelector("//span[contains(text(),'ALL')]");
	//By All =By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
	By sidebarbilling = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[1]/a");
	By SavePaymentDetails = By.cssSelector("mat-icon[ng-reflect-message='Save Payment Details']");
	By yess = By.cssSelector("mat-icon[ng-reflect-message='Yes']");
	By opt = By.xpath("//span[contains(text(),' Bilirubin, Conjugated ')]");
	
	
	
	


	public void Reminder_letter_Pending_Aging_Due_All_Dispatchfunc() throws InterruptedException, AWTException, IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		

		// Create object and take the data from another class
		ReadExcelRowWithSelenium  data = new ReadExcelRowWithSelenium();
		String EnterPatientName=data.TkaePatientName;
		System.out.println("Print the patient name" + EnterPatientName);
		Thread.sleep(10000);
		driver.findElement(mainmenu).click();
		Thread.sleep(2000);
		driver.findElement(BillingMenu).click();
		Thread.sleep(10000);
		WebElement ele = driver.findElement(sidebarbilling);
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(OPDBill).click();
		Thread.sleep(3000);
		driver.findElement(Expand).click();
		Thread.sleep(2000);
		driver.findElement(PatientName).sendKeys(EnterPatientName);
		Thread.sleep(1000);
		driver.findElement(SerachButton).click();
		Thread.sleep(2000);
		String Actual_1 = EnterPatientName;
		String Expected_1 = EnterPatientName;
		Assert.assertEquals(Actual_1, Expected_1, "Patient not found");
		Thread.sleep(2000);
		driver.findElement(ServiceName).sendKeys("Bilirubin, Conjugated");
		driver.findElement(ServiceName).click();
		Thread.sleep(2000);
		driver.findElement(opt).click();
		Thread.sleep(2000);
		driver.findElement(add).click();
		driver.findElement(add).click();
		Thread.sleep(10000);
		driver.findElement(FinallBill).click();
		Thread.sleep(2000);
		driver.findElement(save).click();
		Thread.sleep(2000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//Service_charges_has_been_added_for_Reminder_Letter_Pending_Aging_Due_30_60_Dispatch.png"+dateFormat.format(date)));  
		Thread.sleep(2000);
		String Actual_2 = "Do you want to proceed with billing?";
		String Expected_2 = "Do you want to proceed with billing?";
		Assert.assertEquals(Actual_2, Expected_2, "Charges not applied against patient");
		Thread.sleep(2000);
		driver.findElement(yes).click();
		Thread.sleep(2000);
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot2, new File(".//ScreenShots//Payment_Details_has_been_added_for_Reminder_Letter_Pending_Aging_Due_30_60_Dispatch.png"+dateFormat.format(date)));  
		Thread.sleep(2000);
		Thread.sleep(2000);
		String Actual_3 = "Payment Details";
		String Expected_3 = "Payment Details";
		Assert.assertEquals(Actual_3, Expected_3, "Payment Details has been added");
		Thread.sleep(6000);
		Robot robot = new Robot(); for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL); }

		Thread.sleep(900);
		driver.findElement(SavePaymentDetails).click();
		Thread.sleep(2000);
		String Actual_4 = "Do you want to proceed?";
		String Expected_4 = "Do you want to proceed?";
		Assert.assertEquals(Actual_4, Expected_4, "Payment Details has been added");
		Thread.sleep(6000);
		driver.findElement(yess).click();
		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();
		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window((String) tabs.get(0));
		Thread.sleep(5000);
		WebElement ele1 = driver.findElement(sidebarbilling);
		//Creating object of an Actions class
		Actions action1 = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele1).perform();
		Thread.sleep(2000);
		driver.findElement(ReminderLetter).click();
		Thread.sleep(5000);
		driver.findElement(Pending).click();
		Thread.sleep(2000);
		driver.findElement(Findall).click();
		File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot5, new File(".//ScreenShots//Reminder_Letter_Pending_Aging_Due_30_60_Dispatch.png"+dateFormat.format(date)));  
		Thread.sleep(2000);
		String Actual_5 = "All";
		String Expected_5 = "All";
		Assert.assertEquals(Actual_5, Expected_5, "All Aging due has been displayed");

	}

}  
