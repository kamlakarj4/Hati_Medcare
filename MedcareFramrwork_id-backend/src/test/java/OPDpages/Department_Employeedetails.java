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


public class Department_Employeedetails {

	WebDriver driver = null;

	By dropdownsearch = By.cssSelector("input[aria-label='dropdown search']");
	By empdetails = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[3]/form/mat-tab-group/mat-tab-header/div/div/div/div[2]");
	By Employer = By.cssSelector("mat-select[ng-reflect-id='Employer']");
	By bn = By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
	By employmentNo = By.cssSelector("input[ng-reflect-name='employmentNo']");
	By workingFrom = By.cssSelector("input[ng-reflect-name='workingFrom']");
	By employmentContactNo = By.cssSelector("input[ng-reflect-name='employmentContactNo']");
	By Residential = By.cssSelector("input[ ng-reflect-placeholder='Residential Address']");
	By employmentCountry = By.cssSelector("mat-select[ng-reflect-name='employmentCountry']");
	By employmentState = By.cssSelector("mat-select[ng-reflect-name='employmentState']");
	By employmentCity = By.cssSelector("mat-select[ng-reflect-name='employmentCity']");
	By employmentPostCode = By.cssSelector("input[ng-reflect-name='employmentPostCode']");

	By document = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[3]/form/mat-tab-group/mat-tab-header/div/div/div/div[3]");
	By Upload = By.cssSelector("mat-icon[ng-reflect-message='Upload']");
	By choosefile = By.xpath("//*[@id=\"fileUpload\"]");
	By uploaddocs = By.cssSelector("mat-icon[ng-reflect-message='Upload Document']");

	By Save = By.cssSelector("mat-icon[ng-reflect-message='Save']");
	By Yes = By.cssSelector("mat-icon[ng-reflect-message='Yes']");


	public Department_Employeedetails(WebDriver driver) {
		this.driver= driver;

	}




	public void empdetailsfun(String employmentNoB,String workingFromB,String employmentContactNoB,String ResidentialB,String Residential1B,String employmentCountryB,String employmentStateB,String employmentCityB,String employmentPostCodeB) throws InterruptedException, AWTException, IOException {

		Thread.sleep(500);
		driver.findElement(empdetails).click();
		//Thread.sleep(3000);
		//driver.findElement(Employer).click();
		Thread.sleep(500);
		// driver.findElement(bn).click();
		// Thread.sleep(3000);
		driver.findElement(employmentNo).sendKeys(employmentNoB);
		Thread.sleep(500);
		driver.findElement(workingFrom).sendKeys(workingFromB);
		Thread.sleep(500);
		driver.findElement(employmentContactNo).sendKeys(employmentContactNoB);
		Thread.sleep(500);
		driver.findElement(Residential).sendKeys(ResidentialB);
		Thread.sleep(500);
		driver.findElement(Residential).sendKeys(Residential1B);
		Thread.sleep(500);
		driver.findElement(employmentCountry).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(employmentCountryB);
		Thread.sleep(500);
		driver.findElement(employmentCountry).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(employmentState).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(employmentStateB);
		Thread.sleep(500);
		driver.findElement(employmentState).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(employmentCity).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(employmentCityB);
		Thread.sleep(500);
		driver.findElement(employmentCity).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(employmentPostCode).sendKeys(employmentPostCodeB);
		Thread.sleep(2000);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//New_Appointmet_departmet_EmployeeDetails.png"));
		driver.findElement(Save).click();
		Thread.sleep(500);
		driver.findElement(Yes).click();

		Thread.sleep(8000);
		String winHandleBefore = driver.getWindowHandle();
		//Thread.sleep(8000);
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(8000);

	}



}