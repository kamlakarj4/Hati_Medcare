package OPDTest;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestListener;

public class ItestListener extends testutils implements ITestListener {

	@Override
    public void onTestFailure(ITestResult result) {
		System.out.println("Test failed and details are - screenshot craptured");
		try {
			getscreenshots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
}