package ADTpages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OPD_Registration_Encounter 
{
	WebDriver driver=null;
	//Encounter details
	//Encounter Tab
	By EncounterList=By.xpath("//span[contains(text(),'Encounter List')]");
	By EncounterTab=By.xpath("//*[@id=\"mat-tab-label-3-0\"]");

	//For all Drop down Search
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");

	//Encounter Type
	By EncounterTypeClick=By.cssSelector("mat-select[ng-reflect-name='encounterType']");
	By EncounterTypeSelOpt=By.xpath("//span[contains(text(),'New Case')]");

	//Specialty
	By SpecialityClick=By.cssSelector("mat-select[ng-reflect-name='department']");
	By SpecilitySelOPt=By.xpath("//span[contains(text(),'General Surgery')]");

	//Doctor
	By DoctorClick=By.cssSelector("mat-select[ng-reflect-name='doctor']");
	By DoctorSelOpt=By.xpath("//span[contains(text(),'Dr. Micheal Tan')]");

	//Clinic
	By ClinicClick=By.cssSelector("mat-select[ng-reflect-name='clinic']");
	By ClinicSelOpt=By.xpath("//span[contains(text(),'Consultation Room 1')]");

	//Counter
	By CounterClick=By.cssSelector("mat-select[ng-reflect-name='cashCounter']");
	By CounterSelOpt=By.xpath("//span[contains(text(),'REGISTRATION COUNTER 1')]");

	//Encounter Remarks
	By EncounterRemarks=By.cssSelector("textarea[formcontrolname='remarks']");

	//Encounter Notes
	By EncounterNotes=By.cssSelector("mat-icon[ng-reflect-message='Encounter Notes']");

	//Add Notes
	By AddNotes=By.cssSelector("input[ng-reflect-placeholder='Add Notes']");

	//Add Remark Button
	By AddRemarkButton=By.cssSelector("mat-icon[ng-reflect-message='Add Remark']");

	//Close Button
	By CloseButton=By.cssSelector("mat-icon[ng-reflect-message='Close']");

	//Referral Details

	//VisitReason
	By VisitReasonClick=By.cssSelector("mat-select[ng-reflect-name='visittype']");
	By VisitReasonSelOpt=By.xpath("//span[contains(text(),'Consultation & Treatment')]");

	//Patient Category
	By PatientCategoryClick=By.cssSelector("mat-select[ng-reflect-name='patientCategory']");
	By PatientCategorySelOpt=By.xpath("//span[contains(text(),'Senior Citizen')]");

	//Referral Type
	By ReferralTypeClick=By.cssSelector("mat-select[ng-reflect-name='referralType']");
	By ReferralTypeSelOpt=By.xpath("//span[contains(text(),'Emergency Referral')]");

	//Referral
	By ReferralClick=By.cssSelector("mat-select[ng-reflect-name='referral']");
	By ReferralSelOpt=By.xpath("//span[contains(text(),\"Dato' Dr. Jefri Zain \")]");

	//Patient Notes
	By PatientNotes12=By.cssSelector("textarea[ng-reflect-name='reportRemarks']");

	//Referral Remarks
	By ReferralRemarks12=By.cssSelector("textarea[ng-reflect-name='referralRemarks']");

	//Adding new payer Details

	By addPayerButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Add Payer']");

	//Payer Type
	By PayerTypeClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/table/tbody/tr[1]/td[2]/mat-select");
	By PayerTypeSelOpt=By.xpath("//span[contains(text(),'Insurance (PAYTYPE002)')]");

	//Payer
	By PayerClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/table/tbody/tr[1]/td[3]/mat-select");
	By PayerSelOpt=By.xpath("//span[contains(text(),'AIA Berhad (PAYER002)')]");

	//TariffInsurance2
	By TariffInsuranceClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/table/tbody/tr[1]/td[4]/mat-select");
	By TariffInsuranceSelOpt=By.xpath("//span[contains(text(),'Insurance Tariff')]");

	//selecting Tariff
	By TariffClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/table/tbody/tr[2]/td[4]/mat-select");
	By TariffSelOpt=By.xpath("//span[contains(text(),'Self Tariff')]");

	//Contract
	By ContractClick=By.cssSelector("mat-select[data-automation-attribute='encounterContract1']");
	By ContractSelOpt=By.xpath("//span[contains(text(),'Allianz Life Insurance Contract')]");

	//Policy Number
	By PolicyNumber=By.cssSelector("input[data-automation-attribute='encounterPolicyNumber0']");


	//Tab 2 Next Of Kin
	By NextKinTabClick=By.cssSelector("div[aria-controls='mat-tab-content-3-1']");

	//Next Of kin Details
	//Titles
	By TitleClick=By.cssSelector("mat-select[ng-reflect-name='prefix']");
	By TitleSelOpt=By.xpath("//span[contains(text(),'Tan Sri Dato Seri')]");

	//Name
	By NameClick=By.cssSelector("input[formcontrolname='name']");

	//Identification Type
	By IdentificationTypeClick=By.cssSelector("mat-select[ng-reflect-name='identificationType']");
	By IdentificationTypeSelOpt=By.xpath("//span[contains(text(),'Passport')]");

	//Identification Number
	By IdNumber=By.cssSelector("input[formcontrolname='identificationNumber']");

	//Relation
	By RelationClick=By.cssSelector("mat-select[ng-reflect-name='relation']");
	By RelationSelOpt=By.xpath("//span[contains(text(),'Mother')]");

	//Phone Number
	By PhoneNumber=By.cssSelector("input[formcontrolname='phoneNumber']");

	//Address Details
	//Address
	By AddressNClick=By.cssSelector("input[formcontrolname='address']");

	//Selecting Country
	By CountryNClick=By.cssSelector("mat-select[ng-reflect-name='country']");
	By CountryNSelOpt=By.xpath("//span[contains(text(),'Malaysia')]");

	//State
	By StateNClick=By.cssSelector("mat-select[ng-reflect-name='state']");
	By StateNSelOpt=By.xpath("//span[contains(text(),' Pulau Pinang ')]");

	//City
	By CityNClick=By.cssSelector("mat-select[ng-reflect-name='city']");
	By CityNSelOpt=By.xpath("//span[contains(text(),' Bukit Mertajam ')]");

	//Area
	By AreaNClick=By.cssSelector("mat-select[ng-reflect-name='district']");
	By AreaNSelOpt=By.xpath("//span[contains(text(),'None')]");

	//Postcode
	By PostCodeNClick=By.cssSelector("input[formcontrolname='postcode']");

	//Referral Button
	By ReferralNButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Add Referral']");

	//Save Button
	By SaveBUttonClick=By.cssSelector("mat-icon[ng-reflect-message='Save']");

	//Ok Button
	By OkButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");

	//Tab 3  Document   
	//Click on Document Tab
	By DocumentTabClick=By.cssSelector("div[aria-controls='mat-tab-content-3-2']");

	//Click on Upload button
	By UploadButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Upload Document']");

	//Click on Choose File Button
	By ChooseFIleClick=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-uploadfile/div/div[2]/table/tr/td/input");
	//Upload
	By UploadClick1=By.cssSelector("mat-icon[ng-reflect-message='Upload']");

	public void Encounter(String EncounterRemarksPar,String AddNotesPar,String NamePar,String IdentificationNOPar,String PhoneNoPar,String AddressPar,String PostcodeParAdetailsPar) throws InterruptedException, IOException, AWTException 
	{
		//Encounter details
		//Selecting Encounter tab
		
		Thread.sleep(3000);
		if(driver.getPageSource().contains("Payer Details")) 
		{
			System.out.println("Enconter Details page has been launched successfully"); 
		} else 
		{
			System.out.println("Encounter Details page failed to open"); 
		}
		Thread.sleep(2000);
		driver.findElement(EncounterTab).click();

		//Selecting Encounter Type
		Thread.sleep(1000);
		driver.findElement(EncounterTypeClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("New Case");
		Thread.sleep(1000);
		driver.findElement(EncounterTypeSelOpt).click();

		//Selecting Specialty
		Thread.sleep(1000);
		driver.findElement(SpecialityClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("General Surgery");
		Thread.sleep(1000);
		driver.findElement(SpecilitySelOPt).click();
		//Selecting Doctor
		Thread.sleep(1000);
		driver.findElement(DoctorClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Dr. Micheal Tan");
		Thread.sleep(1000);
		driver.findElement(DoctorSelOpt).click();
		//Clinic
		Thread.sleep(1000);
		driver.findElement(ClinicClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Consultation Room 1");
		Thread.sleep(1000);
		driver.findElement(ClinicSelOpt).click();
		//Selecting Counter
		Thread.sleep(1000);
		driver.findElement(CounterClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("REGISTRATION COUNTER 1");
		Thread.sleep(1000);
		driver.findElement(CounterSelOpt).click();
		//Encounter Remarks
		Thread.sleep(1000);
		driver.findElement(EncounterRemarks).sendKeys(EncounterRemarksPar);
		//Encounter Notes
		Thread.sleep(1000);
		driver.findElement(EncounterNotes).click();
		//Add Notes
		Thread.sleep(2000);
		driver.findElement(AddNotes).sendKeys(AddNotesPar);
		//Click on Add remark Button
		Thread.sleep(2000);
		driver.findElement(AddRemarkButton).click();
		//Click on close button  
		Thread.sleep(2000);
		driver.findElement(CloseButton).click();

		//Referral Details
		//Visit Reason
		Thread.sleep(1000);
		driver.findElement(VisitReasonClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Consultation & Treatment");
		Thread.sleep(1000);
		driver.findElement(VisitReasonSelOpt).click();
		/*//Patient Category
	Thread.sleep(1000);
	driver.findElement(PatientCategoryClick).click();
	Thread.sleep(1000);
	driver.findElement(PatientCategorySearch).sendKeys("Senior Citizen");
	Thread.sleep(1000);
	driver.findElement(PatientCategorySelOpt).click();*/
		//Referral type
		Thread.sleep(1000);
		driver.findElement(ReferralTypeClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Emergency Referral");
		Thread.sleep(1000);
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
	driver.findElement(ReferralRemarks12).sendKeys(ReferralRemarksPar);*/

		//Scrolling Encounter web page
		Thread.sleep(2000);
		Actions actions1 = new Actions(driver);
		actions1.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform(); 

		//Adding new Payer

		//Clicking on New payer button
		Thread.sleep(2000);
		driver.findElement(addPayerButtonClick).click();

		//Clicking on Payer Type
		Thread.sleep(2000);
		driver.findElement(PayerTypeClick).click();
		Thread.sleep(3000);
		driver.findElement(AllDropDownSearch).sendKeys("Insurance(PAYTYPE002)");
		Thread.sleep(2000);
		driver.findElement(PayerTypeSelOpt).click();	

		//Payer
		Thread.sleep(2000);
		driver.findElement(PayerClick).click();
		//Thread.sleep(3000);
		//driver.findElement(AllDropDownSearch).sendKeys("AIA Berhad (PAYER002)");
		Thread.sleep(2000);
		driver.findElement(PayerSelOpt).click();
		
		/*driver.findElement(PayerClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("AIA Berhad (PAYER002)");
		Thread.sleep(2000);
		driver.findElement(PayerSelOpt).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);*/
		
		//Insurance Tariff2
		Thread.sleep(2000);
		driver.findElement(TariffInsuranceClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Insurance Tariff");
		Thread.sleep(2000);
		driver.findElement(TariffInsuranceSelOpt).click();

		//COntract
		Thread.sleep(2000);
		driver.findElement(ContractClick).click();
		Thread.sleep(3000);
		driver.findElement(AllDropDownSearch).sendKeys("Allianz Life Insurance Contract");
		Thread.sleep(2000);
		driver.findElement(ContractSelOpt).click();
		
		//Policy Number
		Thread.sleep(2000);
		driver.findElement(PolicyNumber).sendKeys("653241");
		
		//selecting Tariff	 
		Thread.sleep(2000);
		driver.findElement(TariffClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Self Tariff");
		Thread.sleep(2000);
		driver.findElement(TariffSelOpt).click();

		//Adding new Payer

		//Tab 2 Next Of Kin
		//Clicking on Tab
		Thread.sleep(2000);
		driver.findElement(NextKinTabClick).click();

		//Next Of Kin details
		//Titles
		Thread.sleep(1000);
		driver.findElement(TitleClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Tan Sri Dato Seri");
		Thread.sleep(1000);
		driver.findElement(TitleSelOpt).click();
		//Name
		Thread.sleep(1000);
		driver.findElement(NameClick).sendKeys(NamePar);
		//Identification Type
		Thread.sleep(1000);
		driver.findElement(IdentificationTypeClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Passport");
		Thread.sleep(1000);
		driver.findElement(IdentificationTypeSelOpt).click();
		//Identification Number
		Thread.sleep(1000);
		driver.findElement(IdNumber).sendKeys(IdentificationNOPar);
		/*//Relation
	Thread.sleep(1000);
	driver.findElement(RelationClick).click();
	Thread.sleep(1000);
	driver.findElement(RelationClick).sendKeys("Mother");
	Thread.sleep(1000);
	driver.findElement(RelationSelOpt).click();*/
		//Phone Number
		Thread.sleep(1000);
		driver.findElement(PhoneNumber).sendKeys(PhoneNoPar);
		//Address Details
		//Address
		Thread.sleep(1000);
		driver.findElement(AddressNClick).sendKeys(AddressPar);	
		//Country
		Thread.sleep(1000);
		driver.findElement(CountryNClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Malaysia");
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		driver.findElement(AreaNClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("None");
		Thread.sleep(1000);
		driver.findElement(AreaNSelOpt).click();
		//Post code
		Thread.sleep(1000);
		driver.findElement(PostCodeNClick).sendKeys(PostcodeParAdetailsPar);
		//Click on Add referral Button
		Thread.sleep(1000);
		driver.findElement(ReferralNButtonClick).click();

		//Tab 3
		//Click on Tab 3 Button
		Thread.sleep(2000);
		driver.findElement(DocumentTabClick).click();
		//Click on Upload Button

		//Uploading Documents 
		//Click on Upload document button
		Thread.sleep(2000);
		driver.findElement(UploadButtonClick).click();

		//Click on choose File Button 

		Thread.sleep(3000);
		WebElement browse = driver.findElement(ChooseFIleClick);
		//click on ‘Choose file’ to upload the desired file
		browse.sendKeys("C:\\MedcareImg\\data.txt");

		Thread.sleep(3000);
		driver.findElement(UploadClick1).click();

		//Click on Save Button
		Thread.sleep(2000);
		driver.findElement(SaveBUttonClick).click();

		//Click on Ok Button
		Thread.sleep(3000);
		driver.findElement(OkButtonClick).click();

		//Switching On Main Window

		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());

		//Use the list of window handles to switch between windows
		Thread.sleep(1000);
		driver.switchTo().window((String)tabs.get(0));

		Actions act=new Actions(driver);
		WebElement overforopdslide2=driver.findElement(By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside"));
		act.moveToElement(overforopdslide2).build().perform();

		//Clicking on Encounter List
		Thread.sleep(3000);
		driver.findElement(EncounterList).click();	
		
		Thread.sleep(4000);
		WebElement patientName=driver.findElement(By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[5]"));
		WebElement VIPTag=driver.findElement(By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[5]/img[2]"));
		
		String ptName=patientName.getText();
		String VIPimgtag=VIPTag.getText();
		Thread.sleep(3000);
		if(driver.getPageSource().contains(ptName) && driver.getPageSource().contains(ptName)) 
		{
			System.out.println(ptName+" " +"Patient Has been Registred successfully"); 
		} else 
		{
			System.out.println("Encounter List page failed to open"); 
		}
		
	}
	public OPD_Registration_Encounter (WebDriver driver)
	{
		this.driver=driver;
	}
}
