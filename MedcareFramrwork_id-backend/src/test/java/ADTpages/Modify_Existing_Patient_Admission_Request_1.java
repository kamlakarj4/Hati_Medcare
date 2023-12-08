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


public class Modify_Existing_Patient_Admission_Request_1 {
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
	
	
	
	public Modify_Existing_Patient_Admission_Request_1(WebDriver driver) {
		this.driver= driver;

	}


	public void Modify_Existing_Patient_Admission_Requestfunc() throws InterruptedException, IOException {
		Thread.sleep(8000);
		// Create object and take the data from another class
		DeleteExcelRowWithSelenium  data = new DeleteExcelRowWithSelenium();
		String EnterPatientName_11=data.TkaePatientName;
		System.out.println("Print the patient name" + EnterPatientName_11);

		driver.findElement(mainmenu).click();
		Thread.sleep(1000);
		driver.findElement(OPDMenu).click();
		Thread.sleep(8000);
		// Open the current date and time
		driver.findElement(AdmissionRequest).click();
		Thread.sleep(1000);
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot1, new File(".//ScreenShots//Modify_Existing_Patient_Admission_Request_click_on_edit_button.png"));
		Thread.sleep(1000);
		driver.findElement(Edit).click();
		Thread.sleep(1000);
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp1 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot2, new File(".//ScreenShots//Modify_Existing_Patient_Admission_Request_fill_the_Patient Details.png"));
		Thread.sleep(1000);
		driver.findElement(PrimaeryIdentification).click();
		Thread.sleep(1000);
		String Actaul_1 = "Primaery Identification";
		String Expected_2 = "Passport";
		Assert.assertEquals(Actaul_1, Expected_2, "Assertion pass patient able to select the id");
		Thread.sleep(1000);
		File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp4 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot4, new File(".//ScreenShots//Modify_Existing_Patient_Admission_Request_select_primaery_id.png"));
		Thread.sleep(3000);

		driver.findElement(Primary_Id_Number).sendKeys("1234567456767");
		Thread.sleep(1000);
		driver.findElement(name).sendKeys(EnterPatientName_11);
		Thread.sleep(1000);
		driver.findElement(dob).sendKeys("07/11/1990");
		Thread.sleep(1000);
		
		//Admitting doctor
		driver.findElement(Admitting_Doctor).click();
		Thread.sleep(1000);
		WebElement Admitting_Doctor_1 = driver.findElement(Admitting_Doctor);
		Assert.assertEquals(true, Admitting_Doctor_1.isEnabled()); 
		System.out.println("Admitting_Doctor_1 field is enabled – Assert passed");
		Thread.sleep(1000);
		driver.findElement(search).sendKeys("Ram Patil");
		Thread.sleep(1000);
		driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		//ReferingDoctor
		driver.findElement(refferingDoc).click();
		Thread.sleep(1000);
		WebElement refferingDoc_1 = driver.findElement(refferingDoc);
		Assert.assertEquals(true, refferingDoc_1.isEnabled()); 
		System.out.println("Admitting_Doctor_1 field is enabled – Assert passed");
		Thread.sleep(1000);

		driver.findElement(search).sendKeys("Ram Patil");
		Thread.sleep(1000);
		driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		//Attending doctor
		driver.findElement(attendingCareDoc).click();
		WebElement attendingCareDoc_1 = driver.findElement(attendingCareDoc);
		Assert.assertEquals(true, refferingDoc_1.isEnabled()); 
		System.out.println("attendingCareDoc_1 field is enabled – Assert passed");

		driver.findElement(search).sendKeys("Ram Patil");
		Thread.sleep(1000);
		driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		//select date
		driver.findElement(DOA).sendKeys("27/11/2025");
		Thread.sleep(1000);
		driver.findElement(Payer_Type).click();
		Thread.sleep(1000);
		WebElement Payer_Type_1 = driver.findElement(Payer_Type);
		Assert.assertEquals(true, refferingDoc_1.isEnabled()); 
		System.out.println("Payer_Type_1 field is enabled – Assert passed");
		Thread.sleep(1000);
		driver.findElement(search).sendKeys("Panel");
		Thread.sleep(1000);
		driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(bedWard).sendKeys("27");
		Thread.sleep(1000);
		driver.findElement(notes).sendKeys("27");
		Thread.sleep(1000);
		driver.findElement(remarks).sendKeys("not feeling well");
		Thread.sleep(1000);
		File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp11 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot3, new File(".//ScreenShots//Modify_Existing_Patient_Admission_Request_fill_the_Admission Details.png"));
		Thread.sleep(1000);
		driver.findElement(save).click();
		Thread.sleep(1000);
		String Actaul = "Please fill the mandatory detail";
		String Expected = "confirm";
		Assert.assertEquals(Actaul, Expected, "Assertion pass patient confirmed successfully");
		Thread.sleep(1000);
		File screenshot31 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp111 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot31, new File(".//ScreenShots//Modify_Existing_Patient_Admission_Request_fill_the_mandatory_details.png"));
		Thread.sleep(1000);

	}

}
