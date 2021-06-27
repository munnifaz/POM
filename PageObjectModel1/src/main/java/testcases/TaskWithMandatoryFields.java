package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TaskWithMandatoryFields extends ProjectSpecificMethods {

	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="Login";
	}
		
	
	@Test(dataProvider="fetchData")
	
	public void taskwithMandatoryfields(String Username, String Password ) {
		
		
					new LoginPage().enterUserName(Username).enterpassword(Password).click()
					.clickViewAll().clickSales().newTaskDetails();
}
}