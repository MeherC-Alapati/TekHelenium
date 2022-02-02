package com.tek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.tek.base.Constants;
import com.tek.base.Page;
import com.tek.utilities.Utilities;

public class HomePage extends Page {

	@FindBy(xpath = "//button[text()='Accept All Cookies']")
	public WebElement btnCookies;
	@FindBy(xpath = "//a[text()='Search Jobs']")
	public WebElement lnksearchjobs;
	@FindBy(xpath = "//a[text()='Contractor Login']")
	public WebElement lnkcontractorlogin;
	@FindBy(xpath = "//a[text()='CAREER OPPORTUNITIES']")
	public WebElement elmcareeropportunitie;
	@FindBy(xpath = "//a[text()='Construction Jobs']")
	public WebElement elmconstructionjobs;
	@FindBy(xpath = "//a[text()='Distribution & Logistics Jobs']")
	public WebElement elmdistributionjobs;
	@FindBy(xpath = "//a[text()='Facilities & Maintenance Jobs']")
	public WebElement elmFacilitiesjobs;
	@FindBy(xpath = "//a[text()='Manufacturing & Production Jobs']")
	public WebElement elmManufacturingjobs;

	public HomePage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitwait);
		PageFactory.initElements(factory, this);
	}

	public void selectSearchForJobs() throws InterruptedException {
		Utilities.waitForElementToBeClickable(driver, lnksearchjobs);
		lnksearchjobs.click();
		Thread.sleep(2000);
	}

	public void acceptCookies() throws InterruptedException {
		Utilities.waitForElementToBeClickable(driver, btnCookies);
		btnCookies.click();
		Thread.sleep(2000);
	}

	public void navigateToConstructionJobPage() {
		Utilities.customwait(3);
		Actions actions = new Actions(driver);
		actions.moveToElement(elmcareeropportunitie);
		actions.moveToElement(elmconstructionjobs);
		actions.click().build().perform();
	}

	public void navigateToDistributionAndLogisticJobPage() {
		Utilities.customwait(3);
		Actions actions = new Actions(driver);
		actions.moveToElement(elmcareeropportunitie);
		actions.moveToElement(elmdistributionjobs);
		actions.click().build().perform();
	}

	public void navigateToFacilitiesJobPage() {
		Utilities.customwait(3);
		Actions actions = new Actions(driver);
		actions.moveToElement(elmcareeropportunitie);
		actions.moveToElement(elmFacilitiesjobs);
		actions.click().build().perform();
	}
	
	public void navigateToManufacturingJobPage() {
		Utilities.customwait(3);
		Actions actions = new Actions(driver);
		actions.moveToElement(elmcareeropportunitie);
		actions.moveToElement(elmManufacturingjobs);
		actions.click().build().perform();
	}

}
