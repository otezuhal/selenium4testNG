package Practise;


    import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;
    public class TwitterRegister extends TestBase {
        //twitter a faker class kullanarak kayit olmaya calisiniz
        //actions class kullanmayin twitteri deneyen instagram i denesin
        @Test
        public void register() throws InterruptedException {
            Faker faker = new Faker();
            driver.get("https://www.twitter.com");
            WebElement register = driver.findElement(By.xpath("//a[@data-testid='signupButton']"));
            register.click();
            WebElement emailInstead = driver.findElement(By.xpath("//span[.='E-posta kullan']"));
            emailInstead.click();
            WebElement isim = driver.findElement(By.name("name"));
            isim.sendKeys(faker.funnyName().name());
            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys(faker.internet().emailAddress());
            Thread.sleep(2000);
            WebElement dropDown1 = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));  //ay
            WebElement dropDown2 = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));  //gun
            WebElement dropDown3 = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));  //yil
            Select select = new Select(dropDown1);
            select.selectByIndex(faker.number().numberBetween(1,13)); //int number
            Select select1 = new Select(dropDown2);
            select1.selectByIndex(faker.random().nextInt(1, 30));
            Select select2= new Select(dropDown3);
            select2.selectByIndex(faker.random().nextInt(1, 120));
            WebElement nextButton = driver.findElement(By.xpath("//span[text()='İleri']"));
            nextButton.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }
            driver.findElement(By.xpath("//span[text()='İleri']")).click();
            driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();
        }
}
