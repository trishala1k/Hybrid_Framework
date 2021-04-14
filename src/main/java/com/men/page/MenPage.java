package com.men.page;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.men.test.Testbase;
import com.menObjectRepository.MenObjectRepo;
import com.testUtils.Generics;
import com.testUtils.JxlUtility;
import com.testUtils.PropertiesUtility;


public class MenPage extends MenObjectRepo{
	JxlUtility value=new JxlUtility();
//	 FileInputStream fis = null; 
//		//Properties prop;
		public static Logger log=Logger.getLogger(Testbase.class);//
		PropertiesUtility proputils=null;//
	
	public MenPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean elementslist(){
		Generics.click1(crossButton);
		Generics.click1(Categories);  
		log.info("fhg");
		Testbase.log.info("srrt");
		for(WebElement element:topCategory)
		{
			String text=element.getText();
			System.out.println(text);
			if(text.contains("Kitchen Tools")){
				System.out.println(element.getText());

			}
		}
		return true;
	}
	//done
	@Test(priority=2) //2
	public boolean checkTopcategory() throws Exception{
		ArrayList<String> expectedCategories = new ArrayList<String>();		
		expectedCategories.add("Women");	
		expectedCategories.add("Men");	
		expectedCategories.add("Baby & Kids");	
		expectedCategories.add("Home & Living");	
		ArrayList<String> actualCategories = new ArrayList<String>();	
		for(String name :expectedCategories) {	
			WebElement category=driver.findElement(By.xpath("//div[text()='"+name+"']"));	
			actualCategories.add(category.getText());	
		}	
		if (actualCategories.equals(expectedCategories)) {
			
			//log.info("Page Header Matched::" + expectedCategories);
			System.out.println("Page Header Matched::" + expectedCategories);
			return true;
		} else {
			return false;
		}
	}
	@Test(priority=3) 
	public boolean checkListOfDuffleBags(){
		Generics.click1(DuffleBags);
		System.out.println(bagsList1.size());
		for(WebElement list:bagsList1)
		{
			String text=list.getText();
			System.out.println(text);

		}
		if(bagsList1.size()==4)
		{
			driver.navigate().back();
			System.out.println(" size of Duffle bags are matched");
			return true;	
		}
		else
		{
			System.out.println("size of Duffle bags are not matched");
			return false;
		}		
	}

	@Test(priority=4) 
	public boolean checkMencategory(){
		Generics.click1(MenButton);
		String expectedCategories="Topwear Bottomwear Footwear Winter Wear Watches & Wearables Bags & Wallets AccessoriesPASSED: Mencategory";
		for(WebElement element:subMenButton)
		{
			String actualCategories=element.getText();
			System.out.print(" "+ actualCategories);

			if (actualCategories.equals(expectedCategories)) {
				System.out.println("sub-categories Matched::" + expectedCategories);
				return true;
			}
			else {
				System.out.println("sub-categories not Matched");
				return false;
			}
		}
		return true;
	}

	@Test(priority=5) 
	public boolean verifyReview() throws Exception{
		Thread.sleep(2000);
		Generics.click1(Footwear);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Casual Shoes']"))).click().perform();

		Generics.click1(SelectOneShoe);
		Generics.click1(ShowReview);
		WebElement review=Review1;
		System.out.println(review.getText());
		if(review.getText()=="Product Ratings & Reviews"){
			System.out.println("Reviews are visible");
			return true;
		}else{
			System.out.println("Reviews are not visible");
		}
		driver.navigate().back();
		return true;
	}
	@Test(priority=6) 
	public boolean verifySizeChart() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,-10000)");
		Thread.sleep(5000);
		Thread.sleep(2000);

		Generics.click1(SizeChart);
		for(int i=0;i<SizeList1.size();i++){ //index ka i
			String footNumber=footLengthList1.get(i).getText();

			if(!(footNumber.contains("27.0"))){ //we can use equals or contain method
				String idNum=SizeList1.get(i).getText();
				System.out.println("sr numbers are available without courses content::"+idNum);
			}	   
		}
		driver.findElement(By.xpath("//button[@class='border-0 w-full flex items-start justify-end rounded']")).click();
		return true;
	}

	@Test(priority=7)
	public boolean verifyPageTitle() throws Exception{

		Generics.click1(SelectSize);   
		Generics.click1(AddToCart);
		Generics.click1(CheakAddToCartBtn);
		Generics.sendkeys1(Phone, "8999035090");
		Generics.click1(OTP);
		Thread.sleep(50000);
		Generics.click1(OTPsubmit);
		String actPageTitle=driver.getTitle();
		String expPageTitle="Men Blue Slip-On Canvas Casual Shoes";
		if(actPageTitle.equals(expPageTitle))
		{
			System.out.println(" page title is matched");
			return true;
		}
		else
		{
			System.out.println("page title is not matched");
			return false;
		}
	}

	@Test(priority=8)//7
	public boolean checkRemoveProduct() throws Exception{
		Generics.click1(RemoveBtn);  
		Generics.click1(RemoveProduct); 
		String actualText=EmptyCartText.getText();                            
		String expText="Your Cart is Empty";
		if(actualText.equals(expText))
		{
			driver.navigate().back();
			driver.navigate().back();
			System.out.println(" page title is matched");
			return true;
		}
		else
		{
			System.out.println("page title is not matched");
			return false;
		}
	}

	@Test(priority=9)
	public boolean fillupAddressUsingExcel()throws Exception{

		Thread.sleep(5000);
		Generics.click1(SizeSelect1);
		Generics.click1(ByNow);
		Generics.click1(PayRs);
		Generics.click1(Address);

		for(int i=1;i<2;i++)
		{
			Generics.sendkeys1(name1, (value.readCell("LoginDataJBK.xls","Address",i, 0)));
			Generics.sendkeys1(mobile1, (value.readCell("LoginDataJBK.xls","Address",i,1)));
			Generics.sendkeys1(email1, (value.readCell("LoginDataJBK.xls","Address",i,2)));
			Generics.sendkeys1(houseNo1, (value.readCell("LoginDataJBK.xls","Address",i,3)));
			Generics.sendkeys1(streetAddress1, (value.readCell("LoginDataJBK.xls","Address",i,4)));
			Generics.sendkeys1(pincode1, (value.readCell("LoginDataJBK.xls","Address",i,5)));	
			Thread.sleep(2000);
			Generics.click1(SaveAddress);
			//Generics.click1(SaveAddress);
			System.out.println("Address saved successfully");
		}
		return true;
	}

	@Test(priority=10)
	public boolean verifyPaymentButtons() throws Exception{
		Thread.sleep(2000);
		Generics.click1(RedButton);
		Generics.click1(CtaButton);
		Thread.sleep(2000);
		Generics.click1(nbButton);
		Thread.sleep(2000);
		System.out.println(radioButtons.size());
		int radioButtons1=radioButtons.size();
		if(radioButtons1==4)
		{
			System.out.println(" total size is matched");
			return true;
		}
		else
		{
			System.out.println("total size is not matched");
			return false;
		}
	}

	@Test(priority=11)
	public boolean verifyBankName() throws Exception{
		Thread.sleep(2000);
		Generics.click1(Btn);
		for(WebElement element:BankNames)
		{
			String text=element.getText();
			System.out.println(text);
			if(text.contains("Yes Bank")){
				System.out.println(element.getText());
				if (element.getText()=="Yes Bank") {
					System.out.println("Bank name is matched");
					return true;
				}
				else {
					System.out.println("Bank name is not matched");
					return false;
				}
			}
		}
		return true;
	}
}

