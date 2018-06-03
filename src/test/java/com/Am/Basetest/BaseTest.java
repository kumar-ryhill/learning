package com.Am.Basetest;

import java.io.File;
import Catalog.Catalog;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.locators.FirefoxLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest 
{
	public  class Basestep 
	{
		public WebDriver driver=null;
		
		public Actions action;
		
		
		
		@BeforeSuite(alwaysRun=true)
		@Parameters({ "browser", "URL" })
		public void openBrowser(String browser, String URL) {
			try {
				if (browser.equalsIgnoreCase("Firefox")) 
				{
					System.setProperty("webdriver.gecko.driver", "D:\\workspace\\FrameWork_Puma_Max\\drivers\\chromedriver.exe\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					System.out.print("url"+URL);
					driver.get(URL);
				} else if (browser.equalsIgnoreCase("chrome")) {
					/*System.setProperty("webdriver.chrome.driver","D:\\workspace\\FrameWork_Puma_Max\\drivers\\chromeLastetdriver\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					System.out.print("url"+URL);
					driver.get(URL);*/
					
					//WebDriver driver = null;
					System.setProperty("webdriver.chrome.driver","D:\\Automation\\learning\\src\\test\\resource\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					driver = new ChromeDriver(options);
					System.out.println("Chrome opened using options");
					driver.get(URL);
				} else if (browser.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver","D:\\workspace\\FrameWork_Puma_Max\\drivers\\IEDriverServer.exe");
					
					driver = new InternetExplorerDriver();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					System.out.println("url" +URL);
					driver.get(URL);
				}
				driver.manage().window().maximize();
			
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
		}
		
		public void scrollToElementAsync(WebElement element) {
			int elementPosition = element.getLocation().getY();
			String js = String.format("window.scroll(0, %s)", elementPosition);
			((JavascriptExecutor) driver).executeAsyncScript(js);
			
		}
		
		public void action(WebElement element)
		{
			action= new Actions(driver);
			
			
			
		}
		
		
  
	}
	
	
	

}

	


