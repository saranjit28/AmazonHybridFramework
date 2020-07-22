package com.amazon.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amazon.generics.FileLib;
import com.amazon.generics.TestBaseClass;

public class AmazonSignInSignOut extends TestBaseClass {
	@FindBy(id = "nav-link-accountList")
	private WebElement Signintab;

	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement SignOut;

	@FindBy(id = "ap_email")
	private WebElement EmailTxtFld;

	@FindBy(id = "continue")
	private WebElement ContinueBtn;

	@FindBy(id = "ap_password")
	private WebElement PasswordTxtFld;

	@FindBy(id = "signInSubmit")
	private WebElement SignInBtn;

	@FindBy(id = "continue")
	private WebElement Continue;

	@FindBy(xpath = "//a/div[@class='nav-line-1-container']")
	public WebElement NameVerify;

	public AmazonSignInSignOut() {
		PageFactory.initElements(driver, this);
	}

	public void LoginTest(String emailid, String passwordtext) {
		Signintab.click();
		EmailTxtFld.sendKeys(emailid);
		ContinueBtn.click();
		PasswordTxtFld.sendKeys(passwordtext);
		SignInBtn.click();
		try {
			Continue.click();

		} catch (Exception e) {
			System.out.println("Exception occured :" + e);
			e.printStackTrace();
		} finally {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(NameVerify));
			String Name = NameVerify.getText();
			Assert.assertEquals(Name, "Hello, Saranjit");

		}

	}
	
	
	

	public void Signouttest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(Signintab).build().perform();
		SignOut.click();

	}

}
