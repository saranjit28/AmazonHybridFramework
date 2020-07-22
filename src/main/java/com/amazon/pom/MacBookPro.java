package com.amazon.pom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.generics.TestBaseClass;

public class MacBookPro extends TestBaseClass {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement SearchBar;

	@FindBy(id = "nav-search-submit-text")
	private WebElement Search;

	@FindBy(xpath = "//div[@id='suggestions']/div[3]")
	private WebElement MacBookOption;

	@FindBy(xpath = "//span[contains(text(),'Airy Blue')]")
	private WebElement MacBook;

	@FindBy(id = "a-autoid-0-announce")
	private WebElement DropDownButton;
	@FindBy(id = "quantity_1")
	private WebElement Quantity;
	@FindBy(id = "add-to-cart-button")
	private WebElement AddtoCart;

	@FindBy(xpath = "//span[@id='hlb-ptc-btn-bottom']/span/a[contains(text(),'Proceed to checkout')]")
	private WebElement CheckOut;

	@FindBy(id = "nav-cart")
	private WebElement CartBtn;

	@FindBy(xpath = "//span[contains(text(),'MOSISO MacBook Pro 13 inch Case 2')]/ancestor::div[@class='a-row sc-action-links']/span[1]")
	private WebElement DropDownQuantity;

	@FindBy(xpath="(//a[@id='dropdown1_1'])")
	private WebElement QuantityChange;

	@FindBy(xpath = "//input[@value='Proceed to checkout']")
	private WebElement CheckoutBtn;

	@FindBy(id = "nav-link-accountList")
	private WebElement AccountTab;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement Signout;

	public MacBookPro() {
		PageFactory.initElements(driver, this);
	}

	public void MacBookAdd() throws InterruptedException {
		SearchBar.sendKeys("Macbook pro");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(MacBookOption));
		MacBookOption.click();
		MacBook.click();
		DropDownButton.click();
		Quantity.click();
		AddtoCart.click();
		CheckOut.click();
		

	}

	public void ReduceQuantityMacBook() throws IOException {
		CartBtn.click();
		DropDownQuantity.click();
		QuantityChange.click();
		CheckoutBtn.click();
			
	}

}
