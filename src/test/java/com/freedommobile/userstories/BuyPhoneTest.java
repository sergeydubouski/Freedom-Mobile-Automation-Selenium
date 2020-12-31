package com.freedommobile.userstories;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freedommobile.base.TestUtil;
import com.freedommobile.pages.AddOnPage;
import com.freedommobile.pages.DeviceColourPage;
import com.freedommobile.pages.DevicePlanPage;
import com.freedommobile.pages.InvitationToLoginPage;
import com.freedommobile.pages.ShopPage;
import com.freedommobile.pages.ShoppingCartPage;
import com.freedommobile.pages.WelcomePage;

/**
 * class BuyPhoneTest
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class BuyPhoneTest extends TestUtil {

	@Test(invocationCount = 1 ,dataProvider = "csvDataReader", dataProviderClass = com.freedommobile.base.CsvDataProvider.class)
	public void buyPhoneAsGuestTest(Map<String,String> testdata) {
		
		String no = testdata.get("no");
		String description = testdata.get("description");
		String deviceType = testdata.get("deviceType");//"Phone";// select by visible text
		String deviceBrand = testdata.get("deviceBrand");//"Apple";// select by visible text
		String promotion =testdata.get("promotion");//"";// select by visible text
		String deviceModel = testdata.get("deviceModel");//"iPhone 12 Pro Max";// select by exact text
		String phoneColour =testdata.get("phoneColour");// "Gold";// select by exact text
		String phoneStorageCapacity = testdata.get("phoneStorageCapacity");//"512GB";// select by id value
		String phoneSimCard = testdata.get("phoneSimCard");//"Physical Sim";// select by id value
		String phonePlanCategory =testdata.get("phonePlanCategory");// "Unlimited Plans";// select by aria-label
		String phonePlan =testdata.get("phonePlan");// "plan-Big Gig Unlimited + Talk 20GB Prime";// select by id value
		String worldTravallerAddOn = testdata.get("worldTravallerAddOn");//"TRUE";// select by contains(text()) value. Its checkbox method returns a
											// ShoppingCartPage object
		String bigGigWorldSaverFreedomNationwideAddOn = testdata.get("bigGigWorldSaverFreedomNationwideAddOn");//"TRUE";// select by contains(text()) value
		String unlimitedLongDistanceUsAddOn = testdata.get("unlimitedLongDistanceUsAddOn");//"TRUE";// select by contains(text()) value
		String visualVoicemailAddOn =testdata.get("visualVoicemailAddOn");// "TRUE";// select by contains(text()) value
		String expectedTotalToday = testdata.get("expectedTotalToday");//"$394.00";
		String expectedTotalMonthly =testdata.get("expectedTotalMonthly");// "$130.00";
		String errMsgForExpectedTotalToday =testdata.get("errMsgForExpectedTotalToday");// "Actual total today value is not equal to expected total today value";
		String errMsgForExpectedTotalMonthly =testdata.get("errMsgForExpectedTotalMonthly");// "Actual total monthly value is not equal to expected total monthly value";

		//start of the test
		this.log.info("Starting buy a phone as a guest test ["+no+"]["+description+"]");
	
		// open a welcome web page
		WelcomePage welcomePage = new WelcomePage(this.driver, this.log);
		welcomePage.openWelcomePage();
		this.takeScreenshot("open welcome page");

		// open a shop web page
		//welcomePage.hoverOverShopButton();
		this.takeScreenshot("hover over shop button");
		ShopPage shopPage = welcomePage.clickDevicesButton();
		this.takeScreenshot("click devices button");

		// choose a phone on a shop web page
		DeviceColourPage phoneColourPage = shopPage.chooseDeviceToBuy(promotion, deviceType, deviceBrand, deviceModel);
		this.takeScreenshot("Phone [" + deviceType + "], [" + deviceBrand + "], [" + deviceModel + "]");
		// choose the phone parameters
		InvitationToLoginPage invitationToLoginPage = phoneColourPage
				.chooseDeviceParametersToBuyAsGuest(phoneStorageCapacity, phoneColour, phoneSimCard);
		this.takeScreenshot(
				"Phone parameters [" + phoneStorageCapacity + "], [" + phoneColour + "], [" + phoneSimCard + "]");
		// choose to continue as guest
		DevicePlanPage devicePlanPage = invitationToLoginPage.chooseContinueAsGuest();
		this.takeScreenshot("Buy phone as guest");
		// choose the phone plan
		AddOnPage addOnPage = devicePlanPage.choosePhonePlan(phonePlanCategory, phonePlan);
		this.takeScreenshot("Phone plan [" + phonePlanCategory + "], [" + phonePlan + "]");
		// TestUtil.sleep(5000);
		// choose the phone add-ons
		ShoppingCartPage shoppingCartPage = addOnPage.choosePhoneAddOns(worldTravallerAddOn,
				bigGigWorldSaverFreedomNationwideAddOn, unlimitedLongDistanceUsAddOn, visualVoicemailAddOn);
		this.takeScreenshot("Phone plan addons");
		//TestUtil.sleep(10000);
		String actualTotalToday = shoppingCartPage.getTotalTodayText();
		String actualTotalMonthly = shoppingCartPage.getTotalMonthlyText();
		// TestUtil.sleep(15000);
		//.TestUtil.zoomPageContentByWebDriver(-4);
		TestUtil.zoomPageContentByJS(67);
		
		// Verification
		// Verify a total today value before tax
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(actualTotalToday.contains(expectedTotalToday), errMsgForExpectedTotalToday+". Actual ["+actualTotalToday+"], Expected ["+expectedTotalToday+"]");
		// Verify a total monthly value before tax
		softAssert.assertTrue(actualTotalMonthly.contains(expectedTotalMonthly), errMsgForExpectedTotalMonthly+". Actual ["+actualTotalMonthly+"], Expected ["+expectedTotalMonthly+"]");
		softAssert.assertAll();
		//this.takeScreenshot("Shopping cart page");
	}
}
