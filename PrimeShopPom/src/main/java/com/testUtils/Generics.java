package com.testUtils;

import org.openqa.selenium.WebElement;

public class Generics {
	public static void click1(WebElement element){
		element.click();
	}
	public static void sendkeys1(WebElement web,String val){
		web.sendKeys(val);
	}
	public static String getattribute(WebElement placeholder,String name){
		return placeholder.getAttribute(name);
		
	}
	 public static String getText1(WebElement ele){
			return ele.getText();
			 
		 }
}

