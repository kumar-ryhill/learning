package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {
	public WebDriver driver;
	String chromeExe;
	public Properties prop;

	@Test
	public WebDriver initializeDriver() throws IOException {
	 prop = new Properties();

		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + File.separator + "property" + File.separator + "data.properties");

		// FileInputStream fi= new FileInputStream(System.getProperty("user.dir") +
		// File.separator+"/com.base/data.properties");
		prop.load(fi);

		String browser = prop.getProperty("browser");
		System.out.println(browser);

		if (browser.equals("chrome")) {
			chromeExe = "src" + File.separator + "test" + File.separator + "resource" + File.separator
					+ "chromedriver.exe";// set the path to chromedriver
		}
		System.setProperty("webdriver.chrome.driver", chromeExe);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		System.out.println("Chrome opened using options");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	
	
	public void windowHandle() throws InterruptedException
	{
		String windowHandle = driver.getWindowHandle();
		
		//Thread.sleep(4000);
		driver.switchTo().window(windowHandle).findElement(By.cssSelector("#homepage > div.s.u.m.o.me.listbuilder-popup > div.listbuilder-popup-content > div > div > div > span > div > div.sumome-react-wysiwyg-component.sumome-react-wysiwyg-outside-horizontal-resize-handles.sumome-react-wysiwyg-outside-vertical-resize-handles.sumome-react-wysiwyg-close-button.sumome-react-wysiwyg-popup-image.sumome-react-wysiwyg-image > div > div > div:nth-child(2)")).click();
		
		
		
		
	}
	 


}
