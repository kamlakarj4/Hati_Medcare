package OPDTest;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.hibernate.validator.internal.util.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import OPDpages.Login;
import OPDpages.NewAppointMent;
import OPDpages.OPD_Registration_Encounter;
import OPDpages.OPD_registration;
import OPDpages.RescheduleAppointment;
import OPDpages.Reschedule_New_AppointMent;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
public class Reschedule_New_Appointment_against_doctor
{
	 WebDriver driver ;
	ATUTestRecorder recorder;

	
	
	@Test(priority =1)
	@Parameters({"Uesrid"})

	public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		Login Loginapp=new Login(driver);
		Loginapp.login_Medcare(Uesrid);
	
	}
	@Test(priority=2)
	@Parameters({"AppointmenttypeA","consultationA","specialityA","passportA","PrimeryIDNumberA","ExpiryDateA","TitleoptA","GendesendA","dateOfBirthA","addressA","countryPrimaryA","stateA","CityA","postA","CountryCodeA","AreaA","mobileNumberA","workcontactnoA","homecontactnoA","emailA"})
	public void TC_02_Verify_that_user_is_able_to_book_the_New_appointment(String AppointmenttypeA,String consultationA,String specialityA,String passportA,String PrimeryIDNumberA,String ExpiryDateA,String TitleoptA,String GendesendA,String dateOfBirthA,String addressA,String countryPrimaryA,String stateA,String CityA,String postA,String CountryCodeA,String AreaA,String mobileNumberA,String workcontactnoA,String homecontactnoA,String emailA)throws InterruptedException, AWTException, IOException {
	Reschedule_New_AppointMent BookNewAppointment = new Reschedule_New_AppointMent(driver);
	BookNewAppointment.NewAppontmetfunc(AppointmenttypeA,consultationA,specialityA,passportA,PrimeryIDNumberA,ExpiryDateA,TitleoptA,GendesendA,dateOfBirthA,addressA,countryPrimaryA,stateA,CityA,postA,CountryCodeA,AreaA,mobileNumberA,workcontactnoA,homecontactnoA,emailA);

	}

	@Test(priority =3)
	@Parameters({"selectgender"})
	public void TC_03_Verify_That_User_Is_Able_Reshcedule_the_appointment(String selectgender) throws InterruptedException, IOException, AWTException 
	{
		RescheduleAppointment Reschedule=new RescheduleAppointment(driver);
		Reschedule.Resheduleappointmetfunc(selectgender);	  
		Thread.sleep(10000);
	}
	
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Reschedule_New_Appointment_against_doctor -"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		Thread.sleep(9000);
		driver.manage().window().maximize(); 
		
	}
	@AfterSuite
	public void afterTest() throws ATUTestRecorderException {
		// driver =new ChromeDriver();
		driver.quit();
		recorder.stop();
	}

}
