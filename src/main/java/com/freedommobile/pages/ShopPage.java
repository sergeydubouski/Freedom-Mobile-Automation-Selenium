package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class DeviceShopPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class ShopPage extends BasePageHeader {

	private By deviceCatalogue = By.xpath("//ul[@data-testid='device_container']");
	private By deviceTypeDropDownListLocator = By.xpath("//select[@id='deviceType']");
	private By brandDropDownListLocator = By.xpath("//select[@id='Manufacturer']");
	private By promotionDropDownListLocator = By.xpath("//select[@id='Promo']");

	public ShopPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/* select a brand by visible text*/
	private void selectDeviceBrand(String deviceBrand) {
		this.selectFromDropDownListByText(this.brandDropDownListLocator, deviceBrand);
		this.log.info("Select a device brand by a visible text[" + deviceBrand + "]");
	}

	/* select a promotion by visible text*/
	private void selectPromotion(String promotion) {
		this.selectFromDropDownListByText(this.promotionDropDownListLocator, promotion);
		this.log.info("Select a promotion by visible text[" + promotion + "]");
	}

	/* select a device type by its visible text */
	private void selectDeviceType(String deviceType) {
		this.selectFromDropDownListByText(this.deviceTypeDropDownListLocator, deviceType);
		this.log.info("Select a device type by visible text[" + deviceType + "]");
	}

	/* click a phone to buy by exact text*/
	private void clickDeviceModel(String deviceModel) {
		this.driver.findElement(By.xpath("//h3[.='" + deviceModel + "']")).click();
		this.log.info("Cclick a device model by exact text[" + deviceModel + "]");
	}

	/* choose a device to buy by a promotion, device type, brand and device */
	public DeviceColourPage chooseDeviceToBuy(String promotion, String deviceType, String deviceBrand, String deviceModel) {

		// wait for visibility of device catalogue
		this.waitForVisibility(this.deviceCatalogue, 30);

		// select a promotion
		if (!promotion.equals("")) {
			this.selectPromotion(promotion);
		}
		//this.log.info("Select promotion [" + promotion + "]");

		// select a device type
		if (!deviceType.equals("")) {
			this.selectDeviceType(deviceType);
		}
		//this.log.info("Select device type [" + deviceType + "]");

		// select a device brand
		if (!deviceBrand.equals("")) {
			this.selectDeviceBrand(deviceBrand);
		}
		//this.log.info("Select device brand [" + deviceBrand + "]");

		// select a device model
		if (!deviceModel.equals("")) {
			this.clickDeviceModel(deviceModel);
		}
		//this.log.info("Select device brand [" + deviceModel + "]");

		return new DeviceColourPage(this.driver, this.log);
	}
}
