package com.kony.ktas.suites;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.kony.ktas.util.ReadPropertyData;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	 
	 
	  private static ThreadLocal<AppiumDriver> driver= new ThreadLocal<AppiumDriver>();
	  
	  private ThreadLocal<String> sessionId = new ThreadLocal<String>();
	  
	  @DataProvider(name = "hardCodedBrowsers", parallel = true)
	    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
	        return new Object[][]{
	                
	                new Object[]{"Android", "Samsung Galaxy S8 GoogleAPI Emulator","7.0"},
	                new Object[]{"Android", "Samsung Galaxy S7 GoogleAPI Emulator","7.1"},
	                
	               
	        };
	    }
	  
	
	    public AppiumDriver getWebDriver() {
	        return driver.get();
	    }

	    public String getSessionId() {
	        return sessionId.get();
	    }
	    
	    @SuppressWarnings("rawtypes")
		protected void createDriver(String os,String deviceName, String version, String methodName)
	            throws MalformedURLException, UnexpectedException {
	    

	        DesiredCapabilities caps = new DesiredCapabilities();
			
		    System.out.println("Creating driver instance...");
			caps.setCapability("platformName",os);
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("platformVersion",version);
			
			caps.setCapability("app", ReadPropertyData.readMI("APK_PATH"));
			caps.setCapability("appiumVersion", "1.8.0");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("browserName", "");
		    
		    caps.setCapability("appPackage", "com.orgname.ABBAfe");
		    caps.setCapability("appActivity", "com.orgname.ABBAfe.ABBAfe");
	        caps.setCapability("name", methodName);
	        
	        caps.setCapability("idleTimeout", "180");
	        
	        

	        // Launch remote browser and set it as the current thread
	        driver.set(new AndroidDriver(
	                new URL("https://" + "laxman.aegyarapu" + ":" + "89c5981d-8fd0-4055-abf8-3c3cdd56e335" + "@ondemand.saucelabs.com:443/wd/hub"),
	                caps));

	        // set current sessionId
	        String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
	        sessionId.set(id);
	        
	        System.out.println("done..");
	    }

	    /**
	     * Method that gets invoked after test.
	     * Dumps browser log and
	     * Closes the browser
	     */
	    @AfterMethod(alwaysRun=true)
	    public void tearDown(ITestResult result) throws Exception {
	    	
	    	System.out.println("After method trying to close the app&Session...");
	        ((JavascriptExecutor) driver.get()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
	        driver.get().closeApp();
	        driver.get().quit();
	        System.out.println("Current session closed..");
	    }

	    protected void annotate(String text) {
	        ((JavascriptExecutor) driver.get()).executeScript("sauce:context=" + text);
	    }


}
