package com.Mr.Wang.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class operateelement {
    WebDriver driver;

    @BeforeMethod
    public void openbrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");


    }

    @Test
    public void gettitle() throws InterruptedException {
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("小土科技有限公司");
        Thread.sleep(3000);
        input.clear();

       /* Thread.sleep(3000);
          String text = input.getText();
        */

       /* WebElement button = driver.findElement(By.id("su"));
          button.click();
          Thread.sleep(3000);
          String title = driver.getTitle();
          Assert.assertEquals(title,"小土科技有限公司_百度搜索");
       */
    }

    @Test
    public void gettext(){
        WebElement text = driver.findElement(By.linkText("新闻"));
        String lintext = text.getText();
        System.out.println(lintext);

    }


    @Test
    public void gettagname(){
        String tagname = driver.findElement(By.id("kw")).getTagName();
        System.out.println(tagname);
        Assert.assertEquals(tagname,"input");

    }


    @Test
    public void getAttribute(){
      String val = driver.findElement(By.id("su")).getAttribute("value");
      Assert.assertEquals(val,"百度一下");

    }

    @Test
    public void isdisplayd(){
      Boolean bl = driver.findElement(By.id("su")).isDisplayed();
      Assert.assertTrue(bl);
    }




    @AfterMethod
    public void closebrowser(){
        driver.quit();

    }
}
