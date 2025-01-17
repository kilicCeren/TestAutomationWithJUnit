package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_DosyaIndirmeTesti extends TestBaseEach{
    @Test
    public void test01(){
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //2. download.png dosyasını indirelim //luminoslogo.png

        driver.findElement(By.xpath("//*[.='luminoslogo.png']"))
                .click();
        ReusableMethods.bekle(2);

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dinamikDosyaYolu = System.getProperty("user.home")+ "/Downloads/luminoslogo.png";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }

}
