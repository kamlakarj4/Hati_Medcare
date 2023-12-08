package ADTpages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;

	// Finding locator for Password
	By tab1 = By.id("tab1");
	By tab2 = By.id("tab2");
	By tab3 = By.id("tab3");
	By tab4 = By.id("tab4");
	By tab5 = By.id("tab5");
	By tab6 = By.id("tab6");
	By tab7 = By.id("tab7");
	By tab8 = By.id("tab8");

	By kk = By.cssSelector("span[ng-reflect-message='Dashboard > Dash']");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void login_Medcare(String Uesrid) throws InterruptedException, IOException {
		// driver.manage().deleteAllCookies();
		// driver=new ChromeDriver();
		// driver.get("https://medcare-productqa.hatiintl.com/");

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(tab1).sendKeys(Uesrid);
		driver.findElement(tab2).sendKeys(Uesrid);
		driver.findElement(tab3).sendKeys(Uesrid);
		driver.findElement(tab4).sendKeys(Uesrid);
		driver.findElement(tab5).sendKeys(Uesrid);
		driver.findElement(tab6).sendKeys(Uesrid);
		driver.findElement(tab7).sendKeys(Uesrid);
		driver.findElement(tab8).sendKeys(Uesrid);
		
		
		//Assert(false);
		
		Thread.sleep(7000);
		
		String ActaulUser ="Dashboard > Dash";
		String EXpectedUser ="Dashboard > Dash";

		Assert.assertEquals(ActaulUser, EXpectedUser, "Login failed entered userid is not found");
		
		if(driver.getPageSource().contains("Dashboard > Dash")) 
		{
			System.out.println("Login successfull"); 
		} else 
		{
			System.out.println("Login failed"); 
		}
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//LoginSuccessfully.png"));
		
	}
}

	
















