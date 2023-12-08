package OPDTest;

import org.testng.annotations.Test;

import OPDpages.BookedexistingAppointment;
import OPDpages.Employeedetails;
import OPDpages.ExistingAppointment;
import OPDpages.Hold_AppointMent;
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

public class Hold_Apointment  {

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
	@Parameters({"AppointmenttypeA", "consultationA","specialityA",})
	
	public void TC_01_Verify_that_user_is_able_to_Hold_the_appointment(String AppointmenttypeA, String consultationA, String specialityA)throws InterruptedException, IOException, AWTException {
		Hold_AppointMent holdappointmet = new Hold_AppointMent(driver);
		holdappointmet.NewAppontmetfunc(AppointmenttypeA,consultationA, specialityA);
        
	}
	

	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Hold_Apointment -"+dateFormat.format(date),false);
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
		recorder.stop();
	}

}
