package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.freedommobile.base.TestUtil;

/**
 * class AddOnPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class AddOnPage extends BasePageHeader {

	private By allAddOnOptionsLocator=By.id("skip-navigation");
	private By unlimitedLongDistanceUsCheckBoxLocator = By.xpath(
			"//h3[contains(text(),'Unlimited Long Distance - U.S.')]/ancestor::li//child::input[@type='checkbox']");
	private By visualVoicemailCheckBoxLocator = By
			.xpath("//h3[contains(text(),'Visual Voicemail')]/ancestor::li//child::input[@type='checkbox']");
	private By bigGigWorldSaverFreedomNationwideCheckBoxLocator = By.xpath(
			"//h3[contains(text(),'Big Gig World Saver – Freedom Nationwide')]/ancestor::li//child::input[@type='checkbox']");
	private By worldTravallerCheckBoxLocator = By
			.xpath("//h3[contains(text(),'World Traveller')]/ancestor::li//child::input[@type='checkbox']");
	private By continueButton=By.xpath("//span[contains(text(),'Continue')]/parent::button");

	public AddOnPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/* check World Traveller add-on checkbox */
	private void checkWorldTravallerCheckBox() {
		if (!this.find(this.worldTravallerCheckBoxLocator).isSelected()) {
			this.clickByJS(this.worldTravallerCheckBoxLocator);
		}
		this.log.info("World Traveller add-on is checked");
	}
	/* check Big Gig World Saver – Freedom Nationwide add-on checkbox */
	private void checkBigGigWorldSaverFreedomNationwideCheckBox() {
		if (!this.find(this.bigGigWorldSaverFreedomNationwideCheckBoxLocator).isSelected()) {
			this.clickByJS(this.bigGigWorldSaverFreedomNationwideCheckBoxLocator);
		}
		this.log.info("Big Gig World Saver – Freedom Nationwide add-on is checked");
	}
	/* check Unlimited Long Distance - U.S. add-on checkbox */
	private void checkUnlimitedLongDistanceUsCheckBox() {
		if (!this.find(this.unlimitedLongDistanceUsCheckBoxLocator).isSelected()) {
			this.clickByJS(this.unlimitedLongDistanceUsCheckBoxLocator);
		}
		this.log.info("Unlimited Long Distance - U.S. add-on is checked");
	}
	/* check Visual Voicemail add-on checkbox */
	private void checkVisualVoicemailCheckBox() {
		if (!this.find(this.visualVoicemailCheckBoxLocator).isSelected()) {
			this.clickByJS(this.visualVoicemailCheckBoxLocator);
		}
		this.log.info("Visual Voicemail add-on is checked");
	}
	
	/*click continue button*/
	private void clickContinueButton() {
		this.clickByJS(this.continueButton);
	}
	/*choose phone add-ons*/
	public ShoppingCartPage choosePhoneAddOns(String worldTraveller, String bigGigWorldSaverFreedomNationwide, String unlimitedLongDistanceUs,String visualVoicemail) {
		
		//scroll down the page to display all add-ons
		//TestUtil.scrollPageDown(1200);
		//wait for loading a page
		//this.waitForVisibility(this.allAddOnOptionsLocator, 10);
		
		//check world traveller check box
		if(worldTraveller.equals("TRUE")) {
			this.waitForPresence(this.worldTravallerCheckBoxLocator, 5);
			this.checkWorldTravallerCheckBox();
		}
		//check big gig world saver freedom nationwide check box
		if(bigGigWorldSaverFreedomNationwide.equals("TRUE")) {
			this.waitForPresence(this.bigGigWorldSaverFreedomNationwideCheckBoxLocator, 5);
			this.checkBigGigWorldSaverFreedomNationwideCheckBox();
		}
		//check unlimited long distance US check box
		if(unlimitedLongDistanceUs.equals("TRUE")) {
			this.waitForPresence(this.unlimitedLongDistanceUsCheckBoxLocator, 5);
			this.checkUnlimitedLongDistanceUsCheckBox();
		}
		//check visual voicemail check box
		if(visualVoicemail.equals("TRUE")) {
			this.waitForPresence(this.visualVoicemailCheckBoxLocator, 5);
			this.checkVisualVoicemailCheckBox();
		}
		//click contitue button to go a shopping cart page
		this.waitForPresence(this.continueButton, 5);
		this.clickContinueButton();
		return new ShoppingCartPage(this.driver,this. log);	
	}
	
	
	
	
	
	
	
	
	
	
}
