package OPDpages;

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

public class UpdateSponsorPayerDelete {
	
	WebDriver driver=null;
	
	//MENU
	By mainmenu=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By OPDMenu1=By.xpath("//span[contains(text(),'OPD')]");
	By SideBarMenu1=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By RegistrationMenu=By.xpath("//*[@id='2004']");
	By EncounterListClick=By.xpath("//span[contains(text(),'Encounter List')]");
	//Quick Registration
	By QuickRegistrationClick=By.xpath("//span[contains(text(),'Quick Registration')]");

	//Basic Information
	//for all search same xpath
		By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
		
	//PrimaryID
	By Primaryidclick=By.cssSelector("mat-select[ng-reflect-name='primaryId']");
	By Primaryidselectvalue=By.xpath("//span[contains(text(),' Passport ')]");

	//PrimaryIDnumber
	By PrimaryIDnumberclick=By.cssSelector("input[formcontrolname='primaryNumber']");

	//ExpiryDate
	By Expirydateclick=By.cssSelector("input[formcontrolname='expiryDate']");

	//Title
	By Titleclick=By.cssSelector("mat-select[ng-reflect-name='prefix']");
	By Titleselectvalue=By.xpath("//span[contains(text(),'Tan Sri Datuk')]");

	//Name 
	By Nameclick=By.cssSelector("input[formcontrolname='firstName']");

	//Gender
	By Genderclick=By.cssSelector("mat-select[ng-reflect-name='gender']");
	By Genderselectvalue=By.xpath("//span[contains(text(),' FEMALE ')]");

	//DOB
	By DOBclick=By.cssSelector("input[ng-reflect-name='dateOfBirth']");

	//CountryCode
	By CountryCodeclick=By.cssSelector("mat-select[ng-reflect-name='countryCodemobile']");
	By CountryCodeselectvalue=By.xpath("//span[contains(text(),' +213 ')]");

	//MobielNo
	By Mobilenoclick=By.cssSelector("input[formcontrolname='mobileNumber']");
	
	//Encounter Details
	//EncounterType
	By EncoujnterTypeclick=By.cssSelector("mat-select[ng-reflect-name='encounterType']");
	By EncounterTypeselectvalue=By.xpath("//span[contains(text(),' New Case ')]");

	//SpecialityField
	By Specialityfieldclick=By.cssSelector("mat-select[ng-reflect-name='department']");
	By Specialityfieldselect=By.xpath("//span[contains(text(),' General Surgery ')]");

	//Doctor
	By Doctorclick=By.cssSelector("mat-select[ng-reflect-name='doctor']");
	By Doctorselect=By.xpath("//span[contains(text(),'Dr. Micheal Tan')]");

	//Clinic
	By Clinicclick=By.cssSelector("mat-select[ng-reflect-name='clinic']");
	By Clinicselect=By.xpath("//span[contains(text(),'Consultation Room 1')]");

	//Counter 
	By Counterclick=By.cssSelector("mat-select[ng-reflect-name='cashCounter']");
	By Counterselect=By.xpath("//span[contains(text(),' REGISTRATION COUNTER 1 ')]");

	//ENcounter Remarks
	By EncounterRemarksclick=By.cssSelector("textarea[formcontrolname='remarks']");
	
	//Encounter Notes Button
	By EncounterNotesButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Encounter Notes']");
	
	//Add Notes
	By AddNotesClick=By.cssSelector("input[ng-reflect-name='notes']");
	
	//Add Remark Button
	By AddRemarkButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Add Remark']");
	
	//Close Button
	By CloseButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Close']");
	
	//Referral Details
	//Visit Reason
	By VisitReasonClick=By.cssSelector("mat-select[ng-reflect-name='visittype']");
	By VisitReasonSelOpt=By.xpath("//span[contains(text(),' Consultation & Treatment ')]");
	
	//ReferralType
	By ReferralTypeClick=By.cssSelector("mat-select[ng-reflect-name='referralType']");
	By ReferralTypeSelOpt=By.xpath("//span[contains(text(),' Emergency Referral ')]");
	
	//Referral
	By ReferralClick=By.cssSelector("mat-select[ng-reflect-name='referral']");
	By ReferralSelOpt=By.xpath("//span[contains(text(),\"Dato' Dr. Jefri Zain \")]");
	
	//Patient Category
	By PatientCategoryClick=By.cssSelector("mat-select[ng-reflect-name='patientCategory']");
	By PatientCategorySelOpt=By.xpath("//span[contains(text(),' Senior Citizen ')]");
	
	//Encounter Notes
	By EncounterNotesClick=By.cssSelector("input[formcontrolname='practiceNotes']");
	
	//Patient Notes
	By PatientNotes=By.cssSelector("textarea[formcontrolname='reportRemarks']");
	
	//Referral Remarks
	By ReferralRemarksClick=By.cssSelector("textarea[formcontrolname='referralRemarks']");	
	
	//Tariff
	By Tariffclick12=By.cssSelector("mat-select[aria-labelledby='mat-select-value-55']");
	By Tariffselect12=By.xpath("//span[contains(text(),'Self Tariff')]");
	
	//Save 
		By Saveclick=By.cssSelector("mat-icon[ng-reflect-message='Save']");
		By Saveconfirm=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
		

	//---UpdateSponsor-->
	
	
	
		//SideMenu
		By SideBarMenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside");

		//UpdateSponsor
		
		By UpdateSponsor=By.cssSelector("a[ng-reflect-router-link='updateSponsor']");
		
		//AdvanceSearch
		By Advancesearchclick=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
		By MRNSearch=By.cssSelector("input[ng-reflect-name='mrn']");
		By Searchclick=By.cssSelector("button[ng-reflect-message='Search']");
		
		//SelectPatient
		By SelectPatient=By.cssSelector("mat-radio-group[ng-reflect-message='Payer Tariff']");
		
		//AddButton
		By AddButton=By.cssSelector("mat-icon[ng-reflect-message='Add Sponsor']");
		
		//PayerType
		By PayerType=By.cssSelector("mat-select[ng-reflect-name='payerType']");
		By PayertypeSearch=By.cssSelector("input[aria-label='dropdown search']");
		By PayertypeSelect=By.xpath("//span[contains(text(),'Insurance')]");
		
		//Payer
		By payerclick=By.cssSelector("mat-select[ng-reflect-name='payer']");
		By payersearch=By.cssSelector("input[aria-label='dropdown search']");
		By payerselect=By.xpath("//span[contains(text(),'AIA Berhad')]");
		
		//Tariff
		By Tariff=By.cssSelector("mat-select[ng-reflect-name='tariff']");
		By Tariffsearch=By.cssSelector("input[aria-label='dropdown search']");
		By Tariffselect=By.xpath("//span[contains(text(),'Insurance Tariff')]");
		
		//Contract
		By Contract=By.cssSelector("mat-select[ng-reflect-name='contract']");
		By ContractSearch=By.cssSelector("input[aria-label='dropdown search']");
		By Contractselect=By.xpath("//span[contains(text(),'Allianz Life Insurance Contract')]");
		
		//AssociateCompany 
		By AssociateCompany=By.cssSelector("mat-select[ng-reflect-name='AssociateCompany']");
		By AssociateCompanysearch=By.cssSelector("input[aria-label='dropdown search']");
		By AssocaiteCompanySelect=By.xpath("//span[contains(text(),' GE - OCBC Bank ')]");
		
		//PolicyNumber
		By PolicyNumber=By.cssSelector("input[formcontrolname='policyNo']");
		
		//EffectiveDate
		By EffectiveDate=By.cssSelector("input[ng-reflect-name='GLEffectiveDate']");
		
		//Save1
		By Savebutton1=By.cssSelector("mat-icon[ng-reflect-message='Save Sponsor']");
		
		//Confirmation
		By Confirmation=By.cssSelector("mat-icon[ng-reflect-message=\"Yes\"]");
		
		//Save2
		By Savebutton2=By.cssSelector("button[ng-reflect-message='Save Sponsor']");
		
		//Confirmation2 
		By Confirmation2=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
		
		
		//CreatedMRN
		By CreatedMRN=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[4]");
		
		//AdvanceSearch2
		By Advancesearchclick2=By.cssSelector("mat-icon[ng-reflect-message='Collapse']");
		By MRNSearch2=By.cssSelector("input[ng-reflect-name='mrn']");
		By Searchclick2=By.cssSelector("button[ng-reflect-message='Search']");
		
		//ClickonRadio
		By RadioButton=By.cssSelector("mat-radio-group[ng-reflect-message='Payer Tariff']");
		
		
		//DeleteIcon
		By DeleteIcon=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-update-sponsor/div[5]/table/tbody/tr[1]/td[11]/button[1]");
		
		//Reason
		By ReasonClick=By.cssSelector("mat-select[ng-reflect-name='first']");
		By ReasonSelect=By.xpath("//span[contains(text(),'For Consultation')]");
		
		//Remarks
		By DeleteRemarks=By.cssSelector("textarea[ng-reflect-name='remark']");
		
		//SAVE
		By DeleteSave=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
		
		//Save2
			By Savebutton3=By.cssSelector("button[ng-reflect-message='Save Sponsor']");
		
			//Confirmation2 
			By Confirmation3=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
			
			//AdvanceSearch2
			By Advancesearchclick3=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
			By UpdatedMRN=By.cssSelector("input[ng-reflect-name='mrn']");
			By Searchclick3=By.cssSelector("button[ng-reflect-message='Search']");
			
			
		public UpdateSponsorPayerDelete (WebDriver driver)
		{
			this.driver=driver;
		}
			

  public void UpdateSponsorDelete(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickDateOfBirthPar,String QuickFullNamePar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar, String PolicyNumberPar, String EffectivedatePar,String ReasonSelectPar,String DeleteRemarksPar) throws InterruptedException, IOException 
{
	
	//Clicking on menu Icon
			Thread.sleep(3000);
			Actions act = new Actions(driver);
			//Thread.sleep(2000);
			WebElement ele=driver.findElement(mainmenu);
			act.moveToElement(ele).build().perform();
			act.click(ele).perform();
			
			//Thread.sleep(2000);
			Thread.sleep(4000);
			driver.findElement(OPDMenu1).click();

			//Over the slide bar in OPD Screen
			Thread.sleep(10000);
			WebElement overforopdslide1=driver.findElement(SideBarMenu);
			act.moveToElement(overforopdslide1).build().perform();
			Thread.sleep(4000);
			driver.findElement(RegistrationMenu).click();
			Thread.sleep(4000);
			driver.findElement(QuickRegistrationClick).click();

			//Adding Basic Information
			//Primary Identification
		
			Thread.sleep(5000);
			   if(driver.getPageSource().contains("Basic Information")) 
			   {
			   System.out.println("Quick Registration page has been launched successfully"); 
			   } else 
			   {
			   System.out.println("Quick Registration page failed"); 
			   }
			
			   
				Thread.sleep(1000);
				
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(".//ScreenShots//UpdateSponsorPayerDelete_QuickRegisteration.png")); 
			   
			Thread.sleep(2000);  
			driver.findElement(Primaryidclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Passport");
			Thread.sleep(500);
			driver.findElement(Primaryidselectvalue).click();

			//Primary Id number
			Thread.sleep(500);
			driver.findElement(PrimaryIDnumberclick).sendKeys(QuickPrimaryIdNumberPar);
			//Expire Date
			Thread.sleep(500);
			driver.findElement(Expirydateclick).sendKeys(QuickExparyDatePar);

			//Title
			Thread.sleep(500);
			driver.findElement(Titleclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Tan Sri Datuk");
			Thread.sleep(500);
			driver.findElement(Titleselectvalue).click();
			//Add Full Name
			Thread.sleep(500);
			driver.findElement(Nameclick).sendKeys(QuickFullNamePar);
			//Clicking on Gender
			Thread.sleep(500);
			driver.findElement(Genderclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("FEMALE");
			Thread.sleep(500);
			driver.findElement(Genderselectvalue).click();
			//Clicking on DOB
			Thread.sleep(500);
			driver.findElement(DOBclick).sendKeys(QuickDateOfBirthPar);
			//Country Code
			Thread.sleep(500);
			driver.findElement(CountryCodeclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("+213");
			Thread.sleep(500);
			driver.findElement(CountryCodeselectvalue).click();
			//Mobile Number
			Thread.sleep(500);
			driver.findElement(Mobilenoclick).sendKeys(QuickMobileNumberPar);
			Thread.sleep(500);
			//Encounter Details
			//Encounter Type
			Thread.sleep(500);
			driver.findElement(EncoujnterTypeclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("New Case");
			Thread.sleep(500);
			driver.findElement(EncounterTypeselectvalue).click();

			//Select Specialty
			Thread.sleep(500);
			driver.findElement(Specialityfieldclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("General Surgery");
			Thread.sleep(500);
			driver.findElement(Specialityfieldselect).click();
			//Selecting Doctor
			Thread.sleep(500);
			driver.findElement(Doctorclick).click();
			Thread.sleep(900);
			driver.findElement(AllDropDownSearch).sendKeys("Dr. Micheal Tan");
			Thread.sleep(900);
			driver.findElement(Doctorselect).click();
			//Selecting Clinic
			Thread.sleep(900);
			driver.findElement(Clinicclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Consultation Room 1");
			Thread.sleep(500);
			driver.findElement(Clinicselect).click();
			//Selecting Counter
			Thread.sleep(500);
			driver.findElement(Counterclick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("REGISTRATION COUNTER 1");
			Thread.sleep(500);
			driver.findElement(Counterselect).click();
			//Encounter Remarks
			Thread.sleep(500);
			driver.findElement(EncounterRemarksclick).sendKeys(QuickEncounterRemarksPar);

			//Clicking on Encounter Notes
			Thread.sleep(500);
			driver.findElement(EncounterNotesButtonClick).click();
			//Adding Notes
			/*Thread.sleep(500);
			driver.findElement(AddNotesClick).sendKeys(QuickAddNotesPar);*/
			//Clicking on Add Remark Button
			Thread.sleep(500);
			driver.findElement(AddRemarkButtonClick).click();

			//Closing Dialog
			Thread.sleep(500);
			driver.findElement(CloseButtonClick).click();

			//Referral Details
			//Visit Reason	
			Thread.sleep(500);
			driver.findElement(VisitReasonClick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Consultation & Treatment");
			Thread.sleep(500);
			driver.findElement(VisitReasonSelOpt).click();
			//Referral Type
			Thread.sleep(500);
			driver.findElement(ReferralTypeClick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Emergency Referral");
			Thread.sleep(500);
			driver.findElement(ReferralTypeSelOpt).click();
			//Referral
			Thread.sleep(500);
			driver.findElement(ReferralClick).click();
			Thread.sleep(1000);
			driver.findElement(AllDropDownSearch).sendKeys("Dato' Dr. Jefri Zain");
			Thread.sleep(1000);
			driver.findElement(ReferralSelOpt).click();
			//Patient Category
			Thread.sleep(500);
			driver.findElement(PatientCategoryClick).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Senior Citizen");
			Thread.sleep(500);
			driver.findElement(PatientCategorySelOpt).click();
			//Encounter Notes
			Thread.sleep(500);
			driver.findElement(EncounterNotesClick).sendKeys(QuickEncounterNotesPar);
			//Patient Notes
			Thread.sleep(500);
			driver.findElement(PatientNotes).sendKeys(QuickPatientNotesPar);
			//Referral Remarks
			Thread.sleep(500);
			driver.findElement(ReferralRemarksClick).sendKeys(QuickReferralRemarksPar);

			//Scrolling the web page
			Thread.sleep(4000);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

			//Selecting Tariff
			Thread.sleep(500);
			driver.findElement(Tariffclick12).click();
			Thread.sleep(500);
			driver.findElement(AllDropDownSearch).sendKeys("Self Tariff");
			Thread.sleep(500);
			driver.findElement(Tariffselect12).click();

			
			//Clicking on save button
			Thread.sleep(500);
			driver.findElement(Saveclick).click();

			//Clicking on OK Button
			Thread.sleep(500);
			driver.findElement(Saveconfirm).click();

			Thread.sleep(5000);
			String windowHandle = driver.getWindowHandle();

			//Get the list of window handles

			ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());
			Thread.sleep(2000);
			driver.switchTo().window((String) tabs.get(0));

			
	  
	//SideMenuBar
	  Thread.sleep(3000);
	  WebElement SidebarMenu=driver.findElement(SideBarMenu);
	  act.moveToElement(SidebarMenu).build().perform();
	  
	  //EncounterList
	  Thread.sleep(2000);
	  driver.findElement(EncounterListClick).click();
	  
	  //1stMRN
	  Thread.sleep(2000);
	  WebElement MRNSearch3=driver.findElement(CreatedMRN);
	  String MRNS=MRNSearch3.getText();
	  
	  System.out.println("MRN"+MRNS);
	  
	//SideMenuBar
	  Thread.sleep(3000);
	  WebElement SidebarMenu2=driver.findElement(SideBarMenu);
	  act.moveToElement(SidebarMenu2).build().perform();
	  
	//UpdateSponsor
	  Thread.sleep(3000);
	  driver.findElement(UpdateSponsor).click();
	  
	//Condition1
	  Thread.sleep(5000);
      if(driver.getPageSource().contains("No Patient Selected")) 
      {
      System.out.println("Update Sponsor Page Launch"); 
      } else 
      {
      System.out.println("Update Sponsor page failed"); 
      }
	  
    //ScreenShot
	  File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot1, new File(".//ScreenShots//UpdateSponsorPayerDelete_Update Sponsor Page Launch.png"));
      
 
	 //AdvanceSearch 
	  Thread.sleep(3000);
	  driver.findElement(Advancesearchclick).click();
	  
	  //MRNSearch
	  Thread.sleep(3000);
	  driver.findElement(MRNSearch).sendKeys(MRNS);
	  
	  //Search click
	  driver.findElement(Searchclick).click();
	
	//Condition2
	  Thread.sleep(5000);
      if(driver.getPageSource().contains(MRNS)) 
      {
      System.out.println("Patient MRN Showing on Screen"); 
      } else 
      {
      System.out.println("Patient MRN not showing on Screen"); 
      }
      
    //ScreenShot
	  File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot2, new File(".//ScreenShots//UpdateSponsorPayerDelete_Patient MRN Showing on Screen.png"));
      
	  //SelectPatient 
	  Thread.sleep(2000);
	  driver.findElement(SelectPatient).click();
	  
	  //AddButton
	  Thread.sleep(2000);
	  driver.findElement(AddButton).click();
	  
	//Condition3
	  Thread.sleep(5000);
      if(driver.getPageSource().contains("Add Sponsor")) 
      {
      System.out.println("Add Sponsor Window Appear"); 
      } else 
      {
      System.out.println("Add Sponsor Window Not Appear"); 
      }
	  
    //ScreenShot
	  File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot3, new File(".//ScreenShots//Add Sponsor Window Appear.png"));
	  
	  //PayerType
	  Thread.sleep(2000);
	  driver.findElement(PayerType).click();
	  driver.findElement(PayertypeSearch).sendKeys("Insurance");
	  driver.findElement(PayertypeSelect).click();
	  
	  //Payer
	  Thread.sleep(2000);
	  driver.findElement(payerclick).click();
	  driver.findElement(payersearch).sendKeys("AIA Berhad");
	  driver.findElement(payerselect).click();
	  
	  //Tariff
	  Thread.sleep(2000);
	  driver.findElement(Tariff).click();
	  driver.findElement(Tariffsearch).sendKeys("Insurance Tariff");
	  driver.findElement(Tariffselect).click();
	  
	  //Contract
	  Thread.sleep(2000);
	  driver.findElement(Contract).click();
	  driver.findElement(ContractSearch).sendKeys("Allianz Life Insurance Contract");
	  driver.findElement(Contractselect).click();
	  
	  //AssociateCompany 
	  Thread.sleep(2000);
	  driver.findElement(AssociateCompany).click();
	  driver.findElement(AssociateCompanysearch).sendKeys("GE - OCBC Bank");
	  driver.findElement(AssocaiteCompanySelect).click();
	  
	  //PolicyNumber
	  Thread.sleep(2000);
	  driver.findElement(PolicyNumber).sendKeys(PolicyNumberPar);
	  
	  //EffectiveDate 
	  Thread.sleep(2000);
	  driver.findElement(EffectiveDate).sendKeys(EffectivedatePar);
	  
	  //Save1
	  Thread.sleep(2000);
	  driver.findElement(Savebutton1).click();
	  
	  //Confirmation1
	  Thread.sleep(2000);
	  driver.findElement(Confirmation).click();
	
	//Condition4
	  Thread.sleep(5000);
      if(driver.getPageSource().contains("Insurance")) 
      {
      System.out.println("Insurance Payer Added Successfully"); 
      } else 
      {
      System.out.println("Insurance Payer not Added"); 
      }
      
    //ScreenShot
	  File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot4, new File(".//ScreenShots//UpdateSponsorPayerDelete_Insurance Payer Added Successfully.png"));
	  
	  //Save2
	  Thread.sleep(2000);
	  driver.findElement(Savebutton2).click();
	  
	  //Confirmation2
	  Thread.sleep(2000);
	  driver.findElement(Confirmation2).click();
	  
	  //Advancesearch2
	  Thread.sleep(2000);
	  driver.findElement(Advancesearchclick2).click();
	  
	  //MRNSearch2
	  Thread.sleep(2000);
	  driver.findElement(MRNSearch2).sendKeys(MRNS);
	  
	  //SearchClick
	  Thread.sleep(2000);
	  driver.findElement(Searchclick2).click();
	
	  //Radio
	  Thread.sleep(2000);
	  driver.findElement(RadioButton).click();
	  
	//Condition5
	  Thread.sleep(5000);
      if(driver.getPageSource().contains("Insurance Tariff")) 
      {
      System.out.println("Insurance Payer Showing on Screen"); 
      } else 
      {
      System.out.println("Insurance Payer Not Showing on Screen"); 
      }
	  
      
	  //ScreenShot
	  File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot5, new File(".//ScreenShots//UpdateSponsorPayerDelete_editpayer.png"));
      
      //DeleteIcon
      Thread.sleep(2000);
      driver.findElement(DeleteIcon).click();
      
      //Reason
      Thread.sleep(2000);
      driver.findElement(ReasonClick).click();
      Thread.sleep(2000);
      driver.findElement(ReasonSelect).click();
      
      //Remarks
      Thread.sleep(2000);
      driver.findElement(DeleteRemarks).sendKeys("Testing");
      
      //SAVE
      Thread.sleep(2000);
      driver.findElement(DeleteSave).click();
      
      //SaveButton
      Thread.sleep(2000);
      driver.findElement(Savebutton3).click();
      
      //Confirm
      Thread.sleep(2000);
      driver.findElement(Confirmation3).click();
      
      //Advance
      Thread.sleep(2000);
      driver.findElement(Advancesearchclick3).click();
      Thread.sleep(2000);
      driver.findElement(UpdatedMRN).sendKeys(MRNS);
      Thread.sleep(2000);
      driver.findElement(Searchclick3).click();
      
        //ScreenShot
  	    File screenshot6= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot6, new File(".//ScreenShots//UpdateSponsorPayerDelete.png"));
      
      
      
  }
}
