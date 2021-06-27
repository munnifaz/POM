package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethods;
import pages.LoginPage;

public class Login extends ProjectSpecificMethods{
		
	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="Login";
	}
		
	
	@Test(dataProvider="fetchData")
	public void login(String Username, String Password ) {
		
	new LoginPage().
				enterUserName(Username)
				.enterpassword(Password)
				.click();
				
	}

}


