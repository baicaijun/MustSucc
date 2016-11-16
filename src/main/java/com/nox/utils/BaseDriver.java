package com.nox.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseDriver {
	WebDriver driver;
	
	  static String ChromeDriverPath="C:\\browser\\chromedriver.exe";
	  static String ChromeDriverName="webdriver.chrome.driver";
	  static String IEDriverPath="C:\\browser\\IEDriverServer.exe";
	  static String IEDriverName="webdriver.ie.driver";
	public WebDriver getBaseDriver(String BrowserType){
		if(BrowserType.endsWith("Chrome")){
			System.setProperty(ChromeDriverName, ChromeDriverPath);
			this.driver=new ChromeDriver();		
		}else if(BrowserType.endsWith("FireFox")){
			this.driver=new FirefoxDriver();
		}else{
			 System.setProperty(IEDriverName, IEDriverPath);	
			 
			 DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				     
			 ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				    
			 this.driver =new InternetExplorerDriver(ieCapabilities);
		}
		return driver;	
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	
}
