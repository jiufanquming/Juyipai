package com.Mr.Wang.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class role_Test {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://p.moonpool.com.cn:8080/");
        driver.manage().window().maximize();
        driver.findElement(By.id("userName")).sendKeys("15010685335");
        //输入密码
        driver.findElement(By.id("password")).sendKeys("123456");
        //点击登录按钮
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        //获取剧组名称
        String text = driver.findElement(By.id("crewName")).getText();
        WebElement ps = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ps).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"secondMenu\"]/ul[1]/li[2]/div")).click();
        Thread.sleep(2000);
        String text2 = driver.findElement(By.id("operateMenuInfo")).getText();
        Assert.assertEquals(text2,"拍摄 \\ 角色表");
        Assert.assertEquals(text, "《大闹天竺》");

    }

    //高级查询-主要演员
    @Test
    public void moreserchTest() throws InterruptedException {
        //点击高级查询
        driver.findElement(By.className("advance-search-btn")).click();
        Thread.sleep(1000);
        //定位到演员类型选择框
        WebElement element = driver.findElement(By.id("queryViewRoleType"));
        element.click();
        //实例化Select类
        Select select = new Select(element);
        //调用select方法通过indexx选择主要演员
        select.selectByIndex(1);
        Thread.sleep(2000);
        //点击确定
        driver.findElement(By.xpath("//*[@id=\"advanceSearchWin\"]/div/div/button[1]")).click();
        Thread.sleep(3000);
        //获取筛选出的演员类型
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='viewRoleListGrid']/tbody/tr/td[4]/div"));
        for (int i=0;i<list.size();i++){
            String text = list.get(i).getText();
            Assert.assertEquals(text,"主要演员");
        }




    }

    //添加角色
    @Test
    public void addroleTest() throws InterruptedException {
        driver.findElement(By.id("createRoleBtn")).click();
        driver.findElement(By.id("modifyViewRoleName")).sendKeys("周树人");
        WebElement element = driver.findElement(By.id("modifyViewRoleType"));
        element.click();
        Select select = new Select(element);
        select.selectByValue("1");
        driver.findElement(By.id("saveModifyRole")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.linkText("周树人")).getText();
        Assert.assertEquals(text,"周树人");

    }

    //设置角色类型
    @Test
    public void SetRoleType_Test(){
        driver.findElement(By.xpath("//*[@id=\"viewRoleListGrid\"]/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"setViewRoleType\"]/button")).click();
        driver.findElement(By.linkText("特约演员")).click();
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}