package Pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Wrapper.SeleniumWrapper;

public class HomePage extends MenuPage {
	
private WebDriver driver;
private SeleniumWrapper Owrap;
	
	public HomePage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver=driver;
		this.node=node;
		Owrap=new SeleniumWrapper(driver,node);
	}
	

	public HomePage homePageValidation() throws InterruptedException {
		Thread.sleep(5000);
		if(Owrap.verifyDisplayedwithReturn(driver.findElement(appLanucher), "App Lancher")&&
				Owrap.verifyDisplayedwithReturn(driver.findElement(image), "Image"))
		 {
			System.out.println("user landed correct home page");
			return this;
		}else {
			return this;
		}
		
	}
	
}
