package com.Mr.Wang.day02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class winhandle_Test {

       WebDriver driver;
    @BeforeMethod
    public void openbrowsers(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //打开测试页面
        driver.get("file:///D:/selenium_html/index.html");
    }

    @Test
    public void windowsSelectTest(){
        driver.findElement(By.linkText("Open new window")).click();

        String handle1 = driver.getWindowHandle();

        for(String handles:driver.getWindowHandles()){
            if (handles.equals(handle1))
                continue;
            else
                driver.switchTo().window(handles);
        }

        driver.findElement(By.linkText("baidu")).click();

    }

    @AfterMethod
    public void closebrowser(){
        driver.quit();
    }

}
