package JuEpai.com.page.login;

import org.openqa.selenium.WebDriver;


public class loginPO {


    public static void login(WebDriver driver, String username, String pwd){
        driver.findElement(loginpage.usernameInput).sendKeys(username);
        driver.findElement(loginpage.pwdInput).sendKeys(pwd);
        driver.findElement(loginpage.loginButton).click();

    }

    //打开浏览器



}
