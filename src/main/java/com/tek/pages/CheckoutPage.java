package com.tek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.tek.base.Constants;
import com.tek.base.Page;
import com.tek.utilities.Utilities;
import com.tek.beanclasses.ClientInfo;

public class CheckoutPage extends Page {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "address")
	public WebElement address1;

	@FindBy(id = "address2")
	public WebElement address2;
	

	@FindBy(id = "country")
	public WebElement country;

	@FindBy(id = "state")
	public WebElement state;

	@FindBy(id = "zip")
	public WebElement zip;

	@FindBy(id = "cc-name")
	public WebElement cardName;

	@FindBy(id = "cc-number")
	public WebElement cardNumber;

	@FindBy(id = "cc-expiration")
	public WebElement cardExpiration;
	
	@FindBy(id = "cc-cvv")
	public WebElement cardCVV;
	
	@FindBy(xpath = "//button[text()='Continue to checkout']")
	public WebElement submitButton;

	public CheckoutPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(selfHealingDriver, Constants.implicitwait);
		PageFactory.initElements(factory, this);

	}
	
	//methods
	
	 public void fillInfo(ClientInfo clientInfo) throws InterruptedException {
		
		 firstName.sendKeys(clientInfo.getFirstName());
		lastName.sendKeys(clientInfo.getLastName());
		username.sendKeys(clientInfo.getUsername());
		email.sendKeys(clientInfo.getEmail());
		address1.sendKeys(clientInfo.getAddress1());
		address2.sendKeys(clientInfo.getAddress2());
		Utilities.selectDropDownByIndex(country, 1);
		Utilities.selectDropDownByIndex(state, 1);
		zip.sendKeys(clientInfo.getZip());
		cardName.sendKeys(clientInfo.getCardName());
		cardNumber.sendKeys(clientInfo.getCardNumber());
		cardExpiration.sendKeys(clientInfo.getCardExpiration());
		cardCVV.sendKeys(clientInfo.getCardCVV());
		//submitButton.click();
		Utilities.jsClick(selfHealingDriver, submitButton);
		 }

	 public void navigate(String url) {
		 selfHealingDriver.navigate().to(url);
		 }
		 
		 public void navigateToVersion2(String url_version2) {
			 selfHealingDriver.navigate().to(url_version2);
			 }
		 
		 public void formSent() {
				
				if(selfHealingDriver.getCurrentUrl().contains("paymentMethod=on"))
				{
					System.out.println("Form sent Successfully");
				}
				
			 }
		 
		 public void initializeClientInfoData( ClientInfo clientInfo)
		 {
			
				clientInfo.setFirstName("Anton");
				clientInfo.setLastName("Angelov");
				clientInfo.setUsername("aangelov");
				clientInfo.setEmail("info@berlinspaceflowers.com");
				clientInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
				clientInfo.setAddress2("Lotzowplatz 17");
				clientInfo.setCountry(1);
				clientInfo.setState(1);
				clientInfo.setZip("10115");
				clientInfo.setCardName("Anton Angelov");
				clientInfo.setCardNumber("1234567890123456");
				clientInfo.setCardExpiration("12/23");
				clientInfo.setCardCVV("123");
		 }
	}


