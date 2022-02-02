package com.tek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.tek.base.Constants;
import com.tek.base.Page;
import com.tek.utilities.Utilities;

public class ConstructionJobSearchPage extends Page {

	@FindBy(xpath = "//div[@id='scoreHero']/h1")
	public WebElement lblheader;
	@FindBy(xpath = "//input[@placeholder='Keyword']")
	public WebElement txtkeyword;
	@FindBy(xpath = "(//div[@class='phs-job-title'])[1]")
	public WebElement elekeyresult;
	@FindBy(xpath = "//a[@title='Apply Now']")
	public WebElement lnkapply;
	@FindBy(xpath = "//ppc-content[@show.bind='showTitle']")
	public WebElement lblresultheader;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btnsubmit;

	public ConstructionJobSearchPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitwait);
		PageFactory.initElements(factory, this);
	}

	public String getPageHeader() {
		return lblheader.getText();
	}

	public boolean searchConstructionJob(String role) throws InterruptedException {
		Utilities.scrollintoview(driver, txtkeyword);
		txtkeyword.sendKeys(role);
		btnsubmit.click();
		Utilities.customwait(3);
		if (lblresultheader.getText().contains("Showing Search results")) {
			return true;
		}
		return false;
	}

	public String getJobTitle() {
		Utilities.waitForElementToBeClickable(driver, lnkapply);
		return lblresultheader.getText();
	}

}
