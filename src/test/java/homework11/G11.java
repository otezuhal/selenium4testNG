package homework11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class G11 extends TestBase {
    ///*
    //      go to url :http://demo.guru99.com/popup.php
    //      get the first window
    //      clicking on click here button
    //      get all the window in the set
    //      switch to window
    //      input email id (somepne@gmail.com) and type something in that input
    //      Clicking on the submit button
    //      verify title as expected
    //      switch to first window
    //     */

    @Test
    public void test01() {
        driver.get("http://demo.guru99.com/popup.php");
        String handle1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> handles = driver.getWindowHandles();
        String handle2="";

        for (String w : handles
             ) {
            if (w!=handle1)
            {
                handle2=w;
            }
        }
      driver.switchTo().window(handle2);
        System.out.println(handles);

    }


}
