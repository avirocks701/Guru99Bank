package com.testcase;
import java.io.IOException;

import org.openqa.selenium.By;
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
 *Checking Fetch
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
	@Test(priority=4)
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

		
	}
	@Test(priority=7)
	public void ChangePasswordValidation() throws InterruptedException{
		WebElementsAll wb= new WebElementsAll(Browser.driver);
		ReadDataSheet data= new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 2));
		wb.SendPassword(data.ReadFile("0", 1, 2));
		wb.ClickbtnLogin();
		wb.ChangePassword();
		wb.OldPassword(data.ReadFile("0", 0, 6));
		wb.NewPassword(data.ReadFile("0", 1, 6));
		wb.ConfirmPassword(data.ReadFile("0", 2, 6));
		wb.SubmitChangePassword();
		String Alert=Browser.driver.switchTo().alert().getText();
		Thread.sleep(2000);
		Browser.driver.switchTo().alert().accept();
		//gbscr.GrabScreen1(Browser.driver, Util.destFilePath3);
		Boolean dum1=Alert.contains("Old Password is incorrect");
		
		Assert.assertTrue(dum1);
	}
	
	@Test(priority=8)
	
	public void MethodAddCustomer() throws IOException{
		WebElementsAll wb = new WebElementsAll(Browser.driver);
		ReadDataSheet data=new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 2));
		wb.SendPassword(data.ReadFile("0", 1, 2));
		wb.ClickbtnLogin();
		wb.NewCustomer();
		wb.CustomerName(data.ReadFile("0", 0, 7));
		wb.CustomerGender();
		wb.CustomerDOB(data.ReadFile("0", 1, 7));
		wb.CustomerAddress(data.ReadFile("0", 2, 7));
		wb.CustomerCity(data.ReadFile("0", 3, 7));
		wb.CustomerState(data.ReadFile("0", 4, 7));
		wb.CustomerPIN(data.ReadFile("0", 5, 7));
		wb.CustomerMobile(data.ReadFile("0", 6, 7));
		wb.CustomerEmail(data.ReadFile("0", 7, 7));
		wb.CustomerPassword(data.ReadFile("0", 8, 7));
		wb.CustomerFormSubmit();
		String ValEmail=Browser.driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[13]/td[2]")).getText();
		Assert.assertEquals(ValEmail, data.ReadFile("0", 7, 7));
		String custID=Browser.driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]")).getText();
		System.out.println("Customer Created, Account ID is "+custID);
		data.WriteFile(custID,0,9);
	}
	
	@Test(priority=0)
	public void MethodNewAccount() throws InterruptedException, IOException{
		WebElementsAll wb = new WebElementsAll(Browser.driver);
		ReadDataSheet data=new ReadDataSheet(Util.DataSheetPath);
		wb.Senduid(data.ReadFile("0", 0, 2));
		wb.SendPassword(data.ReadFile("0", 1, 2));
		wb.ClickbtnLogin();
		wb.NewAccount();
		wb.AccountCustomerID(data.ReadFile("0", 0, 9));
		wb.SelectSavingsAccountType(true);
		wb.AccountInitialDeposit("1000");
		wb.NewAccountSubmit();
		String AccID= wb.AccountID();
		data.WriteFile(AccID,0,10);
		Thread.sleep(5000);
		String ValEmail=Browser.driver.findElement(By.xpath("//*[@id='account']/tbody/tr[7]/td[2]")).getText();
		Assert.assertEquals(ValEmail, data.ReadFile("0", 7, 7));
	
		
	}
		
	@AfterTest 
	public void QuitSession(){
			Browser.driver.quit();
	}

}
