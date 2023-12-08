package OPDpages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Department_BookedexistingAppointment {

	WebDriver driver = null;

	By Menu = By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	//By Menu2 =By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
	//By mattooltip = By.cssSelector("mat-icon[mattooltip='Menu']");
	//By opd = By.xpath("//*[@id='mat-menu-panel-1']/div/div/div[1]/div[1]/div[1]/div/img");
	By opd2 = By.xpath("//*[@id=\"mat-menu-panel-6\"]/div/div/div[1]/div[1]/div[1]");
	By sidebar = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[1]/a");
	By Appointment = By.cssSelector("a[id='200101']");


	By AppointmentList = By.cssSelector("a[id='200102']");
	By Expand = By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	By PatientName = By.cssSelector("input[ng-reflect-name='PatientName']");
	By Search = By.cssSelector("button[ng-reflect-message='Search']");
	//By checkbox = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr/td[1]/mat-checkbox");

	By checkbox = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr/td[1]/mat-checkbox");
	By CheckIn = By.cssSelector("mat-icon[ng-reflect-message='Check In']");



	public Department_BookedexistingAppointment(WebDriver driver) {
		this.driver= driver;

	}

	public void Appointmentarrivedfunc(String PatientNameA) throws InterruptedException, AWTException, IOException {
		driver.findElement(Menu).click();
		Thread.sleep(4000);
		driver.findElement(opd2).click();
		Thread.sleep(4000);
		driver.findElement(Expand).click();
		Thread.sleep(2000);
		driver.findElement(PatientName).sendKeys(PatientNameA);
		Thread.sleep(2000);
		//driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(Search).click();
		Thread.sleep(4000);

		Thread.sleep(2000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//BookedExistingAppointment.png"));

		if(driver.getPageSource().contains("Booked")) 
		{
			System.out.println("Existing appointment has been booked successfully"); 
		} else 
		{
			System.out.println("Existing appointment is not Booked"); 
		}
		Thread.sleep(700);
		driver.findElement(checkbox).click();
		Thread.sleep(700);
		driver.findElement(CheckIn).click();
		Thread.sleep(700);




	}



}

