package com.browser.init;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GrabScreen {
	
	public void  GrabScreen1(WebDriver driver, String destFilePath) throws IOException{
		TakesScreenshot scrShot= ((TakesScreenshot) driver);
		File scrSource=scrShot.getScreenshotAs(OutputType.FILE);
		File scrDest=new File(destFilePath);
		FileUtils.copyFile(scrSource, scrDest);
		
		
	}

}
