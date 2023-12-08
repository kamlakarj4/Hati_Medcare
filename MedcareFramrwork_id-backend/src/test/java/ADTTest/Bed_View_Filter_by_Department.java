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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Bed_View_Filter_by_Department 
{
	WebDriver driver;
	ATUTestRecorder recorder;	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	
	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_ADT_Dashboard_Screen(String Uesrid) throws InterruptedException, IOException
	{
		ADTpages.Login Loginapp=new ADTpages.Login(driver);
		Loginapp.login_Medcare(Uesrid);
	}
	@Test(priority=2)
  public void TC_02_Verfiy_That_User_Is_Able__Filter_by_Department_Bed_View() throws InterruptedException, IOException
  {
		ADTpages.Bed_View_Filter_by_Department dep = new ADTpages.Bed_View_Filter_by_Department(driver);
		dep.Bed_View_Filter_by_Departmentfunc();
  }	
	@BeforeTest
	public void startBrowser() throws ATUTestRecorderException 
	{

		recorder = new ATUTestRecorder(".//Videos//","Bed_View_Filter_by_Department -"+dateFormat.format(date),false);
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
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_Bed_View_Filter_by_Department"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void afterTest() throws ATUTestRecorderException 
	{
		driver.quit();
		recorder.stop();;
	}

}
