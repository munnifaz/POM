package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteNewOpp extends ProjectSpecificMethods{

	
	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="CreateNewopp";
	}
		
	@Test(dataProvider="fetchData")
	public void deleteNewOpp(String Username,String Password, String NewOpp) throws InterruptedException {
		
		
		new LoginPage().enterUserName(Username).enterpassword(Password).click()
		.clickViewAll().clickSales().clickBootcamplink().deleteNewOpp(NewOpp).verityDeletedOpp(NewOpp);
		
	}
}
