package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	
	By login= By.xpath("//*[contains(text(),'Login')]");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getLogin()
	{
	
		return driver.findElement(login);
	}
	
	public String gettitle()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
}
