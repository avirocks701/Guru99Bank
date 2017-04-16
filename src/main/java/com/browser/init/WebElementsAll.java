package com.browser.init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * 
 */

/**
 * @author Avinash
 *
 */
public class WebElementsAll {
	
	WebDriver driver;
	By uid = By.name("uid");
	By password = By.name("password");
	By btnLogin= By.name("btnLogin");
	By btnReset=By.name("btnReset");
	By WelcomeText= By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");
	By ManagersName= By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	By LogOutBtn=By.xpath("/html/body/div[2]/div/ul/li[15]/a");
	
	public WebElementsAll(WebDriver driver){
		this.driver=driver;
	}
	
	public void Senduid(String Uid){
		driver.findElement(uid).sendKeys(Uid);
	}
	public void SendPassword(String Pwd){
		driver.findElement(password).sendKeys(Pwd);
	}
	public void ClickbtnLogin(){
		driver.findElement(btnLogin).click();
	}
	public void ClickbtnReset(){
		driver.findElement(btnReset).click();
	}
	public void WelcomeText(){
		String temp=driver.findElement(WelcomeText).getText();
		System.out.println(temp);
	}
	public String ManagersName(){
		String temp=driver.findElement(ManagersName).getText();
		System.out.println(temp);
		return temp;
	}
	
	public void LogOutBtn(){
		driver.findElement(LogOutBtn).click();
	}
}
