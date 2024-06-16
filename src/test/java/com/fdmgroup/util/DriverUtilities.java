package com.fdmgroup.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {

    // 1. private static instance of class
    private static DriverUtilities driverUtilities;
    private WebDriver driver;

    // 2. create private constructor
    private DriverUtilities() {
    }

    // 3. public static getInstance() to create single instance of object SINGLETON
    public static DriverUtilities getInstante() {
	if (driverUtilities == null) {
	    driverUtilities = new DriverUtilities();
	}
	return driverUtilities;
    }

    public WebDriver getDriver() {
	if (driver == null) {
	    createDriver();
	}
	return driver;
    }

    private void createDriver() {
	String driverName = getDriverName();
	switch (driverName) {
	case "google chrome":
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    this.driver = new ChromeDriver();
	    break;
	case "firefox":
	    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
	    this.driver = new FirefoxDriver();
	    break;
	case "edge":
	    System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
	    this.driver = new EdgeDriver();
	    break;
	default:
	    System.out.println("The browser name is invalid!!");
	    break;
	}
    }

    private String getDriverName() {
	Properties config = new Properties();
	String driverName = "";
	try {
	    config.load(new FileInputStream("src/test/resources/config.properties"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	for (String key : config.stringPropertyNames()) {
	    if (key.equals("browser")) {
		driverName = config.getProperty(key);
	    }
	}
	return driverName;
    }
}