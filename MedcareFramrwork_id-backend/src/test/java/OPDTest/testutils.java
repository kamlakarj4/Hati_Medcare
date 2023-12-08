
package OPDTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import atu.testrecorder.ATUTestRecorder;



public class testutils  {
	
	
	public void getscreenshots() throws IOException {
		
		
		Date currentdate = new Date();
		String ScreenShotsFilename = currentdate.toString().replace(" ", "_").replace(":", "_");
		File screenshotfile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(".//screenshot//" + ScreenShotsFilename + ".png"));
		
	}
	
}
