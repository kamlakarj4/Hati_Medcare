package pageInventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory_openeing_balance {
	
	
   WebDriver driver;
   
   // Locators
   
   By mainmenu=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	//By OPDMenu=By.xpath("//span[contains(text(),'OPD')]");

   By Click_On_Inventory = By.xpath("//span[contains(text(),'Inventory')]");
   
   
   
   public void Openingfunc() throws InterruptedException {
	   
	   driver.findElement(Click_On_Inventory).click();  
	   Thread.sleep(1000);
	   driver.findElement(mainmenu).click();
	   Thread.sleep(10000);
	   
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
