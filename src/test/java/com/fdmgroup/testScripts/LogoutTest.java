package com.fdmgroup.testScripts;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.UserIndexPage;
import com.fdmgroup.util.DriverUtilities;

public class LogoutTest {
    private DriverUtilities driverUtilities;
    private WebDriver driver;

    @Before
    public void setUp() {
	driverUtilities = DriverUtilities.getInstante();
	driver = driverUtilities.getDriver();
    }

    @Test
    public void testLogoutFunctionality() {

//System.out.println(HomePage.LogInButton(driver).getText()); // text = "Log In"

	UserIndexPage.loggedInUser(driver).click();
	if (UserIndexPage.logoutLink(driver).isDisplayed()) {
	    UserIndexPage.logoutLink(driver).click();
	}
	assertTrue(HomePage.SignInButton(driver).isDisplayed());
    }

    @After
    public void destroy() {
	driver.quit();
    }
}