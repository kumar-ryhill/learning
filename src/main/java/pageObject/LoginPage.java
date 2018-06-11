package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	By Email = By.xpath("//*[@id='user_email']");

	By Password = By.xpath("//*[@id='user_password']");
	
	By Login = By.xpath("//*[@value='Log In']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Email() {

		return driver.findElement(Email);
	}

	public WebElement password() {
		return driver.findElement(Password);
	}
	
	
	public WebElement loginClick()
	{
		return driver.findElement(Login);
	}

	public String gettitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
}
