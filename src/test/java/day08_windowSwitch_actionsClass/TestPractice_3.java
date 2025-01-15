package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class TestPractice_3 extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkWindowWhd = driver.getWindowHandle();

        // 2- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        // 3- Alert'te cikan yazinin "You selected a context menu" oldugunu test edin.
        String expectedAllertYazi = "You selected a context menu";
        String actualAllertYazi = driver
                .switchTo()
                .alert()
                .getText();
        Assertions.assertEquals(expectedAllertYazi, actualAllertYazi, "Allert icerik testi FAILED");

        // 4- Tamam diyerek alert'i kapatalim
        driver
                .switchTo()
                .alert()
                .accept();

        // 5- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']"))
                .click();
        // acilan yeni window'a gec

        String ikinciWindowWhd = "";
        Set<String> acikButunWindowlarinWhd = driver.getWindowHandles();

        for (String each : acikButunWindowlarinWhd) {

            if (!each.equals(ilkWindowWhd)) {
                ikinciWindowWhd = each;
            }
        }
        driver.switchTo().window(ikinciWindowWhd);

        // 6- Acilan sayfada h1 taginda "Make sure your code lands" yazdigini test edelim
        WebElement h1TagiElementi = driver.findElement(By.className("hero__title"));
        String expectedH1TagiIcerik = "Make sure your code lands";
        String actualH1TagiIcerik = h1TagiElementi.getText();


        Assertions.assertEquals(expectedH1TagiIcerik, actualH1TagiIcerik, "h1 taginda icerik eslesmiyor test FAILED");

        ReusableMethods.bekle(2);
    }
}
