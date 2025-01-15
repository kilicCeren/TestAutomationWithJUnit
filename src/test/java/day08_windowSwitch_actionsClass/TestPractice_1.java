package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class TestPractice_1 extends TestBaseEach {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkWindowWhd = driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());

        //● Sayfadaki textin "Add/Remove Elements" olduğunu doğrulayın.
        WebElement textElement =  driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = textElement.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        //● Sayfa başlığının(title) "Test Otomasyonu" olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actaulTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actaulTitle);


        //● 'Please click for Electronics Products' linkine tiklayin.
        driver.findElement(By.xpath("(//*[@class='has-sub'])[1]"))
                .click();
        //● Electronics sayfasinin acildigini test edin
        String ikinciWindowWhd = "";
        Set<String> tumWindowWHd = driver.getWindowHandles();
        for (String eachWhd : tumWindowWHd) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }
        System.out.println(driver.getCurrentUrl());


        driver.switchTo().window(ikinciWindowWhd);

        System.out.println(driver.getCurrentUrl());

        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

        System.out.println(driver.getCurrentUrl());

        ReusableMethods.bekle(1);

        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement urunSayisiElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String urunSayisiElementiText = urunSayisiElementi.getText(); // 16 Products Found
        urunSayisiElementiText = urunSayisiElementiText.replaceAll("\\D", ""); // 16
        int actualSayi = Integer.parseInt(urunSayisiElementiText); // int 16
        int expectedSayi = 16;
        Assertions.assertEquals(expectedSayi, actualSayi);

        System.out.println(driver.getCurrentUrl());

        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkWindowWhd);
        ReusableMethods.bekle(5);

        System.out.println(driver.getCurrentUrl());

        //● Url'in addremove icerdigini test edin
        System.out.println(driver.getCurrentUrl());
        expectedUrl="addremove";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));


    }
}
