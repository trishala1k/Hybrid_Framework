package com.men.test;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.men.page.MenPage;
import com.testUtils.PropertiesUtility;



public class MenCatTest extends Testbase{
	MenPage menPage ;
	SoftAssert sa = new SoftAssert();

	FileInputStream fis = null;  
	public static Logger log=Logger.getLogger(Testbase.class);
	PropertiesUtility proputils=null;
	
	public MenCatTest(){
		super();
	}

	@BeforeSuite
	public void setup()
	{
		initialization();
		menPage=new MenPage();

	}

	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}


	@Test(priority=1)
	public void validateElementList() throws Throwable
	{
		Assert.assertTrue(menPage.elementslist());
	}



	@Test(priority=2)
	public void validateTopCategory() throws Exception
	{
		Assert.assertTrue(menPage.checkTopcategory());
	}


	@Test(priority=3)
	public void validateListOfDuffleBags() throws Throwable
	{
		Assert.assertTrue(menPage.checkListOfDuffleBags());
	}
	
	@Test(priority=4)
	public void validateMencategory() throws Throwable
	{
		Assert.assertTrue(menPage.checkMencategory());
	}
	
	@Test(priority=5)
	public void validateReview() throws Throwable
	{
		Assert.assertTrue(menPage.verifyReview());
	}
	
	@Test(priority=6)
	public void validateSizeChart() throws Throwable
	{
		Assert.assertTrue(menPage.verifySizeChart());
	}
	
	@Test(priority=7)
	public void validatePageTitle() throws Throwable
	{
		Assert.assertTrue(menPage.verifyPageTitle());
	}
	
	@Test(priority=8)
	public void verifyremoveProduct() throws Throwable
	{
		Assert.assertTrue(menPage.checkRemoveProduct());
	}
	
	@Test(priority=9)
	public void verifyfillupAddressUsingExcel() throws Throwable
	{
		Assert.assertTrue(menPage.fillupAddressUsingExcel());
	}
	
	@Test(priority=10)
	public void validatePaymentButtons() throws Throwable
	{
		Assert.assertTrue(menPage.verifyPaymentButtons());
	}
	
	@Test(priority=11)
	public void validateBankName() throws Throwable
	{
		Assert.assertTrue(menPage.verifyBankName());
	}


}
