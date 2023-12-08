package OPDTest;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import OPDpages.Advanced_serach_forappointment_list_BY_Name_Quick_Registration;
import OPDpages.Quick_Registration;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Modify_Existing_Patient_Admission_Request 
{

	 WebDriver driver ;
	ATUTestRecorder recorder;

	


	@Test(priority=1)	
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		OPDpages.Login Loginapp=new OPDpages.Login(driver);
		Loginapp.login_Medcare(Uesrid);

	} 

	@Test(priority=2)
	@Parameters({"NameSearch"})
	public void TC_02_Verify_That_User_Can_Search_Appoint_Using_Advanced_Search_By_Name(String NameSearch) throws InterruptedException, IOException
	{
		OPDpages.Appointment_List_Advanced_Search_By_Name search=new OPDpages.Appointment_List_Advanced_Search_By_Name(driver);
		search.Advanced_Search_For_Appointment_List_BY_Name(NameSearch);	
	}



	@BeforeTest
	public void startBrowser() throws ATUTestRecorderException 
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Advanced_Search_Of_Appointment_By_Name -"+dateFormat.format(date),false);
		recorder.start();  

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
	}
	


	@AfterSuite
	public void afterTest() throws ATUTestRecorderException {
		// driver =new ChromeDriver();
		driver.quit();
		recorder.stop();;
	}

}
