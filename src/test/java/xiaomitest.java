
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by DT167 on 2018/4/12.
 */
public class xiaomitest {
    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "F:\\开源\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //进入首页
        driver.get("https://www.mi.com/?client_id=180100041086&masid=17489.0001&kwd=%E5%B0%8F%E7%B1%B3%E5%95%86%E5%9F%8E");
        WebElement login = driver.findElement(new By.ById("J_userInfo")).findElement(new By.ByClassName("link"));
        login.click();
        //进入登录页面
        WebElement loginAccount = driver.findElement(new By.ById("username"));
        loginAccount.sendKeys("18717763297");
        WebElement loginPassword = driver.findElement(new By.ById("pwd"));
        loginPassword.sendKeys("bing52013");
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        loginButton.click();
        //登录成功之后，跳转购买页面
        driver.get("https://item.mi.com/product/10000085.html");
        WebElement select = driver.findElement(new By.ById("J_list"));
        List<WebElement> buttons = select.findElements(By.tagName("a"));
        try{
            for(WebElement webElement: buttons) {
                String text = webElement.getText();
                System.out.println(text);
                if(text!=null &&text.contains("64GB")) {
                    System.out.println("选择大小");
                    webElement.click();
                    break;
                }
            }
            buttons = select.findElements(By.tagName("a"));
            for(WebElement webElement: buttons) {
                String text = webElement.getText();
                System.out.println(text);
                if(text!=null &&text.contains("黑色")) {
                    System.out.println("选择颜色");
                    webElement.click();
                    break;
                }
            }
            WebElement element = driver.findElement(By.id("J_buyBtnBox"));
            while(true){
                element.click();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       }
}
