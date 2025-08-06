package TestSceniores;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Base.BassClass;
import Pages.LoginPage;

public class TC001_LoginPage extends BassClass {
	
	@BeforeTest
	public void stepUp() {
		excelFilename="TC01";
		authors="logitha";
		category="smoke";
		testCaseName="Salesforce Login";
		testDescription="Validate all the mandatory field and login with valid and invalid credential";
		testModule="Login";//its given to node name 
	}
	
	@Test(priority = 1)
	public void verifyPageValidation() {
		boolean value = new LoginPage(driver,node).verfiyMessage();
		Assert.assertEquals(value, true);
	}
	@Test(priority = 2,dataProvider = "testIdData")
	public void validationOrginalUserId(String UserName,String PassWord) throws InterruptedException {
		boolean value = new LoginPage(driver,node).enterUserName(UserName)
		               .enterPassword(PassWord)
		               .clickLogin().homePageValidation().imageVerify()
		               .logOutClick().verfiyMessage();
		Assert.assertEquals(value, true);
		
	}
	
	@Test(priority = 3)
	public void validationOrginalUserId2() throws InterruptedException {
		boolean value = new LoginPage(driver,node).enterUserName("logitha@tcs.sandbox")
		               .enterPassword("Mylearning@testing1")
		               .clickLogin().homePageValidation().imageVerify()
		               .logOutClick().verfiyMessage();
		Assert.assertEquals(value, true);
		
	}
	@Test(priority = 4)
	public void validationWrongUserId() {
		boolean errorMessageValidate = new LoginPage(driver,node).enterUserName("logichithra@gmail.com")
		                              .enterPassword("Developer1$3").loginWithInvaliedUserAndPass()
		                              .errorMessageValidate();
		Assert.assertEquals(errorMessageValidate, true);
	}
	

}
