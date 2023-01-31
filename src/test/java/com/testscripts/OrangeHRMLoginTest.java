package com.testscripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.OrangeHRMLogin.Login.OrangeHRMLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {
	WebDriver driver;
	
	Properties pr;
	@BeforeSuite
	public void configData() throws Exception  {
		File file = new File("D:\\NewSelenium\\TestNG\\PageObjectModel\\config.properties");
		BufferedReader reader=new BufferedReader(new FileReader(file));
		Properties pr=new Properties();
		pr.load(reader);
	}
	@BeforeMethod
	public void setUP() {
		 WebDriverManager.chromedriver().setup();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 pr.getProperty("url");
		 driver.get("url");
		 }
	@Test(priority =1)
	public void loginTestScript() {
		OrangeHRMLogin login= new OrangeHRMLogin(driver);
		String username=pr.getProperty("username");
		String password=pr.getProperty("password");
		login.OrangeHRMLoginTest(username, password);
	}
	@AfterMethod
	public void logOut() {
		driver.close();
	}

}
