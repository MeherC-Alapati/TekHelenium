package com.tek.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.tek.base.Page;
import com.tek.pages.HomePage;
import com.tek.pages.ManufacturingJobSearchPage;

public class ManufacturingJobTest extends Page{

	@BeforeClass
	public void setUp() {
		Page.initConfiguration();
	}

	@Test()
	public void ValidateManufacturingJobPage() throws InterruptedException {
		HomePage homepagetest = new HomePage();
		homepagetest.acceptCookies();
		homepagetest.navigateToManufacturingJobPage();

		ManufacturingJobSearchPage jobsearch = new ManufacturingJobSearchPage();
		Assert.assertEquals(jobsearch.getPageHeader(), "Manufacturing & Production Jobs",
				"Manufacturing & Production Jobs Page Validation");
	}

	@Test()
	public void SearchManufacturingJob() throws InterruptedException {

		ManufacturingJobSearchPage jobsearch = new ManufacturingJobSearchPage();
		boolean resultstext = jobsearch.searchManufacturingJob("General Labor");
		Assert.assertEquals(resultstext, true, "Manufacturing & Production Job Result Validation");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
