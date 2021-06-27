package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ContactsPage;
import pages.LoginPage;

public class DeleteAccount extends ProjectSpecificMethods {

	

	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="DeleteAccount";
	}
		
	@Test(dataProvider="fetchData")
	public void DeleteCon(String Username,String Password, String Action, String Name) throws InterruptedException {
		
		ContactsPage cp=new ContactsPage();
		
		new LoginPage().enterUserName(Username).enterpassword(Password).click()
		.clickViewAll().clickContacts();cp.getTheListOfNamesInList().searchUnderListAndGetTheUniqueNameEdit(Action,Name)
		.clickDeletepopup().verifyContactDeleted(Name);
}
}
