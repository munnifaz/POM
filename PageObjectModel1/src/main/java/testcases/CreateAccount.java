package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateAccount extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="CreateAccount";
	}
	
	
	@Test(dataProvider="fetchData") 
	public void CreateAcc(String Username,String Password,String Title,String FirstName,String LastName,String email,String inputtext) throws InterruptedException 
		{
			
		new LoginPage()
		.enterUserName(Username).enterpassword(Password).click().Globalsmallicon().newContact().clickSaluation().title(Title).firstName(FirstName).lastName(LastName)
		.email(email).clickSearchAcc().ClickNewAcc().enterText(inputtext).clickSave().clickSave1().isDisplay();
		
			
	}

}
