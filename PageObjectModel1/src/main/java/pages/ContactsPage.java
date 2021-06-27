package pages;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class ContactsPage extends ProjectSpecificMethods {

	public ContactsPage ClickContactsIcon() {
		try {
			driver.findElementByXPath("//span[text()='Contacts Menu']//preceding::lightning-icon[1]").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage verifyAccUnderBootcamp() {
		try {
			String accName = driver
					.findElementByXPath(
							"(//p[text()='Recent records']/following-sibling::one-app-nav-bar-menu-item)[1]/a/span")
					.getText();
			if (accName.equalsIgnoreCase("Munni shaik" + rand_int1)) {
				Assert.assertTrue(true);
				System.out.println("verified account creation under bootcamp campaign");
			} else {
				Assert.fail();
				System.out.println("not verified account creation under bootcamp campaign");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;}

	
	
	public ContactsPage getTheListOfNamesInList() {
		int i = 1;
		do {

			try {
				driver.findElementByXPath("//table/tbody/tr[" + i + "]//th//a").sendKeys(Keys.PAGE_DOWN);

				System.out.println(driver.findElementByXPath("//table/tbody/tr[" + i + "]//th//a").getText());

			} catch (org.openqa.selenium.NoSuchElementException e) {
				break;
			}

			i = i + 1;

		} while (true);

		System.out.println("the values printed in the list");
		return this;

	}

	
	public ContactsPage searchUnderListAndGetTheUniqueNameEdit(String Action, String Name) throws InterruptedException {

		try {
			driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys(Name);
			WebElement textbox = driver.findElementByXPath("//input[@name='Contact-search-input']");
			textbox.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			List<WebElement> duplicateelements = driver.findElementsByXPath("//tbody/tr/th/span/a");
			int size1 = duplicateelements.size();
			for (int m = 0; m <= size1; m++) {
				if (duplicateelements.get(m).getText().equals(Name)) {
					System.out.println("The uniquename found in" + " " + (m + 1) + " " + "th row & the name is" + " "
							+ duplicateelements.get(m).getText());
					WebElement mt = driver.findElement(By.xpath(
							"//a[@role='button'][@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']/span"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mt);
					Thread.sleep(1000);

					driver.findElementByXPath("//table/tbody/tr[" + (m + 1) + "]/td[8]//div").click();
					driver.findElementByXPath("//a[@title='" + Action + "']").click();

					break;
				} else {
					System.out.println("not match in" + (m + 1) + "row");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage clickDeletepopup() {
		try {

			WebElement Deletepopup = driver.findElementByXPath("//span[text()='Delete']");
			Deletepopup.click();

			WebElement msg = driver
					.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			if (msg.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Deleted msg displayed");
			} else {
				Assert.fail();
				System.out.println("Delete msg not displayed");
			}

			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetails(String PhoneNum) {

		try {

			WebElement title = driver.findElementByXPath("//input[@name='Title']");
			title.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "FAZ");

			WebElement Birthday = driver.findElementByXPath("//input[@name='Birthdate']");
			Birthday.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "06/04/1992");

			driver.findElementByXPath("(//label[text()='Lead Source']/following::input)[1]").sendKeys("Purchased List");

			WebElement Phonenumber = driver.findElementByXPath("//input[@name='Phone']");
			Phonenumber.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "9952983298");

			driver.findElementByXPath("//button[text()='Save']").click();

			String getphonenum = driver.findElementByXPath("//span[@class='forceOutputPhone slds-truncate']").getText();
			String exactphonenumber = getphonenum.replaceAll("\\D", "");
			System.out.println(exactphonenumber);

			if (exactphonenumber.equals(PhoneNum)) {
				Assert.assertTrue(true);
				System.out.println("The testcase passed & phone number updated and verified");
			} else {
				Assert.fail();
				System.out.println("The testcase failed & phone number is not verified");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage updateAccount(String Action, String Email) {

		try {
			// giving test dd in searchbox and clicking
			driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys("test dd");
			WebElement textbox = driver.findElementByXPath("//input[@name='Contact-search-input']");
			textbox.sendKeys(Keys.ENTER);
			WebElement m = driver.findElement(By.xpath(
					"//a[@role='button'][@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']/span"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
			Thread.sleep(3000);
			WebElement editbutton = driver.findElementByXPath(
					"//a[@role='button'][@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']/span");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", editbutton);
			driver.findElementByXPath("//a[@title=" + Action + "']").click();
			WebElement email = driver.findElementByXPath("//input[@name='Email']");
			email.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "mun@gmail.com");
			WebElement Leadsource = driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[5]");
			Leadsource.sendKeys("Partner Referral");
			WebElement area = driver.findElementByXPath("(//textarea[@name='street'])[1]");
			area.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Australia");
			WebElement Level = driver.findElementByXPath("//label[text()='Level']/following::div/input");
			Level.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Tertiary");
			driver.findElementByXPath("//button[text()='Save']").click();
			String EmailfromApp = driver.findElementByXPath("//a[@class='slds-truncate emailuiFormattedEmail']")
					.getText();
			System.out.println(EmailfromApp);
			if (EmailfromApp.equals(Email)) {
				Assert.assertTrue(true);
				System.out.println("The testcase passed & Email updated and verified");
			} else {
				Assert.fail();
				System.out.println("The testcase failed & Email is not verified");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage verifyContactDeleted(String Name) {
		try {
			WebElement NoItems = driver.findElementByXPath("//span[text()='No items to display.']");
			if (NoItems.isDisplayed()) {
				System.out.println("The account was deleted successfully");
			} else {
				List<WebElement> MatchingElements = driver.findElementsByXPath("//tbody/tr/th/span/a");
				int size = MatchingElements.size();
				for (int j = 0; j < size; j++) {
					System.out.println(MatchingElements.get(j).getText());
					if (!MatchingElements.get(j).getText().equals(Name)) {
						Assert.assertTrue(true);
						System.out.println("Contact not found" + " " + Name + " " + "the contact successfully deleted");
					} else {
						Assert.fail();
						System.out.println("The name is Found" + Name + "the contact was not deleted");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public ContactsPage deleteContact() throws InterruptedException {

		try {

			driver.findElementByXPath("//button[@class='slds-button slds-button_icon-border-filled']").click();
			driver.findElementByXPath("//a[@name='Delete']//span").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='Delete'][@class=' label bBody']").click();
			WebElement msg = driver
					.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			if (msg.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("The contact has been deleted msg is displaying");
			} else {
				Assert.fail();
				System.out.println("the contact not deleted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;

	}

}
