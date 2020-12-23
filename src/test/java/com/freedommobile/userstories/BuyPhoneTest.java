package com.freedommobile.userstories;

import org.testng.annotations.Test;

import com.freedommobile.base.TestUtil;
import com.freedommobile.pages.DeviceColorPage;
import com.freedommobile.pages.ShopPage;
import com.freedommobile.pages.WelcomePage;

/**
 * class BuyPhoneTest
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class BuyPhoneTest extends TestUtil {

	@Test
	public void buyPhoneTest() {

		String promotion = "";// ="Promotion";
		String brand = "";// Motorola";
		String deviceType = "";// Phone";
		String device = "iPhone 12 Pro Max";
		String color = "Cloud Lavender";

		WelcomePage welcomePage = new WelcomePage(this.driver, this.log);
		welcomePage.openWelcomePage();
		this.takeScreenshot("open welcome page");

		welcomePage.hoverOverShopButton();
		this.takeScreenshot("hover over shop button");
		ShopPage shopPage = welcomePage.clickDevicesButton();
		this.takeScreenshot("click devices button");

		shopPage.selectPromotion(promotion);
		shopPage.selectDeviceType(deviceType);
		shopPage.selectBrand(brand);
		DeviceColorPage deviceColorPage=shopPage.chooseDevice(device);
		this.takeScreenshot("Color page for ["+device+"]");
		
		
		
		if(deviceType == "Phone") {
			
		}
		
		this.sleep(5000);
	}
}
