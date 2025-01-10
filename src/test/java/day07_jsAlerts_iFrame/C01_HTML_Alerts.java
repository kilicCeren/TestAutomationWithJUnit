package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_HTML_Alerts extends TestBaseEach {

    @Test
    public void test01(){

        // google anasayfaya gidin
        driver.get("https://www.google.com");

        ReusableMethods.bekle(1);

        // cookies kabul edin

        driver.findElement(By.xpath("//div[text()='Accept all']"))
                .click();
        //Cookies Allert cikmamasi halinde Test FAILED

        ReusableMethods.bekle(5);

    }

}
