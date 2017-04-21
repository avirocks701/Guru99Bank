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
	By ChangePassword=By.xpath("/html/body/div[2]/div/ul/li[11]/a");
	By OldPassword=By.name("oldpassword");
	By NewPassword =By.name("newpassword");
	By ConfirmPassword= By.name("confirmpassword");
	By SubmitChangePassword=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input[1]");
	
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
	public void ChangePassword(){
		driver.findElement(ChangePassword).click();
	}
	public void OldPassword(String OldPass){
		driver.findElement(OldPassword).sendKeys(OldPass);;
	}
	public void NewPassword(String NewPass){
		driver.findElement(NewPassword).sendKeys(NewPass);
	}
	public void ConfirmPassword(String ConfPass){
		driver.findElement(ConfirmPassword).sendKeys(ConfPass);	
	}
	public void SubmitChangePassword(){
		driver.findElement(SubmitChangePassword).click();
	}
}
