package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import Utils.ProperityFileReader;
import Wrapper.HTMLreport;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Factory.BrowserManager;


public class BassClass extends HTMLreport {
	
	public static String fileName="SalesForce"; 
	public  WebDriver driver;
	public static String Url=ProperityFileReader.fileReader(fileName, "URL");
	public static String browserType=ProperityFileReader.fileReader(fileName, "Browser");
	public String excelFilename=" ";
	public String testCaseName,testDescription,testModule;
	
	
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void bindReport() {
		endReport();
	}
	
	
	@BeforeClass
	public  void browserSellector() {
		driver=BrowserManager.getDriver(browserType).driverManager();
		driver.navigate().to(Url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		startTestCase(testCaseName, testDescription);
		startTestCase(testModule);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="testIdData")
	public Object[][] excelDataGet() throws IOException {
		Object[][] values=Utils.ExcelDataRead.excelReader(excelFilename);
		return values;
	}
	public String takeScreenShot()  {
		String sPath=System.getProperty("User.dir")+"/Image/img"+System.currentTimeMillis()+".png";
		File Ofile=new File(sPath);
		TakesScreenshot Oshot=(TakesScreenshot)driver;
		File screenshotAs = Oshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, Ofile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sPath;
		
	}

}

