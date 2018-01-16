package com.Mr.Wang.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class moveElement_Test {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //打开测试页面
       // driver.get("file:///D:/selenium_html/dragAndDrop.html");
    }

    @Test
    public void moveElementTest(){
        WebElement element = driver.findElement(By.linkText("设置"));
        //实例化一个Actions类
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


    }

    @Test
    public void xmoveToY(){
        WebElement drag = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drag,500,500).perform();
    }

    @Test
    public void xy_moveto_zw(){
       WebElement element1 = driver.findElement(By.xpath("/html/body/h1"));
       WebElement element2 = driver.findElement(By.id("drag"));
       Actions actions = new Actions(driver);
       actions.clickAndHold(element2)
               .moveToElement(element1)
               .release()
               .perform();

    }

    @Test
    public void moreSelectTest(){
        driver.get("file:///D:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(2))
                .release()
                .perform();

    }

    @Test
    public void ControlS() throws AWTException, InterruptedException {
        driver.get("https://baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);



 }




    @AfterMethod
    public void closeBrowsers() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
