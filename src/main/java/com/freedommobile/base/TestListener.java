package com.freedommobile.base;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

/**
 * class TestListener
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
/* listen to the test results to trigger actions */
public class TestListener implements ITestListener {

	private Logger logListener;
	private String testName;

	/*take a screenshot every scroll down the page*/
	private void takeScreenshotEveryScrollDown(int scrollIteration,int pixels) {
		for (int i = 0; i < scrollIteration; i++) {
			TestUtil.scrollPageDown(pixels);
			this.saveScreenshot();
		}
	}

	@Attachment(value = "PAGE SCREENSHOT", type = "image/png")
	private byte[] saveScreenshot() {
		TakesScreenshot scrShot = (TakesScreenshot) BrowserFactory.getThreadDriver();
		return scrShot.getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "text/plain")
	private String saveTextLog(String msg) {
		return msg;
	}

	@Override
	public void onTestStart(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + " STARTED]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//TestUtil.zoomPageContent(-4);
		this.logListener.info("[TEST METHOD " + result.getName() + " PASSED]");
		this.saveScreenshot();	
		this.takeScreenshotEveryScrollDown(3, 550);
		this.saveTextLog(result.getMethod().getMethodName() + " PASSED with the following parameters:\n"
				+ Arrays.toString(result.getParameters()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//TestUtil.zoomPageContent(-4);
		this.logListener.info("[TEST METHOD " + result.getName() + " FAILED]");
		this.saveScreenshot();
		this.takeScreenshotEveryScrollDown(3, 550);
		this.saveTextLog(result.getMethod().getMethodName() + " FAILED with the following parameters:\n"
				+ Arrays.toString(result.getParameters()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + " SKIPPED]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName() + " SKIPPED with the following parameters:\n"
				+ Arrays.toString(result.getParameters()));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + " FAILED WITH TIMEOUT]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName() + " FAILED WITH TIMEOUT");
	}

	@Override
	public void onStart(ITestContext context) {
		this.logListener = LogManager.getLogger(context.getName() + "@Listener");
		this.logListener.info("[TEST " + context.getName() + " STARTED]");

	}

	@Override
	public void onFinish(ITestContext context) {
		this.logListener.info("[TEST " + context.getName() + " FINISHED]");
	}

}
