package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class InvitationToLoginPage
 * 
 * @author SD
 * @version 1.0
 * @since 25.12.2020
 */
public class InvitationToLoginPage extends BasePage {
	
	private By closeButtonLocator=By.xpath("//button[@data-testid='close-button']");
	private By loginButtonLocator=By.xpath("//button[.='Login']");
	private By continueAsGuestButtonLocator=By.xpath("//button[.='Continue As Guest']");

	public InvitationToLoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/*click Close button*/
	private void clickCloseButton() {
		this.clickByWebDriver(this.closeButtonLocator);
		this.log.info("Click Close button");
	}
	/*click Login button*/
	private void clickLoginButton() {
		this.clickByWebDriver(this.loginButtonLocator);
		this.log.info("Click Login button");
	}
	/*click Continue As Guest button*/
	private void clickContinueAsGuestButton() {
		this.clickByWebDriver(this.continueAsGuestButtonLocator);
		this.log.info("Click Continue As Guest button");
	}
	
	/*click Countinue As Guest button*/
	public DevicePlanPage chooseContinueAsGuest() {
		this.waitForVisibility(continueAsGuestButtonLocator, 5);
		this.clickContinueAsGuestButton();
		return new DevicePlanPage(this.driver,this. log);
	}

}
