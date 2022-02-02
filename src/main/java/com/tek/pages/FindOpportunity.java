package com.tek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.tek.base.Constants;
import com.tek.base.Page;
import com.tek.utilities.Utilities;

public class FindOpportunity extends Page {

	@FindBy(xpath = "//input[@id='keywordSearch']")
	public WebElement txtsearchbox;
	@FindBy(xpath = "(//div[@class='phs-job-title'])[1]")
	public WebElement elekeyresult;
	@FindBy(id = "gllocationInput")
	public WebElement txtlocation;
	@FindBy(xpath = "//button[@id='ph-search-backdrop']")
	public WebElement btnsubmit;

	public FindOpportunity() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitwait);
		PageFactory.initElements(factory, this);

	}

	public void searchOpportunity(String role) throws InterruptedException {

		Utilities.waitForElementToBeClickable(driver, txtsearchbox);
		txtsearchbox.sendKeys(role);
		if (elekeyresult != null) {
			elekeyresult.click();
		}

	}

}
