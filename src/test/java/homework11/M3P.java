package homework11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class M3P extends TestBase {

    @Test
    public void test01(){

//1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String handle1=driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        WebElement loginButtonu=driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        loginButtonu.click();
        //4.Diger window'a gecin
        Set<String> handles=driver.getWindowHandles();
        String handle2="";
        for (String w: handles
             ) {
            if (w!=handle1){
                handle2=w;
            }
        }
        driver.switchTo().window(handle2);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement usernameBox=driver.findElement(By.id("text"));
        usernameBox.sendKeys("oguzhan");
        WebElement passwordBox=driver.findElement(By.id("password"));
        passwordBox.sendKeys("yucedag");
        //6."login" butonuna basin
        WebElement loginButton=driver.findElement(By.xpath("//button[@id='login-button']"));
        loginButton.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualYazi=driver.switchTo().alert().getText();
        String expectedYazi="validation failed";
        Assert.assertTrue(actualYazi.contains(expectedYazi));

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(handle1);

        //10.Ilk sayfaya donuldugunu test edin

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="webdriveruniversity";
        Assert.assertTrue(actualUrl.contains(expectedUrl));



    }




}
