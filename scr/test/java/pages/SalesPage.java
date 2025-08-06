package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import Wrapper.SeleniumWrapper;
public class SalesPage extends MenuPage {
	
	private By leadLink=By.xpath("//a[@title='Leads']/span");
	private By newLink=By.xpath("//div[@part='button-group']//button[text()='New']");
	private By nameEnter=By.xpath("//input[@name='lastName']");
	private By company=By.xpath("//input[@name='Company']");
	private By statusBar=By.xpath("(//label[contains(text(),'Lead Status')]/following-sibling::div)[1]");
	private By role=By.xpath("//*[@id='combobox-button-625-3-625']");
	private By save=By.xpath("//button[@name='SaveEdit']");
	
    private WebDriver driver;
    private SeleniumWrapper Owrap;
	
	public SalesPage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver=driver;
		this.node=node;
		Owrap=new SeleniumWrapper(driver,node);
	}
	
	
	public SalesPage leadLinkClick() {
		Owrap.moveToElementAndClick(driver.findElement(leadLink), "Click Lead");
		return this;
	}
	public SalesPage newButtonClick() {
		Owrap.click(driver.findElement(newLink), "Click New");
		return this;
	}
	public SalesPage enterName(String name) {
		Owrap.type(driver.findElement(nameEnter), name);
		return this;
	}
	public SalesPage companyName(String coName) {
		Owrap.type(driver.findElement(company), coName);
		return this;
		
	}
	public SalesPage statusBarClick() throws InterruptedException {
		Owrap.moveToElementAndClick(driver.findElement(statusBar), "Select Drop Down");
		Owrap.moveToElementAndClick(driver.findElement(role), "Select role");
		return this;
	}
	public SalesPage saveButton() {
		Owrap.click(driver.findElement(save), "Click Save");
		return this;
	}
	

}