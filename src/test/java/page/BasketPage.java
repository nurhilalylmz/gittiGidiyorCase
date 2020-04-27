package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
    String expectingOrderName,actualOrderName;
    public void gotoBasket() {
        WebElement basket = findByElement(By.className("dIB"));
        mouseClick(basket);
        checkOrder();
    }
    public void checkOrder(){
        expectingOrderName=OrderDetailPage.actualOrderName;
        actualOrderName=findByElement(By.className("title-link")).getAttribute("title");
        checkTrue(expectingOrderName,actualOrderName);

    }
}
