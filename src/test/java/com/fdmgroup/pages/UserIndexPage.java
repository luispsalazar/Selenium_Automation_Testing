package com.fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserIndexPage {

    public static WebElement loggedInUser(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/button[4]/div"));
    }

    public static WebElement logoutLink(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/button[4]/div/p"));
    }
}