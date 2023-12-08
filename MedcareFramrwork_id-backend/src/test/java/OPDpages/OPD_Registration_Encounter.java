package OPDpages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import OPDTest.DeleteExcelRowWithSelenium;

public class OPD_Registration_Encounter {

	WebDriver driver=null;
	//Encounter details

	By EncounterList=By.xpath("//span[contains(text(),'Encounter List')]");


	By EncounterTypeClick=By.cssSelector("mat-select[ng-reflect-name='encounterType']");
	By Search=By.cssSelector("input[aria-label='dropdown search']");
	By EncounterTypeSelOpt=By.xpath("//span[contains(text(),'New Case')]");
	//Specialty
	By SpecialityClick=By.cssSelector("mat-select[ng-reflect-name='department']");
	//By SpecialitySearch=By.xpath("//*[@id=\"mat-option-4194\"]/span/ngx-mat-select-search/div/input");
	By SpecilitySelOPt=By.xpath("//span[contains(text(),'General Surgery')]");
	//Doctor
	By DoctorClick=By.cssSelector("mat-select[ng-reflect-name='doctor']");
	//By DoctorSearch=By.xpath("//*[@id=\"mat-option-4190\"]/span/ngx-mat-select-search/div/input");
	By DoctorSelOpt=By.xpath("//span[contains(text(),'Dr. Micheal Tan')]");
	//Clinic
	By ClinicClick=By.cssSelector("mat-select[ng-reflect-name='clinic']");
	//By ClinicSearch=By.xpath("//*[@id=\"mat-option-4196\"]/span/ngx-mat-select-search/div/input");
	By ClinicSelOpt=By.xpath("//span[contains(text(),'Consultation Room 1')]");
	//Counter
	By CounterClick=By.cssSelector("mat-select[ng-reflect-name='cashCounter']");
	//By CounterSearch=By.xpath("//*[@id=\"mat-option-4198\"]/span/ngx-mat-select-search/div/input");
	By CounterSelOpt=By.xpath("//span[contains(text(),'REGISTRATION COUNTER 1')]");
	//Encounter Remarks
	By EncounterRemarks=By.cssSelector("textarea[ng-reflect-name='remarks']");
	//Encounter Notes
	By EncounterNotes=By.cssSelector("mat-icon[ng-reflect-message='Encounter Notes']");
	//Add Notes
	By AddNotes=By.cssSelector("input[ng-reflect-name='notes']");
	//Add Remark Button
	By AddRemarkButton=By.cssSelector("mat-icon[ng-reflect-message='Add Remark']");
	//Close Button
	By CloseButton=By.cssSelector("mat-icon[ng-reflect-message='Close']");

	//Referral Details
	//VisitReason
	By VisitReasonClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/form/div/div[2]/div[2]/div[1]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By VisitReasonSearch=By.xpath("//*[@id=\"mat-option-4200\"]/span/ngx-mat-select-search/div/input");
	By VisitReasonSelOpt=By.xpath("//span[contains(text(),'Consultation & Treatment')]");
	//Patient Category
	By PatientCategoryClick=By.xpath("mat-select[ng-reflect-name='patientCategory']");
	// By PatientCategorySearch=By.xpath("//*[@id=\"mat-option-4202\"]/span/ngx-mat-select-search/div/input");
	By PatientCategorySelOpt=By.xpath("//span[contains(text(),'Senior Citizen')]");
	//Referral Type
	By ReferralTypeClick=By.cssSelector("mat-select[ng-reflect-name='referralType']");
	//By ReferralTypeSearch=By.xpath("//*[@id=\"mat-option-4218\"]/span/ngx-mat-select-search/div/input");
	By ReferralTypeSelOpt=By.xpath("//span[contains(text(),'Emergency Referral')]");
	//Referral
	By ReferralClick=By.cssSelector("mat-select[ng-reflect-name='referral']");
	//By ReferralSearch=By.xpath("//*[@id=\"mat-option-4220\"]/span/ngx-mat-select-search/div/input");
	By ReferralSelOpt=By.xpath("//span[contains(text(),\"Dato' Dr. Jefri Zain \")]");
	//Patient Notes
	//By PatientNotes12=By.xpath("//*[@id=\"mat-input-102\"]");
	//Referral Remarks
	By ReferralRemarks12=By.cssSelector("textarea[ng-reflect-name='referralRemarks']");
	//selecting Tariff
	By TariffClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/table/tbody/tr/td[4]/mat-select");
	// By TariffSearch=By.xpath("//*[@id=\"mat-option-4226\"]/span/ngx-mat-select-search/div/input");
	By TariffSelOpt=By.xpath("//span[contains(text(),'Self Tariff')]");

	//Tab 2 Next Of Kin
	By NextKinTabClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/mat-tab-header/div/div/div/div[2]/div");

	//Next Of kin Details
	//Titles
	By TitleClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[1]/div[2]/div[1]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By TitleSearch=By.xpath("//*[@id=\"mat-option-4204\"]/span/ngx-mat-select-search/div/input");
	By TitleSelOpt=By.xpath("//span[contains(text(),'Tan Sri Dato Seri')]");
	//Name
	By NameClick=By.cssSelector("input[ng-reflect-name='name']");
	//Identification Type
	By IdentificationTypeClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[1]/div[2]/div[3]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By IdentificationTypeSearch=By.xpath("//*[@id=\"mat-option-4206\"]/span/ngx-mat-select-search/div/input");
	By IdentificationTypeSelOpt=By.xpath("//span[contains(text(),'Passport')]");
	//Identification Number
	By IdNumber=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[1]/div[3]/div[1]/mat-form-field/div/div[1]/div[3]/input");
	//Relation
	By RelationClick=By.cssSelector("mat-select[ng-reflect-name='relation']");
	//By RelationSearch=By.xpath("//*[@id=\"mat-option-4208\"]/span/ngx-mat-select-search/div/input");
	By RelationSelOpt=By.xpath("//span[contains(text(),'Mother')]");
	//Phone Number
	By PhoneNumber=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[1]/div[3]/div[3]/mat-form-field/div/div[1]/div[3]/input");

	//Address Details
	//Address
	By AddressNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[2]/div[2]/div[1]/mat-form-field/div/div[1]/div[3]/input");
	//Selecting Country
	By CountryNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[2]/div[2]/div[2]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By CountryNSearch=By.xpath("//*[@id=\"mat-option-4210\"]/span/ngx-mat-select-search/div/input");
	By CountryNSelOpt=By.xpath("//span[contains(text(),'Malaysia')]");
	//State
	By StateNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[2]/div[2]/div[3]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By StateNSearch=By.xpath("//*[@id=\"mat-option-4212\"]/span/ngx-mat-select-search/div/input");
	By StateNSelOpt=By.xpath("//span[contains(text(),' Pulau Pinang ')]");
	//City
	By CityNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[2]/div[3]/div[1]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By CityNSearch=By.xpath("//*[@id=\"mat-option-4214\"]/span/ngx-mat-select-search/div/input");
	By CityNSelOpt=By.xpath("//span[contains(text(),' Bukit Mertajam ')]");
	//Area
	By AreaNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[2]/div[3]/div[2]/app-master-form-field/div/mat-form-field/div/div[1]/div[3]/mat-select");
	//By AreaNSearch=By.xpath("//*[@id=\"mat-option-4216\"]/span/ngx-mat-select-search/div/input");
	By AreaNSelOpt=By.xpath("//span[contains(text(),'None')]");
	//Postcode
	By PostCodeNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/form/div/div[1]/div[2]/div[3]/div[3]/mat-form-field/div/div[1]/div[3]/input");
	//Referral Button
	By ReferralNButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Add Referral']");

	//Save Button
	By SaveBUttonClick=By.cssSelector("mat-icon[ng-reflect-message='Save']");
	//Ok Button
	By OkButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");

	//Tab 3  Document  
	//Click on Document Tab
	By DocumentTabClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/mat-tab-header/div/div/div/div[3]/div");

	//Click on Upload button
	By UploadButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Upload Document']");

	//Click on Choose File Button
	By ChooseFIleClick=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-uploadfile/div/div[2]/table/tr/td/input");
	//Upload
	By UploadClick1=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-uploadfile/div/div[3]/div/button/span[1]/mat-icon");


	public OPD_Registration_Encounter(WebDriver driver) {
		this.driver= driver;
	}

	public void Encounter(String EncounterRemarksPar,String AddNotesPar,String NamePar,String IdentificationNOPar,String PhoneNoPar,String AddressPar,String PostcodeParAdetailsPar) throws InterruptedException, IOException, AWTException
	{


		// Create object and take the data from another class
		DeleteExcelRowWithSelenium  data = new DeleteExcelRowWithSelenium();
		String EnterPatientName=data.TkaePatientName;
		System.out.println("Print the patient name" + EnterPatientName);



		Thread.sleep(5000);
		if(driver.getPageSource().contains("Encounter Details")) 
		{
			System.out.println("Regiteration completed sucessfully"); 
		} else 
		{
			System.out.println("Regiteration has been failed"); 
		}

		//Selecting Encounter Type
		Thread.sleep(2000);
		driver.findElement(EncounterTypeClick).click();
		Thread.sleep(1000);
		driver.findElement(Search).sendKeys("New Case");
		Thread.sleep(1000);
		driver.findElement(EncounterTypeSelOpt).click();

		//Selecting Specialty
		Thread.sleep(1000);
		driver.findElement(SpecialityClick).click();
		Thread.sleep(1000);
		driver.findElement(Search).sendKeys("General Surgery");
		Thread.sleep(1000);
		driver.findElement(SpecilitySelOPt).click();
		//Selecting Doctor
		Thread.sleep(1000);
		driver.findElement(DoctorClick).click();
		Thread.sleep(1000);
		driver.findElement(Search).sendKeys("Dr. Micheal Tan");
		Thread.sleep(1000);
		driver.findElement(DoctorSelOpt).click();
		//Clinic
		Thread.sleep(500);
		driver.findElement(ClinicClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("Consultation Room 1");
		Thread.sleep(500);
		driver.findElement(ClinicSelOpt).click();
		//Selecting Counter
		Thread.sleep(500);
		driver.findElement(CounterClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("REGISTRATION COUNTER 1");
		Thread.sleep(500);
		driver.findElement(CounterSelOpt).click();
		//Encounter Remarks
		Thread.sleep(500);
		driver.findElement(EncounterRemarks).sendKeys(EncounterRemarksPar);
		//Encounter Notes
		Thread.sleep(500);
		driver.findElement(EncounterNotes).click();
		//Add Notes
		Thread.sleep(500);
		driver.findElement(AddNotes).sendKeys(AddNotesPar);
		//Click on Add remark Button
		Thread.sleep(500);
		driver.findElement(AddRemarkButton).click();
		//Click on close button  
		Thread.sleep(500);
		driver.findElement(CloseButton).click();

		//Referral Details
		//Visit Reason
		Thread.sleep(500);
		driver.findElement(VisitReasonClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("Consultation & Treatment");
		Thread.sleep(500);
		driver.findElement(VisitReasonSelOpt).click();
		/*//Patient Category
Thread.sleep(1000);
driver.findElement(PatientCategoryClick).click();
Thread.sleep(1000);
driver.findElement(PatientCategorySearch).sendKeys("Senior Citizen");
Thread.sleep(1000);
driver.findElement(PatientCategorySelOpt).click();*/
		//Referral type
		Thread.sleep(500);
		driver.findElement(ReferralTypeClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("Emergency Referral");
		Thread.sleep(500);
		driver.findElement(ReferralTypeSelOpt).click();

		/*//Selecting referral
Thread.sleep(1000);
driver.findElement(ReferralClick).click();
Thread.sleep(2000);
driver.findElement(ReferralSearch).sendKeys("Dato' Dr. Jefri Zain");
Thread.sleep(2000);
driver.findElement(ReferralSelOpt).click();
//Patient Notes
Thread.sleep(1000);
driver.findElement(PatientNotes12).sendKeys(PatientNotesPar);

//Referral remarks
Thread.sleep(1000);
driver.findElement(ReferralRemarks12).sendKeys(ReferralRemarksPar);

//Scrolling Encounter web page
Thread.sleep(2000);
Actions actions1 = new Actions(driver);
actions1.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform(); */

		//selecting Tariff
		Thread.sleep(5000);
		driver.findElement(TariffClick).click();
		Thread.sleep(5000);
		driver.findElement(Search).sendKeys("Self Tariff");
		Thread.sleep(5000);
		driver.findElement(TariffSelOpt).click();
		Thread.sleep(5000);


		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//Encounterdetails.png"));


		//Tab 2 Next Of Kin
		//Clicking on Tab
		Thread.sleep(500);
		driver.findElement(NextKinTabClick).click();

		//Next Of Kin details
		//Titles
		Thread.sleep(500);
		driver.findElement(TitleClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("Tan Sri Dato Seri");
		Thread.sleep(500);
		driver.findElement(TitleSelOpt).click();
		//Name
		Thread.sleep(500);
		driver.findElement(NameClick).sendKeys(NamePar);
		//Identification Type
		Thread.sleep(500);
		driver.findElement(IdentificationTypeClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("Passport");
		Thread.sleep(500);
		driver.findElement(IdentificationTypeSelOpt).click();
		//Identification Number
		Thread.sleep(500);
		driver.findElement(IdNumber).sendKeys(IdentificationNOPar);
		/*//Relation
Thread.sleep(1000);
driver.findElement(RelationClick).click();
Thread.sleep(1000);
driver.findElement(RelationClick).sendKeys("Mother");
Thread.sleep(1000);
driver.findElement(RelationSelOpt).click();*/
		//Phone Number
		Thread.sleep(500);
		driver.findElement(PhoneNumber).sendKeys(PhoneNoPar);
		//Address Details
		//Address
		Thread.sleep(500);
		driver.findElement(AddressNClick).sendKeys(AddressPar);
		//Country
		Thread.sleep(500);
		driver.findElement(CountryNClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("Malaysia");
		Thread.sleep(500);
		driver.findElement(CountryNSelOpt).click();
		/*//State
Thread.sleep(1000);
driver.findElement(StateNClick).click();
Thread.sleep(1000);
driver.findElement(CityNSearch).sendKeys("Pulau Pinang");
Thread.sleep(1000);
driver.findElement(CityNSelOpt).click();
//City
Thread.sleep(1000);
driver.findElement(CityNClick).click();
Thread.sleep(1000);
driver.findElement(CityNSearch).sendKeys("Bukit Mertajam");
Thread.sleep(1000);
driver.findElement(CityNSelOpt).click();*/
		//Area
		Thread.sleep(500);
		driver.findElement(AreaNClick).click();
		Thread.sleep(500);
		driver.findElement(Search).sendKeys("None");
		Thread.sleep(500);
		driver.findElement(AreaNSelOpt).click();
		//Post code
		Thread.sleep(500);
		driver.findElement(PostCodeNClick).sendKeys(PostcodeParAdetailsPar);
		//Click on Add referral Button
		Thread.sleep(500);
		driver.findElement(ReferralNButtonClick).click();
		Thread.sleep(2000);
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File(".//ScreenShots//NextOfKindetails.png"));

		//Tab 3
		//Click on Tab 3 Button

		Thread.sleep(500); 
		//Click on Upload Button
		driver.findElement(DocumentTabClick).click(); 

		//Uploading Documents //Click on Upload document button Thread.sleep(500);
		driver.findElement(UploadButtonClick).click();

		//Click on choose File Button

		Thread.sleep(2000); 
		WebElement browse = driver.findElement(ChooseFIleClick);
		//click on ‘Choose file’ to upload the desired file

		String projectpath = System.getProperty("user.dir");
		StringSelection ss = new StringSelection(projectpath + "\\Text file\\Demo.txt");
		browse.sendKeys(projectpath + "\\Text file\\Demo.txt");
		// browse.sendKeys("C:\\Users\\Kamlakar\\Desktop\\kk.txt.txt");

		Thread.sleep(500);
		driver.findElement(UploadClick1).click();

		//Click on Save Button
		Thread.sleep(1000);
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot2, new File(".//ScreenShot//Uploaddocs.png"));

		Thread.sleep(500);
		driver.findElement(SaveBUttonClick).click();
		//Click on Ok Button
		Thread.sleep(500);
		driver.findElement(OkButtonClick).click();
		Thread.sleep(1000);
		File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot3, new File(".//ScreenShot//Encounter.png"));

		Thread.sleep(10000);
		String winHandleBefore = driver.getWindowHandle();
		//Thread.sleep(8000);
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(15000);


		Actions act=new Actions(driver);
		WebElement overforopdslide2=driver.findElement(By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside"));
		act.moveToElement(overforopdslide2).build().perform();

		//Clicking on Encounter List
		Thread.sleep(3000);
		driver.findElement(EncounterList).click();

		Thread.sleep(5000);
		/*
		 * if(driver.getPageSource().contains(EnterPatientName)) { System.out.
		 * println("Patient has been created successfully and visible on encounter list "
		 * ); } else {
		 * System.out.println("Patient not created and visible on encounter list"); }
		 */

		File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot4, new File(".//ScreenShots//Patient has been created successfully and visible on encounter list .png"));


	}
}



