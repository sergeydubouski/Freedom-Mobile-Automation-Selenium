package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class PhoneColourPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class DeviceColourPage extends BasePageHeader {

	private By continueToPlanOptionsButtonLocator = By.xpath("//button[@data-testid='Continue to Plan Options']");

	public DeviceColourPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/* click a device storage capacity button */
	private void clickDeviceStorageCapacityButton(String capacity) {
		this.clickByWebDriver(By.xpath("//input[@id='" + capacity + "']"));
		this.log.info("Click storage capacity button by id [" + capacity + "]");
	}

	/* click a device colour button */
	private void clickDeviceColourButton(String colour) {
		this.clickByWebDriver(By.xpath("//li[.='" + colour + "']"));
		this.log.info("Click colour button by exact text [" + colour + "]");
	}

	/* click a device sim card button */
	private void clickDeviceSimCardButton(String simCard) {
		this.clickByWebDriver(By.xpath("//input[@id='" + simCard + "']"));
		this.log.info("Click sim card button by id [" + simCard + "]");
	}

	/* click continue to plan options button */
	private void clickCountinueToPlanOptionsButton() {
		this.clickByWebDriver(this.continueToPlanOptionsButtonLocator);
		this.log.info("Click Continue to plan options button by data-testid");
	}

	/* choose parameters for the device to buy as a guest */
	public InvitationToLoginPage chooseDeviceParametersToBuyAsGuest(String deviceStorageCapacity, String deviceColour,String deviceSimCard) {

		this.waitForVisibility(this.continueToPlanOptionsButtonLocator, 10);

		// select a device storage capacity
		if (!deviceStorageCapacity.equals("")) {
			this.clickDeviceStorageCapacityButton(deviceStorageCapacity);
		}

		// select a device colour
		if (!deviceColour.equals("")) {
			this.clickDeviceColourButton(deviceColour);
		}

		// select a device sim card
		if (!deviceSimCard.equals("")) {
			this.clickDeviceSimCardButton(deviceSimCard);
		}
		
		this.clickCountinueToPlanOptionsButton();
		
		//return InvitationToLoginPage class for a guest
		return new InvitationToLoginPage(this.driver, this.log);
	}

}
