package com.fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    public static WebElement signinPageHeader(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"single-signin__body\"]/div/div[1]/div/div/div/p"));
    }

    public static WebElement emailAddressField(WebDriver driver) {
	return driver.findElement(By.id("username"));
    }

//    public static WebElement continueButton(WebDriver driver) {
//	return driver.findElement(By.id("sign-in-button"));
//    }
    public static WebElement continueButton(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"sign-in-button\"]"));
    }

    public static WebElement enterPasswordField(WebDriver driver) {
	return driver.findElement(By.id("password-input-field"));
    }

    public static WebElement signInButton(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"single-signin__body\"]/div/div[2]/form/button[1]"));
    }
}