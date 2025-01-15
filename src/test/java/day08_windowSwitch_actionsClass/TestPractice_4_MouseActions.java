package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class TestPractice_4_MouseActions extends TestBaseEach {

    @Test
    public void test01(){
     //1- https://demoqa.com/droppable adresine gidelim
    driver.get("https://demoqa.com/droppable ");

    Actions actions = new Actions(driver);

    //actions.sendKeys(Keys.PAGE_DOWN).perform();
        // gerek olması halinde sayfayı asagiya kaydirir

    ReusableMethods.bekle(2);



    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

    WebElement dragMeButtonElementi = driver.findElement(By.id("draggable"));
    WebElement dropHereBoxElementi = driver.findElement(By.id("droppable"));

    actions.dragAndDrop(dragMeButtonElementi,dropHereBoxElementi).perform();

    ReusableMethods.bekle(2);

    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    String expectedYazi = "Dropped!";
    String actualYazi= driver.findElement(By.id("droppable"))
                .getText();

    Assertions.assertEquals(expectedYazi,actualYazi);
    ReusableMethods.bekle(2);

    }
}
