package Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Priority;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import OPDpages.Login;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_openeing_balance {

	WebDriver driver;

    @Test(priority=1)
	@Parameters({"Uesrid"})

	public void TC_1_Login(String Uesrid) throws InterruptedException, IOException {
		Login logintest = new Login(driver);
		logintest.login_Medcare(Uesrid);

	}
    @Test(priority=2)
	public void TC_2_Check_Inventory_openeing_balance() throws InterruptedException {

		pageInventory.Inventory_openeing_balance  inve = new pageInventory.Inventory_openeing_balance();
		inve.Openingfunc();

	}

    @BeforeTest
    public void startBrowser() throws ATUTestRecorderException 
    {
    	
    	
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
    	
    }






}
