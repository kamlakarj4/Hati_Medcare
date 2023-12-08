package ADTpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class NewBornAdmission 
{
	WebDriver driver=null;


	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By ADTMenu=By.xpath("//span[contains(text(),'ADT')]");
	By SideBarMenuADTScreen=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By NewBornMenu=By.xpath("//span[contains(text(),'New Born')]");

	//Main Advanced Search
	By SearchPatient=By.cssSelector("mat-icon[ng-reflect-message='Expand']");

	//MRN Field
	By MRNClick=By.cssSelector("input[ng-reflect-name='mrn']");

	//For all Drop down Search
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");

	//Search click
	By SearchClick=By.cssSelector("button[ng-reflect-message='Search']");

	//Click on No of baby drop down
	By NoOfBabyClick=By.cssSelector("mat-select[ng-reflect-name='noOfbaby']");
	By NoOfBabySelOpt=By.xpath("//span[contains(text(),'2')]");

	//Click on Tab
	By Tab1BabyClick=By.cssSelector("div[aria-controls='mat-tab-content-1-0']");
	By Tab2BabyClick=By.cssSelector("div[aria-controls='mat-tab-content-1-1']");

	//Date of delivery
	By DeliveryDateClick=By.cssSelector("input[ng-reflect-name='deliveryDate']");
	By DeliveryDate2Click=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-newborn-form/div[2]/form/div/div/div/mat-tab-group/div/mat-tab-body[2]/div/div[1]/mat-grid-list[1]/div/mat-grid-tile[1]/div/mat-form-field/div/div[1]/div[3]/input");

	//Admission Time
	By AdmissionTime=By.cssSelector("input[ng-reflect-name='admissionTime']");

	//Type Of delivery
	By TypeOfDeleveryClick=By.cssSelector("mat-select[ng-reflect-name='deliveryType']");
	By TypeOfDeleverySelOpt=By.xpath("//span[contains(text(),' Spontaneous vertex delivery')]");

	//Birth Location
	By BirthLocationClick=By.cssSelector("mat-select[ng-reflect-name='birthLocation']");
	By BirthLocationSelOpt=By.xpath("//span[contains(text(),'Home')]");

	//If Outside Hospital
	By OutsideHospitalClick=By.cssSelector("input[ng-reflect-name='OutSideHosp']");

	//Birth Status
	By BirthStatusClick=By.cssSelector("mat-select[ng-reflect-name='birthStatus']");
	By BirthStatusSelOpt=By.xpath("//span[contains(text(),'C-SECTION')]");

	//Indicator Mark
	By IndicatorMarkClick=By.cssSelector("input[ng-reflect-name='indicatormark']");

	//Specialty
	By SpecialityClick=By.cssSelector("mat-select[ng-reflect-name='speciality']");
	By SpecialitySelOpt=By.xpath("//span[contains(text(),' General Surgery')]");

	//Doctor
	By DoctorClick=By.cssSelector("mat-select[ng-reflect-name='doctor']");
	By DoctorSelOpt=By.xpath("//span[contains(text(),'Dr. Micheal Tan')]");

	//Cradel Bed
	By CradelBedClick=By.cssSelector("mat-select[ng-reflect-name='bedNo']");
	By CradelBedSelOpt=By.xpath("//span[contains(text(),'CB1001')]");

	By CradelBed2SelOpt=By.xpath("//span[contains(text(),'CB2001')]");

	//Babies Status
	//Gender
	By GenderClick=By.cssSelector("mat-select[ng-reflect-name='gender']");
	By GenderSelOpt=By.xpath("//span[contains(text(),'MALE')]");

	//Weight
	By WeightClick=By.cssSelector("input[ng-reflect-name='weight']");

	//Length
	By LengthClick=By.cssSelector("input[ng-reflect-name='length']");

	//Head Circumference
	By HeadCircumClick=By.cssSelector("input[ng-reflect-name='headCircum']");

	//Feeding
	By FeedingClick=By.cssSelector("mat-select[ng-reflect-name='feeding']");
	By FeedingSelOpt=By.xpath("//span[contains(text(),'Tube-Nasogastric')]");

	//Stools
	By StoolsClick=By.cssSelector("mat-select[ng-reflect-name='stools']");
	By StoolSelOpt=By.xpath("//span[contains(text(),'Normal')]");

	//Umbilical cord
	By UmbilicalCordClick=By.cssSelector("mat-select[ng-reflect-name='umbilicalCord']");
	By UmbilicalCordSelOpt=By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[4]/span");

	//Anus Patency
	By AnusPatencyClick=By.cssSelector("mat-select[ng-reflect-name='anusPatency']");
	By AnusPatencySelOpt=By.xpath("//span[contains(text(),'OR1')]");

	//Remarks
	By RemarksClick=By.cssSelector("input[ng-reflect-name='remarks']");

	//APGAR Score
	By Min1ScoreClick=By.cssSelector("mat-select[ng-reflect-name='apgarScoreOne']");
	By Min1ScoreSelOpt=By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[1]/span");

	//Immunization
	By BCGClick=By.cssSelector("mat-checkbox[formcontrolname='bcg']");

	//Save Button
	By SaveClick=By.cssSelector("mat-icon[ng-reflect-message='Save']");
	//Yes Button click
	By YesButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");

	public void New_Born_ADT(String MRNPar,String DeliviryDatePar,String AdmissionTimePar,String IfOutSideHosPar,String IndicatorMarkPar,String WeightPar,String LengthPar,String HeadCircumferencePar) throws InterruptedException, IOException 
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

		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenuADTScreen);
		act.moveToElement(overforopdslide1).build().perform();

		//Admission Click
		Thread.sleep(4000);
		driver.findElement(NewBornMenu).click();

		Thread.sleep(3000);
		if(driver.getPageSource().contains("ADT > New Born"))
		{
			System.out.println("New Born Screen Launch successfully"); 
		} else 
		{
			System.out.println("New Born Screen Not launched"); 
		}
		//Click on Main search
		Thread.sleep(3000);
		driver.findElement(SearchPatient).click();

		//Click On MRN Text Field
		Thread.sleep(2000);
		driver.findElement(MRNClick).sendKeys(MRNPar);

		//Click on Search
		Thread.sleep(2000);
		driver.findElement(SearchClick).click();

		//Click on no of baby
		Thread.sleep(2000);
		driver.findElement(NoOfBabyClick).click();
		Thread.sleep(2000);
		driver.findElement(NoOfBabySelOpt).click();

		//Tab 1 baby click
		Thread.sleep(2000);
		driver.findElement(Tab1BabyClick).click();

		//Click delivery date
		LocalDateTime dt = LocalDateTime.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String myDate = dt.format(df);
		Thread.sleep(2000);
		driver.findElement(DeliveryDateClick).sendKeys(myDate);

		//Click Admission time
		Thread.sleep(2000);
		driver.findElement(AdmissionTime).sendKeys(AdmissionTimePar);

		//Selecting type of 
		Thread.sleep(2000);
		driver.findElement(TypeOfDeleveryClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Spontaneous vertex delivery");
		Thread.sleep(2000);
		driver.findElement(TypeOfDeleverySelOpt).click();

		//Selecting Birth Location 
		Thread.sleep(2000);
		driver.findElement(BirthLocationClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Home");
		Thread.sleep(2000);
		driver.findElement(BirthLocationSelOpt).click();

		//If Outside Hospital
		Thread.sleep(2000);
		driver.findElement(OutsideHospitalClick).sendKeys(IfOutSideHosPar);

		//Selecting Birth Status
		Thread.sleep(2000);
		driver.findElement(BirthStatusClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("C-SECTION");
		Thread.sleep(2000);
		driver.findElement(BirthStatusSelOpt).click();

		Thread.sleep(2000);
		driver.findElement(IndicatorMarkClick).sendKeys(IndicatorMarkPar);

		//Selecting specialty
		Thread.sleep(2000);
		driver.findElement(SpecialityClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("General Surgery");
		Thread.sleep(2000);
		driver.findElement(SpecialitySelOpt).click();

		//Selecting Doctor
		Thread.sleep(2000);
		driver.findElement(DoctorClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Dr. Micheal Tan");
		Thread.sleep(2000);
		driver.findElement(DoctorSelOpt).click();

		//Selecting Cradle Bed
		Thread.sleep(2000);
		driver.findElement(CradelBedClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("CB1001");
		Thread.sleep(2000);
		driver.findElement(CradelBedSelOpt).click();

		//Babies Status
		Thread.sleep(2000);
		driver.findElement(GenderClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("MALE");
		Thread.sleep(2000);
		driver.findElement(GenderSelOpt).click();

		//Weight
		Thread.sleep(2000);
		driver.findElement(WeightClick).sendKeys(WeightPar);

		//Length
		Thread.sleep(2000);
		driver.findElement(LengthClick).sendKeys(LengthPar);

		//Head Circumference
		Thread.sleep(2000);
		driver.findElement(HeadCircumClick).sendKeys(HeadCircumferencePar);

		//Feeding
		Thread.sleep(2000);
		driver.findElement(FeedingClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Tube-Nasogastric");
		Thread.sleep(2000);
		driver.findElement(FeedingSelOpt).click();

		//Stools
		Thread.sleep(2000);
		driver.findElement(StoolsClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Normal");
		Thread.sleep(2000);
		driver.findElement(StoolSelOpt).click();

		//Umbilical cord
		//Thread.sleep(2000);
		//driver.findElement(UmbilicalCordClick).click();
		//Thread.sleep(2000);
		//driver.findElement(AllDropDownSearch).sendKeys("NORMAL12");
		//Thread.sleep(2000);
		//driver.findElement(UmbilicalCordSelOpt).click();

		//Anus Patency 
		Thread.sleep(2000);
		driver.findElement(AnusPatencyClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("OR1");
		Thread.sleep(2000);
		driver.findElement(AnusPatencySelOpt).click();

		//Remarks
		Thread.sleep(2000);
		driver.findElement(RemarksClick).sendKeys("Everything is good for baby");

		//APGAR Score
		Thread.sleep(2000);
		driver.findElement(Min1ScoreClick).click();
		//Thread.sleep(2000);
		//driver.findElement(AllDropDownSearch).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(Min1ScoreSelOpt).click();

		//Immunization
		Thread.sleep(2000);
		driver.findElement(BCGClick).click();

		//Scrolling the web page
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();


		//Second baby tab
		//Tab 1 baby click
		Thread.sleep(2000);
		driver.findElement(Tab2BabyClick).click();

		//Click delivery date
		Thread.sleep(2000);
		driver.findElement(DeliveryDateClick).sendKeys(myDate);

		//Click Admission time
		Thread.sleep(2000);
		driver.findElement(AdmissionTime).sendKeys(AdmissionTimePar);

		//Click delivery date
		Thread.sleep(2000);
		driver.findElement(DeliveryDateClick).sendKeys(myDate);

		//Selecting type of 
		Thread.sleep(2000);
		driver.findElement(TypeOfDeleveryClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Spontaneous vertex delivery");
		Thread.sleep(2000);
		driver.findElement(TypeOfDeleverySelOpt).click();


		//Selecting Birth Location 
		Thread.sleep(2000);
		driver.findElement(BirthLocationClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Home");
		Thread.sleep(2000);
		driver.findElement(BirthLocationSelOpt).click();

		//If Outside Hospital
		Thread.sleep(2000);
		driver.findElement(OutsideHospitalClick).sendKeys(IfOutSideHosPar);

		//Selecting Birth Status
		Thread.sleep(2000);
		driver.findElement(BirthStatusClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("C-SECTION");
		Thread.sleep(2000);
		driver.findElement(BirthStatusSelOpt).click();

		Thread.sleep(2000);
		driver.findElement(IndicatorMarkClick).sendKeys(IndicatorMarkPar);

		//Selecting specialty
		Thread.sleep(2000);
		driver.findElement(SpecialityClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("General Surgery");
		Thread.sleep(2000);
		driver.findElement(SpecialitySelOpt).click();

		//Selecting Doctor
		Thread.sleep(2000);
		driver.findElement(DoctorClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Dr. Micheal Tan");
		Thread.sleep(2000);
		driver.findElement(DoctorSelOpt).click();

		//Selecting Cradle Bed
		Thread.sleep(2000);
		driver.findElement(CradelBedClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("CB2001");
		Thread.sleep(2000);
		driver.findElement(CradelBedSelOpt).click();

		//Babies Status
		Thread.sleep(2000);
		driver.findElement(GenderClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("MALE");
		Thread.sleep(2000);
		driver.findElement(GenderSelOpt).click();

		//Weight
		Thread.sleep(2000);
		driver.findElement(WeightClick).sendKeys(WeightPar);

		//Length
		Thread.sleep(2000);
		driver.findElement(LengthClick).sendKeys(LengthPar);

		//Head Circumference
		Thread.sleep(2000);
		driver.findElement(HeadCircumClick).sendKeys(HeadCircumferencePar);

		//Feeding
		Thread.sleep(2000);
		driver.findElement(FeedingClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Tube-Nasogastric");
		Thread.sleep(2000);
		driver.findElement(FeedingSelOpt).click();

		//Stools
		Thread.sleep(2000);
		driver.findElement(StoolsClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("Normal");
		Thread.sleep(2000);
		driver.findElement(StoolSelOpt).click();

		/*//Umbilical cord
						Thread.sleep(2000);
						driver.findElement(UmbilicalCordClick).click();
						Thread.sleep(2000);
						driver.findElement(AllDropDownSearch).sendKeys("NORMAL12");
						Thread.sleep(2000);
						driver.findElement(UmbilicalCordSelOpt).click();*/

		//Anus Patency 
		Thread.sleep(2000);
		driver.findElement(AnusPatencyClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("OR1");
		Thread.sleep(2000);
		driver.findElement(AnusPatencySelOpt).click();

		//Remarks
		Thread.sleep(2000);
		driver.findElement(RemarksClick).sendKeys("Everything is good for baby");

		//APGAR Score
		Thread.sleep(2000);
		driver.findElement(Min1ScoreClick).click();
		//Thread.sleep(2000);
		//driver.findElement(AllDropDownSearch).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(Min1ScoreSelOpt).click();

		//Immunization
		Thread.sleep(2000);
		driver.findElement(BCGClick).click();

		//Scrolling the web page
		Thread.sleep(2000);
		Actions actions2 = new Actions(driver);
		actions2.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();


		//Save Button Click
		Thread.sleep(2000);
		driver.findElement(SaveClick).click();

		//Yes Button Click
		Thread.sleep(2000);
		driver.findElement(YesButtonClick).click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShot//NewBornAdmission.png"));  

		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());
		//Use the list of window handles to switch between windows
		Thread.sleep(1000);
		driver.switchTo().window((String)tabs.get(0));
		
		//Failure Assertions
				if (driver.getPageSource().contains("baby Of")) 
				{
					System.out.println("Bed Blocked Successfully");
				}
				else
				{
					File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//FailedFor_NewBornAdmission"+ dateFormat.format(date)));
					Assert.assertTrue(false,"Admission is not done for new born baby");
				}
	}
	public NewBornAdmission(WebDriver driver)
	{
		this.driver=driver;

	}
}
