package Academy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;


public class LoginUserTest extends Base 
{
	//public static org.apache.log4j.Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	void beforetest() throws IOException
	{
		driver = initializeDriver();
		log.info("browser is initilized");
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Email, String password,String text) throws IOException {
		String title = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";

		try {
			
		    LandingPage lp = new LandingPage(driver);
		    lp.getLogin().click();
			/*LoginPage lop = new LoginPage(driver);
			lop.Email().sendKeys(Email);
			lop.password().sendKeys(password);
			lop.loginClick().click();*/
		    
		   // Set<String> windowHandles = driver.getWindowHandles();

			System.out.println(text);
		} catch (Throwable e) {

			System.out.println("Fail to verify Landing page");
			org.testng.Assert.fail();

		}

	}
   
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "Restricted@gmail.com";
		data[0][1] = "kumar127";
		data[0][2] = "Restricted user";
/*
	    data[1][0] = "NonRestricteduser@gmail.com";
		data[1][1] = "kumar127";
		data[1][2] = "Restricted user";
*/
		return data;
	}

}
