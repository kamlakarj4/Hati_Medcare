package OPDTest;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OPD_Reg_With_Primary_id_NEW_IC 
{
	WebDriver driver;
	ATUTestRecorder recorder;

	


@Test	
@Parameters({"Uesrid"})

	public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		OPDpages.Login Loginapp=new OPDpages.Login(driver);
		Loginapp.login_Medcare(Uesrid);

	}
	@Test
	 @Parameters({"PrimaryIdNumber12","SecondaryIdNumber12","SecondaryExparyDatePar","DateOfBirthPar","MotherNamePar","PatientNotes","ResidentialAddressPar","PostCodePar","MobileNumberPar","Emailpar","PersonalFaxpar","WorkFaxpar","WorkContactNopar","HomeContactNopar","EmploymentNoPar","WorkFromPar","ContactNumberPar","ResAddPar","PostCodePar12"})
	public void TC_02_User_Can_Select_Primary_ID_AS_NEW_IC(String PrimaryIdNumber12,String SecondaryIdNumber12,String SecondaryExparyDatePar,String DateOfBirthPar,String MotherNamePar,String PatientNotes,String ResidentialAddressPar,String PostCodePar,String MobileNumberPar,String Emailpar,String PersonalFaxpar,String WorkFaxpar,String WorkContactNopar,String HomeContactNopar,String EmploymentNoPar,String WorkFromPar,String ContactNumberPar,String ResAddPar,String PostCodePar12) throws InterruptedException, IOException, AWTException 
	{
		OPDpages.OPD_Registration_With_Primary_ID_NEW_IC newic=new OPDpages.OPD_Registration_With_Primary_ID_NEW_IC(driver);
		newic.OPD_REG_PRIMARY_ID_NEW_IC(PrimaryIdNumber12,SecondaryIdNumber12,SecondaryExparyDatePar,DateOfBirthPar,MotherNamePar,PatientNotes,ResidentialAddressPar,PostCodePar,MobileNumberPar,Emailpar,PersonalFaxpar,WorkFaxpar,WorkContactNopar,HomeContactNopar,EmploymentNoPar,WorkFromPar,ContactNumberPar,ResAddPar,PostCodePar12);
		
	}
	@Test
	 @Parameters({"EncounterRemarksPar","AddNotesPar","NamePar","IdentificationNOPar","PhoneNoPar","AddressPar","PostcodeParAdetailsPar"})
	  public void TC_03_Verify_That_User_Is_Able_TO_Fill_Encounter_Details(String EncounterRemarksPar,String AddNotesPar,String NamePar,String IdentificationNOPar,String PhoneNoPar,String AddressPar,String PostcodeParAdetailsPar) throws InterruptedException, IOException, AWTException
	  {
		  OPDpages.OPD_Registration_Encounter enc=new OPDpages.OPD_Registration_Encounter(driver);
		  enc.Encounter(EncounterRemarksPar,AddNotesPar,NamePar,IdentificationNOPar,PhoneNoPar,AddressPar,PostcodeParAdetailsPar);
	  } 
	@BeforeTest
	  public void startBrowser() throws ATUTestRecorderException 
	  {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(".//Videos//","OPD_Reg_With_Primary_id_NEW_IC -"+dateFormat.format(date),false);
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
