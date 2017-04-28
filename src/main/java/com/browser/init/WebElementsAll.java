package com.browser.init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


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
	////////////////////////////////////////////////////////////////
	By ChangePassword=By.xpath("/html/body/div[2]/div/ul/li[11]/a");
	By OldPassword=By.name("oldpassword");
	By NewPassword =By.name("newpassword");
	By ConfirmPassword= By.name("confirmpassword");
	By SubmitChangePassword=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input[1]");
	
	///////////////////////////////////////////////////////////////
	By NewCustomer =By.xpath("/html/body/div[2]/div/ul/li[2]/a");
	By CustomerName=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input");
	By CustomerGender=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
	By CustomerDOB=By.xpath("//*[@id='dob']");
	By CustomerAddress=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea");
	By CustomerCity=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input");
	By CustomerState=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input");
	By CustomerPIN=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input");
	By CustomerMobile=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input");
	By CustomerEmail=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input");
	By CustomerPassword =By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input");
	By CustomerFormSubmit=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]");
	By CustomerFormReset=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[2]");
	///////////////////////////////////////////////////////////////////
	By NewAccount =By.xpath("/html/body/div[2]/div/ul/li[5]/a");
	By CurrentAmmount=By.xpath("//*[@id='account']/tbody/tr[10]/td[2]");
	By AccountCustomerID= By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input");
	By SelectSavingsAccountType=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select");
	By AccountInitialDeposit=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input");
	By NewAccountSubmit =By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
	By AccountID=By.xpath("//*[@id='account']/tbody/tr[4]/td[2]");
	
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
	public void NewCustomer(){
		driver.findElement(NewCustomer).click();
	}
	public void CustomerName(String name){
		driver.findElement(CustomerName).sendKeys(name);
	}
	public void CustomerGender(){
		if (driver.findElement(CustomerGender).isSelected()){
			System.out.println("Male selected");
		}
		else
		{
			driver.findElement(CustomerGender).clear();
		}
			
	}
	public void CustomerDOB(String dob){
		driver.findElement(CustomerDOB).sendKeys(dob);
		
	}
	public void CustomerAddress(String Addr){
		driver.findElement(CustomerAddress).sendKeys(Addr);
	}
	public void CustomerCity(String city){
		driver.findElement(CustomerCity).sendKeys(city);
	}
	public void CustomerState(String state){
		driver.findElement(CustomerState).sendKeys(state);
	}
	public void CustomerPIN(String pin){
		driver.findElement(CustomerPIN).sendKeys(pin);
	}
	public void CustomerMobile(String number){
		driver.findElement(CustomerMobile).sendKeys(number);
	}
	public void CustomerEmail(String email){
		driver.findElement(CustomerEmail).sendKeys(email);
	}
	public void CustomerPassword(String pwd){
		driver.findElement(CustomerPassword).sendKeys(pwd);
	}
	public void CustomerFormSubmit(){
		driver.findElement(CustomerFormSubmit).click();
	}
	
	public void NewAccount(){
		driver.findElement(NewAccount).click();
	}
	public void AccountCustomerID(String CustID){
		driver.findElement(AccountCustomerID).sendKeys(CustID);
	}
	public void SelectSavingsAccountType(Boolean savings){
		Select accntType= new Select(driver.findElement(SelectSavingsAccountType));
		if(savings==true)
			accntType.selectByIndex(0);
		else
			accntType.selectByIndex(1);
	}
	public void AccountInitialDeposit(String ammount){
		driver.findElement(AccountInitialDeposit).sendKeys(ammount);
	}
	public String CurrentAmmount(){
		return driver.findElement(CurrentAmmount).getText();
	}
	public String AccountID(){
		return driver.findElement(AccountID).getText();
	}
	public void NewAccountSubmit(){
		driver.findElement(NewAccountSubmit).click();
	}
}
