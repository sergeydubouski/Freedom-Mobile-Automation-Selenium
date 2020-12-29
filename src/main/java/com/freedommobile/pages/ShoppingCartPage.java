package com.freedommobile.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class ShoppingCartPage
 * 
 * @author SD
 * @version 1.0
 * @since 23.12.2020
 */
public class ShoppingCartPage extends BasePageHeader {
	
	private By totalTodayValueLocator=By.xpath("(//div[@data-testid='total-value'])[1]");
	private By totalMonthlyValueLocator=By.xpath("(//div[@data-testid='total-value'])[2]");

	public ShoppingCartPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	/*return a total today value*/
	public String getTotalTodayText() {
		this.waitForVisibility(totalTodayValueLocator, 5);
		System.out.println(this.getText(this.totalTodayValueLocator));
		return this.getText(this.totalTodayValueLocator);
	}
	public String getTotalMonthlyText() {
		this.waitForVisibility(totalMonthlyValueLocator, 5);
		System.out.println(this.getText(this.totalMonthlyValueLocator));
		return this.getText(this.totalMonthlyValueLocator);
	}

}
