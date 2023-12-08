package ADTpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelAdmission
{
	WebDriver driver=null;

	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By ADTMenu=By.xpath("//span[contains(text(),'ADT')]");
	By SideBarMenuADTScreen=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By DashBoardClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[3]/a/span[1]");

	By AdvancedSearchClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/div[2]/mat-icon");
	//MRN
	By MRNSearchClick=By.cssSelector("input[ng-reflect-name='mrn']");
	//Search button
	By SearchClick=By.cssSelector("button[ng-reflect-message='Search']");

	By Tableclick=By.cssSelector("tbody[role='rowgroup']");

	By SearchedElement=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-dashboard/mat-drawer-container/mat-drawer-content/div/table/tbody/tr/td[2]");

	//Clicking on row
	By ROWClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-dashboard/mat-drawer-container/mat-drawer-content/div/table/tbody/tr");

	//Clicking on Cancel Admission
	By CancelAdmission=By.cssSelector("img[ng-reflect-message='Cancel Admission']");

	//Cancel Radio Button
	By CancelRadioButton=By.cssSelector("mat-radio-button[ng-reflect-value='Cancelled']");

	//Reason
	By ReasonClick=By.cssSelector("mat-select[ng-reflect-name='Reason']");
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
	By ReasonSelOpt=By.xpath("//span[contains(text(),'Doctors order')]");

	//Remark
	By RemarksClick=By.cssSelector("input[ng-reflect-name='remarks']");

	//Confirm
	By ConfirmButtonClick=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-cancel-discharge/div[3]/td/button");

	public void Cancel_ADT_Admission(String RemarkPar) throws InterruptedException, IOException 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele1=driver.findElement(mainmenuADTScreen);
		act.moveToElement(ele1).build().perform();
		act.click(ele1).perform();
		//Thread.sleep(2000);
		Thread.sleep(3000);
		driver.findElement(ADTMenu).click();

		//Over the slide bar in Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenuADTScreen);
		act.moveToElement(overforopdslide1).build().perform();

		//Clicking on dashboard Menu
		Thread.sleep(3000);
		driver.findElement(DashBoardClick).click();
		
		Thread.sleep(3000);
		if(driver.getPageSource().contains("Total Admission")) 
		{
			System.out.println("Admission Dashboard screen has been launched successfully"); 
		} else 
		{
			System.out.println("Admission Dashboard Screen failed to open"); 
		}
/*
		//Clicking on advanced search
		Thread.sleep(3000);
		driver.findElement(AdvancedSearchClick).click();

		Thread.sleep(1500);
		WebElement MRN=driver.findElement(MRNSearchClick);
		MRN.sendKeys(MRNPar);

		//Click on search button
		Thread.sleep(3000);
		driver.findElement(SearchClick).click();
*/
		//Clicking Row 
		Thread.sleep(3000);
		driver.findElement(ROWClick).click();

		//Clicking on Cancel Admission
		Thread.sleep(3000);
		driver.findElement(CancelAdmission).click();

		//Reason Click
		Thread.sleep(1500);
		driver.findElement(ReasonClick).click();
		Thread.sleep(1500);
		driver.findElement(ReasonSelOpt).click();

		//Adding remark
		Thread.sleep(1500);
		driver.findElement(RemarksClick).sendKeys(RemarkPar);

		//Confirm Click
		Thread.sleep(1500);
		driver.findElement(ConfirmButtonClick).click();

		//Clicking on Cancel radio button.
		Thread.sleep(3000);
		driver.findElement(CancelRadioButton).click();
		
	}
		/*
		//Clicking on advanced search
		Thread.sleep(3000);
		driver.findElement(AdvancedSearchClick).click();
		
		Thread.sleep(1500);
		WebElement MRN1=driver.findElement(MRNSearchClick);
		MRN1.sendKeys(MRNPar);
		//Click on search button
		Thread.sleep(1500);
		driver.findElement(SearchClick).click();
		
		
		
		
		if (driver.getPageSource().contains(MRNPar)&& driver.getPageSource().contains("CANCELLED"))  
		{
			System.out.println(MRNPar + " " + "Admission has been cancelled successfully ");
		}
		else
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//FailedADTAdmissionForm_List_Advanced_Search_By_MRN.png"+ dateFormat.format(date)));
			Assert.assertTrue(false,"Admission Not cancelled");
		}
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShot//CancelAdmissionForm.png"+dateFormat.format(date)));  
	}
	*/



	public CancelAdmission(WebDriver driver)
	{
		this.driver=driver;
	}
}
