package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	

	public LoginPage enterUserName(String Username) {

		try {
			driver.findElementById("username").sendKeys(Username);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return this;
	}

	public LoginPage enterpassword(String Password) {

		try {
			driver.findElementById("password").sendKeys(Password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public Homepage click() {
		try {
			driver.findElementByName("Login").click();
			Thread.sleep(10000);
			String title = driver.getTitle();
			if (title.contains("Home")) {
				Assert.assertTrue(true);
			}

			else {

				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Homepage();

	}

}
