package Wrapper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import Base.BassClass;

public class SeleniumWrapper extends BassClass {
	
	public SeleniumWrapper(WebDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
		
	}
	
	public WebElement locatedElement(String locValue) {
		WebElement loc=driver.findElement(By.id(locValue));
		return loc;
	}
	
	public void type(WebElement ele,String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data"+data+"enter successfully in the field", "PASS");
			
		}catch (InvalidElementStateException e) {
			reportStep("The data"+data+"could not be entre in the field", "FAIL");
			
		}catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("Unknown exception occured while entering "+data+" in the field :", "FAIL");
		}	
	}
	
	public void typeAndChoose(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.TAB);
			reportStep("the data"+data+"enter successfully in the field", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The data"+data+"could not be entre in the field", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :", "FAIL");
		}
	}
	
	public void typeAndEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.ENTER);
			reportStep("the data"+data+"enter successfully in the field", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The data"+data+"could not be entre in the field", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :", "FAIL");
		}	
	}
	
	public void click(WebElement ele) {
		String text=" ";
		try {
			WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(40));
			owait.until(ExpectedConditions.elementToBeClickable(ele));
			text=ele.getText();
			ele.click();
			reportStep("The elements"+test+"is clicked", "PASS");
			
		} catch ( InvalidElementStateException e) {
			reportStep("The elements"+test+"is not clicked", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		}
	}
	
	public void click (WebElement ele,String eleName) {
		try {
			WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(40));
			owait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The elements"+eleName+"is clicked", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The elements"+eleName+"is not clicked", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		}
	}
	
	public void moveToElement(WebElement ele,String eleName) {
		try {
			WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(40));
			owait.until(ExpectedConditions.elementToBeClickable(ele));
			Actions oaction=new Actions(driver);
			oaction.moveToElement(ele).perform();
			reportStep("The elements"+eleName+"is clicked", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The elements"+eleName+"is not clicked", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		}
	}
	
	public void moveToElementAndClick(WebElement ele,String eleName) {
		try {
			WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(40));
			owait.until(ExpectedConditions.elementToBeClickable(ele));
			Actions oaction=new Actions(driver);
			oaction.moveToElement(ele).perform();
			reportStep("The elements"+eleName+"is clicked", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The elements"+eleName+"is not clicked", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		}
	}
	
	public void clickWithNoSnap(WebElement ele) {
		String text=" ";

		try {
			WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(40));
			owait.until(ExpectedConditions.elementToBeClickable(ele));
			text=ele.getText();
			ele.click();
			reportStep("The element :"+text+"  is clicked.", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
			
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL");
		}
	}
	
	public String getText(WebElement ele) {
		String bReturn=" ";
		try {
			bReturn=ele.getText();
			reportStep("the display text"+bReturn+"is display", "PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("the display text"+bReturn+"is not display", "FAIL");
		}
		return bReturn;
	}
	
	public String getTitle() {
		String bReturn=" ";
		try {
			bReturn=driver.getTitle();
			reportStep("The Title is : "+bReturn+"", "PASS");
	
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		}
		return bReturn;
	}
	
	public String getAttribute(WebElement ele,String attribute) {
		String breturn=" ";
		try {
			ele.getAttribute(attribute);
			reportStep("The attribute is: "+breturn+".", "PASS");
			
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return breturn;
	}
	
	public void selectDropDownUsingText(WebElement ele,String value) {
		try {
			new Select(ele).selectByValue(value);
			reportStep("The dropdown is selected with value "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
	}
	
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
			
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
	}
	
	public boolean verfiyExactTitle(String title) {
		boolean bReturn=false;
		try {
			if (getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				return true;
				
			} else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
			
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
		
	}
	public boolean verfiyPartialTitle(String title) {
		boolean bReturn=false;
		try {
			if (getTitle().contains(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				return true;
				
			} else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		}
		return bReturn;
	}
	
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		
		try {
			if (getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");

			} else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}
	
	public void verfiyPartialAttribute(WebElement ele, String attribute, String value) {
		
		try {
			if (getAttribute(ele, attribute).contains(value)) {
				
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");

			} else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");

			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}
	
	public void verfiySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				reportStep("The element "+ele+" is selected","PASS");
				
			} else {
				reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}
	public void verfiyDisplay(WebElement ele) {
		
		@Nullable
		String attribute = ele.getAttribute("name");
		try {
			if (ele.isDisplayed()) {
				reportStep("The element "+attribute+"is visible","PASS");
			} else {
				reportStep("The element "+attribute+" is not visible","FAIL");
			}
			
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}	
	}
	
	public boolean verfiyDisplayWithOutReturn(WebElement ele) {
		
		boolean result=false;
		try {
			@Nullable
			String attribute = ele.getAttribute("name");
			if (ele.isDisplayed()) {
				reportStep("The element "+attribute+" is visible","PASS");
				result=true;
				return result;
			} else {
				reportStep("The element "+attribute+" is not visible","FAIL");
				result=false;
				return result;
			}
			
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
		return result;	
	}
	
	public boolean verifyDisplayedwithReturn(WebElement ele,String element) {
		boolean result = false;
		try {
			if(ele.isDisplayed()) { 
				reportStep("The element "+element+" is visible","PASS");
				result = true;
				return result;
			} else {
				reportStep("The element "+element+"  is not visible","FAIL");
				return result;
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
		return result;
	}
	
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
		return text;
	}


	public void closeActiveBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS");
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS");
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL");
		}
	}


	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}
	
	
	

}
