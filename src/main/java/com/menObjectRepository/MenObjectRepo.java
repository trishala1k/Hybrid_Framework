package com.menObjectRepository;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.men.test.Testbase;

public class MenObjectRepo extends Testbase{
	@FindBy(xpath="//button[@class='focus:outline-none border-0 p-2']")
	public static WebElement crossButton;
	
	@FindBy(xpath="//p[text()='Categories']")
	public WebElement Categories;
	
	@FindBy(xpath="//a[@class='block rounded border border-solid border-gray-300 text-xs p-2 mr-2 mb-2']")
	public List<WebElement> topCategory;
	
	@FindBy(linkText="Messenger & Duffle Bags")
	public WebElement DuffleBags;
	
	@FindBy(xpath="//p[@class='text-xs truncate text-gray-600 leading-6 mb-2']")
	public List<WebElement> bagsList1;
	
	@FindBy(xpath="//div[@id='accordion__heading-raa-174']//following:: div[contains(text(),'Topwear') or contains(text(),'Bottomwear') or contains(text(),'Footwear') or contains(text(),'Winter Wear') or contains(text(),'Watches & Wearables') or contains(text(),'Bags & Wallets') or  contains(text(),'Accessories')]")
	public List<WebElement> subMenButton;
	
	@FindBy(xpath="//div[text()='Footwear']")
	public WebElement Footwear;
	
	@FindBy(xpath="//a[text()='Casual Shoes']")
	public WebElement CasualShoes;
	
	@FindBy(xpath="//div[text()='Men']")
	public WebElement MenButton;
	
	@FindBy(xpath="//img[@alt='Men Blue Slip-On Canvas Casual Shoes']")
	public WebElement SelectOneShoe;
	
	@FindBy(xpath="//button[text()='Show More Reviews']")
	public WebElement ShowReview;
	
	@FindBy(xpath="//h2[text()='Product Ratings & Reviews']")
	public WebElement Review1;
	
	@FindBy(xpath="//span[text()='Size Chart']")
	public WebElement SizeChart;
	
	@FindBy(xpath="//tr//td[1]")
	public List<WebElement> SizeList1;
	
	@FindBy(xpath="//tr/td[2]")
	public List<WebElement> footLengthList1;
	
	@FindBy(xpath="//button[@class='border-0 w-full flex items-start justify-end rounded']")
	public WebElement CloseSizeChart;
	
	@FindBy(xpath="//button[text()='UK6']")
	public WebElement SelectSize;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	public WebElement AddToCart;
	
	@FindBy(xpath="//button[@class='sc-kGXeez sc-hMqMXs itvpbv relative w-48px flex flex-row items-center font-normal']")
	public WebElement CheakAddToCartBtn;
	
	@FindBy(xpath="//input[@name='phone']")
	public WebElement Phone;
	
	@FindBy(xpath="//button[text()='Send OTP']")
	public WebElement OTP;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement OTPsubmit;
	
	@FindBy(xpath="(//button[text()='Remove'])[1]")
	public WebElement RemoveBtn;
	
	@FindBy(xpath="//button[text()='Remove Product']")
	public WebElement RemoveProduct;
	
	@FindBy(xpath="//h1[text()='Your Cart is Empty']")
	public WebElement EmptyCartText;
	
	@FindBy(xpath="//button[text()='UK6']")
	public WebElement SizeSelect1;
	
	@FindBy(xpath="//button[@class='sc-kGXeez sc-ksYbfQ kvajiu']")
	public WebElement ByNow;
	
	@FindBy(xpath="//a[@class='sc-kGXeez sc-dyGzUR eVSPOJ']")
	public WebElement PayRs;
	
	@FindBy(xpath="//button[text()='Add New Address']")
	public WebElement Address;
	
	@FindBy(id="name")
	public WebElement name1;
	
	@FindBy(id="mobile")
	public WebElement mobile1;
	
	@FindBy(id="email")
	public WebElement email1;
	
	@FindBy(id="houseNo")
	public WebElement houseNo1;
	
	@FindBy(id="pincode")
	public WebElement pincode1;
	
	@FindBy(id="streetAddress")
	public WebElement streetAddress1;
	
	@FindBy(xpath="//button[text()='Save Address']")
	public WebElement SaveAddress;
	
	@FindBy(xpath="(//button[@color='red'])[1]")
	public WebElement RedButton;
	
	@FindBy(xpath="//div[@class='cta-button']")
	public WebElement CtaButton;
	
	@FindBy(xpath="//input[@value='nb']")
	public WebElement nbButton;
	
	@FindBy(xpath="//input[@name='paymode']")
	public List<WebElement> radioButtons;
	
	@FindBy(xpath="(//input[@name='paymode'])[4]")
	public WebElement paymodeBtn;
	
	@FindBy(xpath="//div[@class='ib vm pos-r w91 bold _1Am-']")
	public WebElement Btn;
	
	@FindBy(xpath="//li")
	public List<WebElement> BankNames;
	
}
