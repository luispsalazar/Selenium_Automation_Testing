package com.fdmgroup.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static WebElement HomeDepotLink(WebDriver driver) {
	return driver.findElement(By.id("header-thd-logo"));
    }

    public static List<WebElement> ListOfFathersDaySavings(WebDriver driver) {
	return driver.findElements(By.className("sui-tab-base"));
    }

    public static WebElement LogInButton(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/button[4]"));
    }

    public static WebElement SignInButton(WebDriver driver) {
	return driver.findElement(By.xpath("//*[@id=\"header-anchor-drawer\"]/div[2]/div[1]/a[1]"));
    }
}