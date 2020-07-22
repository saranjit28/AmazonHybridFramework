package com.amazon.pom;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.generics.TestBaseClass;

public class HeadPhonesTest extends TestBaseClass {

	@FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
	private WebElement DepartmentMenu;

	@FindBy(xpath = "//li/a[@data-menu-id='21']")
	private WebElement Electronics;

	@FindBy(xpath = "//li/a[text()='Headphones']")
	private WebElement Headphones;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement FirstHeadphone;

	@FindBy(id = "add-to-cart-button")
	private WebElement AddtoCart;

	@FindBy(id = "nav-cart")
	private WebElement CartBtn;

	@FindBy(xpath = "//input[contains(@aria-label,'Delete TOZO T10 Bluetooth 5.0 Wireless E')]")
	private WebElement DeleteBtn;

	@FindBy(id = "nav-link-accountList")
	private WebElement AccountTab;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement Signout;

	public HeadPhonesTest() {
		PageFactory.initElements(driver, this);
	}

	public void AddHeadphoneTest() throws InterruptedException {
		DepartmentMenu.click();
		int X = Electronics.getLocation().getX();
		int Y = Electronics.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + X + ", " + Y + ")");
		Thread.sleep(3000);
		Electronics.click();
		Headphones.click();
		FirstHeadphone.click();
		AddtoCart.click();
		
		
	}

	public void HeadphoneRemoveItemCart() throws IOException {
		CartBtn.click();
		DeleteBtn.click();
		
	}
}
