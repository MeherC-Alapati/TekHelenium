package com.tek.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.tek.base.Page;
import com.tek.pages.ConstructionJobSearchPage;
import com.tek.pages.HomePage;

public class ConstructionJobSearchTest extends Page{

	@BeforeClass
	public void setUp() {
		Page.initConfiguration();		
	}

	@Test()
	public void validateConstructionJobPage() throws InterruptedException {
		HomePage homepagetest = new HomePage();
		homepagetest.acceptCookies();
		homepagetest.navigateToConstructionJobPage();

		ConstructionJobSearchPage jobsearch = new ConstructionJobSearchPage();
		Assert.assertEquals(jobsearch.getPageHeader(), "Construction Jobs", "Construction Jobs Page Validation");

	}

	@Test()
	public void SearchConstructionJob() throws InterruptedException {

		ConstructionJobSearchPage jobsearch = new ConstructionJobSearchPage();
		boolean resultstext = jobsearch.searchConstructionJob("General Labor");
		Assert.assertEquals(resultstext, true, "Construction Job Result Validation");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
