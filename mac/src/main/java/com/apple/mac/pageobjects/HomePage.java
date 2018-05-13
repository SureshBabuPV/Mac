package com.apple.mac.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apple.mac.managers.FileReaderManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	WebDriver driver;
	public ExtentTest testLog;
	public String strPageName = "HomePage : ";

	// Declaring all web elements in Home page
	@FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-mac']")
	private WebElement a_Mac;
	@FindBy(xpath = "//li[@class='chapternav-item chapternav-item-macbook-pro macbook-pro']")
	private WebElement li_MacPro;
	
			


	public HomePage(WebDriver driver, ExtentTest testLog) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.testLog = testLog;
	}


	public void clickOn_Mac() {
		a_Mac.click();
		//testLog.log(LogStatus.INFO, strPageName + "Clicked on ForSale ");
	}

	public void clickOn_MacPro() {
		li_MacPro.click();
	//	testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}
	public void navigateToHomePage()
	{

		driver.get( FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
}
