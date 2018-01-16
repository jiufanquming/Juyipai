package com.Mr.Wang.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register_Test {



    WebDriver driver;




    @BeforeMethod
    public void OpenBrowser() throws InterruptedException {
        // 通过谷歌浏览器打开
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        // 通过火狐浏览器打开
        // driver = new FirefoxDriver();
        driver.get("http://mail.163.com/");
        Thread.sleep(2000);
    }
//    163邮箱注册

    @Test
    public void Resiger_Test() throws InterruptedException {
        //转交控制权给iframe
        driver.switchTo().frame("x-URS-iframe");
        //定位并点击注册按钮
        driver.findElement(By.id("changepage")).click();
        //句柄值选择
        String handle1 = driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }

        String time = String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("nameIpt")).sendKeys("enjon"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("w12345678");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("w12345678");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("000000");
        driver.findElement(By.id("mainRegA")).click();

        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"m_mainAcode\"]/span")));

        String text = driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
        Assert.assertEquals(text,"  手机验证码不正确，请重新填写");




    }

    // 登录163邮箱
    @Test
    public void login_Test(){

        //driver转交控制权
        driver.switchTo().frame("x-URS-iframe");
        //输入用户名
        driver.findElement(By.name("email")).sendKeys("15010685335");
        //  输入密码
        driver.findElement(By.name("password")).sendKeys("wj123456");
        //  点击登录按钮
        driver.findElement(By.id("dologin")).click();
        //  增加显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("退出")));
        //  获取退出文本并效验
        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");

    }




    //  发送邮件
    @Test
    public void sendEamil() throws InterruptedException {
        //driver转交控制权
        driver.switchTo().frame("x-URS-iframe");
        //输入用户名
        driver.findElement(By.name("email")).sendKeys("15010685335");
        //  输入密码
        driver.findElement(By.name("password")).sendKeys("wj123456");
        //  点击登录按钮
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(3000);
        // 点击写信
        driver.findElement(By.xpath("//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        // 添加收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("15010685335@163.com");
        // 添加主题
       // driver.findElement(By.className("nui-ipt-input")).sendKeys("请假申请");
        Thread.sleep(3000);
        // 添加附件
        driver.findElement(By.xpath("//*[@title='点击添加附件']/input")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\\\yujinx.jpg");
        Thread.sleep(5000);
        // 转交driver控制权
        WebElement element = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(element);
        // 添加内容
        driver.findElement(By.xpath("/html/body")).sendKeys("世界那么大，我想去看看");
        // 控制权转回页面
        driver.switchTo().defaultContent();
        // 点击发送
        driver.findElement(By.xpath("//*[text()='发送']")).click();

    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
