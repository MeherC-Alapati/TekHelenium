package com.tek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.tek.base.Constants;
import com.tek.base.Page;

public class Utilities extends Page {

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.implicitwait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBeVisible(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.implicitwait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}

	public static void customwait(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static void scrollintoview(WebDriver driver, WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}
	public static void selectDropDownByIndex(WebElement element,int index)
	{
		Select options=new Select(element);
		options.selectByIndex(index);
	}

}
