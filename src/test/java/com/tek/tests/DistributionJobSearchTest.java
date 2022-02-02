package com.tek.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.tek.base.Page;
import com.tek.pages.DistributionJobSearchPage;
import com.tek.pages.HomePage;

public class DistributionJobSearchTest extends Page{

	@BeforeClass
	public void setUp() {
		Page.initConfiguration();
	}

	@Test()
	public void validateDistributionJobPage() throws InterruptedException {
		HomePage homepagetest = new HomePage();
		homepagetest.acceptCookies();
		homepagetest.navigateToDistributionAndLogisticJobPage();

		DistributionJobSearchPage jobsearch = new DistributionJobSearchPage();
		Assert.assertEquals(jobsearch.getPageHeader(), "Distribution & Logistics Jobs",
				"Distribution & Logistics Jobs Page Validation");
	}

	@Test()
	public void SearchDistributionJob() throws InterruptedException {

		DistributionJobSearchPage jobsearch = new DistributionJobSearchPage();
		boolean resultstext = jobsearch.searchDistributionJob("General Labor");
		Assert.assertEquals(resultstext, true, "Distribution & Logistics Job Result Validation");
	}
	
	@AfterClass()
	public void afterClass() {
		driver.quit();
		System.out.println("After Class");
	}

}
