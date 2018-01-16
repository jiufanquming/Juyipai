package com.Mr.Wang.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendKey_Test {
    WebDriver driver;
     @BeforeMethod
     public void OpenBrowserTest(){
         System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
     }

     @Test
    public void sendTest(){
         driver.get("file:///D:/selenium_html/index.html");
         driver.findElement(By.id("load")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg");

     }

     @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

     }

}
