package com.testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.men.test.Testbase;

public class TestUtility extends Testbase {
	 public static long PAGE_LOAD_TIMEOUT=20;
     public static long Implicit_WAIT=10;
     
     public static void takeScreenshotAtEndOfTest() throws IOException {
    		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		String currentDir = System.getProperty("user.dir");
    		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    	}

}
