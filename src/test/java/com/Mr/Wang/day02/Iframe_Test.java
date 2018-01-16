package com.Mr.Wang.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe_Test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///D:/selenium_html/index.html");
    }

    @Test
    public void iframeTest() throws InterruptedException {

        // 通过element方式，转交控制权给Iframe，
        WebElement element = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.linkText("baidu")).click();
        // 将控制权由Iframe转回
        driver.switchTo().defaultContent();
        // 获取文本
        String text = driver.findElement(By.linkText("登陆界面")).getText();
        System.out.println(text);
        // 校验
        Assert.assertEquals(text,"登陆界面");

        /**
         *
         * Thread.sleep(2000);
           String text = driver.findElement(By.linkText("新闻")).getText();
           Assert.assertEquals(text,"新闻");
         */


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
