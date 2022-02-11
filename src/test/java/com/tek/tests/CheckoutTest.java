package com.tek.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tek.base.Constants;
import com.tek.base.Page;
import com.tek.beanclasses.ClientInfo;
import com.tek.pages.CheckoutPage;


public class CheckoutTest {
	@BeforeMethod
	public void setUp() {
		Page.initHealeniumConfiguration();		
	}

	@Test()
	public void validateCheckoutPageForVersionOne() throws InterruptedException {
		
		CheckoutPage checkout=new CheckoutPage();
		checkout.navigate(Constants.url);
		ClientInfo clientInfo=new ClientInfo();
		checkout.initializeClientInfoData(clientInfo);
		checkout.fillInfo(clientInfo);
	
		Assert.assertTrue(Page.selfHealingDriver.getCurrentUrl().contains("paymentMethod=on"), "Form has been submitted successfully");
	}

	@Test()
	public void validateCheckoutPageForVersionTwo() throws InterruptedException {

		CheckoutPage checkout=new CheckoutPage();
		checkout.navigate(Constants.url_version2_updatedLocaters);
		ClientInfo clientInfo=new ClientInfo();
		checkout.initializeClientInfoData(clientInfo);
		checkout.fillInfo(clientInfo);
	
		Assert.assertTrue(Page.selfHealingDriver.getCurrentUrl().contains("paymentMethod=on"), "Form has been submitted successfully");
	}

	@AfterMethod
	public void afterClass() {
		Page.driver.quit();
	}
}
