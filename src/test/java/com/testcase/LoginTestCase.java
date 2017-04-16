package com.testcase;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.browser.init.*;
/**
 * 
 */

/**
 * @author Avinash
 * Doing Change 1
 *
 */
public class LoginTestCase {
	GrabScreen gbscr= new GrabScreen();
	@BeforeTest
	public void MethodSetup(){
		Browser browser =new Browser();
		browser.start(Util.URL);
	
	
	}
	@Test(priority=1)
	public void MethodLogin() throws InterruptedException, IOException{
		WebElementsAll wb = new WebElementsAll(Browser.driver);
		ReadDataSheet data=new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 2));
		wb.SendPassword(data.ReadFile("0", 1, 2));
		wb.ClickbtnLogin();
		//Assert.assertEquals(Browser.driver.getTitle(), "Guru99 Bank Manager HomePage");
		wb.WelcomeText();
		Boolean dum=wb.ManagersName().contains(data.ReadFile("0", 0, 2));
		Assert.assertTrue(dum);
		gbscr.GrabScreen1(Browser.driver, Util.destFilePath);
		wb.LogOutBtn();
		Thread.sleep(2000);
		Browser.driver.switchTo().alert().accept();
		
		
	}
	@Test(priority=0)
	public void MethodInvalidUserId() throws InterruptedException, IOException{
		WebElementsAll wb= new WebElementsAll(Browser.driver);
		ReadDataSheet data= new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 3));
		wb.SendPassword(data.ReadFile("0", 1, 3));
		wb.ClickbtnLogin();
		String Alert=Browser.driver.switchTo().alert().getText();
		Thread.sleep(2000);
		
		Browser.driver.switchTo().alert().accept();
		gbscr.GrabScreen1(Browser.driver, Util.destFilePath1);
		Assert.assertEquals(Alert, "User or Password is not valid");
		
		
	}
	
	@Test(priority=2)
	public void MethodInvalidPassword() throws InterruptedException, IOException{
		WebElementsAll wb= new WebElementsAll(Browser.driver);
		ReadDataSheet data= new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 4));
		wb.SendPassword(data.ReadFile("0", 1, 4));
		wb.ClickbtnLogin();
		String Alert=Browser.driver.switchTo().alert().getText();
		Thread.sleep(2000);
		Browser.driver.switchTo().alert().accept();
		gbscr.GrabScreen1(Browser.driver, Util.destFilePath2);
		Assert.assertEquals(Alert, "User or Password is not valid");
		
	}
	
	@Test(priority=3)
	public void MethodInvalidBoth() throws InterruptedException, IOException{
		WebElementsAll wb= new WebElementsAll(Browser.driver);
		ReadDataSheet data= new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 5));
		wb.SendPassword(data.ReadFile("0", 1, 5));
		wb.ClickbtnLogin();
		String Alert=Browser.driver.switchTo().alert().getText();
		Thread.sleep(2000);
		Browser.driver.switchTo().alert().accept();
		gbscr.GrabScreen1(Browser.driver, Util.destFilePath3);
		Assert.assertEquals(Alert, "User or Password is not valid");
		
	}
	
	@AfterTest 
	public void QuitSession(){
		Browser.driver.quit();
	}

}
