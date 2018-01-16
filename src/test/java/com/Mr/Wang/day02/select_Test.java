package com.Mr.Wang.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class select_Test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void SelectTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("moreSelect"));
        //实例化Select类，
        Select select = new Select(element);
        select.selectByValue("huawei");
        Thread.sleep(2000);
        select.selectByIndex(0);
        Thread.sleep(2000);
        select.selectByVisibleText("vivo");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
