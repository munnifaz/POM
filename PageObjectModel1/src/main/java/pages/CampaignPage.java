package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

public class CampaignPage extends ProjectSpecificMethods {

	//private static String OppName;

	// going down and clicking Add contact in comapign
	public CampaignPage addContacts() throws InterruptedException {
		try {

			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,1000)");
			WebElement NewButton = driver.findElementByXPath("//div[text()='Add Contacts']");
			js.executeScript("arguments[0].click();", NewButton);
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	/*
	 * public CampaignPage ClickAddContacts() { try { WebElement NewButton =
	 * driver.findElementByXPath("//div[text()='Add Contacts']");
	 * js.executeScript("arguments[0].click();", NewButton); Thread.sleep(10000); }
	 * catch (Exception e) { e.printStackTrace(); } return this; }
	 */

	public CampaignPage typeNewContact() throws InterruptedException {
		try {
			driver.findElementByXPath("//input[@title='Search Contacts']").click();
			driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("New Contact");
			Thread.sleep(3000);
			driver.findElementByXPath("//h2[text()='Add Contacts to Campaign']").click();
			driver.findElementByXPath("//input[@title='Search Contacts']").click();
			Thread.sleep(3000);
			WebElement NewContact = driver.findElementByXPath("//span[text()='New Contact']");
			NewContact.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CampaignPage clickSaluation() {
		try {
			driver.findElementByXPath("(//a[@class='select'])[1]").click();
			driver.findElementByXPath("(//a[text()='Mr.'])[1]").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CampaignPage allInputDetailsForNewContact(String NewContact) {
		try {
			driver.findElementByXPath("//input[@placeholder='First Name']").sendKeys(NewContact);
			driver.findElementByXPath("//input[@placeholder='Last Name']").sendKeys("shaik" + rand_int1);
			WebElement save = driver.findElementByXPath("//button[@title='Save']");
			save.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CampaignPage nextbtnAddContactstoCompaignPage() throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebElement next = driver.findElementByXPath("//button[@type='button']//span[text()='Next']");
			js.executeScript("arguments[0].click();", next);
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return this;
	}

	public CampaignPage submitBtninAddtoCampaignPage() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElementByXPath("//button[@type='button']//span[text()='Submit']").click();
			WebElement msg = driver.findElementByXPath("//div[@class='toastTitle slds-text-heading--small']");
			if (msg.isDisplayed()) {
				System.out.println("new member added to Bootcamp message is displaying");
			} else {
				System.out.println("The Bootcamp msg is not displaying");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CampaignPage clickNewOppInCampaignAndFillDetails(String NewOpp) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,1000)");

			WebElement NewButton = driver.findElementByXPath("//div[@title='New']");
			JavascriptExecutor jsexectrNew = (JavascriptExecutor) driver;
			jsexectrNew.executeScript("arguments[0].click();", NewButton);
			Thread.sleep(1000);
			driver.findElementByXPath("//input[@name='Name']").sendKeys(NewOpp);
			Thread.sleep(1000);

			driver.findElementByXPath("//input[@name='CloseDate']").clear();
			driver.findElementByXPath("//input[@name='CloseDate']").sendKeys("06/04/1992");

			driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[3]").click();
			driver.findElementByXPath("//span[@class='slds-media__body']/span[text()='Needs Analysis']").click();

			// clicking save button
			WebElement savebtn = driver.findElementByXPath("//button[text()='Save']");
			js.executeScript("arguments[0].click();", savebtn);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public CampaignPage verifyNewOpp() {
		try {
			if (driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")
					.isDisplayed()) {
				System.out.println("New oppurtunity has been created");
			} else {
				System.out.println("new oppurtunity NOT Created");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public CampaignPage deleteNewOpp(String NewOpp) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,1000)");			
			List<WebElement> table = driver.findElementsByXPath("(//ul[@class='uiAbstractList'])[2]/li");
			System.out.println(table.size());
			
			List<WebElement> editbtn = driver
					.findElementsByXPath("//span[@class='slds-icon_container slds-icon-utility-down']");
			//System.out.println(editbtn.size());
			
			int sizeOfTheTable = table.size();
			Thread.sleep(3000);

			for (int i = 0; i < sizeOfTheTable; i++) {
				if (table.get(i).getText().contains(NewOpp)) {

					WebElement EditIcon = editbtn.get(i);
					//JavascriptExecutor jsetr = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", EditIcon);

					WebElement Delete = driver.findElementByXPath("//a[@title='Delete']");
					//JavascriptExecutor jsetre = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", Delete);
					Thread.sleep(3000);

					driver.findElementByXPath("//span[text()='Delete']").click();
				} else {
					System.out.println("The oppurtunity is not found");
				}

			}

			WebElement msg = driver
					.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			if (msg.isDisplayed()) {
				System.out.println("The oppurtunity has been deleted successfully message is displaying");
			} else {
				System.out.println("The oppurtnty not deleted & message is not displaying");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public CampaignPage verityDeletedOpp(String NewOpp) {

		Boolean flag = true;
		try {
			WebElement SmallIconverify = driver
					.findElementByXPath("//span[text()='Campaigns Menu']//preceding::lightning-primitive-icon[1]");

			js.executeScript("arguments[0].click();", SmallIconverify);
			Thread.sleep(1000);

			WebElement Bootcamplink = driver.findElementByXPath("(//span[text()='BootCamp'])[1]");
			js.executeScript("arguments[0].click();", Bootcamplink);

			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,1000)");

			WebElement emptyOpp = driver.findElementByXPath("(//h2[@class='slds-card__header-title'])[3]");
			if (emptyOpp.isDisplayed()) {
				System.out.println("The testcase passed & oppurtunity is deleted succssfully");
			}

			else {
				List<WebElement> table = driver
						.findElementsByXPath("(//div[@class='listItemBody withActions']/h3/div/a)");
				System.out.println(table.size());

				List<WebElement> editbtn = driver
						.findElementsByXPath("//span[@class='slds-icon_container slds-icon-utility-down']");
				System.out.println(editbtn.size());

				int sizeOfTheTable1 = table.size();
				Thread.sleep(3000);
				for (int i = 0; i < sizeOfTheTable1; i++) {
					System.out.println(table.get(i).getText());
					if (table.get(i).getText().equals(NewOpp)) {
						flag = false;
						break;
					}
				}
			}

			if (flag = true) {
				System.out.println("The oppurtunity is successfully deleted");
			} else {
				System.out.println("The opp not deleted");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
