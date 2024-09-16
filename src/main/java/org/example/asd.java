/*package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // ChromeDriver'ı başlat
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fatih\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Web sayfasını aç
            driver.get("https://online.tursab.org.tr/publicpages/embedded/agencysearch/");

            // Acenta Adı alanını bulana kadar bekle
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acentaAdi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TursabNo_AutoCompleteTextBox")));
            acentaAdi.sendKeys("Acenta Adı");

            // Belge No alanını bulana kadar bekle
            WebElement belgeNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TursabNoText")));
            belgeNo.sendKeys("15502");

            // Submit butonunu bulana kadar bekle
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ContentPlaceHolder1_SearchButton")));
            submitButton.click();

            // Yanıtı almak için sayfanın tamamen yüklenmesini bekle
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sonucId"))); // Örnek sonuç elemanının ID'si

            // Sayfanın tamamen yüklendiğinden emin olmak için "document.readyState" kontrolü yapın
            WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            // Sayfanın kaynak kodunu al
            String pageSource = driver.getPageSource();
            System.out.println(pageSource);
        } finally {
            // Tarayıcıyı kapat
            driver.quit();
        }
    }
}*/