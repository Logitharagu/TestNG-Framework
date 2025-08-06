package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Base.BassClass;
import Wrapper.SeleniumWrapper;

public class LoginPage extends MenuPage {
	
	
	
	private By userNameText=By.id("username");
	private By passWordText=By.id("password");
	private By loginButton=By.id("Login");
	private By rememeberMe=By.xpath("//label[text()='Remember me']");
	private By forgotPss=By.id("forgot_password_link");
	private By failMessage=By.xpath("//div[@id='error']");
	private WebDriver driver;
	private SeleniumWrapper Owrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver=driver;
		this.node=node;
		Owrap=new SeleniumWrapper(driver,node);
	}
	
	
	public boolean verfiyMessage() {
		if(Owrap.verifyDisplayedwithReturn(driver.findElement(userNameText),"User Name")&& Owrap.verifyDisplayedwithReturn(driver.findElement(passWordText), "Pass Word")
				&& Owrap.verifyDisplayedwithReturn(driver.findElement(loginButton), "Login Button")) {
			System.out.println("Those elements are display");
			return true;
		}else {
			System.out.println("No elements are display");
			return false;
		}
	}
	
	public LoginPage enterUserName(String name) {
		Owrap.type(driver.findElement(userNameText), name);
		return this;
	}
	public LoginPage enterPassword(String pass) {
		Owrap.type(driver.findElement(passWordText), pass);
		return this;
	}
	public HomePage clickLogin() {
		Owrap.click(driver.findElement(loginButton),"Login Button");
		return new HomePage(driver,node);
	}
	public LoginPage loginWithInvaliedUserAndPass() {
		Owrap.click(driver.findElement(loginButton),"Login Button");
		return this;
	}
	public boolean errorMessageValidate() {
		if(Owrap.verifyDisplayedwithReturn(driver.findElement(failMessage), "Error Message")) {
			System.out.println("you enter the wrong username and password");
			return true;
		}else {
			System.out.println("you enter correct username and password");
			return false;
		}
	}

}
