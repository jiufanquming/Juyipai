package com.Mr.Wang.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementTest {
    WebDriver driver;

    @BeforeMethod
    public void openbrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://p.moonpool.com.cn:8080/");
        driver.manage().window().maximize();
        WebElement uname  = driver.findElement(By.id("userName"));
        uname.sendKeys("15010685335");
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("123456");
        WebElement login = driver.findElement(By.id("submit"));
        login.click();

       /**     hread.sleep(3000);
              List<WebElement> lis = driver.findElements(By.xpath("//*[@id = 'navMenu']/li"));
             for (int i = 0; i < lis.size(); i++) {
              String text = lis.get(0).getText();
              System.out.println(text);
        }*/

    }

    @Test
    public void sendjuben() throws InterruptedException {
        WebElement list1 = driver.findElement(By.xpath("//*[@ id = 'navMenu']/li[1]"));
        list1.click();
        Thread.sleep(2000);


    }

    @AfterMethod
    public void closebrowser(){
         driver.quit();

    }

    }

