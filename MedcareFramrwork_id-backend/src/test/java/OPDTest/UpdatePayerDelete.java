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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdatePayerDelete  {
	
	 WebDriver driver ;
	ATUTestRecorder recorder;

	
	
  @Test
  @Parameters({"Uesrid"})
  public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplicationogin (String Uesrid) throws InterruptedException, IOException 
  {
	//Login
	  OPDpages.Login LoginScreen=new OPDpages.Login(driver);
	  LoginScreen.login_Medcare(Uesrid);
  }
  
	  
@Test
@Parameters({"QuickPrimaryIdNumberPar","QuickExparyDatePar","QuickDateOfBirthPar","QuickFullNamePar","QuickMobileNumberPar","QuickEncounterRemarksPar","QuickAddNotesPar","QuickEncounterNotesPar","QuickPatientNotesPar","QuickReferralRemarksPar","PolicyNumberPar","EffectivedatePar","ReasonSelectPar","DeleteRemarksPar"})
public void TC_02_Verify_That_User_Able_to_Delete_Update_sponsor_Delete(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickDateOfBirthPar,String QuickFullNamePar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar,String PolicyNumberPar,String EffectivedatePar,String ReasonSelectPar, String DeleteRemarksPar ) throws InterruptedException, IOException
{
	//UpdateSponsorFlow 
	
	OPDpages.UpdateSponsorPayerDelete UpdateComSponsor =new OPDpages.UpdateSponsorPayerDelete(driver);
	 UpdateComSponsor.UpdateSponsorDelete(QuickPrimaryIdNumberPar,QuickExparyDatePar,QuickDateOfBirthPar,QuickFullNamePar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar,PolicyNumberPar,EffectivedatePar,ReasonSelectPar,DeleteRemarksPar); 
	 
}


@BeforeTest
public void startBrowser() throws ATUTestRecorderException 
{
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	recorder = new ATUTestRecorder(".//Videos//","UpdatePayerDelete -"+dateFormat.format(date),false);
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