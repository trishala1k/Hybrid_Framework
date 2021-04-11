package com.men.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.testUtils.PropertiesUtility;
import com.testUtils.TestUtility;
import com.testUtils.WebEventListener;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	FileInputStream fis = null;  
	public static Logger log=Logger.getLogger(Testbase.class);
	PropertiesUtility proputils=null;
	//	 public static Logger logger;
	//	 
	//	 public Logger testLog(){
	//		 logger=Logger.getLogger(Testbase.class);
	//		 String path=(System.getProperty("user.dir") +"E:/workspace3/PrimeShopPom/src/main/resources/log4j.properties");
	//		 PropertyConfigurator.configure(path);
	//		return logger;
	//		 
	//	 }

	public Testbase(){
		try{
			prop = new Properties();
			FileInputStream fp = new FileInputStream("C:/Users/LOGITECH/git/Hybrid_Framework/PrimeShopPom/src/main/resources/config.properties");
			prop.load(fp);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(){
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		//now create object of Event Listeners to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;



		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(TestUtility.Implicit_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
