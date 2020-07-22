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

public class DataParametrizeCheck extends TestBaseClass {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement SearchBar;

	@FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
	private WebElement Search;

	@FindBy(id = "nav-link-accountList")
	private WebElement AccountTab;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement Signout;

	public DataParametrizeCheck() {
		PageFactory.initElements(driver, this);
	}

	public void GetParameterizedSearchTest() throws Exception {
		FileInputStream fis = new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		for (int i = 1; i <= 10; i++) {
			String value = wb.getSheet("ProductSearch").getRow(i).getCell(1).toString();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(SearchBar));
			SearchBar.sendKeys(value);
			Search.click();
			driver.navigate().back();
			Thread.sleep(3000);
			System.out.println("Searched data----->" + value);
		}

	}

}
