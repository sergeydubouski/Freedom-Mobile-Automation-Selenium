package com.freedommobile.base;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] saveScreenshot() {
		TakesScreenshot scrShot = ((TakesScreenshot) BrowserFactory.getThreadDriver());
		return scrShot.getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value="{0}",type = "text/plain")
	private String saveTextLog(String msg) {
		return msg;
	}

	@Override
	public void onTestStart(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + " STARTED]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + " PASSED]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName() + " PASSED with the following parameters:\n"
				+ Arrays.toString(result.getParameters()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + " FAILED]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName() + " FAILED with the following parameters:\n"
				+ Arrays.toString(result.getParameters()));
		this.saveTextLog(result.getThrowable().getMessage());
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
