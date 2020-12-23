package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class DeviceColorPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class DeviceColorPage extends BasePageHeader {

	By continueToPlanOptionsButtonLocator = By.xpath("//button[@data-testid='Continue to Plan Options']");

	public DeviceColorPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	/* choose a device color */
	public WatchPlanPage chooseDeviceColor(String color) {
		this.driver.findElement(By.id(color)).click();
		return new WatchPlanPage(this.driver, this.log);
	}

	/* choose a phone color */
	public PhonePlanPage choosePhoneColor(String color) {
		this.driver.findElement(By.id(color)).click();
		return new PhonePlanPage(this.driver, this.log);
	}

	/* choose a tablet color */
	public TabletPlanPage chooseTabletColor(String color) {
		this.driver.findElement(By.id(color)).click();
		return new TabletPlanPage(this.driver, this.log);
	}

	/* choose a watch color */
	public WatchPlanPage chooseWatchDeviceColor(String color) {
		this.driver.findElement(By.id(color)).click();
		return new WatchPlanPage(this.driver, this.log);
	}

	/* click continue to plan options button */
	public void clickCountinueToPlanOptionsButton() {
		this.click(this.continueToPlanOptionsButtonLocator);
	}
}
