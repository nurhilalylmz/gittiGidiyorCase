package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderDetailPage extends BasePage {
    public static String expectingOrderName,actualOrderName;
    public void gotoOderDetail(){
        //Detayına gidilmek istenen ürünün sayısı girilir.
        int chooseOrderNumber=8;
        //Ürünün bilgisi alınır.
        WebElement chooseOrder=findByElement(By.xpath("//*[@product-index=\""+chooseOrderNumber+"\"]/a"));
        //Listedeki ürünün başlığı alınır.
        expectingOrderName=chooseOrder.getAttribute("title");
        waitSeconds(4);
        //Ürüne tıklanır.
        chooseOrder.click();
        logMessage(chooseOrder.getText()+ "ürününe tıklandı.");
        waitSeconds(4);
        //Ürün bilgisi kontrol edilir.
        checkTrueOrder();
    }
    public void checkTrueOrder() {
        waitSeconds(3);
        //Bulunduğu sayfadaki ürünü bulur.
        WebElement orderDetail=findByElement(By.id("sp-title"));
        //Bulunduğu sayfadaki ürünün başlığını alır.
        actualOrderName=orderDetail.getText();
        //Doğru ürünün detayında mı kontrol edilir.
        checkTrue(expectingOrderName,actualOrderName);
    }
    public void addToBasket(){
        WebElement addBasket=findByElement(By.id("add-to-basket"));
        scrollPage(addBasket);
        mouseClick(addBasket);
    }

}
