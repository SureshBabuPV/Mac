package com.apple.mac.managers;

import org.openqa.selenium.WebDriver;

import com.apple.mac.pageobjects.HomePage;
import com.apple.mac.pageobjects.MacBookProPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private MacBookProPage macBookProPage;

	public PageObjectManager(WebDriver driver) {
		 
		this.driver = driver;
 
	}
 
	
 
	public HomePage getHomePage(){
 
		return (homePage == null) ? homePage = new HomePage(driver, null) : homePage;
 
	}
	public MacBookProPage getMacBookProPage(){
		 
		return (macBookProPage == null) ? macBookProPage = new MacBookProPage(driver, null) : macBookProPage;
 
	}
}
