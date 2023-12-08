package OPDTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import OPDpages.Medcare_Registeration;

public class Registeration {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\eclipse-workspace\\MedcareFramrwork_id\\MedcareFramrwork_id-backend\\src\\test\\java\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/#/");
		driver.manage().window().maximize();
		Thread.sleep(20000);


		Medcare_Registeration medcare = new Medcare_Registeration(driver);
		medcare.login();
		medcare.basicinformatiobn();
		for(int i=0; i<5; i++) {

			String winHandleBefore = driver.getWindowHandle();

			Thread.sleep(5000);

			// Switch back to original browser (first window)

			driver.switchTo().window(winHandleBefore);
			medcare.basicinformatiobn();
		}

	}
}

