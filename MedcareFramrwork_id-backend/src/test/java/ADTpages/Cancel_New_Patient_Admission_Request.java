package ADTpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import OPDTest.DeleteExcelRowWithSelenium;
import OPDTest.ReadExcelRowWithSelenium;


public class Cancel_New_Patient_Admission_Request {
	public	WebDriver driver = null;

	//Locators

	By mainmenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
	By MainMenuTooltip=By.xpath("/html/body/div[2]");
	By OPDMenu=By.xpath("//*[@id='mat-menu-panel-1']/div/div/div[1]/div[1]/div[3]/div/img");
	By AdmissionRequest=By.cssSelector("a[ng-reflect-router-link='admission-request']");
	By Edit=By.cssSelector("mat-icon[ng-reflect-message='Edit']");
	By PrimaeryIdentification=By.cssSelector("mat-select[ng-reflect-name='primaryId']");
	By Primary_Id_Number=By.cssSelector("input[ng-reflect-placeholder='Primary Id Number']");
	By name=By.cssSelector("input[ng-reflect-name='fullName']");
	By search=By.cssSelector("input[aria-label='dropdown search']");
	By Admitting_Doctor=By.cssSelector("mat-select[ng-reflect-name='primaryCareDoc']");
	By refferingDoc=By.cssSelector("mat-select[ng-reflect-name='refferingDoc']");
	By attendingCareDoc=By.cssSelector("mat-select[ng-reflect-name='attendingCareDoc']");
	By DOA=By.cssSelector("input[ng-reflect-name='DOA']");
	By Payer_Type=By.cssSelector("mat-select[ng-reflect-name='paymentEntitlement']");
	By bedWard=By.cssSelector("input[ng-reflect-name='bedWard']");
	By notes=By.cssSelector("input[ng-reflect-name='notes']");
	By remarks=By.cssSelector("input[ng-reflect-name='remarks']");
	By save=By.cssSelector("mat-icon[ng-reflect-message='Save']");
	By dob=By.cssSelector("input[ng-reflect-name='dob']");
	By Reason=By.cssSelector("mat-select[ng-reflect-name='Reason']");
	
	By Cancel=By.cssSelector("mat-icon[ng-reflect-message='Cancel']");
	
	By remarks1=By.cssSelector("input[ng-reflect-name='remarks']");
	
	By yes =By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-cancel-discharge/div[3]/td/button");

	
	
	

	public Cancel_New_Patient_Admission_Request(WebDriver driver) {
		this.driver= driver;

	}


	public void Cancel_New_Patient_Admission_Requestfunc() throws InterruptedException, IOException {
		Thread.sleep(8000);
		// Create object and take the data from another class
		DeleteExcelRowWithSelenium  data = new DeleteExcelRowWithSelenium();
		String EnterPatientName_11=data.TkaePatientName;
		System.out.println("Print the patient name" + EnterPatientName_11);

		driver.findElement(mainmenu).click();
		Thread.sleep(1000);
		driver.findElement(OPDMenu).click();
		Thread.sleep(8000);
		driver.findElement(AdmissionRequest).click();
		Thread.sleep(1000);
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot1, new File(".//ScreenShots//Cancel_New_Patient_Admission_Request.png"));
		Thread.sleep(1000);
		driver.findElement(Cancel).click();
		Thread.sleep(1000);
		driver.findElement(Reason).click();
		Thread.sleep(1000);
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp2= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot2, new File(".//ScreenShots//Cancel_New_Patient_Admission_Request_select_reason.png"));
		Thread.sleep(1000);
		String Actual = "Cancel reason";
		String Expected = "option";
		Assert.assertEquals(Actual, Expected, "Select cancel reason");
		Thread.sleep(1000);
		driver.findElement(remarks1).sendKeys("Testing");
		Thread.sleep(1000);
		driver.findElement(yes).click();
		Thread.sleep(1000);
		String Actual_1 = "Please enter mandatory field";
		String Expected_1 = "cancelled sucessfully";
		Assert.assertEquals(Actual_1, Expected_1, "Click on yes to cancel admission request");
		Thread.sleep(1000);
		File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp3= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot3, new File(".//ScreenShots//Cancel_New_Patient_Admission_Request_Click_on_YES_button.png"));
		Thread.sleep(3000);
		
		
	}

}
