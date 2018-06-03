package com.Am.Basetest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class chrome  {

	@Test
	public static void launch() throws InterruptedException, IOException
	{
		WebDriver driver = null;
		
		System.out.println("i am in test class");
		
		//WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\learning\\src\\test\\resource\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.id("alertbtn")).click();
		
	Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		
		
		//new Select(driver.findElement(By.id("dropdown-class-example"))).selectByValue("option3");
		
		/*WebElement list = driver.findElement(By.xpath("//div[@class='puma_sale']/ul"));
		System.out.println(list.findElements(By.tagName("a")).size());
		
		for(int i=1;i<list.findElements(By.tagName("a")).size();i++)
		{
			String chord = Keys.chord(Keys.CONTROL,Keys.ENTER);
			list.findElements(By.tagName("a")).get(i).sendKeys(chord);
			Thread.sleep(5000);
			
		}*/
			/*Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();
			
			while(iterator.hasNext())
			{
				driver.switchTo().window( iterator.next());
				
				System.out.println(driver.getTitle());
				
				Thread.sleep(7000);
				
				driver.findElement(By.id("teacher-input-email")).sendKeys("kumar");
			}
			
		}
		*/
		
		
		
	}
	}


