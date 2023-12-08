package OPDTest;
import org.testng.annotations.Test;

import OPDpages.Book_to_Cancel_new_appointment_against_departmet;
import OPDpages.BookedNewAppointment;
import OPDpages.Employeedetails;
import OPDpages.ExistingAppointment;
import OPDpages.Medcare_Registeration;
import OPDpages.NewAppointMent;
import OPDpages.New_Appointment_Encounterr;
import OPDpages.OPD_Registration_Encounter;
import OPDpages.OPD_Registration_Encounterr;
import OPDpages.arrivedAppointment;
import OPDpages.cancelAppointmentPage;
import OPDpages.cancel_new_Appointment_against_depratmet;
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

public class Cancel_new_appointment_against_Department {

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
@Parameters({"AppointmenttypeA","consultationA","specialityA","passportA","PrimeryIDNumberA","ExpiryDateA","TitleoptA","GendesendA","dateOfBirthA","addressA","countryPrimaryA","stateA","CityA","postA","CountryCodeA","AreaA","mobileNumberA","workcontactnoA","homecontactnoA","emailA"})
public void TC_02_Verify_that_user_is_able_to_book_the_New_appointment_against_Department(String AppointmenttypeA,String consultationA,String specialityA,String passportA,String PrimeryIDNumberA,String ExpiryDateA,String TitleoptA,String GendesendA,String dateOfBirthA,String addressA,String countryPrimaryA,String stateA,String CityA,String postA,String CountryCodeA,String AreaA,String mobileNumberA,String workcontactnoA,String homecontactnoA,String emailA)throws InterruptedException, AWTException {
Book_to_Cancel_new_appointment_against_departmet BookNewAppointment = new Book_to_Cancel_new_appointment_against_departmet(driver);
BookNewAppointment.NewAppontmetfunc(AppointmenttypeA,consultationA,specialityA,passportA,PrimeryIDNumberA,ExpiryDateA,TitleoptA,GendesendA,dateOfBirthA,addressA,countryPrimaryA,stateA,CityA,postA,CountryCodeA,AreaA,mobileNumberA,workcontactnoA,homecontactnoA,emailA);

}

@Test(priority=3) 
@Parameters({"RemarksPar"})
public void TC_03_Verify_that_appointment_is_cancelled_succsessfull_against_department(String RemarksPar) throws InterruptedException, AWTException, IOException { 
	cancel_new_Appointment_against_depratmet canc = new cancel_new_Appointment_against_depratmet(driver);
	canc.AppointmentCancel(RemarksPar);
	Thread.sleep(10000);
}


	@BeforeTest 
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Cancel_new_appointment_against_Department-"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		driver.manage().window().maximize(); Thread.sleep(8000);
	}

	@AfterSuite
	public void afterTest() throws ATUTestRecorderException { 
		//driver =new ChromeDriver();
		driver.quit();
		recorder.stop();
	}

}
