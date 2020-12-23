package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class WelcomePage
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
public class WelcomePage extends BasePageHeader {

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private String pageUrl = "https://www.freedommobile.ca";
	private By shopButtonLocator = By.xpath("//button[@data-testid='accordion-button-Shop']");
	private By shopDevicesButtonLocator=By.xpath("//ul[@id='Shop']//a[contains(text(),'Devices')]");
	
	/*open Welcome page*/
	public void openWelcomePage() {
		this.openUrl(this.pageUrl);
		this.log.info("Open welcome page");
	}

	/*hover over shop tab*/
	public void hoverOverShopButton() {
		this.hover(this.shopButtonLocator);
		this.log.info("Hover over shop button");
	}
	/*click devices tab from a shop tab menu*/
	public ShopPage clickDevicesButton() {
		this.click(this.shopDevicesButtonLocator);
		this.log.info("Click Devices button");
		//this.waitForVisibility(By.xpath("//div[@data-testid='device_container']"), 5);//explicit wait is used because it takes time to load a shop devices page
		return new ShopPage(this.driver,this. log);
	}
}
