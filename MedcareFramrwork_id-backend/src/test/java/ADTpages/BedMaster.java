package ADTpages;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BedMaster 
{
	WebDriver driver=null;

	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	
	By AllDropDownSearch1=By.cssSelector("input[aria-label='dropdown search']");

	//Master Menu
	By MasterMenuClick=By.xpath("//span[contains(text(),'Master')]");

	//Other Master Click
	By OtherMasterClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[2]/a/span[1]");

	By SideBarMenu=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	//Bed Master
	By BedMaster=By.xpath("//span[contains(text(),'Bed Master')]");

	//Add Buttons
	By AddButtons=By.xpath("//mat-icon[contains(text(),'add')]");

	//Unit
	By UnitClick=By.cssSelector("mat-select[formcontrolname='unit']");
	By UnitSelOpt=By.xpath("//span[contains(text(),'HATI Intl Specialist Hospital, KL')]");

	//code
	By code1ClickBy=By.cssSelector("input[ng-reflect-name='code']");

	//Description
	By Description1Click=By.cssSelector("input[ng-reflect-name='desc']");

	//Bed No
	By BedNo1Click=By.cssSelector("input[ng-reflect-name='bedNo']");

	//Ward
	By WardClick=By.cssSelector("mat-select[ng-reflect-name='ward']");
	By WardSelOpt=By.xpath("//span[contains(text(),'Obstetric and Gynecology Intensive Care Unit A')]");
	

	//Room
	By RoomClick=By.cssSelector("mat-select[ng-reflect-name='room']");
	By RoomSelOpt=By.xpath("//span[contains(text(),'O&G ICU A Room 2')]");

	//ParentId
	By ParentIdClick=By.cssSelector("mat-select[ng-reflect-name='parentId']");
	By ParentSelOpt=By.xpath("//span[contains(text(),'OG-A-R2 004')]");

	//Is Cradle
	By IsCradleClick=By.cssSelector("mat-slide-toggle[ng-reflect-name='isCradle']");
	//Click on Add TO List
	By AddTOListClick=By.cssSelector("mat-icon[ng-reflect-message='Add to List']");

	//Save Button CLick
	By SaveButtonClick=By.cssSelector("button[ng-reflect-message='Save']");
	
	//for next baby
	//code
		By code2ClickBy=By.cssSelector("input[ng-reflect-name='code']");

		//Description
		By Description2Click=By.cssSelector("input[ng-reflect-name='desc']");

		//Bed No
		By BedNo2Click=By.cssSelector("input[ng-reflect-name='bedNo']");


	public void Bed_masterC_Onfiguration(String CodePar,String DescriptionPar,String BedNoPar,String CodePar2,String DescriptionPar2,String BedNoPar2) throws InterruptedException, IOException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		Thread.sleep(2000);
		Actions act = new Actions(driver);

		Thread.sleep(2000);
		WebElement ele1=driver.findElement(mainmenuADTScreen);
		act.moveToElement(ele1).build().perform();
		act.click(ele1).perform();

		Thread.sleep(10000);
		driver.findElement(MasterMenuClick).click();

		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenu);
		act.moveToElement(overforopdslide1).build().perform();
		
		Thread.sleep(4000);
		driver.findElement(BedMaster).click();
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Master > OtherMasters > Bed Master")) 
		{
			System.out.println("Bed Master screen has been launched successfully"); 
		} else 
		{
			System.out.println("Bed Master Screen failed to open"); 
		}

		Thread.sleep(3000);
		driver.findElement(AddButtons).click();

		//Selecting Unit
		Thread.sleep(2000);
		driver.findElement(UnitClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("HATI Intl Specialist Hospital, KL");
		Thread.sleep(2000);
		driver.findElement(UnitSelOpt).click();

		//Selecting Code
		Thread.sleep(2000);
		driver.findElement(code1ClickBy).sendKeys(CodePar);

		//Selecting Description
		Thread.sleep(2000);
		driver.findElement(Description1Click).sendKeys(DescriptionPar);

		//Selecting Bed number
		Thread.sleep(2000);
		driver.findElement(BedNo1Click).sendKeys(BedNoPar);		

		//Selecting Ward
		Thread.sleep(2000);
		driver.findElement(WardClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("Obstetric and Gynecology Intensive Care Unit A");
		Thread.sleep(2000);
		driver.findElement(WardSelOpt).click();

		//Selecting Room
		Thread.sleep(2000);
		driver.findElement(RoomClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("O&G ICU A Room 2");
		Thread.sleep(2000);
		driver.findElement(RoomSelOpt).click();

		//Selecting ParentId 
		Thread.sleep(2000);
		driver.findElement(ParentIdClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("OG-A-R2 004");
		Thread.sleep(2000);
		driver.findElement(ParentSelOpt).click();
		
		Thread.sleep(2000);
		driver.findElement(IsCradleClick).click();
		
		Thread.sleep(2000);
		driver.findElement(AddTOListClick).click();
		
		Thread.sleep(2000);
		driver.findElement(SaveButtonClick).click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShot//BedMasterforbaby1.png"));  
		
		
//Create second cradle bed for second baby
		Thread.sleep(5000);
		driver.findElement(AddButtons).click();

		//Selecting Unit
		Thread.sleep(2000);
		driver.findElement(UnitClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("HATI Intl Specialist Hospital, KL");
		Thread.sleep(2000);
		driver.findElement(UnitSelOpt).click();

		//Selecting Code
		Thread.sleep(2000);
		driver.findElement(code2ClickBy).sendKeys(CodePar2);

		//Selecting Description
		Thread.sleep(2000);
		driver.findElement(Description2Click).sendKeys(DescriptionPar2);

		//Selecting Bed number
		Thread.sleep(2000);
		driver.findElement(BedNo2Click).sendKeys(BedNoPar2);		

		//Selecting Ward
		Thread.sleep(2000);
		driver.findElement(WardClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("Obstetric and Gynecology Intensive Care Unit A");
		Thread.sleep(2000);
		driver.findElement(WardSelOpt).click();

		//Selecting Room
		Thread.sleep(2000);
		driver.findElement(RoomClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("O&G ICU A Room 2");
		Thread.sleep(2000);
		driver.findElement(RoomSelOpt).click();

		//Selecting ParentId 
		Thread.sleep(2000);
		driver.findElement(ParentIdClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch1).sendKeys("OG-A-R2 004");
		Thread.sleep(2000);
		driver.findElement(ParentSelOpt).click();
		
		Thread.sleep(2000);
		driver.findElement(IsCradleClick).click();
		
		Thread.sleep(2000);
		driver.findElement(AddTOListClick).click();
		
		Thread.sleep(2000);
		driver.findElement(SaveButtonClick).click();
		
		if (driver.getPageSource().contains("Updated Successfully"))
		{
			System.out.println(CodePar2 + " " + "Record saved successfully");
		}
		else
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//FailedforBed_Master_FillAll_Mandatory_Filled.png"+ dateFormat.format(date)));
			Assert.assertTrue(false,"Please fill all mandatory field");
		}

		File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot3, new File(".//ScreenShot//BedMasterforBaby2.png"));  	
		Thread.sleep(2000);	
		if (driver.getPageSource().contains(CodePar2))
		{
			System.out.println(CodePar2 + " " + "Bed Has been created successfully ");
		}
		else
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failedfor_BedMaster.png"+ dateFormat.format(date)));
			Assert.assertTrue(false,"Bed Has been not created");
		}
	}
	public BedMaster(WebDriver driver)
	{
		this.driver=driver;
	}
}
