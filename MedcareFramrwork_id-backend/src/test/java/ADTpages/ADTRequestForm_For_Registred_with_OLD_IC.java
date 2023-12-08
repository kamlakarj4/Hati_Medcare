package ADTpages;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ADTRequestForm_For_Registred_with_OLD_IC 
{
	
	
	WebDriver driver;
	By mainmenu=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By OPDMenu=By.xpath("//*[@id='mat-menu-panel-6']/div/div/div[1]/div[1]/div[1]/div");
	By SideBarMenu=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By RegistrationMenu=By.cssSelector("a[id='2004']");
	By EncounterListClick=By.xpath("//span[contains(text(),'Encounter List')]");
	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	//ADT
	By ADT=By.xpath("//span[contains(text(),'ADT')]");
	//AddButton
	By AddButton=By.cssSelector("mat-icon[ng-reflect-message='Add Admission Request']");
	//PrimaryIdentification
	By PriID=By.cssSelector("mat-select[ng-reflect-name='primaryId']");
	By Prisearch=By.cssSelector("input[aria-label='dropdown search']");
	By Priselect=By.xpath("//span[contains(text(),'Passport')]");
	//PriNumber
	By PriNumber=By.cssSelector("input[ng-reflect-name='primaryDocNo']");
	//Name
	By Name=By.cssSelector("input[ng-reflect-name='fullName']");
	//ExpiryDate
	By ExpiryDate=By.cssSelector("input[ng-reflect-placeholder='Expiry Date']");
	//Title
	By Title=By.cssSelector("mat-select[ng-reflect-name='prefix']");
	By Titlesearch=By.cssSelector("input[aria-label='dropdown search']");
	By Titleselect=By.xpath("//span[contains(text(),\"Tan Sri Dato'\")]");
	//Gender
	By Gender=By.cssSelector("mat-select[ng-reflect-name='gender']");
	By Gendersearch=By.cssSelector("input[aria-label='dropdown search']");
	By Genderselect=By.xpath("//span[contains(text(),'MALE')]");
	//DOB
	By DOB=By.cssSelector("input[ng-reflect-name='dob']");
	//Mobile 
	By Mobile=By.cssSelector("input[ng-reflect-name='mobileNo']");
	//Email
	By Email=By.cssSelector("input[ng-reflect-name='emailId']");
	//AdmittingDoctor
	By Admdoctor=By.cssSelector("mat-select[ng-reflect-name='primaryCareDoc']");
	By AdmDctsearch=By.cssSelector("input[aria-label='dropdown search']");
	By AdmDctselect=By.xpath("//span[contains(text(),'AMAN')]");
	//AdmittingDepartment 
	By AdmDepartment=By.cssSelector("mat-select[ng-reflect-name='primaryCareDept']");
	By AdmDepsearch=By.cssSelector("input[aria-label='dropdown search']");
	By AdmDepselect=By.xpath("//span[contains(text(),'Cardiology')]");
	//AttendingDoctor
	By AttendDoctor=By.cssSelector("mat-select[ng-reflect-name='attendingCareDoc']");
	By AttendDctsearch=By.cssSelector("input[aria-label='dropdown search']");
	By AttendDctselect=By.xpath("//span[contains(text(),'Dr. Salina Yusof')]");
	//ReferringDoctor
	By ReferringDoctor=By.cssSelector("mat-select[ng-reflect-name='refferingDoc']");
	By ReferringDctsearch=By.cssSelector("input[aria-label='dropdown search']");
	By ReferringDctselect=By.xpath("//span[contains(text(),'Dr. James Raman')]");
	//AdmissionType
	By Admissiontype=By.cssSelector("mat-select[ng-reflect-name='typeOfAdmission']");
	By Admissiontypesearch=By.cssSelector("input[aria-label='dropdown search']");
	By Admissiontypeselect=By.xpath("//span[contains(text(),'Elective')]");
	//ReasonAdmission
	By ReasonAdmission=By.cssSelector("mat-select[ng-reflect-name='reasonOfAdmission']");
	By ReasonAdmsearch=By.cssSelector("input[aria-label='dropdown search']");
	By ReasonAdmselect=By.xpath("//span[contains(text(),'Admitted')]");
	//DOA
	By DOA=By.cssSelector("input[ng-reflect-name='DOA']");
	//Length
	By Length=By.cssSelector("input[ng-reflect-name='ELS'");
	//FinancialClass
	By Financialclass=By.cssSelector("mat-select[ng-reflect-name='financialClass']");
	By Financialsearch=By.cssSelector("input[aria-label='dropdown search']");
	By Financialselect=By.xpath("//span[contains(text(),'Third Class')]");
	//BedCategory 
	By Bedcategory=By.cssSelector("mat-select[ng-reflect-name='bedCategory']");
	By Bedcatsearch=By.cssSelector("input[aria-label='dropdown search']");
	By Bedcatselect=By.xpath("//span[contains(text(),'4-Bedded')]");
	//PayerType
	By Payertype=By.cssSelector("mat-select[ng-reflect-name='paymentEntitlement']");
	By Payertypesearch=By.cssSelector("input[aria-label='dropdown search']");
	By Payertypeselect=By.xpath("//span[contains(text(),'Insurance')]");
	//Notes
	By Notes=By.cssSelector("input[ng-reflect-name='notes']");
	//Remarks 
	By Remarks=By.cssSelector("input[ng-reflect-name='remarks'");
	//Save 
	By Save=By.cssSelector("mat-icon[ng-reflect-message='Save']");
	//ConfirmButton
	By ConfirmButton=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
	//Edit 
	By Edit=By.cssSelector("mat-icon[ng-reflect-message='Save Admission']");
	//Registered Radio button
	By RegisteredButtonClick=By.cssSelector("mat-radio-button[ng-reflect-value='registered']");
	//Advance Search
	By AdvancedSearchclick=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	//MRD Field
	By MRNTextClick=By.cssSelector("input[ng-reflect-name='mrn']");
	//Search button Click
	By SearchButtonClick=By.cssSelector("button[ng-reflect-message='Search']");
	//patient MRN From Encounter List
		By PatientMRN=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[4]");

	public void ADT_Request_Registered_With_OLD_IC(String MRNPar,String EmailPar, String DOAPar, String LengthPar, String NotesPar, String RemarksPar) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele=driver.findElement(mainmenu);
		act.moveToElement(ele).build().perform();
		act.click(ele).perform();
		Thread.sleep(5000);
		driver.findElement(OPDMenu).click();

		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenu);
		act.moveToElement(overforopdslide1).build().perform();
		
		Thread.sleep(5000);
		driver.findElement(RegistrationMenu).click();
		driver.findElement(RegistrationMenu).click();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		driver.findElement(EncounterListClick).click();
		
		Thread.sleep(3000);
		WebElement PTMRN=driver.findElement(PatientMRN);
		String PatientMRN=PTMRN.getText();
		System.out.println("MRN From ENcounter list"+PatientMRN);
		
		Actions act1 = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele1=driver.findElement(mainmenuADTScreen);
		act.moveToElement(ele1).build().perform();
		act1.click(ele1).perform();
		//Thread.sleep(2000);

		//ADT
		Thread.sleep(3000);
		driver.findElement(ADT).click();

		//Condition
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Admission Date"))
		{
			System.out.println("Admission Request Screen Appear");

		}
		else
		{
			System.out.println("Admission Request Screen not appear");
		}

		//ScreenShot1
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1,new File(".//ScreenShot//AdmissionRequest1.png"));

		//AddButton
		Thread.sleep(3000);
		driver.findElement(AddButton).click();

		//Condition2
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Admission Details"))
		{
			System.out.println("Admission Request form open");
		}
		else
		{
			System.out.println("Admission Request form not open");
		}

		//ScreenShot1
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot2,new File(".//ScreenShot//AdmissionRequest2.png"));

		//Clicking on Registered Radio button
		Thread.sleep(2000);
		driver.findElement(RegisteredButtonClick).click();

		//Clicking on Advanced search
		Thread.sleep(2000);
		driver.findElement(AdvancedSearchclick).click();

		//Sending MRN
		Thread.sleep(2000);
		driver.findElement(MRNTextClick).sendKeys(PatientMRN);

		//Clicking on Search button
		Thread.sleep(2000);
		driver.findElement(SearchButtonClick).click();

		/* //PrimaryID
		Thread.sleep(2000);
		driver.findElement(PriID).click();
		driver.findElement(Prisearch).sendKeys("Passport");
		driver.findElement(Priselect).click();

		//PriNumber
		Date d=new Date(System.currentTimeMillis()+ System.nanoTime());
		Long id=d.getTime();
		Thread.sleep(2000);
		driver.findElement(PriNumber).sendKeys(PriNumberPar+id);
		System.out.println("id="+id);

		//Name
		Thread.sleep(2000);
		driver.findElement(Name).sendKeys(PatientNamePar);

		//ExpiryDate
		Thread.sleep(2000);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDatePar);

		//Title
		Thread.sleep(2000);
		driver.findElement(Title).click(); 
		driver.findElement(Titlesearch).sendKeys("Tan Sri Dato'");
		driver.findElement(Titleselect).click();

		//Gender
		Thread.sleep(2000);
		driver.findElement(Gender).click();
		driver.findElement(Gendersearch).sendKeys("MALE");
		driver.findElement(Genderselect).click();

		//DOB
		Thread.sleep(2000);
		driver.findElement(DOB).sendKeys(DOBPar);

		//Mobile 
		Thread.sleep(2000);
		driver.findElement(Mobile).sendKeys(MobilePar);*/

		//Email
		Thread.sleep(2000);
		driver.findElement(Email).sendKeys(EmailPar);

		//AdmittingDoctor
		Thread.sleep(2000);
		driver.findElement(Admdoctor).click();
		driver.findElement(AdmDctsearch).sendKeys("AMAN");
		driver.findElement(AdmDctselect).click();
		
		//AdmittingDepartment
		Thread.sleep(2000);
		driver.findElement(AdmDepartment).click();
		driver.findElement(AdmDepsearch).sendKeys("Cardiology");
		driver.findElement(AdmDepselect).click();

		//AttendingDoctor
		Thread.sleep(2000);
		driver.findElement(AttendDoctor).click();
		driver.findElement(AttendDctsearch).sendKeys("Dr. Salina Yusof");
		driver.findElement(AttendDctselect).click();

		//RefDoctor
		Thread.sleep(2000);
		driver.findElement(ReferringDoctor).click();
		driver.findElement(ReferringDctsearch).sendKeys("Dr. James Raman");
		driver.findElement(ReferringDctselect).click();

		//AdmissionType
		Thread.sleep(2000);
		driver.findElement(Admissiontype).click();
		driver.findElement(Admissiontypesearch).sendKeys("Elective");
		driver.findElement(Admissiontypeselect).click();

		//ReasonAdmission
		Thread.sleep(2000);
		driver.findElement(ReasonAdmission).click();
		driver.findElement(ReasonAdmsearch).sendKeys("Admitted");
		driver.findElement(ReasonAdmselect).click();

		//Date of Admission
		LocalDateTime dt = LocalDateTime.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String myDate = dt.format(df);
		Thread.sleep(2000);
		driver.findElement(DOA).sendKeys(myDate);

		//Length
		Thread.sleep(2000);
		driver.findElement(Length).sendKeys(LengthPar);

		//FinancialClass
		Thread.sleep(2000);
		driver.findElement(Financialclass).click();
		driver.findElement(Financialsearch).sendKeys("Third Class");
		driver.findElement(Financialselect).click();

		//BedCategory 
		Thread.sleep(2000);
		driver.findElement(Bedcategory).click();
		driver.findElement(Bedcatsearch).sendKeys("4-Bedded");
		driver.findElement(Bedcatselect).click();

		//PayerType
		Thread.sleep(2000);
		driver.findElement(Payertype).click();
		driver.findElement(Payertypesearch).sendKeys("Insurance");
		driver.findElement(Payertypeselect).click();

		//Notes
		Thread.sleep(2000);
		driver.findElement(Notes).sendKeys(NotesPar);

		//Remarks
		Thread.sleep(2000);
		driver.findElement(Remarks).sendKeys(RemarksPar);
		//Save
		Thread.sleep(2000);
		driver.findElement(Save).click();

		//ConfirmButton
		Thread.sleep(2000);
		driver.findElement(ConfirmButton).click();

		//Edit 
		Thread.sleep(5000);
		driver.findElement(Edit).click();  
	}

	public ADTRequestForm_For_Registred_with_OLD_IC (WebDriver driver)

	{
		this .driver=driver;

	}
}