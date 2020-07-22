package com.amazon.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.generics.FileLib;
import com.amazon.generics.TestBaseClass;
import com.amazon.pom.AmazonSignInSignOut;
import com.amazon.pom.DataParametrizeCheck;
import com.amazon.pom.HeadPhonesTest;
import com.amazon.pom.MacBookPro;

public class AmazonTest extends TestBaseClass {
	AmazonSignInSignOut signin;
	FileLib f;
	HeadPhonesTest headphone;
	MacBookPro macbook;
	DataParametrizeCheck data;

	public AmazonTest() {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		InitialsetUP();
		signin = new AmazonSignInSignOut();
		f = new FileLib();
		String EmailId = f.getPropertyValue("username");
		String Password = f.getPropertyValue("password");
		signin.LoginTest(EmailId, Password);
	}

	@Test(groups = "Sample Login")
	public void simpleLoginTest() throws Exception {
		signin = new AmazonSignInSignOut();
		signin.Signouttest();

	}

	@Test(groups = "HeadPhone", priority = 1)
	public void HeadphoneAdd() throws Exception {
		headphone = new HeadPhonesTest();
		headphone.AddHeadphoneTest();

	}

	@Test(groups = "HeadPhone", priority = 2)
	public void deleteHeadPhones() throws Exception {
		headphone = new HeadPhonesTest();
		headphone.HeadphoneRemoveItemCart();
	}

	@Test(groups = "MacBook Pro", priority = 1)
	public void MacBookProAdd() throws Exception {
		macbook = new MacBookPro();
		macbook.MacBookAdd();
	}

	@Test(groups = "MacBook Pro", priority = 2)
	public void ReduceQuantityMacBookPro() throws Exception {
		macbook = new MacBookPro();
		macbook.ReduceQuantityMacBook();
	}

	@Test(groups = "Paramaterization Check")
	public void Parameterizationtest() throws Exception {
		data = new DataParametrizeCheck();
		data.GetParameterizedSearchTest();
	}

	@AfterMethod
	public void tearDown() throws Exception {

		driver.quit();
	}

}
