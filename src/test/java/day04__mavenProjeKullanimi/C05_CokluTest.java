package day04__mavenProjeKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_CokluTest {

    public static void main(String[] args) {

        testOtomasyonuTest();

        // çoklu test yapabilmek için kendi test methodlarimizi yazarak
        // main methodtan istediğimizi test methodlarimzi cagirabiliriz.
        // Bu amaç için kullanılanaa test notasyonu mevcut,
        // Framework'un bize sağladığı bu natosyonlar sayesinde,
        // main methodtanda kurtularak daha cok onlari kullanırız.

    }

    public static void testOtomasyonuTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");

        // sayfayi kapatin
        ReusableMethods.bekle(2);
        driver.quit();

    }
}
