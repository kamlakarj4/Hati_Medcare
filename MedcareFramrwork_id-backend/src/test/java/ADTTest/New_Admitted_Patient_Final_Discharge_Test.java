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
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class New_Admitted_Patient_Final_Discharge_Test {

	ATUTestRecorder recorder;
	WebDriver driver;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();

	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_Verify_Login(String Uesrid) throws InterruptedException, IOException 
	{
		//Login
		ADTpages.Login LoginScreen=new ADTpages.Login(driver);
		LoginScreen.login_Medcare(Uesrid);
	}
	@Test(priority=2)
	@Parameters({"PriNumberPar","PatientNamePar","ExpiryDatePar","DOBPar","MobilePar","EmailPar","LengthPar","NotesPar","RemarksPar","RegAddressPar","LengthOfStayPar","AdmittingDiagPar","AddNotesPar","PatientNotesPar","AdmissionRemarksPar","BillEstimationPar","ReferralRemarksPar","NamePar","IdentificationNOPar","PhoneNumberPar","AddressPar","ZipCodePar","InstructionPar","ClincialRemarksPar"})
	public void TC_02_User_Able_To_Do_Final_Discharge(String PriNumberPar,String PatientNamePar,String ExpiryDatePar,String DOBPar,String MobilePar,String EmailPar,String LengthPar,String NotesPar,String RemarksPar,String RegAddressPar,String LengthOfStayPar,String AdmittingDiagPar,String AddNotesPar,String PatientNotesPar,String AdmissionRemarksPar,String BillEstimationPar,String ReferralRemarksPar,String NamePar,String IdentificationNOPar,String PhoneNumberPar,String AddressPar,String ZipCodePar,String InstructionPar,String ClincialRemarksPar) throws InterruptedException, IOException
	{
		ADTpages.Admitted_Patient_Final_Discharge AdmittedFinalDischarge=new ADTpages.Admitted_Patient_Final_Discharge(driver);
		AdmittedFinalDischarge.AdmittedPatientFinalDischarge (PriNumberPar,PatientNamePar,ExpiryDatePar,DOBPar,MobilePar,EmailPar,LengthPar,NotesPar,RemarksPar,RegAddressPar,LengthOfStayPar,AdmittingDiagPar,AddNotesPar,PatientNotesPar,AdmissionRemarksPar,BillEstimationPar,ReferralRemarksPar,NamePar,IdentificationNOPar,PhoneNumberPar,AddressPar,ZipCodePar,InstructionPar,ClincialRemarksPar);

	}
	@BeforeTest 
	public void startBrowser() throws ATUTestRecorderException 
	{
		recorder = new ATUTestRecorder(".//Videos//","NewAdmissionWithVIPPatient_NewIC"+dateFormat.format(date),false);
		recorder.start();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");  
	}
	@AfterMethod(alwaysRun=true)
	public void FailedScreenShot(ITestResult Result) throws IOException
	{
		if(ITestResult.FAILURE==Result.getStatus())
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_New_Admitted_Patient_Final_Discharge_Test"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		driver.quit();
		recorder.stop();
	}
}