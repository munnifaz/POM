package base;
	import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Parameters;

	import io.github.bonigarcia.wdm.WebDriverManager;
    import util.ReadExcel;

	public class ProjectSpecificMethods { 

	public String excelFileName, sheetName;
	public static RemoteWebDriver driver;
	// @Parameters({"browser"})
	static String browser = "Chrome";
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public Random rand = new Random();
	public int rand_int1 = rand.nextInt(1000);
	
			
		//chromedriver setup and disable notifications
		@BeforeMethod
		public void login() throws InterruptedException {
			
			if(browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
					//	,"headless");
				//options.addArguments("window-size=1366,768");
				
				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				}
				
			
			else if(browser.equalsIgnoreCase("IE")){
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();}
					
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
				}
			
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();}
			
			
				
				Properties prop=new Properties();
				try {
					InputStream input=new FileInputStream("C:\\Users\\munni\\TestLeaf\\PageObjectModel1\\src\\main\\java\\base\\config.properties");
					prop.load(input);
					String url=prop.getProperty("url");
					System.out.println(url);
					driver.get("https://login.salesforce.com");
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					Thread.sleep(10000);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			

			
		}

			@DataProvider(name = "fetchData")
			public String[][] sendData() throws IOException {
				ReadExcel re = new ReadExcel();
				String[][] readData = ReadExcel.readExcelSData(excelFileName,sheetName);
				return readData;
			}
			
		@AfterMethod
		public void close() {
			driver.quit();
			
		}
	}


