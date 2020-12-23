package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * class DevicePlanPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class DevicePlanPage extends BasePageHeader {

	public DevicePlanPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	/*choose plan for a phone*/
	public AddOnPage choosePhonePlan(String plan) {
		return null;
		
	}
	/*choose plan for a tablet and wearable*/
	public ShoppingCartPage chooseWearablePlan(String plan) {
		return null;
		
	}
	
}
