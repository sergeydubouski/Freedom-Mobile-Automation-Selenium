package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * class PhonePlanPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class DevicePlanPage extends BasePageHeader {

	private By unlimitedPlansButtonLocator = By.xpath("//button[@aria-label='Unlimited Plans']");// this locator is used
																									// to wait for
																									// loading the page

	public DevicePlanPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/* click a device plan option button */
	private void clickDevicePlanCategoryButton(String planCategory) {
		this.clickByWebDriver(By.xpath("//button[@aria-label='" + planCategory + "']"));
		this.log.info("Click a plan option by aria-label [" + planCategory + "]");
	}

	/* click a device plan button */
	public void clickDevicePlanButton(String devicePlan) {
		this.clickByJS(By.xpath("//input[@id='" + devicePlan + "']"));// select by id value
		this.log.info("Click a device plan by id value [" + devicePlan + "]");
	}

	/* click Continue button */
	private void clickContinueButton() {
		this.clickByWebDriver(By.xpath("//button[.='Continue']"));
		this.log.info("Click Continue button");
	}

	/* choose a phone plan */
	public AddOnPage choosePhonePlan(String phonePlanCategory, String phonePlan) {
		
		//wait for loading the page
		this.waitForVisibility(this.unlimitedPlansButtonLocator, 10);

		// click phonePlanCategory button
		if (!phonePlanCategory.equals("")) {
			this.clickDevicePlanCategoryButton(phonePlanCategory);
		}
		// click phone plan
		if (!phonePlan.equals("")) {
			this.waitForPresence(By.xpath("//input[@id='" + phonePlan + "']"), 5);
			this.clickDevicePlanButton(phonePlan);
		}
		this.clickContinueButton();
		return new AddOnPage(this.driver, this.log);
	}

}
