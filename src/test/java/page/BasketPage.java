package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
    String expectingOrderName, actualOrderName;

    public void gotoBasket() {
        try {
            WebElement wrapperBasket = findByElement(By.className("header-cart-hidden-link"));
            WebElement gotoBasket=findByElement(By.xpath("//a[@href=\"https://www.gittigidiyor.com/sepetim\"]"));
            if (wrapperBasket.isDisplayed()) {
//                mouseOn(wrapperBasket);
//                waitSeconds(4);
//                scrollPage(gotoBasket);
                isDisplayedElement(gotoBasket);
                waitSeconds(3);
            }
            checkOrder();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void checkOrder() {
        expectingOrderName = OrderDetailPage.actualOrderName;
        actualOrderName = findByElement(By.xpath("//*[@class=\"product-item-box product  last-item-box selected\"]/div[2]/div[3]/div/a"))
                .getAttribute("title");
        logMessage(actualOrderName);
        checkTrue(expectingOrderName, actualOrderName);
    }
}
