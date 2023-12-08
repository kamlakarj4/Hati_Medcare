package ADTTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBornTest 
{
	public WebDriver driver;
	ATUTestRecorder recorder;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	
	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_ADT_Admission_Form_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		ADTpages.Login Loginapp=new ADTpages.Login(driver);
		Loginapp.login_Medcare(Uesrid);
	}
	@Test(priority=2)
	@Parameters({"CodePar","DescriptionPar","BedNoPar","CodePar2","DescriptionPar2","BedNoPar2"})
	public void TC_02_User_Is_Able_to_Do_Credale_Bed_Configuration(String CodePar,String DescriptionPar,String BedNoPar,String CodePar2,String DescriptionPar2,String BedNoPar2) throws InterruptedException, IOException
	{
		ADTpages.BedMaster BedMasterConfi=new ADTpages.BedMaster(driver);
		BedMasterConfi.Bed_masterC_Onfiguration(CodePar,DescriptionPar,BedNoPar,CodePar2,DescriptionPar2,BedNoPar2);
	}
	@Test(priority=3)
	@Parameters({"MRNPar","DeliviryDatePar","AdmissionTimePar","IfOutSideHosPar","IndicatorMarkPar","WeightPar","LengthPar","HeadCircumferencePar"})
	public void TC_03_Verify_That_User_Is_Able_To_Create_New_Born_Baby_Admission(String MRNPar,String DeliviryDatePar,String AdmissionTimePar,String IfOutSideHosPar,String IndicatorMarkPar,String WeightPar,String LengthPar,String HeadCircumferencePar) throws InterruptedException, IOException
	{
		ADTpages.NewBornAdmission newBorn=new ADTpages.NewBornAdmission (driver);
		newBorn.New_Born_ADT(MRNPar,DeliviryDatePar,AdmissionTimePar,IfOutSideHosPar,IndicatorMarkPar,WeightPar,LengthPar,HeadCircumferencePar);
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {

		
		recorder = new ATUTestRecorder(".//Videos//","NewBornTest-"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		Thread.sleep(8000);
		driver.manage().window().maximize(); 
	}
	@AfterMethod(alwaysRun=true)
	public void FailedScreenShot(ITestResult Result) throws IOException
	{
		if(ITestResult.FAILURE==Result.getStatus())
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_NewBorn"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		driver.quit();
		recorder.stop();
	}
	}
