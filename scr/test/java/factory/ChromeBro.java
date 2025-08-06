package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBro implements BrowserFactoryInf {

	@Override
	public WebDriver driverManager() {
		
		return new ChromeDriver();
	}

}
