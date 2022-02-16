package homework11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SH12 extends TestBase {
    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
// 7.Checkout'a tıklayın


    @Test
    public void test01(){
       driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
       List<WebElement> liste=driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        System.out.println("sitede " + liste.size() +" urun var ");
       for (int i=0; i< liste.size(); i++)
       {
           System.out.println( i+1 + ".urun : " + liste.get(i).getText());
       }
       List<String> listeStr=new ArrayList<>();
       for (int i=0; i<liste.size(); i++)
       {
           listeStr.add(liste.get(i).getText());

       }
        System.out.println(listeStr);
       List<WebElement> sepeteeklelist=driver.findElements(By.xpath("//div[@class='shelf-item__buy-btn']"));
       List<String> sepetList=new ArrayList<>();
       Random rdm=new Random();
        int upperbound = sepeteeklelist.size();
        int sayac=0;
     do {
         int int_random = rdm.nextInt(upperbound);
          if (!sepetList.contains(listeStr.get(int_random))){
              sayac++;
              System.out.println(sepetList.add(listeStr.get(int_random)));

          }
     }while(sayac==5);
        int toplam=0;
     List<WebElement> fiyatListesi=driver.findElements(By.xpath("//div[@class='val']"));
        for (WebElement w: fiyatListesi
             ) {
            String ucret=w.getText();
            String fiyat= ucret.replaceAll("$","");
            System.out.println(fiyat);
        }
        


    }




}
