package ADTpages;

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
import org.testng.Assert;
import org.testng.annotations.Test;

public class ADTBedViewsBY_Bed_Category 
{
	WebDriver driver=null;  


	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By ADTMenu=By.xpath("//span[contains(text(),'ADT')]");
	By SideBarMenuADTScreen=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By AdmissionForm=By.xpath("//span[contains(text(),'Admission Form')]");

	//For all Drop down Search
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
	//Bed View
	By BedViewClick=By.cssSelector("a[ng-reflect-router-link='bed-view']");
	//Search
	By SearchCLick=By.cssSelector("mat-icon[ng-reflect-message='Search ']");

	//clicking on opened bed panel
	By Bedpannel=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-bed-view/mat-drawer-container/mat-drawer-content/div/div/mat-accordion/mat-expansion-panel/mat-expansion-panel-header");
	//Expand Button
	By ExpandClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-bed-view/mat-grid-list[1]/div/mat-grid-tile[7]/div/mat-card/mat-card-content/mat-grid-list/div/mat-grid-tile[4]/div/mat-checkbox/label/span[1]");
	//Ward
	By WardClick=By.xpath("//span[contains(text(),'Select Ward')]");
	By WardSelOpt=By.xpath("//span[contains(text(),'Intensive Care Unit (ICU)')]");
	//bed category
	By BedCategoryClick=By.cssSelector("mat-select[ng-reflect-placeholder='Select Bed Category']");
	By BedCategorySelopt=By.xpath("//span[contains(text(),'6-Bedded')]");

	public void ADT_Bed_View_By_Bed_Catogry() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement ele1=driver.findElement(mainmenuADTScreen);
		act.moveToElement(ele1).build().perform();
		act.click(ele1).perform();
		//Thread.sleep(2000);
		Thread.sleep(3000);
		driver.findElement(ADTMenu).click();

		//Over the slide bar in OPD Screen
		Thread.sleep(10000);
		WebElement overforopdslide1=driver.findElement(SideBarMenuADTScreen);
		act.moveToElement(overforopdslide1).build().perform();

		Thread.sleep(2000);
		driver.findElement(BedViewClick).click();

		Thread.sleep(5000);
		if(driver.getPageSource().contains("Overall Statistics")) 
		{
			System.out.println("Bed View screen has been launched successfully"); 
		} else 
		{
			System.out.println("Bed View Screen failed to open"); 
		}
		//Selecting Ward
		Thread.sleep(2000);
		driver.findElement(WardClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Intensive Care Unit (ICU)");
		Thread.sleep(3000);
		driver.findElement(WardSelOpt).click();

		//Clicking outside space after clicking ward
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveByOffset(200, 0).click().build().perform();
		
		//Selecting Status
		Thread.sleep(2000);
		driver.findElement(BedCategoryClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("6-Bedded");
		Thread.sleep(3000);
		driver.findElement(BedCategorySelopt).click();

		//Clicking outside space after clicking department
		Thread.sleep(2000);
		Actions action3 = new Actions(driver);
		action3.moveByOffset(200, 0).click().build().perform(); 

		//Clicking on Search
		Thread.sleep(2000);
		driver.findElement(SearchCLick).click();

		//Clicking on expand button 
		Thread.sleep(2000);
		driver.findElement(ExpandClick).click();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShot//BedVIewFormBy_Bed_Category.png"+dateFormat.format(date)));  
		if (driver.getPageSource().contains("Intensive Care Unit (ICU)")) 
		{
			System.out.println("Ward searched Successfully");
		}
		else
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShot//FailedForBedCategoryForWardSelection.png"+ dateFormat.format(date)));
			Assert.assertTrue(false,"No Proper bed has been selected");
		}
		/*String Actual_1 = "Ward N3-A";
        String Expected_1 = "Ward N3-A";
        Assert.assertEquals(Actual_1, Expected_1, "Filtered by doctor successfully");
        Thread.sleep(1000);
        File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp3= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        FileUtils.copyFile(screenshot3, new File(".//ScreenShot//Bed_View_Filter_by_Doctor.png"));
        Thread.sleep(3000);*/
	}
	public ADTBedViewsBY_Bed_Category(WebDriver driver)
	{
		this.driver=driver;

	}

}
