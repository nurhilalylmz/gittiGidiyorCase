package page;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static base.BaseTest.*;

public class MainPage extends BasePage {

    String[] headerExpectingElements= new String[]{"Elektronik",
            "Ev, Bahçe ve Ofis",
            "Moda",
            "Kozmetik, Kişisel Bakım",
            "Bebek, Anne",
            "Süpermarket",
            "Kitap, Müzik, Oyuncak, Hobi",
            "Otomobil, Motosiklet",
            "Spor, Outdoor"};
    String expectingCategoryText,actualSelectedCategoryText;

    public void goToMainPage() {
        WebElement logo = findByElement(By.name("//*[@id=\"container\"]/div[3]/div/div[2]/div[3]/h3"));
        //openMainPage(logo);
    }
    public void pageMain(){
        //URL kontrol edilir.
        controlURL(driver.getCurrentUrl());
        //Menü elementleri alınır.
        List<WebElement> headerActualElements = findByElements(By.xpath(".//*[@class='hidden-m hidden-t horizontal-menu robot-header-horizontalMenu-container gg-d-24 gg-w-24']/div"));
        //Menü elementleri doğru gelmiş mi kontrol edilir.
        controlHeaderElements(headerExpectingElements,headerActualElements);
    }
    public void selectCategory(){
        //Main Category
        WebElement categoryMain = findByElement(By.xpath("//*[text()='Elektronik']"));
        //Sub Category
        WebElement categoryVideo = findByElement(By.xpath("//*[@id=\"header_wrapper\"]/div[6]/div[1]/div/div[3]/div[4]/h3/a"));
        //Beklenen kategori ismi
        expectingCategoryText=categoryVideo.getAttribute("title");
        //Pop-up close button
        WebElement popupClose= findByElement(By.xpath("//*[@class='mfp-close wis-mfp-close-27556']"));
        //Kategori seçilir.
        choiceCetagory(categoryMain,categoryVideo,popupClose);
        actualSelectedCategoryText=findByElement(By.xpath("//*[@id=\"search-result-info\"]/div[1]/div/div/h1/span")).getText();
        checkTrue(expectingCategoryText,actualSelectedCategoryText);
    }

    public void choiceCetagory(WebElement categoryMain, WebElement categoryVideo, WebElement popupCloseElement) {
        waitSeconds(2);
        outClickPopup(popupCloseElement);
        waitSeconds(2);
        scrollPage(categoryMain);
        waitSeconds(3);
        mouseOn(categoryMain);
        waitSeconds(4);
        categoryVideo.click();
        waitSeconds(10);
    }
    public void outClickPopup(WebElement popupCloseElement) {
            waitSeconds(4);
            mouseClick(popupCloseElement);
    }
}
