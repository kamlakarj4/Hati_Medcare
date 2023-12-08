package OPDpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Appointment_List_Advanced_Search 
{
	WebDriver driver=null; 
	public Appointment_List_Advanced_Search(WebDriver driver) 
	{
		this.driver=driver;

	}
	//By Search=By.xpath("mat-icon[mattooltip='Search']");
		By mainmenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
		By MainMenuTooltip=By.xpath("/html/body/div[2]");
		By OPDMenu=By.xpath("//*[@id=\"mat-menu-panel-1\"]/div/div/div[1]/div[1]/div[1]/div/img");
		By SideBarMenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside");
		By AppointmentList=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[2]/ul/li[1]/a/span[1]");
		//Advanced Search
		By advancedSearchClick=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
		//MRN Taking from encounter list
		By MRNL=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[3]");
		By PatientMRNClick=By.cssSelector("input[ng-reflect-name='MRN']");
		By SearchButtonClick=By.cssSelector("button[ng-reflect-message='Search']");
		By RowClicking=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr");
		//By RegistrationSubMenuClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[3]/ul/li[2]/a/span[1]");
public void Advanced_Search_For_Appointment_List_BY_MRN(String MRNPar) throws InterruptedException, IOException
{
	Thread.sleep(2000);
	Actions act = new Actions(driver);
	Thread.sleep(8000);
	WebElement ele=driver.findElement(mainmenu);
	act.moveToElement(ele).build().perform();
	act.click(ele).perform();
	Thread.sleep(4000);
	driver.findElement(OPDMenu).click();
	Thread.sleep(8000);
	driver.findElement(advancedSearchClick).click();
	//Enter MRN In MRN field
	Thread.sleep(2000);
	driver.findElement(PatientMRNClick).sendKeys(MRNPar);
	//Click on Search button
	Thread.sleep(2000);
	driver.findElement(SearchButtonClick).click();
	//Clicking on row
	Thread.sleep(2000);
	driver.findElement(RowClicking).click();
	Thread.sleep(3000);
	if(driver.getPageSource().contains(MRNPar))
	{
		System.out.println(MRNPar+" "+"Patient has been searched"); 
	} else 
	{
		System.out.println("Patient not fount!!!"); 
	}
	

	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	// Open the current date and time
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	FileUtils.copyFile(screenshot, new File(".//ScreenShots//Appointment_List_Advanced_Search_MRN.png"));
}
  
}
