package ADTpages;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ADTAdmissionForm_WIth_Reg 
{
	WebDriver driver=null;

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

	//Uplad Document

	By UploadDocClick=By.cssSelector("mat-icon[ng-reflect-message='Upload Document']");

	//Choose Button
	By ChooseButtonClick=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-uploadfile/div/div[2]/table/tr/td/input");

	//Upload Button
	By UploadClick=By.cssSelector("mat-icon[ng-reflect-message='Upload']");

	//Save Button
	By SaveBtnClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-form/mat-drawer-container/mat-drawer-content/div/div[2]/mat-grid-list/div/mat-grid-tile[4]/div/div/div/button[3]/span[1]/mat-icon");
	//Yes BUtton
	By OkButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
	
	
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
	
	
	public void ADT_Admission_Form(String LengthOfStayPar,String AdmittingDiagPar,String AddNotesPar,String PatientNotesPar,String AdmissionRemarksPar,String BillEstimationPar,String ReferralRemarksPar,String NamePar,String IdentificationNOPar,String PhoneNumberPar,String AddressPar,String ZipCodePar) throws InterruptedException, IOException
	{
		
		//Condition4
	      Thread.sleep(5000);
	      if(driver.getPageSource().contains("MARUTI"))
	      {
	    	  System.out.println("Admission Form Screen Open");
	      }
	      else
	      {
	    	  System.out.println("Admission Form Screen not open");
	      }
	      
	    //ScreenShot4
		  File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot4,new File(".//ScreenShot//AdmissionRequest4.png"));
	      
		//Admission Time
		Thread.sleep(2000);
		driver.findElement(AdmissionTimeClick).sendKeys("11:00AM");

		//Patient Meal Preference
		Thread.sleep(2000);
		driver.findElement(PatientMealClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Children");
		Thread.sleep(1000);
		driver.findElement(PatientMealSelOpt).click();

		//Attendance Meal Preference
		Thread.sleep(2000);
		driver.findElement(AttendenceMealClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("MAC Vegetarian");
		Thread.sleep(2000);
		driver.findElement(AttendenceMealSelOpt).click();

		//Length Of Stay
		Thread.sleep(2000);
		driver.findElement(LengthStayClick).sendKeys(LengthOfStayPar);

		//Admitting Diagnosis
		Thread.sleep(2000);
		driver.findElement(AdmittingDiagnosisClick).sendKeys(AdmittingDiagPar);

		//Click on Admission notes button
		Thread.sleep(2000);
		driver.findElement(AdmissionNotesclick).click();

		//Add Notes
		Thread.sleep(2000);
		driver.findElement(AddNotesclick).sendKeys(AddNotesPar);

		//Click on Add Remark
		Thread.sleep(2000);
		driver.findElement(AddRemarkButtonclick).click();

		//Click on Close button
		Thread.sleep(2000);
		driver.findElement(CloseButton).click();

		//Patient Notes
		Thread.sleep(2000);
		driver.findElement(PatientNotes).sendKeys(PatientNotesPar);

		//Admission Remarks
		Thread.sleep(2000);
		driver.findElement(Admissionremark).sendKeys(AdmissionRemarksPar);
		
		//Bill Estimation NO
		driver.findElement(BillEstimationNoClick).sendKeys(BillEstimationPar);

		//Referral Type
		Thread.sleep(2000);
		driver.findElement(ReferraltypesClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Emergency Referral");
		Thread.sleep(2000);
		driver.findElement(ReferralTypeSelopt).click();

		//Referral 
		Thread.sleep(2000);
		driver.findElement(RefferralClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Dato' Dr. Jefri Zain");
		Thread.sleep(2000);
		driver.findElement(RefferralSelopt).click();


		//Referral Remarks
		Thread.sleep(2000);
		driver.findElement(ReferralRemarkClick).sendKeys(ReferralRemarksPar);

		//Click on Add Button for adding bed
		Thread.sleep(2000);
		driver.findElement(AddButtonClick).click();

		//Condition5
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Expand All"))
		{
			System.out.println("Bed Selection Window Appear");
		}
		else
		{
			System.out.println("Bed Selection Window not Appear");
		}
	

	    //ScreenShot5
		  File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot5,new File(".//ScreenShot//AdmissionRequest5.png"));

		
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
      	Thread.sleep(2000);
		driver.findElement(SearchClick).click();

		//Scrolling the web page
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		//Bed CLick
		Thread.sleep(2000);
		driver.findElement(BedClick).click();

		//Click on Save Button
		Thread.sleep(2000);
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

		//Tab3 Documents
		//Clicking on Document tab
		Thread.sleep(2000);
		driver.findElement(DocumentsClickTab).click();

		//Click on Upload document button

		/*Thread.sleep(4000);
		driver.findElement(UploadDocClick).click();

		Thread.sleep(3000);
		WebElement browse = driver.findElement(ChooseButtonClick);
		//click on ‘Choose file’ to upload the desired file
		browse.sendKeys("C:\\MedcareImg\\data.txt");
		
		Thread.sleep(4000);
		driver.findElement(UploadClick).click();*/

		//Clicking on save button	
		Thread.sleep(2000);
		driver.findElement(SaveBtnClick).click();


		//Clicking on Okay dialog
		Thread.sleep(3000);
		driver.findElement(OkButtonClick).click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//ADTAdmissionForm.png"));  
		
		
		 //TabSwitch
		  Thread.sleep(5000);
	      String windowHandle = driver.getWindowHandle();
		
		//Get the list of window handles

	      ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());

	      //Use the list of window handles to switch between windows
	      Thread.sleep(1000);
	      driver.switchTo().window((String)tabs.get(0));

	      //Condition6
	      Thread.sleep(5000);
	      if(driver.getPageSource().contains("Total Admission"))
	      {
	    	  System.out.println("Admission Dashboard Appear");
	      }
	      else
	      {
	    	  System.out.println("Admission Dashboard Not Appear");
	      }

		    //ScreenShot6
			  File screenshot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(screenshot6,new File(".//ScreenShot//AdmissionRequest6.png"));
	      
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
	      
	        //Condition7
	        Thread.sleep(5000);
	        if(driver.getPageSource().contains("Status")&& (driver.getPageSource().contains("ADMITTED")))
	        {
	        	System.out.println("Status Showing As Admitted");
	        }
	        else
	        {
	        	System.out.println("Status Showing not as Admitted");
	        }
	        
	        //ScreenShot7
			  File screenshot7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(screenshot7,new File(".//ScreenShots//AdmissionRequest7.png"));
	      
	}
	
	public ADTAdmissionForm_WIth_Reg(WebDriver driver)
	{
		this.driver=driver;
	}

}
