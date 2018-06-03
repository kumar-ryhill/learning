package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Appium_BaseClass {

	public Process process;
	public AppiumDriver driver;
	
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;	
	
	@Test(priority=0)
	public void Start_Server() throws IOException, InterruptedException
	{
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!= null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT started");
		}
		
		Thread.sleep(12000);
		//*********************************
	}
	
	@Test(priority=1)
	
	public void Launch_Application() throws InterruptedException, IOException
	{
		
		 DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName","Lenovo A7010a48");
			System.out.println("Device name");
			cap.setCapability("platformName","Android");
			System.out.println("platformName name");
			cap.setCapability("platformVersion","5.1");
			System.out.println(" platformVErsion name");
			//Thread.sleep(1000);
			
			//cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability("appPackage","net.one97.paytm");
			cap.setCapability("appActivity","net.one97.paytm.landingpage.activity.AJRMainActivity");
			//Thread.sleep(6000);
			
			AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			Thread.sleep(5000);
			 driver.findElementByXPath("//*[@bounds='[0,926][240,1211]']").click();
		
			/*Thread.sleep(20000);
			
			driver.findElement(By.id("lst-ib")).sendKeys("sachin");
			
			//driver.findElementByXPath("//android.widget.Spinner[@text='1']").sendKeys("sachin");
			
			//xpath("//android.widget.Button[@text='5']")
			driver.findElementByXPath("//div[@class='sbico']").click();
			
			Thread.sleep(12000);
			
			String Actual_Result = driver.findElementByXPath("//div[contains(text(),'Cricketer')]").getText();
			System.out.println("Actual Result is "+Actual_Result);*/
		
	}
	
	
	public void Explicit_Wait(WebElement ele, long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
		
	}
	
	
	public String Capture_Screenshot1(String TC_ID,String Order_Set) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Apr30_BB_project\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str));
		
		String Path="D:\\Apr30_BB_project\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str;
		return Path;
		
	}
	
	@BeforeSuite
	public static void Report_Extent()
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String str2=df.format(date);
		
		extentreport= new ExtentReports("D:\\Apr30_BB_project\\Report\\"+"BB_Project"+"-"+str2+".html",false);
		
	}
	
	public void Stop_Server() throws InterruptedException
	{
		//stop server
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(4000);
			System.out.println("Stopped the Appium Server");
			
		}
		
		extentreport.endTest(extenttest);
		extentreport.flush();
		
	}
	
	
	
}
