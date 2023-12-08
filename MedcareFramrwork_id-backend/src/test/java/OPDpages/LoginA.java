package OPDpages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginA 
{
	
	WebDriver driver=null;
	
	By tab1=By.id("tab1");
	By tab2=By.id("tab2");
	By tab3=By.id("tab3");
	By tab4=By.id("tab4");
	By tab5=By.id("tab5");
	By tab6=By.id("tab6");
	By tab7=By.id("tab7");
	By tab8=By.id("tab8");
	
	public LoginA(WebDriver driver)
	
	{
		this.driver=driver;
	}

@Test
  @Parameters({"Uesrid"})
  public void LoginMedcare(String Uesrid) throws InterruptedException, IOException 
  {
	  
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
		
		
		
		Thread.sleep(5000);
		   if(driver.getPageSource().contains("Dashboard > Dash")) 
		   {
		   System.out.println("Login successfull"); 
		   } else 
		   {
		   System.out.println("Login failed"); 
		   }

		
		Thread.sleep(2000);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//LoginSuccessfully.png"));

		
  }
}
