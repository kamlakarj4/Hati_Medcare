package ADTpages;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Quick_Registration_Advanced_Search_By_MRN 
{
	WebDriver driver=null; 
	public Quick_Registration_Advanced_Search_By_MRN(WebDriver driver) 
	{
		this.driver=driver;

	}
	By advancedSearchClick=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	By mainmenu=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By OPDMenu=By.xpath("//span[contains(text(),'OPD')]");
	By SideBarMenu=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By RegistrationMenu=By.xpath("//span[contains(text(),'Registration')]");
	By EncounterListClick=By.xpath("//span[contains(text(),'Encounter List')]");
	//Quick Registration
	By QuickRegistrationClick=By.xpath("//span[contains(text(),'Quick Registration')]");

	//Basic Information
	//for all search same xpath
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
	//Gender
	By Genderclick=By.cssSelector("mat-select[ng-reflect-name='gender']");
	By Genderselectvalue=By.xpath("//span[contains(text(),'FEMALE')]");
	//MRN Field
	By MRNFieldClick=By.cssSelector("input[ng-reflect-name='mrn']");
	//search Button
	By SearchButtonClick=By.cssSelector("button[ng-reflect-message='Search']");
	//Tariff
	By Tariffclick12=By.cssSelector("mat-select[aria-labelledby='mat-select-value-55']");
	By Tariffselect12=By.xpath("//span[contains(text(),'Self Tariff')]");	

	//Add Payer Button
	By AddPayerButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Add Payer']");

	//Payer Type Click
	By PayerTypeClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-sample-patient-registration/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/mat-select");
	By PayerTypeSelOpt=By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[3]/span");

	//Payer
	By PayerCLick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-sample-patient-registration/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[3]/mat-select"); 
	By PayerSelOpt=By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[4]/span");

	//Tariff2
	By Tariff22Click=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-sample-patient-registration/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[4]/mat-select");
	By Tariff22Selopt=By.xpath("//span[contains(text(),'Insurance Tariff')]");

	//Policy number
	By PolicyNoClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-sample-patient-registration/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[8]/input");

	//Save 
	By Saveclick=By.cssSelector("mat-icon[ng-reflect-message='Save']");
	By Saveconfirm=By.cssSelector("mat-icon[ng-reflect-message='Yes']");


	//Referral Details

	public void Quick_Registration_Advanced_Search_MRN(String MRNPar) throws InterruptedException, IOException 
	{

		//Clicking on menu Icon
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele=driver.findElement(mainmenu);
		act.moveToElement(ele).build().perform();
		act.click(ele).perform();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(OPDMenu).click();

		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenu);
		act.moveToElement(overforopdslide1).build().perform();
		Thread.sleep(2000);
		driver.findElement(RegistrationMenu).click();
		Thread.sleep(2000);
		driver.findElement(QuickRegistrationClick).click();

		Thread.sleep(5000);
		if(driver.getPageSource().contains("Personal Information")) 
		{
			System.out.println("Quick Registration page has been launched successfully"); 
		} else 
		{
			System.out.println("Quick Registration page failed"); 
		}
		Thread.sleep(2000);
		driver.findElement(advancedSearchClick).click();

		//Adding MRN IN MRN field
		Thread.sleep(2000);
		driver.findElement(MRNFieldClick).sendKeys(MRNPar);

		//Clicking on search button
		Thread.sleep(2000);
		driver.findElement(SearchButtonClick).click();

		//Clicking on Gender
		Thread.sleep(1000);
		driver.findElement(Genderclick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("FEMALE");
		Thread.sleep(1000);
		driver.findElement(Genderselectvalue).click();
		
		//Adding payer clicking on plus button
		Thread.sleep(2000);
		driver.findElement(AddPayerButtonClick).click();

		//Payer Type
		Thread.sleep(2000);
		driver.findElement(PayerTypeClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("I");
		Thread.sleep(2000);
		driver.findElement(PayerTypeSelOpt).click();

		//Payer
		Thread.sleep(2000);
		driver.findElement(PayerCLick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("A");
		Thread.sleep(2000);
		driver.findElement(PayerSelOpt).click();

		//Policy number
		Thread.sleep(2000);
		driver.findElement(PolicyNoClick).sendKeys("23698");

		//Selecting Tariff second
		Thread.sleep(2000);
		driver.findElement(Tariff22Click).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Insurance Tariff");
		Thread.sleep(2000);
		driver.findElement(Tariff22Selopt).click();

		//Selecting Tariff
		Thread.sleep(3000);
		driver.findElement(Tariffclick12).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Self Tariff");
		Thread.sleep(2000);
		driver.findElement(Tariffselect12).click();


		//Clicking on save button
		Thread.sleep(2000);
		driver.findElement(Saveclick).click();

		//Clicking on OK Button
		Thread.sleep(2000);
		driver.findElement(Saveconfirm).click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Selenium Eclipse WorkSpace\\Medcare_Hati\\ScreenShot\\QuickRegistrationadvancedSearch_By_MRN.png"));

		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles

		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());
		Thread.sleep(3000);
		driver.switchTo().window((String) tabs.get(0));

		Thread.sleep(3000);
		WebElement overforopdslide2=driver.findElement(SideBarMenu);
		act.moveToElement(overforopdslide2).build().perform();

		Thread.sleep(3000);
		driver.findElement(EncounterListClick).click();

		WebElement ptname=driver.findElement(By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[5]"));
		String regptname=ptname.getText();

		System.out.println("Patient name"+ptname);

		if(driver.getPageSource().contains(regptname)) 
		{
			System.out.println(regptname+"Patient has been created"); 
		} else 
		{
			System.out.println("Encounter page not open"); 
		}
		Thread.sleep(2000);
		driver.quit();
	}



}
