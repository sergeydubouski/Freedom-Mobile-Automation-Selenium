package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * class WelcomePageTest
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
public class BasePage {

	protected WebDriver driver;
	protected Logger log;

	public BasePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	/** wait for visibility of a web element */
	public void waitForVisibility(By locator, Integer... timeInSec) {
		int attempt = 0;
		while (attempt < 2) {
			try {
				this.waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						timeInSec != null ? timeInSec[0] : null);
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempt++;
		}
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver, (timeInSec != null ? timeInSec : 30));
		wait.until(condition);
	}

	/* find a web element */
	protected WebElement find(By by) {
		return this.driver.findElement(by);
	}

	/* click a web element */
	protected void click(By by) {
		this.find(by).click();
	}

	/* send keys to a web element */
	protected void sendKeys(By by, String keysToSend) {
		this.find(by).sendKeys(keysToSend);
	}

	/* open a web page by its url */
	protected void openUrl(String url) {
		this.driver.get(url);
	}

	/* hover over a web element */
	protected void hover(By by) {
		Actions action = new Actions(this.driver);
		action.moveToElement(this.find(by)).perform();
	}
	
	/*select an item from a drop down list by its visible text*/
	protected void selectFromDropDownListByText(By by,String text) {
		Select select =new Select(this.find(by));
		select.selectByVisibleText(text);
	}
	/*select an item from a drop down list by its value*/
	protected void selectFromDropDownListByValue(By by,String value) {
		Select select =new Select(this.find(by));
		select.selectByValue(value);

	}

}
