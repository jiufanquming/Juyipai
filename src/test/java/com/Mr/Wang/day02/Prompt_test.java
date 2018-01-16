package com.Mr.Wang.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Prompt_test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///D:/selenium_html/index.html");

    }

    /**
     * 打开测试界面
     * 点击prompt提示框
     * 输入框输入内容：这个是Prompt
     * 点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException {

        WebElement prompt = driver.findElement(By.xpath("//*[@id=\"prompt\"]/input"));
        prompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这是个Prompt");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(1000);
        alert.accept();


    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
