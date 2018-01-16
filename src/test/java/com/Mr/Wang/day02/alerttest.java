package com.Mr.Wang.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alerttest {
    WebDriver driver;
    @BeforeMethod
    public void alerttest(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //打开测试页面
        driver.get("file:///D:/selenium_html/index.html");
    }

    @Test
    public void alertcleck() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"alert\"]/input"));
        element.click();
        Thread.sleep(3000);
        // driver将控制权转交给alert，返回类型为Alert类型
        Alert alert = driver.switchTo().alert();
        //点击确定(alert方法）
        alert.accept();

    }



    @AfterMethod
    public void closebrowser(){
        driver.quit();
    }
}


