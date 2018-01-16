package com.Mr.Wang;

import JuEpai.com.page.login.loginPO;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_test {
    WebDriver driver;

    @BeforeMethod

    public void OpenBrowserChrome(){
        // 打开谷歌浏览器
         System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
         // 实例化driver
         driver = new ChromeDriver();
         // 打开剧易拍网址
         driver.get("http://p.moonpool.com.cn:8080/");
    }

     // 登录剧易拍
    @Test
    public void logincase(){
        loginPO.login(driver, "15010685335","123456");
    }

    // 关闭浏览器
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
