package com.tek.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.tek.base.Page;
import com.tek.pages.FindOpportunity;
import com.tek.pages.HomePage;
import com.tek.pages.JobDescriptionPage;

public class GlobalJobSearchTest extends Page {

	@BeforeClass
	public void setUp() {
		Page.initConfiguration();
	}

	@Test()
	public void SearchJobs() throws InterruptedException {
		HomePage homepagetest = new HomePage();
		homepagetest.acceptCookies();
		homepagetest.selectSearchForJobs();

		FindOpportunity opportunity = new FindOpportunity();
		opportunity.searchOpportunity("Assistant Chief Engineer");

		JobDescriptionPage jdpage = new JobDescriptionPage();
		Assert.assertEquals(jdpage.getJobTitle(), "Assistant Chief Engineer", "Job Search Validation");

	}

	@Test()
	public void VerifyJobCount() throws InterruptedException {

		int jobcout = 0;
		JobDescriptionPage jdpage = new JobDescriptionPage();
		jdpage.clickSaveJob();

		int newjobcount = jdpage.getSavedJobsCount();
		Assert.assertEquals(newjobcount > jobcout, true, "Saved Jobs counter update validation");
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
		System.out.println("After Class");
	}
}
