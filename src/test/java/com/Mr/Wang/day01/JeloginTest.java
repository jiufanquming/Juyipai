package com.Mr.Wang.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JeloginTest {
    WebDriver driver;

    @Test
    public void login() throws InterruptedException {


        //打开chrome浏览器
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        //实例化
        driver = new ChromeDriver();
        //打开剧易拍网址
        driver.get("http://p.moonpool.com.cn:8080/");
        //等待3s
        Thread.sleep(3000);
        //后退
        driver.navigate().back();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();

    }


    @Test
    public void windows() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        //实例化chromedriver
        driver = new ChromeDriver();
        //打开剧易拍网址
        driver.get("http://p.moonpool.com.cn:8080/");
        //设置窗口最大化
        driver.manage().window().maximize();
        //等待3s
        Thread.sleep(3000);
        //返回
        Thread.sleep(2000);
        //前进
        driver.navigate().forward();
        Thread.sleep(2000);
        //刷新
        driver.navigate().refresh();
        Thread.sleep(2000);
        //关闭浏览器
        driver.quit();
    }

    @Test
    public void dimclass() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        //实例化chromedriver
        driver = new ChromeDriver();
        //打开剧易拍网址
        driver.get("http://p.moonpool.com.cn:8080/");
        //实例化Dimension,设置窗口大小
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //最大化窗口
        driver.manage().window().maximize();
        //获取当前url
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //校验url预期和实际是否相等
        //Assert.assertEquals("获得的url是"+url,"");
        //关闭浏览器
        driver.quit();

    }

}
