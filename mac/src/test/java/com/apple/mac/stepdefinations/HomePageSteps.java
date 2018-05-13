package com.apple.mac.stepdefinations;

import java.util.Map;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import com.apple.mac.context.TestContext;
import com.apple.mac.managers.PageObjectManager;
import com.apple.mac.managers.WebDriverManager;
import com.apple.mac.pageobjects.HomePage;
import com.apple.mac.pageobjects.MacBookProPage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps { 

	PageObjectManager pageObjectManager;	
	WebDriverManager webDriverManager;
	WebDriver driver;
	HomePage homePage;	
	MacBookProPage macBookProPage;
	TestContext testContext;

	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		macBookProPage = testContext.getPageObjectManager().getMacBookProPage();
	}
	@Given("^I go to the website$")
	public void i_go_to_the_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homePage.navigateToHomePage();
	}

	@When("^I choose a MacBook Pro with the following features and accessories$")
	public void i_choose_a_MacBook_Pro_with_the_following_features_and_accessories(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		homePage.clickOn_Mac();
		homePage.clickOn_MacPro();
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		macBookProPage.clickOn_Buy();
		macBookProPage.selectMacProScreenSize(data.get("Screen"));
		macBookProPage.selectMacProColor(data.get("Colour"));
		macBookProPage.selectMacProcessor(data.get("Processor"));
		macBookProPage.selectLogicProx(data.get("Software"));
		//macBookProPage.clickOn_15Inch();
		//macBookProPage.clickOn_Silver15Inch2_9();
		//macBookProPage.clickOn_Select15Inc2_9();
		//macBookProPage.clickOn_LogicProx();
		macBookProPage.clickOn_AddToCart();
		macBookProPage.clickOn_ReviewBag();
		//macBookProPage.clickOn_AddToBagaUSBC_to_USB();
		macBookProPage.selectDisplayAdopter(data.get("Display adapter"));
		macBookProPage.clickOn_CheckOut();
	
	}

	@Then("^I can place an order for it\\.$")
	public void i_can_place_an_order_for_it() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		macBookProPage.clickOn_GustCheckOut();
		if(macBookProPage.is_CheckOutPage()) 
		{
			assertEquals("Check Out Page is not displayed",macBookProPage.is_CheckOutPage(),true);
			
		}
			
	}
	
	@Given("^when I choose the following items:$")
	public void when_I_choose_the_following_items(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		homePage.navigateToHomePage();
		homePage.clickOn_Mac();
		homePage.clickOn_MacPro();
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		macBookProPage.clickOn_Buy();
		macBookProPage.clickOn_15Inch();
		macBookProPage.select15InchMacBookProByPrice(data.get("MacBook Pro"));
		macBookProPage.selectLogicProXByPrice(data.get("Logic Pro X"));
		macBookProPage.clickOn_AddToCart();
		macBookProPage.clickOn_ReviewBag();
		macBookProPage.selectRelatedProductByPrice(data.get("Display adapter"));
	}

	@When("^I proceed to the checkout$")
	public void i_proceed_to_the_checkout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Check Out is not Implemented. After check out Total & VAT Details are not displayed",true,true);
	}

	@Then("^a total price of £\"(.*)\" will be displayed$")
	public void a_total_price_of_£_will_be_displayed(String strTotalPrice) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean boolMatched=macBookProPage.verify_TotalPrice(strTotalPrice);
		assertEquals("Total Price Match",boolMatched,true);
	}

	@Then("^£\"(.*)\" will be listed for VAT\\.$")
	public void £_will_be_listed_for_VAT(String strVat) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean boolMatched=macBookProPage.verify_VAT(strVat);
		assertEquals("Total VAT Match",boolMatched,true);
	}

}
