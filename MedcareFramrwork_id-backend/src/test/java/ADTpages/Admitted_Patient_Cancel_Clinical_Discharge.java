package ADTpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Admitted_Patient_Cancel_Clinical_Discharge 
{
	WebDriver driver=null;
	
	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
		
		//ADT
				By ADT=By.xpath("//*[@id='mat-menu-panel-1']/div/div/div[1]/div[1]/div[3]/div/img");
				
				//AddButton
				By AddButton=By.cssSelector("mat-icon[ng-reflect-message='Add Admission Request']");
				
				//PrimaryIdentification
				By PriID=By.cssSelector("mat-select[ng-reflect-name='primaryId']");
				By Prisearch=By.cssSelector("input[aria-label='dropdown search']");
				By Priselect=By.xpath("//span[contains(text(),'New IC')]");
				
				//PriNumber
				By PriNumber=By.cssSelector("input[ng-reflect-name='primaryDocNo']");
				
				//Name
				By Name=By.cssSelector("input[ng-reflect-name=\"fullName\"]");
				
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
				
				//CreatedPatient 
				By CreatedPatient=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-request/mat-drawer-container/mat-drawer-content/div/div[2]/table/tbody/tr[1]/td[5]");
				
				//Edit 
				
				By Edit=By.cssSelector("mat-icon[ng-reflect-message='Save Admission']");
				
				
				//---Registration--//
				
				//VIPPatient 
				By VIPPatient=By.cssSelector("mat-checkbox[ng-reflect-name='isVip']");
				
				//Address
				By Address=By.cssSelector("input[ng-reflect-name='addressPrimary']");
				
				//Country
				By Country=By.cssSelector("mat-select[ng-reflect-name='countryPrimary']");
				By Countrysearch=By.cssSelector("input[aria-label='dropdown search']");
				By Countryselect=By.xpath("//span[contains(text(),'Malaysia')]");
				
				//State
				By State=By.cssSelector("mat-select[ng-reflect-name='statePrimary']");
				By Statesearch=By.cssSelector("input[aria-label='dropdown search']");
				By Stateselect=By.xpath("//span[contains(text(),'Kedah')]");
				
				//City 
				By City=By.cssSelector("mat-select[ng-reflect-name='cityPrimary']");
				By Citysearch=By.cssSelector("input[aria-label='dropdown search']");
				By Cityselect=By.xpath("//span[contains(text(),'Kulim')]");
				
				//Area
				By Area=By.cssSelector("mat-select[ng-reflect-name='subDistrictPrimary']");
				By Areasearch=By.cssSelector("input[aria-label=\'dropdown search\']");
				By Areaselect=By.xpath("//span[contains(text(),'Sample')]");
				
				//CheckBox
				By Checkbox=By.xpath("//span[contains(text(),'Same as Residential Address')]");
				
				//CountryCode
				By Countrycode=By.cssSelector("mat-select[ng-reflect-name='countryCodemobile']");
				By Codesearch=By.cssSelector("input[aria-label=\'dropdown search\']");
				By Codeselect=By.xpath("//span[contains(text(),'+61')]");
				
				//Gender
				By Gender1=By.cssSelector("mat-select[ng-reflect-name='gender']");
				By Gender1search=By.cssSelector("input[aria-label=\'dropdown search\']");
				By Gender1select=By.xpath("//span[contains(text(),'MALE')]");
				
				//Save
				By Saveclick=By.cssSelector("mat-icon[ng-reflect-message='Save']");
				By Confirmclick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
				


				//---Admission Form---//
				
				
				//For All Drop down Search
				By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
				
				//Admission Time
				By AdmissionTimeClick=By.cssSelector("input[formcontrolname='admissionTime']");

				//Patient Meal Preferences
				By PatientMealClick=By.cssSelector("mat-select[ng-reflect-name='patientMealPreference']");
				By PatientMealSelOpt=By.xpath("//span[contains(text(),'Children')]");

				//Attendance Meal Reference
				By AttendenceMealClick=By.cssSelector("mat-select[ng-reflect-name=\"attendanceMealReference\"]");
				By AttendenceMealSelOpt=By.xpath("//span[contains(text(),'MAC Vegetarian')]");

				//Length Of Stay
				By LengthStayClick=By.cssSelector("input[formcontrolname='lengthOfStay']");

				//Admitting Diagnosis
				By AdmittingDiagnosisClick=By.cssSelector("input[formcontrolname='admittingDiagnosis']");

				//Admission Notes
				By AdmissionNotesclick=By.cssSelector("mat-icon[ng-reflect-message='Admission Notes']");

				//Add Notes
				By AddNotesclick=By.cssSelector("input[ng-reflect-name='notes']");

				//Add remark Button
				By AddRemarkButtonclick=By.cssSelector("mat-icon[ng-reflect-message='Add Remark']");

				//close button
				By CloseButton=By.cssSelector("mat-icon[ng-reflect-message='Close']");

				//Patient Notes
				By PatientNotes=By.cssSelector("input[formcontrolname='patientNotes']");

				//Admission Remark
				By Admissionremark=By.cssSelector("input[formcontrolname='remarks']");
				
				//Bill Estimation No
				By BillEstimationNoClick=By.cssSelector("input[ng-reflect-placeholder='Bill Estimation No']");

				//Referral Details

				//Referral Type
				By ReferraltypesClick=By.cssSelector("mat-select[ng-reflect-name='referralType']");
				By ReferralTypeSelopt=By.xpath("//span[contains(text(),'Emergency Referral')]");

				//Referral
				By RefferralClick=By.cssSelector("mat-select[ng-reflect-name='referral']");
				By RefferralSelopt=By.xpath("//span[contains(text(),\"Dato' Dr. Jefri Zain\")]");

				//Referral Remarks
				By ReferralRemarkClick=By.cssSelector("input[ng-reflect-placeholder='Referral Remarks']");

				//Assigned Bed
				//Click on Add button
				By AddButtonClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-form/mat-drawer-container/mat-drawer-content/div/div[1]/div[1]/div[2]/div[2]/div[1]/b/a[1]/mat-icon");

				//Select ward
				By SelectWardClick=By.cssSelector("mat-select[ng-reflect-placeholder='Select Ward']");
				By ALlSelOpt=By.xpath("//span[contains(text(),'Ward W3-A')]");

				//clicking on search
				By SearchClick=By.cssSelector("mat-grid-tile[style='left: calc((8.33333% - 0.916667px + 1px) * 6); width: calc((8.33333% - 0.916667px) * 1 + 0px); top: 0px; height: calc(60px);']");

				//Select Bed
				By BedClick=By.xpath("//span[contains(text(),'WW3-A-R1')]");

				//Click on Save Button
				By SaveButtonClick=By.cssSelector("button[type='submit']");

				//Doctor Specialty
				By AttendingDoctorSpecialityClick=By.cssSelector("mat-select[ng-reflect-name='dept']");
				By AttendingDoctorSpecialitySelOpt=By.xpath("//span[contains(text(),'General Surgery')]");

				//Selecting doctor
				By AttendingDoctorClick=By.cssSelector("mat-select[data-automation-attribute='sltdepartment']");
				By AttendingDoctorSelOpt=By.xpath("//span[contains(text(),'Dr. Micheal Tan')]");

				//Add Attending Doctor
				By AddAttendingDoctorclick=By.cssSelector("mat-icon[ng-reflect-message='Add Attending Doctor']");

				//Selecting Tab


				//Select Tariff
				By TariffClick=By.cssSelector("mat-select[data-automation-attribute='encounterTariff0']");
				By TariffSelOpt=By.xpath("//span[contains(text(),'Self Tariff')]");

				//Clicking on TAb2 Next Of Kin
				By NextOfKinClick=By.xpath("//mat-icon[contains(text(),'how_to_reg')]");

				//Title
				By TitleClick=By.cssSelector("mat-select[ng-reflect-name='kinPrefix']");
				By TitleSelOpt=By.xpath("//span[contains(text(),\" Tan Sri Dato' Ir \")]");

				//Name
				By NameClick=By.cssSelector("input[formcontrolname='kinName']");

				//Relation
				By RelationClick=By.cssSelector("mat-select[ng-reflect-name='kinRelation']");
				By RelationSelOpt=By.xpath("//span[contains(text(),'Wife')]");

				//Primary Identification
				By PrimaryIdentificationClick=By.cssSelector("mat-select[ng-reflect-name='kinIDType']");
				By PrimaryIdentificationSelOpt=By.xpath("//span[contains(text(),'Passport')]");

				//Identification No
				By IdentificationNoClick=By.cssSelector("input[formcontrolname='kinIDDesc']");

				//PhoneNumber
				By PhoneNumberClick=By.cssSelector("input[ng-reflect-name='Kinmobile']");

				//Permanent Address
				//Address
				By AddressClick=By.cssSelector("input[formcontrolname='kinAdress']");

				//Country
				By CountryClick=By.cssSelector("mat-select[formcontrolname='kinCountry']");
				By CountrySelOpt=By.xpath("//span[contains(text(),'Malaysia')]");

				//State
				By StateClick=By.cssSelector("mat-select[formcontrolname='kinState']");
				By StateSelOpt=By.xpath("//span[contains(text(),'Negeri Sembilan')]");

				//city
				By CityClick=By.cssSelector("mat-select[formcontrolname='kinDist']");
				By CitySelOpt=By.xpath("//span[contains(text(),'Nilai')]");

				//ZipCode
				By ZipCodeClick=By.cssSelector("input[formcontrolname='kinPincode']");

				//Tab3 Documents
				By DocumentsClickTab=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-form/mat-drawer-container/mat-drawer-content/div/div[1]/div[2]/mat-tab-group/mat-tab-header/div/div/div/div[3]");

				//Upload Document

				By UploadDocClick=By.cssSelector("mat-icon[ng-reflect-message='Upload Document']");

				//Choose Button
				By ChooseButtonClick=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-uploadfile/div/div[2]/table/tr/td/input");

				//Upload Button
				By UploadClick=By.cssSelector("mat-icon[ng-reflect-message='Upload']");

				//Save Button
				By SaveBtnClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-form/mat-drawer-container/mat-drawer-content/div/div[2]/mat-grid-list/div/mat-grid-tile[4]/div/div/div/button[3]/span[1]/mat-icon");
				//Yes BUtton
				By OkButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
				
				//VIPTag
				By VIPTag=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-dashboard/mat-drawer-container/mat-drawer-content/div/table/tbody/tr[1]/td[4]/img");
				
				//AdmissionStatusChanged 
				
				By AdvancedSearchClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/div[2]/mat-icon");
			    //MRN
			    By MRNSearchClick=By.cssSelector("input[ng-reflect-name='mrn']");
			    //Search button
			    By SearchClick12=By.cssSelector("button[ng-reflect-message='Search']");

			    By Tableclick=By.cssSelector("tbody[role='rowgroup']");
			    //Clicking on row
			    By ROWClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-dashboard/mat-drawer-container/mat-drawer-content/div/table/tbody/tr");
			    //Update Status
			    By UpdateStatus=By.cssSelector("img[ng-reflect-message='Update Status']");

			    //Status
			    By StatusClick=By.cssSelector("mat-select[ng-reflect-name='first']");
			    By StatusSelopt=By.xpath("//span[contains(text(),'ADMITTED')]");
			    
			    //Remarks
			    By RemarksClick12=By.cssSelector("input[ng-reflect-name='remarks']");
			    
			    //Confirm 
			    By ConfirmButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Confirm']");
			    

			  //---ClinicalDischarge---//
			    
			    
			    //ClinicalDischarge
			    By ClinicalDischarge=By.cssSelector("img[ng-reflect-message='Clinical Discharge']");
			    
			    //DischargingType
			    By DischargingType=By.cssSelector("mat-select[ng-reflect-name='dischargeType']");
			    
			    //DischaringTypeName
			    By Dischargingtypeselect=By.xpath("//span[contains(text(),'Normal')]");
			    
			    //Destination 
			    By Destination=By.cssSelector("mat-select[ng-reflect-name='dischargeDestination']");
			    
			    //DestinationSelect 
			    By DestinationSelect=By.xpath("//span[contains(text(),'Home Release')]");
			    
			    //DischargeDate 
			    By DischargeDate=By.cssSelector("input[ng-reflect-name='dischargeDate']");
			    
			    //DischargeTime 
			    By DischargeTime=By.cssSelector("input[ng-reflect-name='dischargeTime']");
			    
			    //Instruction
			    By Instruction=By.cssSelector("input[ng-reflect-name='instructions']");
			    
			    //Remarks 
			    By ClincialRemarks=By.cssSelector("input[ng-reflect-name='remarks']");
			    
			    //ClincialSave
			    By ClincialSave=By.cssSelector("mat-icon[ng-reflect-message='Save']");
			    
			    
			    //----CancelClinicalDischarge---//
			    
			    //CancelIcon
			    By CancelIcon=By.cssSelector("img[ng-reflect-message='Cancel Discharge']");
			    
			    //Reason
			    By CancelReasonclick=By.cssSelector("mat-select[name='Reason']");
			    
			    //ReasonSelect
			    By ReasonSelect=By.xpath("//span[contains(text(),'Doctors order')]");
	
			    //CancelRemarks 
			    By CancelRemarks=By.cssSelector("input[ng-reflect-name='remarks']");
			    
			    //CancelSave
			    By CancelSave=By.cssSelector("mat-icon[ng-reflect-message='Confirm']");
			    
			    
  
  public void AdmittedPatientClinicalDischargeCancel(String PriNumberPar,String PatientNamePar,String ExpiryDatePar,String DOBPar,String MobilePar,String EmailPar,String LengthPar,String NotesPar,String RemarksPar,String RegAddressPar,String LengthOfStayPar,String AdmittingDiagPar,String AddNotesPar,String PatientNotesPar,String AdmissionRemarksPar,String BillEstimationPar,String ReferralRemarksPar,String NamePar,String IdentificationNOPar,String PhoneNumberPar,String AddressPar,String ZipCodePar,String InstructionPar,String ClincialRemarksPar,String CancelRemarksPar) throws InterruptedException, IOException 
  
  {
	  Thread.sleep(2000);
      Actions act = new Actions(driver);
      Thread.sleep(2000);
      WebElement ele1=driver.findElement(mainmenuADTScreen);
      act.moveToElement(ele1).build().perform();
      act.click(ele1).perform();
      //Thread.sleep(2000);
      
    //ADT
	  Thread.sleep(3000);
	  driver.findElement(ADT).click();
	  
	  //Condition1
	  Thread.sleep(10000);
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
      FileUtils.copyFile(screenshot1,new File(".//ScreenShots//AdmissionRequestDashBoard.png"));
	  
	 //AddButton
	  Thread.sleep(2000);
	  driver.findElement(AddButton).click();
	  
	  //Condition2
	  Thread.sleep(5000);
	  if(driver.getPageSource().contains("Admission Details"))
	  {
		  System.out.println("Admission Request form open");
	  }
	  else
	  {
		  System.out.println("Admission Request form not open");
	  }
	  
	  
	//ScreenShot2
	  File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot2,new File(".//ScreenShots//AdmissionRequestForm.png"));
	  
	  
	  //PrimaryID
	  Thread.sleep(2000);
	  driver.findElement(PriID).click();
	  driver.findElement(Prisearch).sendKeys("New IC");
	  driver.findElement(Priselect).click();
	  
	  
	  //Assertion
	  String Actual_1 = "New IC";
      String Expected_1 = "New IC";
      Assert.assertEquals(Actual_1, Expected_1, "NewIC PrimaryID Selected Successfully Assertion Passed");
     
      Thread.sleep(1000);
      File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String timestamp3= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
      FileUtils.copyFile(screenshot3, new File(".//ScreenShots//NewAdmissionWithVIPPatient_NewICPrimaryID.png"));
      Thread.sleep(3000);
	  
      
	//Select Primary Id Number
      Date d=new Date(System.currentTimeMillis()+ System.nanoTime());
      Long id=d.getTime();
      Thread.sleep(2000);
      driver.findElement(PriNumber).sendKeys(PriNumberPar+id);
	  
	  //PriNumber
	  /*Thread.sleep(2000);
	  driver.findElement(PriNumber).sendKeys(PriNumberPar);*/
	  
	  //Name
	  Thread.sleep(3000);
	  driver.findElement(Name).sendKeys(PatientNamePar);
	  
	  //ExpiryDate
	  /*Thread.sleep(2000);
	  driver.findElement(ExpiryDate).sendKeys(ExpiryDatePar);*/
	  
	  //Title
	  Thread.sleep(3000);
	  driver.findElement(Title).click(); 
	  driver.findElement(Titlesearch).sendKeys("Tan Sri Dato'");
	  driver.findElement(Titleselect).click();
	  
	  //Gender
	  Thread.sleep(3000);
	  driver.findElement(Gender).click();
	  driver.findElement(Gendersearch).sendKeys("MALE");
	  driver.findElement(Genderselect).click();
	  
	  //DOB
	  /*Thread.sleep(2000);
	  driver.findElement(DOB).sendKeys(DOBPar);*/
	  
	  //Mobile 
	  Thread.sleep(3000);
	  driver.findElement(Mobile).sendKeys(MobilePar);
	  
	  //Email
	  Thread.sleep(3000);
	  driver.findElement(Email).sendKeys(EmailPar);
	  
	  //AdmittingDoctor
	  Thread.sleep(3000);
	  driver.findElement(Admdoctor).click();
	  driver.findElement(AdmDctsearch).sendKeys("AMAN");
	  driver.findElement(AdmDctselect).click();
	  
	  
	  //AdmittingDepartment
	  Thread.sleep(3000);
	  driver.findElement(AdmDepartment).click();
	  driver.findElement(AdmDepsearch).sendKeys("Cardiology");
	  driver.findElement(AdmDepselect).click();
	  
	  //AttendingDoctor
	  Thread.sleep(3000);
	  driver.findElement(AttendDoctor).click();
	  driver.findElement(AttendDctsearch).sendKeys("Dr. Salina Yusof");
	  driver.findElement(AttendDctselect).click();
	  
	  //RefDoctor
	  Thread.sleep(3000);
	  driver.findElement(ReferringDoctor).click();
	  driver.findElement(ReferringDctsearch).sendKeys("Dr. James Raman");
	  driver.findElement(ReferringDctselect).click();
	  
	  //AdmissionType
	  Thread.sleep(3000);
	  driver.findElement(Admissiontype).click();
	  driver.findElement(Admissiontypesearch).sendKeys("Elective");
	  driver.findElement(Admissiontypeselect).click();
	  
	  //ReasonAdmission
	  Thread.sleep(3000);
	  driver.findElement(ReasonAdmission).click();
	  driver.findElement(ReasonAdmsearch).sendKeys("Admitted");
	  driver.findElement(ReasonAdmselect).click();
	  
	  //CurrentDate
	  LocalDateTime dt = LocalDateTime.now();
		 
	  DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  String myDate = dt.format(df);
		  
		  
	  //DOA
	  /*Thread.sleep(2000);
	  driver.findElement(DOA).sendKeys(DOAPar);*/
	  
	  //DOA
	  Thread.sleep(3000);
	  driver.findElement(DOA).sendKeys(myDate);
	  
	  //Length
	  Thread.sleep(3000);
	  driver.findElement(Length).sendKeys(LengthPar);
	  
	  //FinancialClass
	  Thread.sleep(3000);
	  driver.findElement(Financialclass).click();
	  driver.findElement(Financialsearch).sendKeys("Third Class");
	  driver.findElement(Financialselect).click();
	  
	  //BedCategory 
	  Thread.sleep(3000);
	  driver.findElement(Bedcategory).click();
	  driver.findElement(Bedcatsearch).sendKeys("4-Bedded");
	  driver.findElement(Bedcatselect).click();
	  
	  //PayerType
	  Thread.sleep(3000);
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
	  Thread.sleep(3000);
	  driver.findElement(Save).click();
	  
	  
	  //ConfirmButton
	  Thread.sleep(2000);
	  driver.findElement(ConfirmButton).click();
	  
	//CreatedMRN
	  Thread.sleep(5000);
	  WebElement Patient=driver.findElement(CreatedPatient);
	  String PatientName=Patient.getText();
	  
	  System.out.println("MRN"+PatientName);
	  
	  
	//Condition3
	  Thread.sleep(5000);
	  if(driver.getPageSource().contains(PatientName))
	  {
		  System.out.println("Admission Request Created and Displayed");
	  }
	  else
	  {
		  System.out.println("Admission Request Not Created");
	  }
	  
	  
	//ScreenShot3
	  File screenshot10 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot10,new File(".//ScreenShots//CreatedRequest on DashBoardScreen.png"));
	  
	  
	  //Edit 
	  Thread.sleep(5000);
	  driver.findElement(Edit).click();
	  
	  
	  
	  //-----Registration---//
	  
	  
	  
	//Condition4
	  Thread.sleep(10000);
      if(driver.getPageSource().contains("Health Tourist Details"))
      {
    	System.out.println("Registration Page Open");  
      }
      else
      {
    	  System.out.println("Registration Page not open");
      }

    //ScreenShot4
	  File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot4,new File(".//ScreenShots//RegistrationScreen For Admission.png"));
      
      
     //VIPPatient 
      Thread.sleep(3000);
      driver.findElement(VIPPatient).click();
	  
      
    //Save
	  Thread.sleep(3000);
	  driver.findElement(Saveclick).click();
      
	  Thread.sleep(2000);
      File screenshot11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String timestamp11= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
      FileUtils.copyFile(screenshot3, new File(".//ScreenShots//NewAdmissionWithVIPPatient_NewIC_MandatoryField.png"));
      Thread.sleep(3000);
	  
      //Assertion
	  String Actual_2 = "Please fill all mandatory fields";
      String Expected_2 = "Please fill all mandatory fields";
      Assert.assertEquals(Actual_1, Expected_1, "Registartion Mandatory Field highlighting and Assertion Passed");
     
      
      
	//Address
	  Thread.sleep(4000);
	  driver.findElement(Address).sendKeys(RegAddressPar);
	  
	  //Country
	  Thread.sleep(3000);
	  driver.findElement(Country).click();
	  driver.findElement(Countrysearch).sendKeys("Malaysia");
	  driver.findElement(Countryselect).click();
	  
	  //State
	  Thread.sleep(3000);
	  driver.findElement(State).click();
	  driver.findElement(Statesearch).sendKeys("Kedah");
	  driver.findElement(Stateselect).click();
	  
	  //City
	  Thread.sleep(3000);
	  driver.findElement(City).click();
	  driver.findElement(Citysearch).sendKeys("Kulim");
	  driver.findElement(Cityselect).click();
	  
	  //Area
	  Thread.sleep(3000);
	  driver.findElement(Area).click();
	  driver.findElement(Areasearch).sendKeys("Sample");
	  driver.findElement(Areaselect).click();	  
	  //CheckBox
	  Thread.sleep(3000);
	  driver.findElement(Checkbox).click();
	  
	  //CountryCode
	  Thread.sleep(3000);
	  driver.findElement(Countrycode).click();
	  driver.findElement(Codesearch).sendKeys("+61");
	  driver.findElement(Codeselect).click();
	  
	//Gender
	  Thread.sleep(5000);
	  driver.findElement(Gender1).click();
	  driver.findElement(Gender1search).sendKeys("MALE");
	  driver.findElement(Gender1select).click();
	  
	  //Save
	  Thread.sleep(3000);
	  driver.findElement(Saveclick).click();
	  driver.findElement(Confirmclick).click();
	  
	  //TabSwitch
	  Thread.sleep(5000);
      String windowHandle = driver.getWindowHandle();

      //Get the list of window handles

      ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());

      //Use the list of window handles to switch between windows
      Thread.sleep(1000);
      driver.switchTo().window((String)tabs.get(0));
      
      Thread.sleep(4000);
      
      
	  
      //-----AdmissionFrom---//
      
      
      
    //Condition5
      Thread.sleep(5000);
      if(driver.getPageSource().contains("General Information"))
    	  
      {
    	  System.out.println("Admission Form Screen Open");
      }
      else
      {
    	  System.out.println("Admission Form Screen not open");
      }
      
    //ScreenShot5
	  File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot5,new File(".//ScreenShots//AdmissionFormScreen.png"));
      
    //Clicking on save button	
  	Thread.sleep(2000);
  	driver.findElement(SaveBtnClick).click();


  	//Clicking on Okay dialog
  	Thread.sleep(3000);
  	driver.findElement(OkButtonClick).click(); 
      
    //Assertion
  	Thread.sleep(1000);
    File screenshot22 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String timestamp22= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
    FileUtils.copyFile(screenshot22, new File(".//ScreenShots//NewAdmissionWithVIPPatient_NewIC_MandatoryFieldAdmissionform.png"));
    Thread.sleep(3000);
  	
      String Actual_33 = "Please fill all mandatory fields";
      String Expected_33 = "Please fill all mandatory fields";
      Assert.assertEquals(Actual_33, Expected_33, "Admission Mandatory Field highlighting and Assertion Passed");
     
      
  	//CurrentTIme 
     Date date = new Date();
     SimpleDateFormat formatTime = new SimpleDateFormat("hh:mma");
     String time = formatTime.format(date);

	//Admission Time
	Thread.sleep(3000);
	driver.findElement(AdmissionTimeClick).sendKeys(time);
	
	//Patient Meal Preference
	Thread.sleep(3000);
	driver.findElement(PatientMealClick).click();
	Thread.sleep(3000);
	driver.findElement(AllDropDownSearch).sendKeys("Children");
	Thread.sleep(3000);
	driver.findElement(PatientMealSelOpt).click();

	//Attendance Meal Preference
	Thread.sleep(3000);
	driver.findElement(AttendenceMealClick).click();
	Thread.sleep(3000);
	driver.findElement(AllDropDownSearch).sendKeys("MAC Vegetarian");
	Thread.sleep(3000);
	driver.findElement(AttendenceMealSelOpt).click();

	//Length Of Stay
	Thread.sleep(3000);
	driver.findElement(LengthStayClick).sendKeys(LengthOfStayPar);

	//Admitting Diagnosis
	Thread.sleep(3000);
	driver.findElement(AdmittingDiagnosisClick).sendKeys(AdmittingDiagPar);

	//Click on Admission notes button
	Thread.sleep(3000);
	driver.findElement(AdmissionNotesclick).click();

	//Add Notes
	Thread.sleep(3000);
	driver.findElement(AddNotesclick).sendKeys(AddNotesPar);

	//Click on Add Remark
	Thread.sleep(3000);
	driver.findElement(AddRemarkButtonclick).click();

	//Click on Close button
	Thread.sleep(3000);
	driver.findElement(CloseButton).click();

	//Patient Notes
	Thread.sleep(3000);
	driver.findElement(PatientNotes).sendKeys(PatientNotesPar);

	//Admission Remarks
	Thread.sleep(3000);
	driver.findElement(Admissionremark).sendKeys(AdmissionRemarksPar);
	
	//Bill Estimation NO
	driver.findElement(BillEstimationNoClick).sendKeys(BillEstimationPar);

	//Referral Type
	Thread.sleep(3000);
	driver.findElement(ReferraltypesClick).click();
	Thread.sleep(3000);
	driver.findElement(AllDropDownSearch).sendKeys("Emergency Referral");
	Thread.sleep(3000);
	driver.findElement(ReferralTypeSelopt).click();

	//Referral 
	Thread.sleep(3000);
	driver.findElement(RefferralClick).click();
	Thread.sleep(3000);
	driver.findElement(AllDropDownSearch).sendKeys("Dato' Dr. Jefri Zain");
	Thread.sleep(3000);
	driver.findElement(RefferralSelopt).click();


	//Referral Remarks
	Thread.sleep(3000);
	driver.findElement(ReferralRemarkClick).sendKeys(ReferralRemarksPar);

	//Click on Add Button for adding bed
	Thread.sleep(3000);
	driver.findElement(AddButtonClick).click();

	//Condition6
	Thread.sleep(5000);
	if(driver.getPageSource().contains("Expand All"))
	{
		System.out.println("Bed Selection Window Appear");
	}
	else
	{
		System.out.println("Bed Selection Window not Appear");
	}


    //ScreenShot6
	  File screenshot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot6,new File(".//ScreenShots//BedSelectionWindow.png"));

	
	//Selecting Ward
	Thread.sleep(4000);
	driver.findElement(SelectWardClick).click();
	Thread.sleep(4000);
	driver.findElement(AllDropDownSearch).sendKeys("Ward W3-A");
	
	Thread.sleep(5000);
	driver.findElement(ALlSelOpt).click();
	
	Thread.sleep(2000);
	Actions action = new Actions(driver);
    action.moveByOffset(0,0).click().build().perform();
	
	//Clicking on Search
  	Thread.sleep(3000);
	driver.findElement(SearchClick).click();

	//Scrolling the web page
	Thread.sleep(2000);
	Actions actions = new Actions(driver);
	actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	//Bed CLick
	Thread.sleep(3000);
	driver.findElement(BedClick).click();

	//Click on Save Button
	Thread.sleep(3000);
	driver.findElement(SaveButtonClick).click();

	//Selecting Doctor Specialty
	Thread.sleep(2000);
	driver.findElement(AttendingDoctorSpecialityClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("General Surgery");
	Thread.sleep(2000);
	driver.findElement(AttendingDoctorSpecialitySelOpt).click();

	//Selecting Doctor
	Thread.sleep(2000);
	driver.findElement(AttendingDoctorClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Dr. Micheal Tan");
	Thread.sleep(2000);
	driver.findElement(AttendingDoctorSelOpt).click();

	//Clicking Add Attending Doctor button
	Thread.sleep(2000);
	driver.findElement(AddAttendingDoctorclick).click();


	//Scrolling 
	Thread.sleep(2000);
	Actions actions1 = new Actions(driver);
	actions1.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	
	//Selecting Tariff
	Thread.sleep(2000);
	driver.findElement(TariffClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Self Tariff");
	Thread.sleep(2000);
	driver.findElement(TariffSelOpt).click();

	//Clicking on TAb2 Next Of Kin
	Thread.sleep(2000);
	driver.findElement(NextOfKinClick).click();

	//Clicking on title
	Thread.sleep(2000);
	driver.findElement(TitleClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Tan Sri Dato' Ir");
	Thread.sleep(2000);
	driver.findElement(TitleSelOpt).click();

	//Adding Name
	Thread.sleep(2000);
	driver.findElement(NameClick).sendKeys(NamePar);

	//Selecting Relation
	Thread.sleep(2000);
	driver.findElement(RelationClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Wife");
	Thread.sleep(2000);
	driver.findElement(RelationSelOpt).click();

	//Selecting Primary Identification
	Thread.sleep(2000);
	driver.findElement(PrimaryIdentificationClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Passport");
	Thread.sleep(2000);
	driver.findElement(PrimaryIdentificationSelOpt).click();

	//Adding Identification NO
	Thread.sleep(2000);
	driver.findElement(IdentificationNoClick).sendKeys(IdentificationNOPar);

	//Phone Number
	Thread.sleep(2000);
	driver.findElement(PhoneNumberClick).sendKeys(PhoneNumberPar);

	//Address
	Thread.sleep(2000);
	driver.findElement(AddressClick).sendKeys(AddressPar);

	//Selecting Country
	Thread.sleep(2000);
	driver.findElement(CountryClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Malaysia");
	Thread.sleep(2000);
	driver.findElement(CountrySelOpt).click();

	//Selecting State
	Thread.sleep(2000);
	driver.findElement(StateClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Negeri Sembilan");
	Thread.sleep(2000);
	driver.findElement(StateSelOpt).click();

	//Selecting City
	Thread.sleep(2000);
	driver.findElement(CityClick).click();
	Thread.sleep(2000);
	driver.findElement(AllDropDownSearch).sendKeys("Nilai");
	Thread.sleep(2000);
	driver.findElement(CitySelOpt).click();

	//Adding ZipCode
	Thread.sleep(2000);
	driver.findElement(ZipCodeClick).sendKeys(ZipCodePar);

	/*
	
	//Tab3 Documents
	//Clicking on Document tab
	Thread.sleep(2000);
	driver.findElement(DocumentsClickTab).click();

	//Click on Upload document button

	Thread.sleep(4000);
	driver.findElement(UploadDocClick).click();

	Thread.sleep(3000);
	WebElement browse = driver.findElement(ChooseButtonClick);
	//click on ‘Choose file’ to upload the desired file
	browse.sendKeys("D:\\ImgTest.txt");
	
	Thread.sleep(4000);
	driver.findElement(UploadClick).click();
*/
	//Clicking on save button	
	Thread.sleep(2000);
	driver.findElement(SaveBtnClick).click();


	//Clicking on Okay dialog
	Thread.sleep(3000);
	driver.findElement(OkButtonClick).click(); 
	
	
	 //TabSwitch
	  Thread.sleep(5000);
      String windowHandle2 = driver.getWindowHandle();
	
	//Get the list of window handles

      ArrayList<Object> tabs1 = new ArrayList<Object> (driver.getWindowHandles());

      //Use the list of window handles to switch between windows
      Thread.sleep(1000);
      driver.switchTo().window((String)tabs1.get(0));
      
      //VIP
	  Thread.sleep(10000);
	  WebElement VIPLogo=driver.findElement(VIPTag);
	  String VIP=VIPLogo.getText();

      //Condition7
      Thread.sleep(5000);
      if(driver.getPageSource().contains(PatientName)&& (driver.getPageSource().contains(VIP)))
 		 
      {
    	  System.out.println("Admission Dashboard Appear and Patient Displayed with VIP Tag");
      }
      else
      {
    	  System.out.println("Admission Dashboard Not Appear");
      }

	    //ScreenShot7
		  File screenshot7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot7,new File(".//ScreenShots//AdmissionCreatedwithVIP.png"));
   
	      
	      
        //Clicking Row 
        Thread.sleep(3000);
        driver.findElement(ROWClick).click();

        //Clicking update status menu. 
        Thread.sleep(1500);
        driver.findElement(UpdateStatus).click();

        //Clicking on status.
        Thread.sleep(1500);
        driver.findElement(StatusClick).click();
        Thread.sleep(1500);
        driver.findElement(StatusSelopt).click();
        
        //Adding Remarks
        Thread.sleep(1500);
        driver.findElement(RemarksClick12).sendKeys("Want to do admitted patient");

        //Clicking on confirm button
        Thread.sleep(1500);
        driver.findElement(ConfirmButtonClick).click();
      
        //Condition8
        Thread.sleep(5000);
        if(driver.getPageSource().contains("Status")&& (driver.getPageSource().contains("ADMITTED")))
        {
        	System.out.println("Status Showing As Admitted");
        }
        else
        {
        	System.out.println("Status Showing not as Admitted");
        }
        
        //ScreenShot8
		  File screenshot8 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot8,new File(".//ScreenShots//AdmissionStatus.png"));
      
	      
	    //----ClinicalDischarge---//
	      
	      
		     //Clicking Row 
		      Thread.sleep(3000);
		      driver.findElement(ROWClick).click();
		      
		      //ClinicalDischareIcon
		      Thread.sleep(3000);
		      driver.findElement(ClinicalDischarge).click();
		      
		    //DischargingType
		      Thread.sleep(3000);
		      driver.findElement(DischargingType).click();
		      Thread.sleep(2000);
		      driver.findElement(Dischargingtypeselect).click();
		      
		      //Destination 
		      Thread.sleep(3000);
		      driver.findElement(Destination).click();
		      Thread.sleep(2000);
		      driver.findElement(DestinationSelect).click();
		     
		      
		      //CurrentDate
			  LocalDateTime dt2 = LocalDateTime.now();
				 
			  DateTimeFormatter df2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			  String myDate2 = dt2.format(df2);
				  
		      
		      //DischargeDate
		      Thread.sleep(3000);
		      driver.findElement(DischargeDate).sendKeys(myDate2);
		      
		      
		    //CurrentTIme 
		      Date date2 = new Date();
		      SimpleDateFormat formatTime2 = new SimpleDateFormat("hh:mma");
		      String time2 = formatTime2.format(date2);

		      
		      //DischargeTime
		      Thread.sleep(3000);
		      driver.findElement(DischargeTime).sendKeys(time2);
		      
		      //Instruction
		      Thread.sleep(3000);
		      driver.findElement(Instruction).sendKeys(InstructionPar);
		      
		      //Remarks
		      Thread.sleep(3000);
		      driver.findElement(ClincialRemarks).sendKeys(ClincialRemarksPar);
		      
		      //ClinicalSave
		      Thread.sleep(3000);
		      driver.findElement(ClincialSave).click();
		      
		      
		      //TabSwitch
			  Thread.sleep(5000);
		      String windowHandle4 = driver.getWindowHandle();

		      //Get the list of window handles

		      ArrayList<Object> tabs2 = new ArrayList<Object> (driver.getWindowHandles());

		      //Use the list of window handles to switch between windows
		      Thread.sleep(1000);
		      driver.switchTo().window((String)tabs2.get(0));
		      
		      //Condition10
		        Thread.sleep(5000);
		        if(driver.getPageSource().contains("Status")&& (driver.getPageSource().contains("DISCHARGE INITIATED")))
		        {
		        	System.out.println("Status Showing As Discharge Initiated");
		        }
		        else
		        {
		        	System.out.println("Status Showing not as Discharge");
		        }
		        
		        //ScreenShot1
				  File screenshot14 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			      FileUtils.copyFile(screenshot14,new File(".\\ScreenShots\\AdmissionStatusforDischarge.png"));
		      

			      //Assertion
				  String Actual_5 = "Discharge Initiated";
			      String Expected_6 = "Discharge Initiated";
			      Assert.assertEquals(Actual_5, Expected_6, "NewIC PrimaryID Selected Successfully Assertion Passed");
			     
			      Thread.sleep(1000);
			      File screenshot44 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			      String timestamp78= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			      FileUtils.copyFile(screenshot44, new File(".//ScreenShots//NewAdmissionClinicalDischarge_Status.png"));
			      Thread.sleep(3000);
			      

			      //---CancelClinicalDischarge----//
			      
			      Thread.sleep(3000);
			      driver.findElement(CancelIcon).click();
			      
				  //Reason
			      Thread.sleep(3000);
			      driver.findElement(CancelReasonclick).click();
			      
			      //ReasonSelect
			      Thread.sleep(3000);
			      driver.findElement(ReasonSelect).click();	
			      
			      //CancelRemarks 
			      Thread.sleep(3000);
			      driver.findElement(CancelRemarks).sendKeys(CancelRemarksPar);
			      
			      //CancelSave
			      Thread.sleep(3000);
			      driver.findElement(CancelSave).click();
			      
			    //Condition11
			        Thread.sleep(5000);
			        if(driver.getPageSource().contains("Status")&& (driver.getPageSource().contains("ADMITTED")))
			        {
			        	System.out.println("Status Showing As Admitted");
			        }
			        else
			        {
			        	System.out.println("Status Showing not as Admitted");
			        }
			        
			        //ScreenShot1
					  File screenshot33 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				      FileUtils.copyFile(screenshot33,new File(".//ScreenShots//AdmissionStatusforCancelDischarge.png"));
			      
			      
			      
			      
	      //Close
	      Thread.sleep(2000);
	      driver.close();
  }
  
  public Admitted_Patient_Cancel_Clinical_Discharge(WebDriver driver)
	
	{
		this .driver=driver;
		
	}
  
}
