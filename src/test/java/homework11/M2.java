package homework11;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class M2 extends TestBase {

    @Test
    public void test01(){
    //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
    //2.“Our Products” butonuna basin
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
    //3.“Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[@class='sub-heading']")).click();
    //4.Popup mesajini yazdirin
        System.out.println(driver.findElement(By.xpath("//h4[@class='modal-title']")));
        //5.“close” butonuna basin
        //button[.='Close']
        driver.findElement(By.xpath("//button[.='Close']")).click();
    //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
}
}
