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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cancel_Existing_Appointment_Department {

	WebDriver driver = null;

	By tab1 = By.id("tab1");
	By tab2 = By.id("tab2");
	By tab3 = By.id("tab3");
	By tab4 = By.id("tab4");
	By tab5 = By.id("tab5");
	By tab6 = By.id("tab6");
	By tab7  = By.id("tab7");
	By tab8 = By.id("tab8");
	By Menu = By.cssSelector("mat-icon[role='img']");
	By Menu2 =By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
	By mattooltip = By.cssSelector("mat-icon[mattooltip='Menu']");

	By opd = By.xpath("//*[@id='mat-menu-panel-1']/div/div/div[1]/div[1]/div[1]/div/img");
	By opd2 = By.xpath("//*[@id='mat-menu-panel-6']/div/div/div[1]/div[1]/div[1]");


	By sidebar = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[1]/a");
	By Appointment = By.cssSelector("a[id='200101']");
	By Appointmenttype = By.cssSelector("mat-select[ng-reflect-placeholder='Appointment Type']");
	By consultation = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment/div/div/div[1]/table/tbody/tr/td[1]/mat-form-field[2]");
	By speciality = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment/div/div/div[1]/table/tbody/tr/td[1]/mat-form-field[3]");
	By search = By.cssSelector("input[placeholder='Search']");
	By selectdoctor = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment/div/div/div[2]/div[1]/div/div[2]/div/ul/li[1]/span/button");
	By selectaappontmet = By.xpath("//*[@id='e-appointment-wrapper-5']/div[3]");                          
	By Existing = By.cssSelector("mat-radio-button[ng-reflect-value='registered']");
	By searchh = By.cssSelector("input[placeholder='Search']");
	By PatientName = By.cssSelector("input[ng-reflect-name='PatientName']");
	By clickonsearch = By.cssSelector("button[ng-reflect-message='Search']");
	By radiobuttonr =By.cssSelector("mat-radio-button[ng-reflect-value='1']");
	By gender =By.cssSelector("mat-select[ng-reflect-name='Gender']");
	By save =By.cssSelector("button[ng-reflect-message='Save']");
	By genderinput = By.cssSelector("input[aria-label='dropdown search']");
	By yes =By.cssSelector("mat-icon[ ng-reflect-message='Yes']");

	By selectval  = By.cssSelector("mat-select[ng-reflect-name='IdType']");
	By passport = By.cssSelector("input[aria-label='dropdown search']");
	By PrimeryIDNumber = By.cssSelector("input[formcontrolname='IdNumber']");
	By ExpiryDate  = By.cssSelector("input[formcontrolname='idExpiry']");
	By Title = By.cssSelector("mat-select[ng-reflect-name='Title']");



	By Titleopt = By.cssSelector("input[aria-label='dropdown search']");
	By FullNmae = By.cssSelector("input[ng-reflect-placeholder='Full Name']");
	By GenderOpt = By.cssSelector("mat-select[ng-reflect-name='Gender']");
	By Gendesend = By.cssSelector("input[aria-label='dropdown search']");
	By dateOfBirth = By.cssSelector("input[ng-reflect-name='DOB']");
	By address = By.cssSelector("input[ng-reflect-placeholder='Residential Address']");
	By email = By.cssSelector("input[ formcontrolname='Email']");

	By countryPrimary = By.cssSelector("mat-select[ng-reflect-name='countryPrimary']");
	By search2 =  By.cssSelector("input[aria-label='dropdown search']");
	By state= By.cssSelector("mat-select[ng-reflect-name='statePrimary']");
	By statesend =  By.cssSelector("input[aria-label='dropdown search']");
	By City = By.cssSelector("mat-select[ng-reflect-name='cityPrimary']");
	By Citysend =  By.cssSelector("input[aria-label='dropdown search']");
	//  By Area =  By.cssSelector("input[mat-select='subDistrictPrimary']");
	By Area =  By.xpath("//*[@id=\"mat-dialog-0\"]/app-dilog/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/form/mat-grid-list[4]/div/mat-grid-tile[4]/div/app-master-form-field");
	By Areasearch =  By.cssSelector("input[aria-label='dropdown search']");


	By post = By.cssSelector("input[ng-reflect-name='pincodePrimary']");
	By CountryCode = By.cssSelector("mat-select[ng-reflect-name='countryCodemobile']");
	By CountryCodesend = By.cssSelector("input[aria-label='dropdown search']");
	By mobileNumber = By.cssSelector("input[formcontrolname='HandPhoneNumber']");
	By workcontactno = By.cssSelector("input[formcontrolname='OffciePhoneNumber']");
	By homecontactno = By.cssSelector("input[formcontrolname='HomePhoneNumber']");
	By Country = By.cssSelector("mat-select[id='mat-select-38']");
	By UploadImhe = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-dilog/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/form/div/div[1]/div/div");

	By UploadImhek = By.cssSelector("input[id='fileAttachment']");

	//Thread.sleep(8000);


	//
	By Save = By.cssSelector("mat-icon[ng-reflect-message='Save']");

	By needviptratment = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-dilog/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/form/section/div/input[1]");
	By Email = By.cssSelector("input[ng-reflect-name='Email']");
	By Workcontct = By.cssSelector("input[ng-reflect-placeholder='Work Contact No']");
	By Homecontact = By.cssSelector("input[ng-reflect-placeholder='Home Contact No']");
	By Remarks = By.cssSelector("textarea[ng-reflect-name='Remarks']");

	// mat-select[ng-reflect-name='Gender']


	By AppointmentSerach = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment/div/div/div[1]/table/tbody/tr/td[1]/button");
	By Serach = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-appointment-quick-search/div[2]/form/mat-grid-list[4]/div/mat-grid-tile[3]/div/button");
	By selectAppointment = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-appointment-quick-search/div[2]/div[1]/table/tbody/tr[1]");
	By fromDateRange = By.cssSelector("input[ng-reflect-name='fromDateRange']");
	By toDateRange = By.cssSelector("input[ng-reflect-name='toDateRange']");
	By Appointment_1 = By.cssSelector("a[id='2001']");
	By Appointmenttypeclick = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment/div/div/div[1]/table/tbody/tr/td[1]/mat-form-field[1]");
	
	By Day = By.cssSelector("button[aria-label='Day']");
	//By Day = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-appointment/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div/ejs-schedule/div[1]/div/div/div[3]/div[3]/button");
	By Next = By.cssSelector("div[title='Next']");
	By Selectappointment_1 = By.xpath("//div[contains(text(),'Clinical Consultation')]");
	
	
	public Cancel_Existing_Appointment_Department(WebDriver driver) {
		this.driver= driver;

	}

	public void login(String Uesrid) throws InterruptedException, IOException {
		Thread.sleep(1000);
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
		FileUtils.copyFile(screenshot, new File("\\ScreenShot\\login.png"));
		//Thread.sleep(20000);


	}
	public void ExitingAppontmetfunc(String AppointmenttypeA, String consultationA, String specialityA,String EmailA, String WorkcontctA, String HomecontactA, String RemarksA) throws InterruptedException, AWTException, IOException {
		//String kk = Quick_Registration.EnterPatientName;

		// Create object and take the data from another class
		ReadExcelRowWithSelenium  data = new ReadExcelRowWithSelenium();
		String EnterPatientName=data.TkaePatientName;
		System.out.println("Print the patient name" + EnterPatientName);

	//	driver.findElement(Menu).click();
		//Thread.sleep(5000);
	//	driver.findElement(opd2).click();
		Thread.sleep(8000);
		driver.findElement(sidebar).click();
		Thread.sleep(3000);
		driver.findElement(Appointment_1).click();
		Thread.sleep(3000);
		driver.findElement(Appointment).click();
		Thread.sleep(1000);

		if(driver.getPageSource().contains("Appointment Calendar")) 
		{
			System.out.println("OPD > Appointment > Appointment page has been launched successfully"); 
		} else 
		{
			System.out.println("OPD > Appointment > Appointment failed"); 
		}

		driver.findElement(Appointmenttypeclick).click();
		Thread.sleep(500);
		driver.findElement(search).sendKeys(AppointmenttypeA);
		Thread.sleep(500);
		driver.findElement(search).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(consultation).click();
		Thread.sleep(900);
		//driver.findElement(search).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(search).sendKeys(consultationA);
		Thread.sleep(900);
		driver.findElement(search).sendKeys(Keys.ENTER);
		Thread.sleep(900);
		driver.findElement(speciality).click();
		Thread.sleep(900);
		driver.findElement(search).sendKeys(specialityA);
		Thread.sleep(900);
		driver.findElement(search).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(Day).click();
		Thread.sleep(4000);
		driver.findElement(Next).click();
		Thread.sleep(4000);
		driver.findElement(Selectappointment_1).click();
		Thread.sleep(4000);

		driver.findElement(Existing).click();
		Thread.sleep(900);
		driver.findElement(searchh).click();
		Thread.sleep(900);
		driver.findElement(PatientName).sendKeys(EnterPatientName);
		Thread.sleep(900);
		driver.findElement(clickonsearch).click();
		Thread.sleep(900);
		driver.findElement(radiobuttonr).click();
		Thread.sleep(10000);
		Actions action=new Actions(driver);
		WebElement image=driver.findElement(UploadImhe);
		action.moveToElement(image).click().perform();
		Robot rb = new Robot();
		rb.delay(5000);
		// Copy your image path
		
		String projectpath = System.getProperty("user.dir");
		StringSelection ss = new StringSelection(projectpath + "\\image\\kk.png.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//Paste you image path
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		// Release the image path
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		//Enter and release
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(900);
	/*
		 driver.findElement(gender).click(); Thread.sleep(900);
		 driver.findElement(genderinput).sendKeys(genderA); Thread.sleep(900);
		 driver.findElement(gender).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	     Thread.sleep(900);
	*/
		driver.findElement(Email).clear();
		Thread.sleep(900);
		driver.findElement(Email).sendKeys(EmailA);
		Thread.sleep(900);
		driver.findElement(Workcontct).sendKeys(WorkcontctA);
		Thread.sleep(900);
		driver.findElement(Homecontact).sendKeys(HomecontactA);
		Thread.sleep(5000);

		Robot robot = new Robot(); for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL); }

		Thread.sleep(900);

		driver.findElement(Remarks).sendKeys(RemarksA);
		Thread.sleep(900);
		driver.findElement(save).click();
		Thread.sleep(900);
		driver.findElement(yes).click();
		Thread.sleep(2000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//Departmet_existing_appointment_.png"));

		Thread.sleep(10000);
		String winHandleBefore = driver.getWindowHandle();
		//Thread.sleep(8000);
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(10000);

	}


}