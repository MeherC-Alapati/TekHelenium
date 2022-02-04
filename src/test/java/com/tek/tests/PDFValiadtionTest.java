package com.tek.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.tek.base.Page;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

public class PDFValiadtionTest extends Page {
	public WebDriver driver;
	public final String pdfpath = "http://www.pdf995.com/samples/pdf.pdf";

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(pdfpath);
	}

	@Test
	public void validatePDFContent() {
		try {
			String pdfContent = readPdfContent(pdfpath);
			Assert.assertTrue(pdfContent.contains("The Pdf995 Suite offers the following features"),
					"PDF content validation");
		} catch (MalformedURLException e) {

		} catch (IOException e) {

		}
	}

	@Test
	public void validatePDFTotalPageNumbers() throws IOException {
		String pdfpath = "http://www.pdf995.com/samples/pdf.pdf";
		driver.get(pdfpath);
		URL pdfUrl = new URL(pdfpath);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int pagenumbers = getPageCount(doc);
		System.out.println("Tot number of pages in the document " + pagenumbers);
	}

	@Test
	public void validateKeywordSearchPage() {
		try {
			getTextFromPage(pdfpath, "Virtual Reality Modeling Language");

		} catch (MalformedURLException e) {

		} catch (IOException e) {

		}
	}

	public void getTextFromPage(String url, String keyword) throws IOException {
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		for (int pageNumber = 1; pageNumber < doc.getNumberOfPages(); pageNumber++) {

			PDFTextStripper s = new PDFTextStripper();
			s.setStartPage(pageNumber);
			s.setEndPage(pageNumber);
			String contents = s.getText(doc);

			if (contents.contains(keyword)) {
				System.out.println("Keyword '" + keyword + "' is found in Page " + pageNumber);
			}
		}
		doc.close();
	}

	public static String readPdfContent(String url) throws IOException {

		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		String content = new PDFTextStripper().getText(doc);
		doc.close();

		return content;
	}

	// get the total number of pages in the pdf document
	public static int getPageCount(PDDocument doc) {
		int pageCount = doc.getNumberOfPages();
		return pageCount;
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

}
