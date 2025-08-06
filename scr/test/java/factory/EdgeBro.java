package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBro implements BrowserFactoryInf {

	@Override
	public WebDriver driverManager() {
		
		return new EdgeDriver();
	}

}
