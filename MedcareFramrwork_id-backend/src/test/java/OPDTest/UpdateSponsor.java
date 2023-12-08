package OPDTest;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import OPDpages.Quick_Registration;
import OPDpages.Update_Sponsore_Quick_Registration;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
public class UpdateSponsor  {

	 WebDriver driver;
	ATUTestRecorder recorder;



	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_Verify_Login(String Uesrid) throws InterruptedException, IOException 
	{
		//Login
		OPDpages.Login LoginScreen=new OPDpages.Login(driver);
		LoginScreen.login_Medcare(Uesrid);
	}

	@Test(priority=2)
	@Parameters({"QuickPrimaryIdNumberPar","QuickExparyDatePar","QuickDateOfBirthPar","QuickMobileNumberPar","QuickEncounterRemarksPar","QuickAddNotesPar","QuickEncounterNotesPar","QuickPatientNotesPar","QuickReferralRemarksPar"})
	public void TC_02_Verify_That_User_Is_Able_To_Do_Quick_Registration(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickDateOfBirthPar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar) throws InterruptedException, IOException
	{
		Update_Sponsore_Quick_Registration QuickReg=new Update_Sponsore_Quick_Registration (driver);
		QuickReg.Quick_Registration_Verification(QuickPrimaryIdNumberPar,QuickExparyDatePar,QuickDateOfBirthPar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar);
		//Thread.sleep(10000);
	}


	@Test(priority=3)
	@Parameters({"PolicyNumberPar","EffectivedatePar"})
	public void TC_03_Verify_Update_sponsor(String PolicyNumberPar, String EffectivedatePar) throws InterruptedException, IOException
	{
		OPDpages.UpdateSponsorFlow UpdateComSponsor =new OPDpages.UpdateSponsorFlow(driver);
		UpdateComSponsor.UpdateSponsor1(PolicyNumberPar,EffectivedatePar); 

	}


	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","UpdateSponsor -"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		Thread.sleep(8000);
		driver.manage().window().maximize(); 
	}
	@AfterSuite
	public void afterTest() throws ATUTestRecorderException {
		// driver =new ChromeDriver();
		driver.quit();
		recorder.stop();
	}
}