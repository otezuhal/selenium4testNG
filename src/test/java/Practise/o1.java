package Practise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class o1 extends TestBase {
    ////          1.soru :Turkce
    //    //web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //    // pencereyi büyüt
    //    // eylem diyalog düğmesine tıklayın
    //    // kullanmanız gerekiyorsa açıkça bekleyin
    //    // tamam butonuna tıklayın
    //    // iframe mesajını kabul et


    @Test
    public void test(){
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='action']")).click();

    }
}
