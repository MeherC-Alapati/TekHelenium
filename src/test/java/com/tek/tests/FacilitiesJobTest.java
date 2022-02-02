package com.tek.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.tek.base.Page;
import com.tek.pages.FacilitiesJobSearchPage;
import com.tek.pages.HomePage;

public class FacilitiesJobTest extends Page {

	@BeforeClass
	public void setUp() {
		Page.initConfiguration();
	}

	@Test()
	public void validateFacilitiesJobPage() throws InterruptedException {
		HomePage homepagetest = new HomePage();
		homepagetest.acceptCookies();
		homepagetest.navigateToFacilitiesJobPage();

		FacilitiesJobSearchPage jobsearch = new FacilitiesJobSearchPage();
		Assert.assertEquals(jobsearch.getPageHeader(), "Facilities & Maintenance Jobs",
				"Facilities & Maintenance Jobs Page Validation");
	}

	@Test()
	public void SearchFacilitiesJob() throws InterruptedException {

		FacilitiesJobSearchPage jobsearch = new FacilitiesJobSearchPage();
		boolean resultstext = jobsearch.searchFacilitiesJob("General Labor");
		Assert.assertEquals(resultstext, true, "Facilities & Maintenance Job Result Validation");
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
		System.out.println("After Class");
	}

}
