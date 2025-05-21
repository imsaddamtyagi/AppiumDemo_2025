package com.qa.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class MyFirstTest 
{
	
	String GitLink =   "new UiSelector().description(\"Visit My GitHub Profile\")";

    AppiumDriver driver;
	
     @BeforeTest
	 public void AppiumSetUp() throws URISyntaxException, MalformedURLException
        {
    	 
    	   UiAutomator2Options options = new UiAutomator2Options();
    	   
    	   options.setPlatformName("Android");
    	   options.setPlatformVersion("15");
    	   options.setDeviceName("192.0.0.2:5555");
    	   options.setAutomationName("UiAutomator2");
    	   options.setAppPackage("com.example.app");
    	   options.setAppActivity("com.example.app.MainActivity");
    	   options.setNoReset(true);

	        URI uri = new URI("http://127.0.0.1:4723/");        	
	        driver = new AndroidDriver(uri.toURL(), options);     
	        	
	   }
	 
     
     @Test
     public void MyFirstTest_Appium() throws InterruptedException
     {
    	 
    	 Thread.sleep(5000);
    	 doClick(driver,GitLink);
       
    
    	 }
     
     
     
     
     
     public static   void doClick(AppiumDriver driver, String locator)
     { 
    	 
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
    elem.click();
 
    
     }
     
     
     public static   void doSend(AppiumDriver driver, String locator,String value)
     { 
    	 
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
    elem.sendKeys(value);
 
    
     }
     
     
    
     }

  
     
    	 
    
	 
     
	 
	















