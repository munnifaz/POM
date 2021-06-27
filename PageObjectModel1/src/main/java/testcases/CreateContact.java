package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ContactsPage;
import pages.LoginPage;

public class CreateContact extends ProjectSpecificMethods {
	
	
	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="CreateContact";
	}
		
	@Test(dataProvider="fetchData")
	public void createCon(String Username,String Password, String NewContact) throws InterruptedException {
		
		ContactsPage cp=new ContactsPage();
		
		new LoginPage().enterUserName(Username).enterpassword(Password).click()
		.clickViewAll().clickSales().clickBootcamplink().addContacts()
		.typeNewContact().clickSaluation().allInputDetailsForNewContact(NewContact)
		.nextbtnAddContactstoCompaignPage().submitBtninAddtoCampaignPage();
		cp.ClickContactsIcon().verifyAccUnderBootcamp();
		
	}
	
	
	
	
}
