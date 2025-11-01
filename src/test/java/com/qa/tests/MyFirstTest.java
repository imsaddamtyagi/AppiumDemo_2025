package com.qa.tests;

import java.net.URI;
import java.time.Duration;
import org.testng.annotations.Test;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    	   options.setDeviceName("100.64.0.1:5555");   // Mobile local Address
    	 //options.setDeviceName("192.168.1.8:5555"); // Over WiFi Connection
    	   options.setAutomationName("UiAutomator2");
    	   options.setAppPackage("com.example.app");
    	   options.setAppActivity("com.example.app.MainActivity");
    	   options.setNoReset(true);

	        URI uri = new URI("http://127.0.0.1:4723/");    // Appium Server Address    	
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

  
     
    	 
    
	 
     
	 
	















