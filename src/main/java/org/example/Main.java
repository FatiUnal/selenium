package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        for (String str: getAcente("15505")){
            System.out.println(str);
        }
    }

    public static List<String> getAcente(String acenteNo) {

        if (!acenteNo.matches("\\d+")&& acenteNo.length()>6)
            throw new RuntimeException("Geçersiz data");

        List<String> elemanlar = new ArrayList<>();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fatih\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Web sayfasını aç
            driver.get("https://online.tursab.org.tr/publicpages/embedded/agencysearch/");


            // Form elemanlarını bul ve değerleri gir
            WebElement acentaAdi = driver.findElement(By.name("ctl00$ContentPlaceHolder1$TursabNo$AutoCompleteTextBox"));
            acentaAdi.sendKeys("Acenta Adı");


            WebElement belgeNo = driver.findElement(By.name("ctl00$ContentPlaceHolder1$TursabNoText"));
            belgeNo.sendKeys(acenteNo);

            // Formu gönder
            WebElement submitButton = driver.findElement(By.id("ContentPlaceHolder1_SearchButton")); // submit butonunun ID'sini buraya koyun
            submitButton.click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Yanıtı al (örneğin, formun gönderildiği sayfayı kontrol et)
            String pageSource = driver.getPageSource();
            System.out.println(pageSource);


            Document doc = Jsoup.parse(pageSource);
            Element panelDiv = doc.select("div.w3-panel").first();

            // Tüm "w3-row" sınıfına sahip div'leri seç
            Elements rows = doc.select("div.w3-row");

            // Her bir row içerisindeki "w3-col" div'lerini işleyin
            for (Element row : rows) {

                // İçindeki "litc" sınıfına sahip div'leri seç
                Elements litcDivs = row.select("div.litc");

                // Her bir "litc" div'inin içeriğini yazdır
                for (int i = 0; i < litcDivs.size(); i++) {
                    Element litcDiv = litcDivs.get(i);
                    String content = litcDiv.text().trim();
                    elemanlar.add(content);
                }

                // İçindeki "lit2" sınıfına sahip div'leri seç
                Elements lit2Divs = row.select("div.lit2");

                // Her bir "lit2" div'inin içeriğini yazdır
                for (int i = 0; i < lit2Divs.size(); i++) {
                    Element lit2Div = lit2Divs.get(i);
                    String content = lit2Div.text().trim();
                    elemanlar.add(content);
                }
            }

            if (elemanlar.size() == 0){
                elemanlar.add("Arama kriterlerinize uygun sonuç bulunamamıştır!");
            }
        } finally {
            driver.quit();
        }
        return elemanlar;
    }

}

