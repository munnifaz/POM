package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ContactsPage;
import pages.LoginPage;

public class UpdateAccount extends ProjectSpecificMethods {

	@BeforeTest
	public void setFile() {
		excelFileName = "Salesforce";
		sheetName = "UpdateAccount";
	}

	@Test(dataProvider = "fetchData")
	public void updateCon(String Username, String Password, String Action,String Name, String Email) throws InterruptedException {

		ContactsPage cp = new ContactsPage();

		new LoginPage().enterUserName(Username).enterpassword(Password).click().clickViewAll().clickContacts();
		cp.getTheListOfNamesInList().searchUnderListAndGetTheUniqueNameEdit(Action,Name).editContactDetails(Email);

	}
}
