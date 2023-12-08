package OPDTest;
import org.testng.annotations.Test;

import OPDpages.Book_Reschedule_ExistingAppointment_against_Department;
import OPDpages.BookedNewAppointment;
import OPDpages.Cancel_Existing_Appointment_Department;
import OPDpages.Cancel_Existing_Appointment_against_doctor;
import OPDpages.Cancel_existing_appointment_againsr_depart_Quick_Registration;
import OPDpages.Employeedetails;
import OPDpages.ExistingAppointment;
import OPDpages.Medcare_Registeration;
import OPDpages.NewAppointMent;
import OPDpages.New_Appointment_Encounterr;
import OPDpages.OPD_Registration_Encounter;
import OPDpages.OPD_Registration_Encounterr;
import OPDpages.Quick_Registration;
import OPDpages.arrivedAppointment;
import OPDpages.cancelAppointmentPage;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Cancel_Existing_appointment_against_Department {

	WebDriver driver;
	ATUTestRecorder recorder;

	
@Test(priority=1)
@Parameters({"Uesrid"})
public void TC_01_Verify_that_user_is_able_to_login_the_application(String Uesrid) throws InterruptedException, IOException {
Medcare_Registeration medcare = new Medcare_Registeration(driver);
medcare.login(Uesrid);
//Thread.sleep(5000);

}
@Test(priority=2)
@Parameters({"QuickPrimaryIdNumberPar","QuickExparyDatePar","QuickDateOfBirthPar","QuickMobileNumberPar","QuickEncounterRemarksPar","QuickAddNotesPar","QuickEncounterNotesPar","QuickPatientNotesPar","QuickReferralRemarksPar"})
public void TC_02_Verify_That_User_Is_Able_To_Do_Quick_Registration_to_cancel_existing_appointment_against_Department(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickDateOfBirthPar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar) throws InterruptedException, IOException
{
	Cancel_existing_appointment_againsr_depart_Quick_Registration QuickReg=new Cancel_existing_appointment_againsr_depart_Quick_Registration (driver);
	QuickReg.Quick_Registration_Verification(QuickPrimaryIdNumberPar,QuickExparyDatePar,QuickDateOfBirthPar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar);
	Thread.sleep(10000);
}
@Test(priority = 3)
@Parameters({"AppointmenttypeA", "consultationA", "specialityA", "EmailA", "WorkcontctA", "HomecontactA", "RemarksA" })
public void TC_03_Verify_that_user_is_able_to_book_the_Existing_appointment__against_Department_to_cancel_appointment(String AppointmenttypeA, String consultationA, String specialityA, String EmailA, String WorkcontctA, String HomecontactA, String RemarksA)throws InterruptedException, AWTException, IOException {
	Cancel_Existing_Appointment_Department BookExitingAppointment = new Cancel_Existing_Appointment_Department(driver);
	BookExitingAppointment.ExitingAppontmetfunc(AppointmenttypeA, consultationA,specialityA, EmailA, WorkcontctA, HomecontactA, RemarksA);
}

@Test(priority=4) 
@Parameters({"RemarksPar"})
public void TC_04_Verify_that_Existing_appointment_is_cancelled_succsessfull_against_Department(String RemarksPar) throws InterruptedException, AWTException, IOException { 
	Cancel_Existing_Appointment_against_doctor canc = new Cancel_Existing_Appointment_against_doctor(driver);
	canc.AppointmentCancel(RemarksPar);
	Thread.sleep(10000);
}


	@BeforeTest 
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Cancel_Existing_appointment_against_Department -"+dateFormat.format(date),false);
		recorder.start();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		driver.manage().window().maximize(); Thread.sleep(8000);
	}
/*
	@AfterSuite
	public void afterTest() throws ATUTestRecorderException { 
		//driver =new ChromeDriver();
		driver.quit();
		recorder.stop();
	}
  */
}
