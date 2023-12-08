package OPDTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Advanced_Search_Quick_Registration_By_MRN 
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
	@Parameters({"MRNPar"})
	public void TC_02_Verify_That_User_Is_Able_To_Add_New_Encounter_For_Quick_REG_to_Already_Registred_Patient_By_Searh_Patient_MRN(String MRNPar) throws InterruptedException, IOException
	{
		OPDpages.Quick_Registration_Advanced_Search_By_MRN  QuickReg=new OPDpages.Quick_Registration_Advanced_Search_By_MRN(driver);
		QuickReg.Quick_Registration_Advanced_Search_MRN(MRNPar);	
	}
	@BeforeTest
	public void startBrowser() throws ATUTestRecorderException 
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","Advanced_Search_Quick_Registration_By_MRN -"+dateFormat.format(date),false);
		recorder.start();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		//driver.close();
		//driver.quit();
	}
	@AfterSuite
	public void afterTest() throws ATUTestRecorderException {
		// driver =new ChromeDriver();
		driver.quit();
		recorder.stop();
	}
}
