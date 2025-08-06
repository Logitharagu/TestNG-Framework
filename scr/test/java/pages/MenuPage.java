package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Base.BassClass;
import Wrapper.SeleniumWrapper;

public class MenuPage extends BassClass{
	//button[@title='App Launcher']/div
	
	protected  By appLanucher=By.xpath("//div[@class='slds-icon-waffle']");
	protected  By veiwAll=By.xpath("//button[text()='View All']");
	protected  By sales=By.xpath("(//div[@class='slds-truncate']//p[@role='presentation'])[8]");
	protected  By service=By.xpath("(//div[@class='slds-truncate']//p[@role='presentation'])[1]");
	protected  By image=By.xpath("(//span[@class='uiImage']/parent::div[@data-aura-class='forceEntityIcon'])[1]");
	protected  By logOut=By.xpath("//a[text()='Log Out']");
	protected WebDriver driver; 
	protected SeleniumWrapper Owrap;
	
	public MenuPage(WebDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		Owrap=new SeleniumWrapper(driver,node);
	}
	
	public MenuPage appLanucherClick() throws InterruptedException {
		Thread.sleep(5000);
		Owrap.click(driver.findElement(appLanucher), "App Lancher");
		return this;
	}
	
	public MenuPage veiwAllClick() {
		Owrap.click(driver.findElement(veiwAll), "View All Link");
		return this;
	}
	
	public MenuPage imageVerify() throws InterruptedException {
		Thread.sleep(5000);
		Owrap.click(driver.findElement(image), "Image");
		return this;
	}
	
	public LoginPage logOutClick() throws InterruptedException {
		//Thread.sleep(2000);
		Owrap.click(driver.findElement(logOut), "LogOut");
		return new LoginPage(driver,node);
	}
	public SalesPage salesPageLink() throws InterruptedException {
		//Thread.sleep(5000);
		Owrap.click(driver.findElement(sales), "Salse Link");
		
		return new SalesPage(driver,node);
		
	}
	

}
