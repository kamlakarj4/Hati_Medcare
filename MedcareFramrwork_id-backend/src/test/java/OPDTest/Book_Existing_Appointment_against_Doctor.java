package OPDTest;

import org.testng.annotations.Test;

import OPDpages.Book_Existing_appointment_against_doctor_Quick_Registration;
import OPDpages.BookedexistingAppointment;
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

public class Book_Existing_Appointment_against_Doctor   {

	WebDriver driver ;
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
	public void TC_02_Verify_That_User_Is_Able_To_Do_Quick_Registration(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickDateOfBirthPar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar) throws InterruptedException, IOException
	{
		
		Book_Existing_appointment_against_doctor_Quick_Registration QuickReg=new Book_Existing_appointment_against_doctor_Quick_Registration (driver);
		QuickReg.Quick_Registration_Verification(QuickPrimaryIdNumberPar,QuickExparyDatePar,QuickDateOfBirthPar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar);
		Thread.sleep(10000);
	}

	@Test(priority = 3)
	@Parameters({"AppointmenttypeA", "consultationA", "specialityA","EmailA", "WorkcontctA", "HomecontactA", "RemarksA" })
	public void TC_03_Verify_that_user_is_able_to_book_the_Existing_appointment(String AppointmenttypeA, String consultationA, String specialityA,String EmailA, String WorkcontctA, String HomecontactA, String RemarksA)throws InterruptedException, AWTException, IOException {
		ExistingAppointment BookExitingAppointment = new ExistingAppointment(driver);
		BookExitingAppointment.ExitingAppontmetfunc( AppointmenttypeA, consultationA,specialityA, EmailA, WorkcontctA, HomecontactA, RemarksA);
	}

	
	
	  @Test(priority=4)
	  public void TC_04_Verify_that_Existing_appointment_is_booked_successfully() throws InterruptedException, AWTException, IOException {
	  BookedexistingAppointment appointmentt = new BookedexistingAppointment(driver);
	  appointmentt.Appointmentarrivedfunc(); Thread.sleep(10000); }
	 

	@Test(priority = 5)
	@Parameters({ "EncounterRemarksPar", "AddNotesPar", "NamePar", "IdentificationNOPar", "PhoneNoPar", "AddressPar","PostcodeParAdetailsPar" })
	public void TC_05_Verify_that_user_is_able_to_redirect_to_the_encounter_page_and_fill_the_details(String EncounterRemarksPar, String AddNotesPar, String NamePar, String IdentificationNOPar,String PhoneNoPar, String AddressPar, String PostcodeParAdetailsPar)throws InterruptedException, AWTException, IOException {
		OPD_Registration_Encounterr encounterr = new OPD_Registration_Encounterr(driver);
		encounterr.Encounter(EncounterRemarksPar, AddNotesPar, NamePar, IdentificationNOPar, PhoneNoPar, AddressPar,PostcodeParAdetailsPar);

	}

	@Test(priority = 6)
	public void TC_06_Verify_that_Existing_appointment_Arrived_successfully()throws InterruptedException, AWTException, IOException {
		arrivedExistingAppointment appointmentt = new arrivedExistingAppointment(driver);
		appointmentt.Appointmentarrivedfunc();
		Thread.sleep(10000);
		
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Book_Existing_Appointment_against_Doctor -"+dateFormat.format(date),false);
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
