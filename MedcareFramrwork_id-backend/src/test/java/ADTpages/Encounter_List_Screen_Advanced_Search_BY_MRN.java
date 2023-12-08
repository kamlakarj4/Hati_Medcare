package ADTpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Encounter_List_Screen_Advanced_Search_BY_MRN 
{
	WebDriver driver=null; 
	public Encounter_List_Screen_Advanced_Search_BY_MRN (WebDriver driver) 
	{
		this.driver=driver;

	}
	//By Search=By.xpath("mat-icon[mattooltip='Search']");
		By mainmenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
		By MainMenuTooltip=By.xpath("/html/body/div[2]");
		By OPDMenu=By.xpath("//*[@id=\"mat-menu-panel-1\"]/div/div/div[1]/div[1]/div[1]/div/img");
		By SideBarMenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside");
		By RegistrationMenu=By.xpath("//span[contains(text(),'Registration')]");
		By EncounterList=By.xpath("//span[contains(text(),'Encounter List')]");
		//Advanced Search
		By advancedSearchClick=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
		//MRN Taking from encounter list
		By MRNL=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr/td[4]");
		By PtName=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr/td[5]");
		By PatientMRNClick=By.cssSelector("input[ng-reflect-name='mrnno']");
		By SearchButtonClick=By.cssSelector("button[ng-reflect-message='Search']");
		//By RegistrationSubMenuClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[3]/ul/li[2]/a/span[1]");
public void Advanced_Search_For_Encounter_List_BY_MRN() throws InterruptedException
{
	Thread.sleep(2000);
	Actions act = new Actions(driver);
	Thread.sleep(8000);
	WebElement ele=driver.findElement(mainmenu);
	act.moveToElement(ele).build().perform();
	act.click(ele).perform();
	Thread.sleep(4000);
	driver.findElement(OPDMenu).click();

	//Over the slide bar in OPD Screen
	Thread.sleep(3000);
	WebElement overforopdslide1=driver.findElement(SideBarMenu);
	act.moveToElement(overforopdslide1).build().perform();
	
	Thread.sleep(5000);
	driver.findElement(RegistrationMenu).click();
	
	Thread.sleep(2000);
	driver.findElement(EncounterList).click();
	
	Thread.sleep(3000);
	if(driver.getPageSource().contains("Encounter"))
	{
		System.out.println("ENcounter List Screen Successfully opened"); 
	} else 
	{
		System.out.println("Encounter List page failed to open"); 
	}
	Thread.sleep(2000);
	WebElement MRNT=driver.findElement(MRNL);
	String MRNSearch=MRNT.getText();
	//Click on MRN Search
	Thread.sleep(2000);
	driver.findElement(advancedSearchClick).click();
	//Enter MRN In MRN field
	Thread.sleep(2000);
	driver.findElement(PatientMRNClick).sendKeys(MRNSearch);
	//Click on Search button
	Thread.sleep(2000);
	driver.findElement(SearchButtonClick).click();
	
	Thread.sleep(3000);
	if(driver.getPageSource().contains(MRNSearch))
	{
		System.out.println(MRNSearch+" "+"Patient has been searched"); 
	} else 
	{
		System.out.println("Patient not fount!!!"); 
	}
}
	

}
