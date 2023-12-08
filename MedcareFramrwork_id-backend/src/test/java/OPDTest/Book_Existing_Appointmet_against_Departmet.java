package OPDTest;

import org.testng.annotations.Test;

import OPDpages.BookedexistingAppointment;
import OPDpages.Department_ExistingAppointment;
import OPDpages.Departmet_Existing_appointment_Quick_Registration;
import OPDpages.Departmet_arrivedExistingAppointment;
import OPDpages.Departmet_existing_OPD_Registration_Encounterr;
import OPDpages.Employeedetails;
import OPDpages.ExistingAppointment;
import OPDpages.Medcare_Registeration;
import OPDpages.OPD_Registration_Encounter;
import OPDpages.OPD_Registration_Encounterr;
import OPDpages.Quick_Registration;
import OPDpages.arrivedAppointment;
import OPDpages.arrivedExistingAppointment;
import OPDpages.fillbasicinfopostapponitment;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;


public class Book_Existing_Appointmet_against_Departmet  {
    WebDriver driver;
	ATUTestRecorder recorder;

	


	@Test(priority = 1)
	@Parameters({ "Uesrid" })
	public void TC_01_Verify_that_user_is_able_to_login_the_application(String Uesrid)
		throws InterruptedException, IOException {
		Medcare_Registeration medcare = new Medcare_Registeration(driver);
		medcare.login(Uesrid);
		

	}
	@Test(priority = 2)
	@Parameters({"QuickPrimaryIdNumberPar","QuickExparyDatePar","QuickDateOfBirthPar","QuickMobileNumberPar","QuickEncounterRemarksPar","QuickAddNotesPar","QuickEncounterNotesPar","QuickPatientNotesPar","QuickReferralRemarksPar"})
	public void TC_02_Verify_That_User_Is_Able_To_Do_Quick_Registration_to_book_the_existing_appointmet(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickDateOfBirthPar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar) throws InterruptedException, IOException
	{
		Departmet_Existing_appointment_Quick_Registration depexiQuickReg=new Departmet_Existing_appointment_Quick_Registration (driver);
		depexiQuickReg.Quick_Registration_Verification(QuickPrimaryIdNumberPar,QuickExparyDatePar,QuickDateOfBirthPar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar);
		Thread.sleep(10000);
	}

	@Test(priority = 3)
	@Parameters({ "AppointmenttypeA", "consultationA", "specialityA","EmailA", "WorkcontctA", "HomecontactA", "RemarksA" })
	public void TC_03_Verify_that_user_is_able_to_book_the_Existing_Appointmet_for_Department_Apointment_Type_Journey(String AppointmenttypeA, String consultationA, String specialityA,String EmailA, String WorkcontctA, String HomecontactA, String RemarksA)throws InterruptedException, AWTException, IOException {
		Department_ExistingAppointment depexBookExitingAppointment = new Department_ExistingAppointment(driver);
		depexBookExitingAppointment.ExitingAppontmetfunc(AppointmenttypeA, consultationA,specialityA,EmailA, WorkcontctA, HomecontactA, RemarksA);
	}

	
	  

	  @Test(priority=4)
	  public void TC_04_Verify_that_for_Department_Apointment_Type_Journey_Existing_appointmet_is_booked_successfully() throws InterruptedException, AWTException, IOException {
	  BookedexistingAppointment depexappointmentt = new BookedexistingAppointment(driver);
	  depexappointmentt.Appointmentarrivedfunc(); Thread.sleep(10000); 
	  
	  }
	 
	  /*
	@Test(priority = 5)
	@Parameters({ "EncounterRemarksPar", "AddNotesPar", "NamePar", "IdentificationNOPar", "PhoneNoPar", "AddressPar","PostcodeParAdetailsPar" })
	public void TC_05_Verify_that_user_is_able_to_redirect_to_the_encounter_page_and_fill_the_details_for_Department_Apointment_Type_Journey(String EncounterRemarksPar, String AddNotesPar, String NamePar, String IdentificationNOPar,String PhoneNoPar, String AddressPar, String PostcodeParAdetailsPar)throws InterruptedException, AWTException, IOException {
		Departmet_existing_OPD_Registration_Encounterr depxencounterr = new Departmet_existing_OPD_Registration_Encounterr(driver);
		depxencounterr.Encounter(EncounterRemarksPar, AddNotesPar, NamePar, IdentificationNOPar, PhoneNoPar, AddressPar,PostcodeParAdetailsPar);
		Thread.sleep(10000);
	}
	

	@Test(priority = 4)
	
	public void TC_04_Verify_that_existing_appointmet_is_Arrived_successfully_for_Department_Apointment_Type_Journey()throws InterruptedException, AWTException, IOException {
		Departmet_arrivedExistingAppointment depaxappointmentt = new Departmet_arrivedExistingAppointment(driver);
		depaxappointmentt.Appointmentarrivedfunc();
		Thread.sleep(10000);
	}
	
	*/

	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Book_Existing_Appointmet_against_Departmet -"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		driver.manage().window().maximize();
		Thread.sleep(8000);
	}

	@AfterSuite
	public void afterTest() throws ATUTestRecorderException {
		// driver =new ChromeDriver();
		driver.quit();
		recorder.start();
	}

}
