package com.apple.mac.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentTest;


public class MacBookProPage {

	WebDriver driver;
	public ExtentTest testLog;
	public String strPageName = "MacBookProPage : ";

	// Declaring all web elements in Home page
	@FindBy(xpath = "//a[@class='ac-ln-button']")
	private WebElement a_Buy;
	@FindBy(xpath = "//button[@data-tab-urllink='15-inch']")
	private WebElement btn_15Inch;
	@FindBy(xpath = "//label[@for='colorOptionGridGroup_MPTV2B/A']/span")
	private WebElement label_Silver15Inch2_9;
	@FindBy(xpath = "//form[@data-part-number='MPTV2B/A']/div/span/button")
	private WebElement btn_Select15Inc2_9;
	@FindBy(xpath = "//input[@id='sw_logic_pro_x_z0ue_065_c29h_2']")
	private WebElement input_LogicProx;
	@FindBy(xpath = "//button[@name='add-to-cart']")
	private WebElement btn_AddToCart;
	@FindBy(xpath = "//button[@title='Review Bag']")
	private WebElement btn_ReviewBag;
	@FindBy(xpath = "//a[@class='button secondary' and @data-evar11='MJ1M2|recommended cart']")
	private WebElement a_AddToBagUSBC_to_USB;
	@FindBy(xpath = "//button[@id='cart-actions-checkout']")
	private WebElement btn_CheckOut;
	@FindBy(xpath = "//button[@id='guest-checkout']")
	private WebElement btn_GustCheckOut;
	@FindBy(xpath = "//span[@id='delivery-box-title']")
	private WebElement span_DeliveryboxTitle;
	@FindBy(xpath = "//td[@class='offer-total-value total-top']")
	private WebElement td_TotalPrice;
	@FindBy(xpath = "//div[@class='offer-summary cmg']/table/tr[12]/td/span[2]")
	private WebElement td_VAT;

	public MacBookProPage(WebDriver driver, ExtentTest testLog) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.testLog = testLog;
	}

	public void clickOn_Buy() {
		a_Buy.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ForSale ");
	}

	public void clickOn_15Inch() {
		btn_15Inch.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_LogicProx() {
		setFocus(input_LogicProx);

		input_LogicProx.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_ReviewBag() {
		btn_ReviewBag.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_AddToBagaUSBC_to_USB() {
		a_AddToBagUSBC_to_USB.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_CheckOut() {
		btn_CheckOut.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_GustCheckOut() {
		btn_GustCheckOut.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_Silver15Inch2_9() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label_Silver15Inch2_9.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public void clickOn_Select15Inc2_9() {
		setFocusWithOffset(btn_Select15Inc2_9,0,btn_Select15Inc2_9.getLocation().y-500);
		btn_Select15Inc2_9.click();
		// testLog.log(LogStatus.INFO, strPageName + "Clicked on ToRent ");

	}

	public boolean is_CheckOutPage() {
		// testLog.log(LogStatus.INFO, strPageName +
		// "Verifying Property Type List is visible : ");
		try {

			span_DeliveryboxTitle.isDisplayed();

			// testLog.log(LogStatus.INFO, strPageName +
			// " Property Type List is visible");
		} catch (Exception e) {
			// testLog.log(LogStatus.INFO, strPageName +
			// " Property Type List is not visible");

			return false;
		}
		return true;

	}
	
	public void selectMacProScreenSize(String strMacScreenSize)
	{
		if (strMacScreenSize.trim().contains("15-Inch"))
			{
			clickOn_15Inch();			
			}
		else
		{
			throw new RuntimeException("Mac Screen size not implemented for :" + strMacScreenSize);
		}
	}
	
	public void selectMacProColor(String strMacColor)
	{
		if (strMacColor.trim().contains("Silver"))
			{
			clickOn_Silver15Inch2_9();			
			}
		else
		{
			throw new RuntimeException("Mac Screen color not implemented for :" + strMacColor);
		}
	}
	
	public void selectMacProcessor(String strMacProcessor)
	{
		if (strMacProcessor.trim().contains("2.9 GHz"))
			{
			clickOn_Select15Inc2_9();			
			}
		else
		{
			throw new RuntimeException("Mac processer not implemented for :" + strMacProcessor);
		}
	}
	public void selectLogicProx(String strLogicProx)
	{
		if (strLogicProx.trim().contains("Logic Pro X"))
			{
			clickOn_LogicProx();			
			}
		else
		{
			throw new RuntimeException("Logic Pro X not implemented for :" + strLogicProx);
		}
	}
	
	public void selectDisplayAdopter(String strDisplayAdoptor)
	{
		if (strDisplayAdoptor.trim().contains("USB-C to USB Adapter"))
			{
			clickOn_AddToBagaUSBC_to_USB();			
			}
		else
		{
			throw new RuntimeException("Display Adopter is not implemented for :" + strDisplayAdoptor);
		}
	}
	public void select15InchMacBookProByPrice(String strMacPrice) {
		List<WebElement> list15InchMacBooks = driver.findElements(By
				.xpath("//div[@data-group='15inch']"));

		for (WebElement macBookWebElement : list15InchMacBooks) {

			List<WebElement> listMacDetails = macBookWebElement
					.findElements(By
							.xpath(".//div[@class='as-slide-swapper as-macbtr-details']"));

			for (WebElement macBookDetails : listMacDetails) {

				WebElement macPrice = macBookDetails.findElement(By
						.xpath(".//div[@class='as-price']/span/span"));
				String strPrice = macPrice.getAttribute("innerHTML");
				setFocus(macPrice);
				if (strPrice.trim().contains(strMacPrice)) {
					WebElement macSelect = macBookDetails.findElement(By
							.xpath(".//form//div/span/button"));

					macSelect.click();

					return;
				}

			}

		}
	}

	public void selectLogicProXByPrice(String strLogicProxPrice) {

		WebElement logicProcXSec = driver.findElement(By
				.xpath("//div[@data-group-key='option.sw_logic_pro_x_z0uc']"));
		List<WebElement> listLogicProcXOptions = logicProcXSec
				.findElements(By
						.xpath(".//div[@class='column large-12 as-optionselector-option']"));

		for (WebElement logicProcXOption : listLogicProcXOptions) {
			WebElement logicProxprice = logicProcXOption
					.findElement(By
							.xpath(".//div[@class='form-choiceselectorlabel-twocolright as-optiontile-pricedelta']"));

			String strPrice = logicProxprice.getAttribute("innerHTML");
			if (strPrice.trim().contains(strLogicProxPrice)) {
				setFocus(logicProxprice);
				WebElement logicProxSelect = logicProcXOption.findElement(By
						.xpath(".//input"));

				logicProxSelect.click();

				return;
			}
		}
	}

	public void selectRelatedProductByPrice(String strRelatedProductPrice) {
		List<WebElement> listRelatedProducts = driver.findElements(By
				.xpath("//ul[@class='row  phm pts']/li"));
		for (WebElement relatedProduct : listRelatedProducts) {
			WebElement relatedProductPrice = relatedProduct.findElement(By
					.xpath(".//div[@class='price fsm mvm']"));
			String strPrice = relatedProductPrice.getAttribute("innerHTML");

			if (strPrice.trim().contains(strRelatedProductPrice)) {
				WebElement relatedProductSelect = relatedProduct.findElement(By
						.xpath(".//a[@role='button']"));

				relatedProductSelect.click();

				return;
			}
		}
	}

	public boolean verify_TotalPrice(String strTotalPrice) {
		setFocus(td_TotalPrice);
		String strPrice = td_TotalPrice.getAttribute("innerHTML");

		if (strPrice.trim().contains(strTotalPrice)) {

			return true;
		} else {
			return false;
		}

	}

	public boolean verify_VAT(String strVAT) {
		setFocus(td_VAT);
		String strPrice = td_VAT.getAttribute("innerHTML");

		if (strPrice.trim().contains(strVAT)) {

			return true;
		} else {
			return false;
		}

	}

	public void setFocus(WebElement webElement) {
		Point eleLoc = webElement.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + (eleLoc.y - 100) + ")", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void setFocusWithOffset(WebElement webElement,int locx,int locy) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+ locx +"," + locy + ")", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
