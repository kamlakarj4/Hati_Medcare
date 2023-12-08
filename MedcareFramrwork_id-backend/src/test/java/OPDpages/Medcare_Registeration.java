package OPDpages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class Medcare_Registeration {
	
	//String screen = "C:\\Users\\Kamlakar\\Desktop\\medcare06_11_2023\\MedcareFramrwork_Latestone\\MedcareFramrwork_0.1\\MedcareFramrwork_0.1\\MedcareFramrwork_id-backend\\Path";
	

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
	By opd2 = By.xpath("//*[@id=\"mat-menu-panel-6\"]/div/div/div[1]/div[1]/div[1]");

	By sidebar = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[1]/a");
	By option = By.xpath("//*[@id='2004']");
	By optionITER = By.xpath("//*[@id=\'2004\']/i");
	By option2  = By.xpath("//*[@id='2005']");

	By Patient = By.xpath("//*[@id='Add Patient']/span[1]/mat-icon");
	By selectval  = By.cssSelector("mat-select[formcontrolname='primaryId']");
	By passport = By.cssSelector("input[aria-label='dropdown search']");
	By PrimeryIDNumber = By.cssSelector("input[formcontrolname='primaryNumber']");
	By ExpiryDate  = By.cssSelector("input[formcontrolname='expiryDate']");
	By Title = By.cssSelector("app-master-form-field[ng-reflect-label='Title']");

	By Titleopt = By.cssSelector("input[aria-label='dropdown search']");
	By FullNmae = By.cssSelector("input[data-placeholder='Full Name']");
	By GenderOpt = By.cssSelector("mat-select[ng-reflect-name='gender']");
	By Gendesend = By.cssSelector("input[aria-label='dropdown search']");
	By dateOfBirth = By.cssSelector("input[formcontrolname='dateOfBirth']");
	By address = By.cssSelector("input[formcontrolname='addressPrimary']");
	By countryPrimary = By.cssSelector("mat-select[ng-reflect-name='countryPrimary']");
	By search =  By.cssSelector("input[aria-label='dropdown search']");
	By state= By.cssSelector("mat-select[ng-reflect-name='statePrimary']");
	By statesend =  By.cssSelector("input[aria-label='dropdown search']");
	By City = By.cssSelector("mat-select[ ng-reflect-name='cityPrimary']");
	By Citysend =  By.cssSelector("input[aria-label='dropdown search']");
	By post = By.cssSelector("input[formcontrolname='pincodePrimary']");
	By CountryCode = By.cssSelector("mat-select[ ng-reflect-name='countryCodemobile']");
	By CountryCodesend = By.cssSelector("input[aria-label='dropdown search']");
	By mobileNumber = By.cssSelector("input[ng-reflect-name='mobileNumber']");
	By Save = By.cssSelector("mat-icon[ng-reflect-message='Save']");
	By Yes = By.cssSelector("mat-icon[ng-reflect-message='Yes']");
	By Encounter = By.xpath("//*[@id='mat-tab-label-0-0']/div");
	By Doctor = By.xpath("//*[@id='mat-select-value-25']/span");
	By Speciality = By.xpath("//*[@id='mat-select-value-29']");
	By Tarrif  = By.cssSelector("mat-select[data-automation-attribute='encounterTariff0']");
	By Doctorsend = By.cssSelector("input[aria-label='dropdown search']");
	By Specialitysend = By.cssSelector("input[aria-label='dropdown search']");
	By Tarrifsend= By.cssSelector("input[aria-label='dropdown search']");
	By EncounterSave= By.xpath("//*[@id='Save Encounter']/span[1]/mat-icon");
	By Encountertype = By.xpath("//*[@id='mat-select-value-27']");
	By Encountertypesend = By.cssSelector("input[aria-label='dropdown search']");
	By containerq = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/div[2]/mat-icon");
	By inppput = By.xpath("//*[@id='mat-input-13']");
	By inppput2  = By.xpath("//*[@id='mat-input-21']");
	By subbbmit2 = By.xpath("//*[@id='mat-menu-panel-6']/div/div/form/div[7]/div[2]/button[1]");
	By subbbmit = By.xpath("//*[@id='mat-menu-panel-6']/div/div/form/div[10]/div[2]/button[1]");
	By  bullet= By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-registration/app-patient-search/div/div/div/table/tbody/tr[1]/td[1]");
	By bullet2 = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-opdbill/app-patient-search/div/div/div/table/tbody/tr[1]/td[1]");

	By bill = By.xpath("//*[@id='mat-menu-panel-1']/div/div/div[1]/div[1]/div[2]");
	By OPbill = By.xpath("//*[@id='mat-tab-content-0-0']/div/div[1]/mat-grid-list/div/mat-grid-tile[1]/div/button/span");
	By  SericeName = By.xpath("//*[@id='mat-input-23']");

	By Checkbox = By.cssSelector("mat-checkbox[id='Check All Services']");
	By Checkbox2 = By.cssSelector("mat-checkbox[id='Final Bill']");
	By savebill = By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-opdbill/div[4]/div/div/div[2]/mat-grid-list/div/mat-grid-tile[2]/div/div[2]/button/span[1]/mat-icon");
	By saveyes = By.xpath("//*[@id='mat-dialog-0']/app-dynamic-confirm-dialog/div/form/div[3]/div/button[1]");
	By addpat = By.xpath("//*[@id='mat-dialog-1']/app-billing-payment-dialog/div/form/div[2]/div/div[5]/form/mat-grid-list/div/mat-grid-tile[4]/div/button/span[1]/mat-icon");
	By Ammontsave  = By.xpath("//*[@id='mat-dialog-1']/app-billing-payment-dialog/div/form/div[3]/form/mat-grid-list/div/mat-grid-tile[5]/div/button/span[1]/mat-icon");
	By Confirmlats = By.xpath("//*[@id='mat-dialog-2']/app-confirm-dialog/div/form/div[3]/div/button[1]");
	By Cooonf = By.xpath("//*[@id='mat-dialog-0']/app-regsuccess-dialog/div/div[3]/div/button[1]/span[1]/mat-icon");

	//*[@id="registration"]/form/div[1]/div/div[1]/div/img 
	By photo = By.xpath("//*[@id=\"registration\"]/form/div[1]/div/div[1]/div/img");
	By uploadimage = By.xpath("//*[@id=\"btnUploadPhoto\"][3]");
	By lab = By.xpath("//*[@id=\"mat-dialog-4\"]/app-camera-dialog/div/div[1]");
	By savade = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-camera-dialog/div/div[2]/div[2]/div[2]/button[3]/span[1]/mat-icon");

	//*[@id="mat-dialog-4"]/app-camera-dialog/div/div[2]/div[2]/div[2]/button[3]/span[3]

	By labk = By.xpath("//*[@id=\"Upload Document\"]");



	public Medcare_Registeration(WebDriver driver) {
		this.driver= driver;

	}
	public void login(String Userid) throws InterruptedException, IOException {
		driver.findElement(tab1).sendKeys(Userid);
		driver.findElement(tab2).sendKeys(Userid);
		driver.findElement(tab3).sendKeys(Userid);
		driver.findElement(tab4).sendKeys(Userid);
		driver.findElement(tab5).sendKeys(Userid);
		driver.findElement(tab6).sendKeys(Userid);
		driver.findElement(tab7).sendKeys(Userid);
		driver.findElement(tab8).sendKeys(Userid);

		Thread.sleep(5000);
		if(driver.getPageSource().contains("Dashboard > Dash")) 
		{
			System.out.println("Login successfull"); 
		} else 
		{
			System.out.println("Login failed"); 
		}
		
     	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//Login.png"));
		

	}
}