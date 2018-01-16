package com.Mr.Wang.day03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login_Test {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_demo1701\\drivers\\chromedriver.exe");
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
        String text  =  driver.findElement(By.id("crewName")).getText();
        WebElement ps = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ps).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"secondMenu\"]/ul[1]/li[1]/div")).click();
        String text1 = driver.findElement(By.id("operateMenuInfo")).getText();
        System.out.println(text);
        //校验登录是否成功
        Assert.assertEquals(text,"《大闹天竺》");
        Assert.assertEquals(text1,"拍摄 \\ 剧本分析");
        //Thread.sleep(3000);
    }
    // 上传剧本
   // @Test
    public void sendkey_juben_Test() throws InterruptedException {
        driver.findElement(By.id("uploadScriptBtn")).click();
        driver.switchTo().frame("uploadIframe");
        driver.findElement(By.xpath("//*[@id=\"firstWindow\"]/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"thirdWindow\"]/div[3]/button[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("//*[@name=\"file\"]/label"))
                  .sendKeys("C:\\Users\\Administrator\\Desktop\\《大闹天竺》第11集剧本.docx");

        driver.findElement(By.id("uploadBtn")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"fivethWindow\"]/div[3]/button[2]")).click();

    }

    //角色智能提取

   // @Test
    public void roleTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"aiAnalysisBtn\"]/button")).click();
        driver.findElement(By.linkText("服化道提取")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"confirm\"]")).click();

    }

     //剧本导出
  //  @Test
    public void exportTest(){
        driver.findElement(By.id("exportScriptBtn")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"exportScenarioDiv\"]/div[1]/input[1]"));
        Boolean bl = element.isSelected();
        driver.findElement(By.id("exportBtn")).click();
        Assert.assertTrue(bl);

    }

    //批量删除
   @Test
    public void deleteTest(){
        driver.findElement(By.id("repeatDeleteBtn")).click();
        driver.findElement(By.xpath("//*[@id=\"viewNoDiv\"]/table/tbody/tr[4]/td/label/span")).click();
        driver.findElement(By.id("delViewBtn")).click();
        driver.findElement(By.className("confirm")).click();

    }

   //添加广告
    @Test
    public void add() {
        WebElement element = driver.findElement(By.id("f_scene_create"));
        driver.switchTo().frame(element);
        driver.findElement(By.id("addAdvertTitle")).click();
        driver.findElement(By.id("advertName")).sendKeys("宝马");
        driver.findElement(By.id("advertAddBtn")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"advertInfoTable\"]/tr[2]/td[1]/input")).getAttribute("value");
        Assert.assertEquals(text, "宝马");

    }

    //删除广告
    @Test
    public void delete() throws InterruptedException {
        WebElement element = driver.findElement(By.id("f_scene_create"));
        driver.switchTo().frame(element);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"advertInfoTable\"]/tr[2]/td[3]/div")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);


    }


    @AfterMethod
    public void closeChrome() throws InterruptedException {
        driver.quit();
    }

}
