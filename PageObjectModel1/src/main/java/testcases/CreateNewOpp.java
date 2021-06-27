package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateNewOpp extends ProjectSpecificMethods {

	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="CreateNewopp";
	}
		
	@Test(dataProvider="fetchData")
	public void createNewOpp(String Username,String Password, String NewOpp) throws InterruptedException {
		
		
		new LoginPage().enterUserName(Username).enterpassword(Password).click()
		.clickViewAll().clickSales().clickBootcamplink().clickNewOppInCampaignAndFillDetails(NewOpp).verifyNewOpp();
		
	}
	
}
