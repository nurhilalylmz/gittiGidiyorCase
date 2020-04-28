package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
    String expectingOrderName, actualOrderName;

    public void gotoBasket() {
        try {
            WebElement wrapperBasket = findByElement(By.className("dIB"));
            WebElement gotoBasket=findByElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a"));
            hoverElement(wrapperBasket,gotoBasket);
            waitSeconds(3);
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
