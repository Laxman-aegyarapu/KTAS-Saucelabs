package com.kony.ktas.suites;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.kony.ktas.common.Log;
import com.kony.ktas.util.ReadPropertyData;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverClass {
	
	
	private static String USERNAME = null;
	private static String ACCESS_KEY = null;
	private static String URL =null;
	
	
	public static volatile AppiumDriver<MobileElement> driver=null;
	
	
	public AndroidDriver<MobileElement> launchApp() throws MalformedURLException {
		
		Log.info("Intiated Method to Launch the application on Saucelabs...");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appiumVersion", "1.8.0");
		caps.setCapability("deviceName","Samsung Galaxy S8 GoogleAPI Emulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","7.0");
		caps.setCapability("platformName","Android");
		caps.setCapability("app","sauce-storage:amplify14.apk");
		//caps.setCapability("app", ReadPropertyData.readMI("APK_PATH"));
	    
	    caps.setCapability("appPackage", "com.orgname.ABBAfe");
	    caps.setCapability("appActivity", "com.orgname.ABBAfe.ABBAfe");
	    
	    USERNAME=ReadPropertyData.readMI("USERNAME");
	    ACCESS_KEY=ReadPropertyData.readMI("ACCESS_KEY");
	    URL="https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	    
	    
	 
	    driver = new AndroidDriver<>(new URL(URL), caps);
	  
	    return (AndroidDriver<MobileElement>) driver;
	}
	
   /* public AndroidDriver<MobileElement> launchApp() throws MalformedURLException {
		
		Log.info("Intiated Method to Launch the application on Saucelabs...");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
	    capabilities.setCapability("platformName", ReadPropertyData.readMI(Integer.toString(1),"MOBILE_OS"));
	    capabilities.setCapability("deviceName", ReadPropertyData.readMI(Integer.toString(1),"MOBILE_NAME_ID"));
	    capabilities.setCapability("platformVersion", ReadPropertyData.readMI(Integer.toString(1),"MOBILE_VERSION_Android"));
	    
	    capabilities.setCapability("app", ReadPropertyData.readMI("APK_PATH"));
	    
	    capabilities.setCapability("browserName", "");
	    capabilities.setCapability("deviceOrientation", "portrait");
	    capabilities.setCapability("appiumVersion", ReadPropertyData.readMI("appiumVersion_Android"));
	    
	    capabilities.setCapability("appPackage", ReadPropertyData.readMI("PACKAGE_NAME"));
	    capabilities.setCapability("appActivity", ReadPropertyData.readMI("ACTIVITY_NAME"));
	 
	    USERNAME=ReadPropertyData.readMI("USERNAME");
	    ACCESS_KEY=ReadPropertyData.readMI("ACCESS_KEY");
	    URL="https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	    
	    driver = new AndroidDriver<>(new URL(URL), capabilities);
	  
	    return (AndroidDriver<MobileElement>) driver;
	}
*/
	
	/* public AndroidDriver<MobileElement> launchApp() throws MalformedURLException {
			
			Log.info("Intiated Method to Launch the application on Saucelabs...Jenkins");
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			Log.info("Printing Env variables...");
			
			System.out.println("Platform is :: "+System.getenv("SELENIUM_PLATFORM"));
			System.out.println("Device name is :: "+System.getenv("SELENIUM_DEVICE"));
			System.out.println("platform version is :: "+System.getenv("SELENIUM_VERSION"));
			
			System.out.println("UserName :: "+System.getenv("SAUCE_USERNAME"));
			System.out.println("AccessKey :: "+System.getenv("SAUCE_ACCESS_KEY"));
			
			
		    capabilities.setCapability("platformName",  System.getenv("SELENIUM_PLATFORM"));
		    capabilities.setCapability("deviceName", System.getenv("SELENIUM_DEVICE"));
		    capabilities.setCapability("platformVersion", System.getenv("SELENIUM_VERSION"));
		    
		    capabilities.setCapability("app", ReadPropertyData.readMI("APK_PATH"));
		   // capabilities.setCapability("browserName", "");
		    capabilities.setCapability("deviceOrientation", System.getenv("SELENIUM_DEVICE_ORIENTATION "));
		   // capabilities.setCapability("appiumVersion", ReadPropertyData.readMI("appiumVersion_Android"));
		    
		    capabilities.setCapability("appPackage", ReadPropertyData.readMI("PACKAGE_NAME"));
		    capabilities.setCapability("appActivity", ReadPropertyData.readMI("ACTIVITY_NAME"));
		 
		    //USERNAME=ReadPropertyData.readMI("USERNAME");
		    //ACCESS_KEY=ReadPropertyData.readMI("ACCESS_KEY");
		    URL="https://" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com:443/wd/hub";
		    
		    driver = new AndroidDriver<>(new URL(URL), capabilities);
		  
		    return (AndroidDriver<MobileElement>) driver;
		    
		   //System.getenv("SAUCE_NATIVE_APP")
		}*/

}
