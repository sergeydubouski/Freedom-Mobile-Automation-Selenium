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

	private By deviceTypeDropDownListLocator = By.xpath("//select[@id='deviceType']");
	private By brandDropDownListLocator = By.xpath("//select[@id='Manufacturer']");
	private By promotionDropDownListLocator = By.xpath("//select[@id='Promo']");

	public ShopPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	/* select a device type by its visible text */
	public void selectDeviceType(String device) {
		this.waitForVisibility(this.brandDropDownListLocator, 5);
		if (device != "") {
			this.selectFromDropDownListByText(this.deviceTypeDropDownListLocator, device);
			this.log.info("Selected a device type by text[" + device + "]");
		}
	}

	/* select a brand */
	public void selectBrand(String brand) {
		this.waitForVisibility(this.brandDropDownListLocator, 5);
		if (brand != "") {
			this.selectFromDropDownListByText(this.brandDropDownListLocator, brand);
			this.log.info("Selected a brand by text[" + brand + "]");
		}
	}

	/* select a promotion */
	public void selectPromotion(String promotion) {
		this.waitForVisibility(this.brandDropDownListLocator, 5);
		if (promotion != "") {
			this.selectFromDropDownListByText(this.promotionDropDownListLocator, promotion);
			this.log.info("Selected a promotion by text[" + promotion + "]");
		}
	}

	/* select a device */
	public DeviceColorPage chooseDevice(String device) {
		this.driver.findElement(By.xpath("//h3[.='"+device+"']")).click();
		this.log.info("Choose a device by exact text[" + device + "]");
		return new DeviceColorPage(this.driver,this. log);
	}

}
