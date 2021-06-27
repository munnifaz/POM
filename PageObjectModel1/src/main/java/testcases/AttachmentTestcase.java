package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class AttachmentTestcase extends ProjectSpecificMethods {

	

	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="Attachment";
	}
		
	@Test(dataProvider="fetchData")
	public void createCon(String Username,String Password, String From, String To) throws InterruptedException {
		
		
		new LoginPage().enterUserName(Username).enterpassword(Password).click()
		.clickViewAll().clickServiceConsole().clickIconandFiles().clickLatestModifiedItem().UploadFileUsingFileStream(From,To)
		.clickShareAndVerifyErrormsg().uploadFile().viewFileDetails().deleteFile();
		
}
}
