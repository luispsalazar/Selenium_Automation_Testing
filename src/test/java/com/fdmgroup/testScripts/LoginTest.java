package com.fdmgroup.testScripts;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fdmgroup.data.DataFile;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.SignInPage;
import com.fdmgroup.pages.UserIndexPage;
import com.fdmgroup.util.DriverUtilities;

public class LoginTest {
    private DriverUtilities driverUtilities;
    private WebDriver driver;

    @Before
    public void setUp() {
	driverUtilities = DriverUtilities.getInstante();
	driver = driverUtilities.getDriver();
    }

    @Test
    public void testLoginFunctionality() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(DataFile.homeURL);

	System.out.println("Number of Father's Day Savings: " + HomePage.ListOfFathersDaySavings(driver).size());

	for (WebElement element : HomePage.ListOfFathersDaySavings(driver)) {
	    System.out.println(element.getText());
	}

	if (HomePage.LogInButton(driver).isDisplayed()) {
	    HomePage.LogInButton(driver).click();
	}
	// It was not launching so had to insert a wait period!!!
	Thread.sleep(500);

	HomePage.SignInButton(driver).click();
	assertEquals(DataFile.signin, SignInPage.signinPageHeader(driver).getText());

	SignInPage.emailAddressField(driver).sendKeys(DataFile.emailAddress);
	SignInPage.continueButton(driver).click();
	SignInPage.enterPasswordField(driver).sendKeys(DataFile.password);
	SignInPage.signInButton(driver).click();

	assertEquals(DataFile.name, UserIndexPage.loggedInUser(driver).getText());
    }
}