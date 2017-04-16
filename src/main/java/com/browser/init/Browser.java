package com.browser.init;

import java.util.concurrent.TimeUnit;
import com.browser.init.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static WebDriver driver;
	
	public void start(String URL){
		System.setProperty(Util.DriverName, Util.path);
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}
