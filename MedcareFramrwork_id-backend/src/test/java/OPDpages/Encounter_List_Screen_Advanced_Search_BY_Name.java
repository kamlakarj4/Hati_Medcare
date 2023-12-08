package OPDpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Encounter_List_Screen_Advanced_Search_BY_Name 
{
	WebDriver driver=null; 
	public Encounter_List_Screen_Advanced_Search_BY_Name (WebDriver driver) 
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
		By PatientNameClick=By.cssSelector("input[ng-reflect-name='patientName']");
		By SearchButtonClick=By.cssSelector("button[ng-reflect-message='Search']");	
	public void Advanced_Search_For_Encounter_List_BY_Name() throws InterruptedException
	{
		//Over the slide bar in OPD Screen
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(8000);
		WebElement ele=driver.findElement(mainmenu);
		act.moveToElement(ele).build().perform();
		act.click(ele).perform();
		Thread.sleep(4000);
		driver.findElement(OPDMenu).click();
		Thread.sleep(4000);
		WebElement overforopdslide1=driver.findElement(SideBarMenu);
		act.moveToElement(overforopdslide1).build().perform();
		
		Thread.sleep(5000);
		driver.findElement(RegistrationMenu).click();	
		
		Thread.sleep(4000);
		driver.findElement(EncounterList).click();
		
		Thread.sleep(4000);
		if(driver.getPageSource().contains("Encounter"))
		{
			System.out.println("ENcounter List Screen Successfully opened"); 
		} else 
		{
			System.out.println("Encounter List page failed to open"); 
		}
		
		Thread.sleep(2000);
		WebElement PtN=driver.findElement(PtName);
		String PatientName=PtN.getText();
		
		Thread.sleep(2000);
		driver.findElement(advancedSearchClick).click();
		
		Thread.sleep(2000);
		driver.findElement(PatientNameClick).sendKeys(PatientName);
		
		Thread.sleep(2000);
		driver.findElement(SearchButtonClick).click();
		
		Thread.sleep(3000);
		if(driver.getPageSource().contains(PatientName))
		{
			System.out.println(PatientName+" "+"Patient has been searched"); 
		} else 
		{
			System.out.println("Patient not fount!!!"); 
		}
	}

}
