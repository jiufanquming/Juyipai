package com.Mr.Wang.day02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClick_Test {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //打开测试页面
        driver.get("https://www.baidu.com/");
    }

    @Test
    public void rightTest(){
        WebElement  element = driver.findElement(By.id("su"));
        //实例化一个Actions类
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();

    }

    @AfterMethod
    public void closeBrowsers() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}