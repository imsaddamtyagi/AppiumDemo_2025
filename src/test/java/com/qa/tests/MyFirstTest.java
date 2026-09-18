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
    String Profile        = "new UiSelector().resourceId(\"com.uptodown:id/rl_avatar_user\")";
	String SignIn         = "new UiSelector().resourceId(\"com.uptodown:id/tv_username_user\")";
    String Email          = "new UiSelector().resourceId(\"com.uptodown:id/et_user_login\")";
    String Password       = "new UiSelector().resourceId(\"com.uptodown:id/et_pass_login\")";
    String Login          = "new UiSelector().resourceId(\"com.uptodown:id/tv_login\")";
    String GoBack         = "new UiSelector().description(\"Back\")";

	String Games          = "new UiSelector().description(\"Games\")";
    String SearchGames    = "new UiSelector().resourceId(\"com.uptodown:id/tv_main_search_view\")";
    String EnterValue     = "new UiSelector().resourceId(\"com.uptodown:id/actv_search_bar\")";
    String RemoveSearch   = "new UiSelector().resourceId(\"com.uptodown:id/iv_delete_search_bar\")";
    String Categories     = "new UiSelector().className(\"android.widget.ImageView\").instance(16)";
    String BellIcon       = "new UiSelector().description(\"My feed\")";
    String MainMenu       = "new UiSelector().className(\"android.widget.ImageView\").instance(4)";	
	String Avatar         = "new UiSelector().resourceId(\"com.uptodown:id/iv_avatar_user\")";
	
    String Logout         = "new UiSelector().resourceId(\"com.uptodown:id/tv_logout_uep\")";
    String BckAfterLogout = "new UiSelector().description(\"Back\")";
    

    String ThreeDot       = "new UiSelector().description(\"More options\")";
    String EditProfile    = "new UiSelector().text(\"Edit profile\")";

    
    AppiumDriver driver;
	
     @BeforeTest
	 public void AppiumSetUp() throws URISyntaxException, MalformedURLException
        {
    	 
    	   UiAutomator2Options options = new UiAutomator2Options();
    	   
    	   options.setPlatformName("Android");
    	   options.setPlatformVersion("16");
    	 //options.setDeviceName("100.64.0.1:5555");     // Mobile local Address
    	   options.setDeviceName("192.168.1.3:5555");   // Over WiFi Connection(Laptop and Mobile on same WiFi)
    	   options.setAutomationName("UiAutomator2");
    	   options.setAppPackage("com.uptodown");
    	   options.setAppActivity("com.uptodown.activities.MainActivity");
    	   options.setNoReset(true);

	        URI uri = new URI("http://127.0.0.1:4723/");    // Appium Server Address    	
	        long startTime = System.currentTimeMillis();
	        
	        driver = new AndroidDriver(uri.toURL(), options);  
	        
	        long endTime = System.currentTimeMillis();
	        double executionTimeInSeconds = (endTime - startTime) / 1000; // Divide by 1000 for seconds        
	        System.out.println("Time taken in launching application: " + executionTimeInSeconds + " seconds");
	        
	   }
	 
     
     @Test
     public void MyFirstTest_Appium() throws InterruptedException
     {
     	 doClick(driver,Profile); 
     	 doClick(driver,SignIn); 
     	 doSend(driver,Email,"imsaddamtyagi@gmail.com");
     	 doSend(driver,Password,"Kaalo@1234");
    	 doClick(driver,Login);
     	 doClick(driver,GoBack);  	 
    	 doClick(driver,Games);
    	 doClick(driver,SearchGames);
    	 doSend(driver,EnterValue,"PUBG");   
    	 doClick(driver,RemoveSearch);   
    	 doClick(driver,Categories);
    	 doClick(driver,BellIcon);  
    	 doClick(driver,MainMenu); 	 
         doClick(driver,Avatar);
    	 doClick(driver,ThreeDot); 
    	 doClick(driver,EditProfile);
    	 doClick(driver,Logout); 
    	 doClick(driver,BckAfterLogout);
     }
     
         
     public static   void doClick(AppiumDriver driver, String locator)
     {   	 
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
    elem.click();   
    System.out.println("Click Success: "+locator);
     }
     
     
     public static void doSend(AppiumDriver driver, String locator,String value)
     {   	 
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(locator))); 
    elem.sendKeys(value);    
    System.out.println("Send Success: "+value);
     }
     
     
     public static void scrollDownAndClick(AppiumDriver driver, String locator) 
     {
    	    try {
    	        String uiAutomatorString = 
    	        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" + locator + ")";

    	        WebElement elem = driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorString));

    	        if (elem != null)
    	        {
    	            System.out.println("Element found and scrolled into view: " + locator);
    	            elem.click();
    	            System.out.println("Clicked success");
    	        }
    	    } catch (Exception e) {
    	        System.out.println("Failed to scroll to element: " + locator);
    	        e.printStackTrace();
    	    }
    	}
     
    
     }

  
     
    	 
    
	 
     
	 
	















