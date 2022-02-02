package com.tek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.tek.base.Constants;
import com.tek.base.Page;
import com.tek.utilities.Utilities;

public class JobDescriptionPage extends Page {

	@FindBy(xpath = "//a[@title='Apply Now']")
	public WebElement lnkapply;
	@FindBy(xpath = "//div[@class='savejob-checkbox']/label/span/ppc-content")
	public WebElement btnsavejob;
	@FindBy(xpath = "//h1[@class='job-title']")
	public WebElement lblheader;
	@FindBy(xpath = "(//a[@data-ph-href='jobcart'])[1]/span[@class='phs-jobcart-count']")
	public WebElement elmjobcount;

	public JobDescriptionPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitwait);
		PageFactory.initElements(factory, this);
	}

	public String getJobTitle() throws InterruptedException {
		Utilities.waitForElementToBeClickable(driver, lnkapply);
		return lblheader.getText();
	}

	public void clickSaveJob() throws InterruptedException {
		Utilities.waitForElementToBeClickable(driver, btnsavejob);
		Utilities.jsClick(driver, btnsavejob);		
		Thread.sleep(3000);
	}

	public int getSavedJobsCount() {
		return Integer.parseInt(elmjobcount.getText());
	}

}
