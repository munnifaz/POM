package pages;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class Homepage extends ProjectSpecificMethods {

	JavascriptExecutor jsexecutr = (JavascriptExecutor) driver;
	Random rand = new Random();
	int rand_int1 = rand.nextInt(1000);

	// click global actions icon
	public Homepage Globalsmallicon() throws InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement smallicon = driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']");
			smallicon.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// clicking the new contact
	public Homepage newContact() throws InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement contact = driver.findElementByXPath("//span[text()='New Contact']");
			contact.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Filling the details
	public Homepage clickSaluation() {
		try {
			driver.findElementByXPath("//*[text()='Salutation']//following::div[4]/a").click();
		} catch (Exception e) {

		}
		return this;
	}

	public Homepage title(String Title) {
		try {
			driver.findElementByXPath("(//a[text()='" + Title + "'])[1]").click();
		} catch (Exception e) {
		}
		return this;
	}

	public Homepage firstName(String FirstName) {
		try {
			driver.findElementByXPath("//input[@class='firstName compoundBorderBottom form-element__row input']")
					.sendKeys(FirstName);
		} catch (Exception e) {
		}
		return this;
	}

	public Homepage lastName(String LastName) {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		driver.findElementByXPath(
				"//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")
				.sendKeys(LastName + rand_int1);
		return this;
	}

	public Homepage email(String email) {
		driver.findElementByXPath("//input[@inputmode='email']").sendKeys(email);
		return this;
	}

	// Creating the Account

	public Homepage clickSearchAcc() throws InterruptedException {
		driver.findElementByXPath("//input[@title='Search Accounts']").click();
		Thread.sleep(1000);
		return this;
	}

	public Homepage ClickNewAcc() {
		driver.findElementByXPath("//span[@title='New Account']").click();
		return this;
	}

	// Giving the Details in account, it is identifying as same window

	public Homepage enterText(String inputtext) {
		driver.findElementByXPath("(//input[@class=\" input\"][@type='text'])[3]").sendKeys(inputtext);
		return this;
	}

	public Homepage clickSave() throws InterruptedException {
		driver.findElementByXPath("(//button[@type='button'][@title='Save'])[2]").click();
		Thread.sleep(1000);
		return this;
	}

	public Homepage clickSave1() {
		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		return this;
	}

	// checking the account creation successful or not

	public Homepage isDisplay() {
		Boolean ElemenetDisplay = driver.findElementByXPath("//div[@data-key='success'][@role='alert']").isDisplayed();
		if (ElemenetDisplay) {
			Assert.assertTrue(true);
			System.out.println("The testcase passed & Contact successfully created");
		} else {
			Assert.fail();
			System.out.println("The testcase failed & unsuccesful New contact creation");

		}
		return this;
	}

	public Homepage clickViewAll() {
		try {
			driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
			//WebDriverWait wait = new WebDriverWait(driver, 30);
			//WebElement ViewAllbutton = driver.findElementByXPath("//button[text()='View All']");
			driver.findElementByXPath("//button[text()='View All']").click();
			//wait.until(ExpectedConditions.elementToBeClickable(ViewAllbutton));
			//ViewAllbutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickContacts() {
		try {

			driver.findElementByXPath("//input[@class='slds-input']").sendKeys("Contacts");
			driver.findElementByXPath("//mark[text()='Contacts']").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickSales() {
		try {

			driver.findElementByXPath("//input[@class='slds-input']").sendKeys("Sales");
			driver.findElementByXPath("(//mark[text()='Sales'])[3]").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public FilesPage clickServiceConsole() {
		try {
			driver.findElementByXPath("//input[@class='slds-input']").sendKeys("Service Console");
			driver.findElementByXPath("//mark[text()='Service Console']").click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FilesPage();
	}

	// Click on Campaigns small ICON ->BootCamp link
	public CampaignPage clickBootcamplink() throws InterruptedException {
		try {

			WebElement SmallIcon = driver
					.findElementByXPath("//span[text()='Campaigns Menu']//preceding::lightning-primitive-icon[1]");
			jsexecutr.executeScript("arguments[0].click();", SmallIcon);
			Thread.sleep(1000);
			WebElement Bootcamplink = driver.findElementByXPath("(//span[text()='BootCamp'])[1]");
			jsexecutr.executeScript("arguments[0].click();", Bootcamplink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CampaignPage();
	}

	public ContactsPage clickContactUnderBootcampLink(String NewContact) {

		try {
			driver.findElementByXPath("//span[text()='Contacts Menu']//preceding::lightning-icon[1]").click();
			WebElement accName = driver.findElementByXPath(
					"(//p[text()='Recent records']/following-sibling::one-app-nav-bar-menu-item)[1]//a");

			String Contactlnk = accName.getText();
			System.out.println(accName);

			if (Contactlnk.contains(NewContact)) {

				accName.click();
				jsexecutr.executeScript("arguments[0].click();", accName);
				Thread.sleep(2000);
			} else {
				System.out.println("Contact not found under Bootcamp Link");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ContactsPage();
	}

	public Homepage newTaskDetails() {
		try {
			driver.findElementByXPath("//a[@title='Tasks']/following-sibling::one-app-nav-bar-item-dropdown//div")
					.click();

			WebElement newtask = driver.findElementByXPath("(//span[text()='New Task'])[1]");
			jsexecutr.executeScript("arguments[0].click();", newtask);
			driver.findElementByXPath("//input[@title='Search Contacts']").click();
			driver.findElementByXPath("//div[@title='test dd']").click();
			driver.findElementByXPath(
					"//textarea[@class='textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")
					.sendKeys("Automation");
			driver.findElementByXPath("//button[@title='Save']").click();

			WebElement msg = driver
					.findElementByXPath("//li[text()='These required fields must be completed: Subject']");
			if (msg.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println(
						"Tc passed & The required fields must be completed : subject error message is displaying ");
			} else {
				Assert.fail();
				System.out.println("TC Failed & The error message is not displaying");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
