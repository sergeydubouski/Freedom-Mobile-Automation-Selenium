package com.freedommobile.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * class BaseTest
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
@Listeners({ com.freedommobile.base.TestListener.class })
public class BaseTest {

	protected String browser;
	protected Logger log;
	protected WebDriver driver;
	protected String testSuiteName;// used in takeScreenshot method
	protected String testName;// used in takeScreenshot method
	protected String testMethodName;// used in takeScreenshot method

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	protected void setUpDriver(ITestContext ctx, Method method, @Optional("chrome") String browser) {

		String name = ctx.getCurrentXmlTest().getName();
		this.testName = name;
		this.testSuiteName = ctx.getSuite().getName();
		this.testMethodName = method.getName();
		this.browser = browser;

		this.log = LogManager.getLogger(name);

		this.driver = new BrowserFactory().createDriver(this.browser);
		this.driver.manage().window().maximize();
		this.log.info("Create browser " + this.browser);
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		this.log.info("Close browser " + this.browser);
		this.driver.quit();
	}
}
