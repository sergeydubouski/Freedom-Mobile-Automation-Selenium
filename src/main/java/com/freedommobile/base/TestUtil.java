package com.freedommobile.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * class TestUtil
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
public class TestUtil extends BaseTest {

	/** sleep a thread execution */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** take and save a screenshot */
	public void takeScreenshot(String fileName) {

		// screenshot file location
		String screenshotFileLocation = System.getProperty("user.dir") + File.separator + "test-output" + File.separator
				+ "Screenshots" + File.separator + new SimpleDateFormat("dd-MMM-yyyy").format(new Date())
				+ File.separator + this.testName + File.separator
				+ new SimpleDateFormat("HH-mm-ss.SSS aa").format(new Date()) + " " + fileName + ".png";

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) BrowserFactory.getThreadDriver());
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(screenshotFileLocation);
		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			this.log.info("Cannot save the screenshot. Please verify the file path.");
			e.printStackTrace();
		}
	}

	// zoom in and zoom out of the page content
	public static void zoomPageContent(int times) {
		try {
			Robot robot = new Robot();
			if (times < 0) {
				for (int i = 0; i > times; i--) {
					System.out.println("zoom out " + (-i + 1) + " times");
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_SUBTRACT);
					robot.keyRelease(KeyEvent.VK_SUBTRACT);
					robot.keyRelease(KeyEvent.VK_CONTROL);
				}
			} else {
				for (int i = 0; i < times; i++) {
					System.out.println("zoom in " + i + " times");
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_ADD);
					robot.keyRelease(KeyEvent.VK_ADD);
					robot.keyRelease(KeyEvent.VK_CONTROL);
				}
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
		TestUtil.sleep(1000);// it's because a browser is not responsive enough
	}

	/* scroll a pge all the way down */
	public static void scrollPageDown(int pixels) {		
		System.out.println("Scroll down by "+pixels+" pixels");
		JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getThreadDriver();
		js.executeScript("window.scrollBy(0,"+pixels+")");
		TestUtil.sleep(1000);// it's because a browser is not responsive enough
	}

}
