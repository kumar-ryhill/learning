package com.API;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;

import jxl.write.Label;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.WebDriverBackedSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class FileReading_Writing
 {
	public WebDriver driver;
	
	
	public Selenium selenium=new WebDriverBackedSelenium(driver, "https://www.facebook.com/");

	public String str;

	@Test(priority=1)

  public void step2() throws Exception
{
  
FileInputStream fi=new FileInputStream("D:\\login.xls");

  Workbook w=Workbook.getWorkbook(fi);

  Sheet s=w.getSheet(0);



  FileOutputStream fo=new FileOutputStream("D:\\loginres.xls");

  WritableWorkbook wb=Workbook.createWorkbook(fo);

  WritableSheet ws=wb.createSheet("Results", 0);



  for (int i = 1; i < s.getRows(); i++) 
  { 

	driver.findElement(By.xpath("//*[@id='email']")).sendKeys(s.getCell(0, i).getContents());

	driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(s.getCell(1, i).getContents());

	driver.findElement(By.cssSelector("input.signin")).click();

	Thread.sleep(4000);


	if(selenium.isElementPresent("link=Sign out"))

	{

		driver.findElement(By.linkText("Sign out")).click();

		str="Pass";

	}else{

		System.out.println("In valid credential");

		str="Fail";

	}
  


	Label result=new Label(2,i,str);

	ws.addCell(result);

	driver.get("http://mail.in.com");
  


for (int j = 0; j < s.getColumns(); j++)
        { 

		System.out.println(s.getCell(j, i).getContents());

		Label lab=new Label(j, i, s.getCell(j, i).getContents());

		ws.addCell(lab);

	}

   }

	Label un=new Label(0,0,"Username");

	Label pw=new Label(1,0,"Password");

	Label rs=new Label(2,0,"Results");

	ws.addCell(un);

	ws.addCell(pw);

	ws.addCell(rs);

	wb.write();

	wb.close();
 
 }
 
 @BeforeTest
 
 public void beforeTest() 
 {
	 System.setProperty("webdriver.chrome.driver","D:\\Automation\\learning\\src\\test\\resource\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		System.out.println("Chrome opened using options");
		driver.get("https://www.facebook.com/");
		
  }
}





