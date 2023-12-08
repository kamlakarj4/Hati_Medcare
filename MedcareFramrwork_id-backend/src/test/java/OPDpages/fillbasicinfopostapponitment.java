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

import OPDTest.ReadExcelRowWithSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class fillbasicinfopostapponitment {

	WebDriver driver = null;

	By Menu = By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	//By Menu2 =By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
	//By mattooltip = By.cssSelector("mat-icon[mattooltip='Menu']");
	By opd = By.xpath("//*[@id='mat-menu-panel-1']/div/div/div[1]/div[1]/div[1]/div/img");
	By opd2 = By.xpath("//*[@id='mat-menu-panel-6']/div/div/div[1]/div[1]/div[1]");
	By sidebar = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[1]/a");
	By Appointment = By.cssSelector("a[id='200101']");


	By AppointmentList = By.cssSelector("a[id='200102']");
	By Expand = By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	By PatientName = By.cssSelector("input[ng-reflect-name='PatientName']");
	By Search = By.cssSelector("button[ng-reflect-message='Search']");
	By checkbox = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr/td[1]/mat-checkbox");
	By CheckIn = By.cssSelector("mat-icon[ng-reflect-message='Check In']");


	By issuedCountryPrimary = By.cssSelector("mat-select[ng-reflect-name='issuedCountryPrimary']");
	By dropdownsearch = By.cssSelector("input[aria-label='dropdown search']");

	By secondaryId = By.cssSelector("mat-select[ng-reflect-name='secondaryId']");
	By secondaryNumber = By.cssSelector("input[ng-reflect-name='secondaryNumber']");
	//By secondaryNumber = By.cssSelector("mat-select[ng-reflect-placeholder='Secondary Expiry Date']");
	By faculty = By.cssSelector("mat-select[ng-reflect-name='faculty']");
	By genderr = By.cssSelector("mat-select[ng-reflect-name='gender']");
	By martial = By.cssSelector("mat-select[ng-reflect-name='martial']");
	By religion = By.cssSelector("mat-select[ng-reflect-name='religion']");
	By isDeceased = By.cssSelector("mat-checkbox[ng-reflect-name='isDeceased']");
	By patientCategory = By.cssSelector("mat-select[ng-reflect-name='patientCategory']");
	By preferredLanguage = By.cssSelector("mat-select[ng-reflect-name='preferredLanguage']");
	By nation = By.cssSelector("mat-select[ng-reflect-name='nation']");
	By motherName = By.cssSelector("input[ng-reflect-name='motherName']");
	By education = By.cssSelector("mat-select[ng-reflect-name='education']");
	By occupation = By.cssSelector("mat-select[ng-reflect-name='occupation']");
	By race = By.cssSelector("mat-select[ng-reflect-name='race']");
	By ethnic = By.cssSelector("mat-select[ng-reflect-name='ethnic']");
	By birthplace = By.cssSelector("input[ng-reflect-name='birthplace']");
	By bloodGroup = By.cssSelector("mat-select[ng-reflect-name='bloodGroup']");
	By sourceType = By.cssSelector("mat-select[ng-reflect-name='sourceType']");
	By employmentStatus = By.cssSelector("mat-select[ng-reflect-name='employmentStatus']");
	By patientNotes = By.cssSelector("input[ng-reflect-name='patientNotes']");
	By contactRelation = By.cssSelector("mat-select[ng-reflect-name='contactRelation']");
	By Correspondence = By.cssSelector("input[ng-reflect-placeholder='Correspondence Address']");
	By chkSameAsLocalAddress = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/div[3]/form/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div/div[3]/mat-grid-list/div/mat-grid-tile[2]/div/mat-checkbox/label/span[1]");
	By personalFax = By.cssSelector("input[ng-reflect-name='personalFax']");
	By workFax = By.cssSelector("input[ng-reflect-name='workFax']");
	By countrySecondary = By.cssSelector("mat-select[ng-reflect-name='countrySecondary']");
	By stateSecondary = By.cssSelector("mat-select[ng-reflect-name='stateSecondary']");
	By subDistrictSecondary = By.cssSelector("mat-select[ng-reflect-name='subDistrictSecondary']");
	By Postcode = By.cssSelector("input[ng-reflect-placeholder='Postcode']");
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
	public fillbasicinfopostapponitment(WebDriver driver) {
		this.driver= driver;

	}




	public void fillbasicinfopostapponitmentfun(String issuedCountryPrimaryA, String secondaryIdA, String secondaryNumberA,String genderrA,String martialA, String religionA, String patientCategoryA, String preferredLanguageA,String nationA,String nation1A, String motherNameA, String educationA, String occupationA,String raceA,String ethnicA,String birthplaceA,String bloodGroupA,String sourceTypeA,String employmentStatusA,String patientNotesA,String contactRelationA,String CorrespondenceA,String personalFaxA,String workFaxA,String subDistrictSecondaryA,String PostcodeA) throws InterruptedException, AWTException, IOException {


		//String kk = Quick_Registration.EnterPatientName;

		// Create object and take the data from another class
		ReadExcelRowWithSelenium  data = new ReadExcelRowWithSelenium();
		String EnterPatientName=data.TkaePatientName;
		System.out.println("Print the patient name" + EnterPatientName);

		driver.findElement(Menu).click();
		Thread.sleep(5000);
		driver.findElement(opd2).click();
		Thread.sleep(5000);
		driver.findElement(sidebar).click();
		Thread.sleep(2000);
		driver.findElement(AppointmentList).click();
		Thread.sleep(700);
		driver.findElement(Expand).click();
		Thread.sleep(500);
		driver.findElement(PatientName).sendKeys(EnterPatientName);
		Thread.sleep(500);
		//driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(Search).click();
		Thread.sleep(2000);
		driver.findElement(checkbox).click();
		Thread.sleep(500);
		driver.findElement(CheckIn).click();
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Basic Information")) 
		{
			System.out.println("After checkin registeration page successfully launched"); 
		} else 
		{
			System.out.println("After checkin registeration page failed"); 
		}
		driver.findElement(issuedCountryPrimary).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(issuedCountryPrimaryA);
		Thread.sleep(500);
		driver.findElement(issuedCountryPrimary).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(secondaryId).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(secondaryIdA);
		Thread.sleep(500);
		driver.findElement(secondaryId).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(secondaryNumber).sendKeys(secondaryNumberA);
		Thread.sleep(500);
		driver.findElement(faculty).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys("FAKULTI PERNIAGAAN, EKONOMI DAN PERAKAUNAN");
		Thread.sleep(500);
		driver.findElement(faculty).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(genderr).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys("MALE");
		Thread.sleep(500);
	    driver.findElement(genderr).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(martial).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(martialA);
		Thread.sleep(500);
		driver.findElement(martial).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(religion).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(religionA);
		Thread.sleep(500);
		driver.findElement(religion).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(patientCategory).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(patientCategoryA);
		Thread.sleep(500);
		driver.findElement(patientCategory).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(preferredLanguage).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(preferredLanguageA);
		Thread.sleep(500);
		driver.findElement(preferredLanguage).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(nation).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(nationA);
		Thread.sleep(500);
		driver.findElement(nation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(nation).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(nation1A);
		Thread.sleep(500);
		driver.findElement(nation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(motherName).sendKeys(motherNameA);
		Thread.sleep(500);
		driver.findElement(education).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(educationA);
		Thread.sleep(500);
		driver.findElement(education).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(occupation).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(occupationA);
		Thread.sleep(500);
		driver.findElement(occupation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		// driver.findElement(race).click();
		//Thread.sleep(3000);
		//driver.findElement(dropdownsearch).sendKeys(raceA);
		//Thread.sleep(3000);
		// driver.findElement(race).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// Thread.sleep(3000);
		driver.findElement(ethnic).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(ethnicA);
		Thread.sleep(500);
		driver.findElement(ethnic).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(birthplace).sendKeys(birthplaceA);
		Thread.sleep(500);
		driver.findElement(bloodGroup).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(bloodGroupA);
		Thread.sleep(500);
		driver.findElement(bloodGroup).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(sourceType).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(sourceTypeA);
		Thread.sleep(500);
		driver.findElement(sourceType).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(employmentStatus).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(employmentStatusA);
		Thread.sleep(500);
		driver.findElement(employmentStatus).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(patientNotes).sendKeys(patientNotesA);
		Thread.sleep(500);
		driver.findElement(contactRelation).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(contactRelationA);
		Thread.sleep(500);
		driver.findElement(contactRelation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(Correspondence).sendKeys(CorrespondenceA);
		Thread.sleep(500);
		driver.findElement(chkSameAsLocalAddress).click();
		Thread.sleep(500);
		driver.findElement(personalFax).sendKeys(personalFaxA);
		Thread.sleep(500);
		driver.findElement(workFax).sendKeys(workFaxA);
		Thread.sleep(500);
		driver.findElement(subDistrictSecondary).click();
		Thread.sleep(500);
		driver.findElement(dropdownsearch).sendKeys(subDistrictSecondaryA);
		Thread.sleep(500);
		driver.findElement(subDistrictSecondary).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(Postcode).sendKeys(PostcodeA);
		Thread.sleep(5000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//FillBasicinfo.png"));


	}



}