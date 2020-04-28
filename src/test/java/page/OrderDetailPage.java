package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderDetailPage extends BasePage {
    public static String expectingOrderName, actualOrderName;

    public void gotoOderDetail() {
        //Detayına gidilmek istenen ürünün sayısı girilir.
        int chooseOrderNumber = 8;
        //Ürünün bilgisi alınır.
        WebElement chooseOrder = findByElement(By.xpath("//*[@product-index=\"" + chooseOrderNumber + "\"]/a"));
        //Listedeki ürünün başlığı alınır.
        expectingOrderName = chooseOrder.getAttribute("title");
        waitSeconds(4);
        //Ürüne tıklanır.
        isDisplayedElement(chooseOrder);
        waitSeconds(4);
        //Ürün bilgisi kontrol edilir.
        checkTrueOrder();
    }

    public void checkTrueOrder() {
        waitSeconds(3);
        //Bulunduğu sayfadaki ürünü bulur.
        WebElement orderDetail = findByElement(By.id("sp-title"));
        //Bulunduğu sayfadaki ürünün başlığını alır.
        actualOrderName = orderDetail.getText();
        //Doğru ürünün detayında mı kontrol edilir.
        logMessage(actualOrderName);
        checkTrue(expectingOrderName, actualOrderName);
    }

    public void addToBasket() {
        List<WebElement> option = findByElements(By.xpath("//*[@id=\"sp-spec-options\"]/div/div/ul/li"));
        WebElement addBasket = findByElement(By.id("add-to-basket"));
        WebElement selectedOption = null;
        if(!option.isEmpty()){
            selectedOption = option.get(0);
            scrollPage(selectedOption);
            isDisplayedElement(selectedOption);
        }
        waitSeconds(2);
        isDisplayedElement(addBasket);
        waitSeconds(2);
    }

}
