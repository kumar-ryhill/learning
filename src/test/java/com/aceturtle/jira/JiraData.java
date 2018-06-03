package com.aceturtle.jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class JiraData 
{
	WebDriver driver;

	
	@Test
	public void jira_data()
	{
	   driver = null;
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\learning\\src\\test\\resource\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		driver.get("https://aceturtle.atlassian.net/secure/RapidBoard.jspa?rapidView=62&projectKey=STEP&view=reporting&chart=burndownChart&sprint=174");
		
		//driver.findElement(By.)
		
		
		
	}
	
	
	
	
	
    

}
