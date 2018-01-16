package com.Mr.Wang.day03;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class grid_Test {

    @Test
    public void openGridTest() throws MalformedURLException, InterruptedException {
        //创建一个DC类
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //  通过grid分发脚本
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"),dc);
        //  打开剧易拍网址
        driver.get("http://p.moonpool.com.cn:8080/");
        // 等待3s
        Thread.sleep(3000);
        // 关闭浏览器
        driver.quit();
    }

    //同一个脚本在不同浏览器运行（用到数据驱动）
    @DataProvider(name="bro")
    public Object[][] Test(){
        return new Object[][]{
                {"chrome","http://192.168.1.100:7777"},
                {"firefox","http://192.168.1.100:5555"}
        };
    }

    @Test(dataProvider = "bro")
    public void grid_Test(String browser,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else if (browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else {
            System.out.println("Error");
        }
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        driver.get("http://p.moonpool.com.cn:8080/");
        Thread.sleep(3000);
        driver.quit();
    }


}