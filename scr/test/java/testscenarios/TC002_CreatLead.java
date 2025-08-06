package TestSceniores;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


import Base.BassClass;
import Library.FakerDataProvider;
import Pages.LoginPage;

public class TC002_CreatLead extends BassClass {
	
	@BeforeTest
	public void setUpData() {
		excelFilename="TC02";
		authors="narmatha";
		category="sanity";
		testCaseName="Salesforce Lead Creat";
		testDescription="Validate all the mandatory field and created lead by providing only mandatory fields ";
		testModule="Lead Creat";
		//its given to node name 
	}
	
	
	@Test(priority = 1,dataProvider = "testIdData")
	public void salseForeSalsePage(String UserName,String PassWord) throws InterruptedException {
		
		boolean result = new LoginPage(driver,node).enterUserName(UserName)
		               .enterPassword(PassWord)
		               .clickLogin()
		               .homePageValidation()
		               .appLanucherClick()
		               .veiwAllClick()
		               .salesPageLink()
		               .leadLinkClick()
		               .newButtonClick()
		               .enterName(FakerDataProvider.getLastName())
		               .companyName(FakerDataProvider.getCompanyName())
		               .saveButton()
		               .imageVerify()
		               .logOutClick()
		               .verfiyMessage();
		AssertJUnit.assertEquals(result, true);
	}

}
