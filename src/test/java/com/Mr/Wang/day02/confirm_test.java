package com.Mr.Wang.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class confirm_test {
    WebDriver driver;
    /**
     * 打开测试页面
     * 点击confirm按钮
     * 点击弹出提示框取消按钮
     * 再次点击提示框确定按钮
     */
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //打开测试页面
        driver.get("file:///D:/selenium_html/index.html");

    }

    @Test
    public void confirtTest() throws InterruptedException {
        WebElement  confirm = driver.findElement(By.xpath("//*[@id=\"confirm\"]/input"));
        confirm.click();
        Thread.sleep(3000);
        //driver控制权转交给Alert,返回值类型为Alert
        Alert alert = driver.switchTo().alert();
        //点击取消
        alert.dismiss();
        Thread.sleep(1000);
        //点击确定
        alert.accept();
        // Alert alert1 = driver.switchTo().alert();

        // alert1.accept();

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
