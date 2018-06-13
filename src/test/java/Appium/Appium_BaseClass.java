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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Appium_BaseClass {

	public Process process;
	public AppiumDriver driver;

	public static ExtentReports extentreport;
	public static ExtentTest extenttest;

	@BeforeTest
	public void Start_Server() throws IOException, InterruptedException {
		String Start_Server = "D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(Start_Server);

		if (process != null) {
			System.out.println("Started the Appium Server");
		} else {
			System.out.println("NOT started");
		}

		Thread.sleep(12000);
		// *********************************
	}

	
	public void Launch_Application() throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Lenovo A7010a48");
		System.out.println("Device name");
		cap.setCapability("platformName", "Android");
		System.out.println("platformName name");
		cap.setCapability("platformVersion", "5.1");
		System.out.println(" platformVErsion name");
		// Thread.sleep(1000);

		// cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		// cap.setCapability("appPackage","net.one97.paytm");
		// cap.setCapability("appActivity","net.one97.paytm.landingpage.activity.AJRMainActivity");
		// Thread.sleep(6000);

		cap.setCapability("appPackage", "com.lenovo.ideafriend");
		cap.setCapability("appActivity", "com.lenovo.ideafriend.alias.MmsActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(4000);

		// Thread.sleep(4000); driver.findElement(By.
		driver.findElement(By.xpath("//android.widget.TextView[@text='Suresh aceturtle']")).click();

		String text = driver.findElement(By.id("com.lenovo.ideafriend:id/text_view")).getText();
		System.out.println(text);
		String[] split = text.split(" ");

		System.out.println(split[0]);

		// return split[0];
	}

	public void Stop_Server() throws InterruptedException {
		// stop server
		if (process != null) {
			process.destroy();
			Thread.sleep(4000);
			System.out.println("Stopped the Appium Server");

		}

	}

	

	// extentreport.endTest(extenttest);
	// extentreport.flush();

}
