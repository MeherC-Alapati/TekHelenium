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

	@Test
	public void ValidatePDFContent() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		String pdfpath = "http://www.pdf995.com/samples/pdf.pdf";
		driver.get(pdfpath);
		try {
			String pdfContent = readPdfContent(pdfpath);
			Assert.assertTrue(pdfContent.contains("The Pdf995 Suite offers the following features"),
					"PDF content validation");
		} catch (MalformedURLException e) {

		} catch (IOException e) {

		}
	}

	// get the pdf content from the pdf document
	public static String readPdfContent(String url) throws IOException {

		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int numberOfPages = getPageCount(doc);
		System.out.println("The total number of pages " + numberOfPages);
		String content = new PDFTextStripper().getText(doc);
		doc.close();

		return content;
	}

	// get the total number of pages in the pdf document
	public static int getPageCount(PDDocument doc) {
		int pageCount = doc.getNumberOfPages();
		return pageCount;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
