package OPDpages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;

public class PatientBlock {
	
	WebDriver driver=null;
	By EncounterList=By.xpath("//span[contains(text(),'Encounter List')]");
	//Menu icon 
			By mainmenu=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
			By MainMenuTooltip=By.xpath("/html/body/div[2]");
			
	//OPD Menu
			By OPDMenu=By.xpath("//*[@id='mat-menu-panel-6']/div/div/div[1]/div[1]/div[1]/div/img");
			By SideBarMenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside");
			By RegistrationMenu=By.xpath("//*[@id='2004']/span[1]");
	//PatientBlocking
			By Patientblocking=By.xpath("//*[@id=\"12121\"]/span[1]");
			
		
	//AddButton
			By Addbuttonclick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-blocking/div[2]/button[3]/span[1]/mat-icon");
			
	//SearchClick
			By Searchpatientclick=By.cssSelector("input[placeholder='Search Patient']");
	//MRN    
			By MRN=By.cssSelector("input[ng-reflect-name='mrn']");
			
	//SearchClick
			By Searchbutton=By.cssSelector("button[data-automation-attribute='btn-search']");
			
		//	//*[@id="mat-menu-panel-15"]/div/div/form/div[10]/div/button[1]/span[1]/mat-icon
	//PatientSelect
			By Patientselect=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-patient-block-add/div/div[6]/div/mat-table/mat-row/mat-cell[7]");
			
	//Reason
			By Reasonclick=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-patient-block-add/div/div[5]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
			By Reasonselect=By.xpath("//span[contains(text(),'Alleged Assault')]");
	//Remarks 
			By Remarks=By.cssSelector("input[ng-reflect-name='remarks']");
			
	//Save
			By Savebutton=By.cssSelector("mat-icon[ng-reflect-message='Save']");
			
		
	//Pagination 
			By Paginationclick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-blocking/mat-tab-group/div/mat-tab-body/div/mat-paginator/div/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]");
			By Paginationselect=By.xpath("//span[contains(text(),'100')]");
			
	//SearchClick2
			By Searchpatientclick2=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	
	//MRN
			By MRN2=By.cssSelector("input[ng-reflect-name='mrn']");
			
	//SearchClick
			By Searchbutton2=By.cssSelector("button[ng-reflect-message='Search']");
			
		//Radio
			By RadioClick=By.cssSelector("mat-radio-group[role='radiogroup']");
			
			//ReleasePatient 
			By ReleasePatient=By.cssSelector("mat-icon[ng-reflect-message='Release Patient']");
			
			//Reason
			By Reason=By.cssSelector("mat-select[ng-reflect-name='reason']");
			
			//ReasonSelect
			By ReasonSelect=By.xpath("//span[contains(text(),'Counselling')]");
			
			//Confirm
			By Confirm=By.cssSelector("mat-icon[ng-reflect-message='Confirm']");
			
		
			
				
			public PatientBlock (WebDriver driver)
			
			{
				this .driver=driver;
				
			}
 
  public void Patientblocking(String RemarksPar) throws InterruptedException, IOException 
  
  {
	  Thread.sleep(3000);
	  Actions act = new Actions(driver);
	  
	  WebElement mainMenu=driver.findElement(mainmenu);
	  act.moveToElement(mainMenu).build().perform();
	  act.click(mainMenu).perform(); 
	
	//OPDMenu
	  Thread.sleep(8000);
	  driver.findElement(OPDMenu).click();
	  
	  //SideMenuBar
	  Thread.sleep(4000);
	  WebElement SidebarMenu=driver.findElement(SideBarMenu);
	  act.moveToElement(SidebarMenu).build().perform();
	  
	 
	  //Registration 
	  Thread.sleep(6000);
	  driver.findElement(RegistrationMenu).click();
	  driver.findElement(RegistrationMenu).click();
	  Thread.sleep(6000);
	  
	  driver.findElement(EncounterList).click();
	  Thread.sleep(4000);
	  
	  WebElement mrnvale=driver.findElement(By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[4]"));
	  String val = mrnvale.getText();
	  System.out.println("print mrn" + val);
	  
	  
	  Thread.sleep(4000);
	  WebElement SidebarMenu1=driver.findElement(SideBarMenu);
	  act.moveToElement(SidebarMenu1).build().perform();
	  

	  //PatientBlock
	  Thread.sleep(8000);
	  driver.findElement(Patientblocking).click();
	  
	  
	  //Condition
	  Thread.sleep(5000);
      if(driver.getPageSource().contains("Patient Blocking")) 
      {
      System.out.println("Patient Blocking Page Launch Successfully"); 
      } else 
      {
      System.out.println("Patient Blocking page failed"); 
      }
	  
    //ScreenShot
	  File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot1, new File(".//ScreenShots//Blocking1.png"));
      
	  //AddButton
	  Thread.sleep(4000);
	  driver.findElement(Addbuttonclick).click();
	  
	  //AdvanceSearch
	  Thread.sleep(6000);
	  driver.findElement(Searchpatientclick).click();
	  
	  //PatientMRN
	  Thread.sleep(4000);
	  driver.findElement(MRN).sendKeys(val);
	  
	  //SearchButton
	  Thread.sleep(4000);
	  driver.findElement(Searchbutton).click();
	  
	//Condition
	  Thread.sleep(5000);
      if(driver.getPageSource().contains(val)) 
      {
      System.out.println("Patient MRN Showing on Screen"); 
      } else 
      {
      System.out.println("Patient MRN Failed"); 
      }
	  
    //ScreenShot
	  File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot2, new File(".//ScreenShots//Blocking2.png"));
      
	  //PatientSelect
	  Thread.sleep(3000);
	  driver.findElement(Patientselect).click();
	 // Thread.sleep(1000);
	 // driver.findElement(Patientselect).click();
	  
	  //Reason
	  Thread.sleep(3000);
	  driver.findElement(Reasonclick).click();
	  Thread.sleep(2000);
	  driver.findElement(Reasonselect).click();
	  
	  //Remarks
	  Thread.sleep(1000);
	  driver.findElement(Remarks).sendKeys(RemarksPar);
	  
	  //Save
	  Thread.sleep(1000);
	  driver.findElement(Savebutton).click();
	  
	  
	  //Pagination 
	  Thread.sleep(2000);
	  driver.findElement(Paginationclick).click();
	  Thread.sleep(1000);
	  driver.findElement(Paginationselect).click();
	  
	  //Refresh
	  Thread.sleep(1000);
	  driver.navigate().refresh();
	  
	  //Search
	  Thread.sleep(1000);
	  driver.findElement(Searchpatientclick2).click();
	  
	  //MRN
	  Thread.sleep(1000);
	  driver.findElement(MRN2).sendKeys(val);
	  
	  //SearchClick
	  Thread.sleep(1000);
	  driver.findElement(Searchbutton2).click();
	  
	//Condition
	  Thread.sleep(5000);
      if(driver.getPageSource().contains(val) && (driver.getPageSource().contains("Blocked"))) 
      {
      System.out.println("Status Showing as Blocked"); 
      } else 
      {
      System.out.println("Status not showing as Blocked"); 
      }
      
    //ScreenShot
	  File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot3, new File(".//ScreenShots//Blocking3.png"));
	  
	  //Radio
	  Thread.sleep(1000);
	  driver.findElement(RadioClick).click();
	  
	  //Release
	  Thread.sleep(1000);
	  driver.findElement(ReleasePatient).click();
	  
	  //Reason
	  Thread.sleep(1000);
	  driver.findElement(Reason).click();
	  
	  //ReasonSelect
	  Thread.sleep(1000);
	  driver.findElement(ReasonSelect).click();
	  
	  //Confirm 
	  Thread.sleep(1000);
	  driver.findElement(Confirm).click();
	  
	  //ScreenShot
	  File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot4, new File(".//ScreenShots//Blocking4.png"));
      
	  
  }
 
}
