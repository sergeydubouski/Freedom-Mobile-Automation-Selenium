package com.freedommobile.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * class BrowserFactory
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
public class BrowserFactory {
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(); //a thread driver can be accessed from every class used to run a test for the current thread
	
	/*create a web driver for a given browser*/
	public WebDriver createDriver(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			BrowserFactory.threadDriver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			BrowserFactory.threadDriver.set(new FirefoxDriver());
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			BrowserFactory.threadDriver.set(new ChromeDriver());
			break;
		}
		return BrowserFactory.getThreadDriver();
	}

	/* get a thread driver */
	public static WebDriver getThreadDriver() {
		return BrowserFactory.threadDriver.get();
	}
}
