package homework11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class M3 extends TestBase {
    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test01(){
        driver.get("http://webdriveruniversity.com/");
        String handle1=driver.getWindowHandle();
    Actions actions=new Actions(driver);
  //  WebElement ilkElement=driver.findElement(By.xpath("//div[@class='thumbnail']"));

    actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement loginportal=driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        loginportal.click();
        Set<String> handles=driver.getWindowHandles();
String handle2="";
        for (String w: handles) {
            if (w!=handle1)
            {
               handle2=w;
            }
        }
        driver.switchTo().window(handle2);
WebElement username=driver.findElement(By.xpath("//input[@id='text']"));

WebElement password=driver.findElement(By.id("password"));
WebElement loginButtonu=driver.findElement(By.id("login-button"));
loginButtonu.click();
String actualText=driver.switchTo().alert().getText();
String expectedText="validation failed";
        Assert.assertTrue(actualText.contains(expectedText));
        driver.switchTo().alert().accept();

        driver.switchTo().window(handle1);
String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);
String expectedUrl="webdriveruniversity";
Assert.assertTrue(actualUrl.contains(expectedUrl));


    }

}
