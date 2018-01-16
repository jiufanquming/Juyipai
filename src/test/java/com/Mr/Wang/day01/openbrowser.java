package com.Mr.Wang.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class openbrowser {
      WebDriver driver;
    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

   @AfterMethod
    public void close(){
        driver.quit();
    }



   @Test
    public void openFF(){
       driver = new FirefoxDriver();

    }
}
