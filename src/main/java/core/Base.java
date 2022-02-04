package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Base {

	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	
	private String propertyPath = ".\\src\\test\\resources\\input\\property.properties";
	private String log4jPath = ".\\src\\test\\resources\\input\\log4j.properties";
	
	public Base() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyPath));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);
	}
	
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public static void openBrowser() {
		driver.get(getUrl());
	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();

	}
	
	//This method is for cross-browser testing. We can just change the browser name and run our test cases.
	public static void browser() {
		String browserName = getBrowser();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void explicitWait (WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}
}
