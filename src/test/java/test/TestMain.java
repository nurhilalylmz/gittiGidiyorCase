package test;

import base.BaseTest;
import org.junit.Test;
import page.BasketPage;
import page.LoginPage;
import page.MainPage;
import page.OrderDetailPage;

import java.awt.*;

public class TestMain extends BaseTest{

    MainPage mainPage;
    LoginPage loginPage;
    OrderDetailPage detailPage;
    BasketPage basketPage;
    @Test
    public void MainTest() throws InterruptedException, AWTException {
        mainPage=new MainPage();
        loginPage=new LoginPage();
        detailPage=new OrderDetailPage();
        basketPage=new BasketPage();

        mainPage.pageMain();
        loginPage.openLoginPage();
        loginPage.login();
        mainPage.selectCategory();
        detailPage.gotoOderDetail();
        detailPage.addToBasket();
        basketPage.gotoBasket();

    }

}
