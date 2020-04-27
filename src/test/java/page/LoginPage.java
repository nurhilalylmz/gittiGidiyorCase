package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {
    String email = "testhilaltest@gmail.com";
    String password = "testhilal34";
    String username = "hilalyilmaz261558";
    String actualTitle;

    public void openLoginPage() {
        WebElement wrapperClick = findByElement(By.className("afterLoginURL"));
        WebElement buttonClick = findByElement(By.xpath("//*[@id=\"SignIn\"]"));

        if (wrapperClick.isEnabled()) {
            mouseOn(wrapperClick);
            waitSeconds(4);
            buttonClick.click();
            logMessage(buttonClick.getText()+" butonuna tıklandı.");
            waitSeconds(6);
        }
    }

    public void login() {
        loginInfo();
        waitSeconds(4);
        checkTrueUser();
    }

    public void checkTrueUser() {
        String actualUsername = findByElement(By.className("profile-name")).getText();
        checkTrue(username, actualUsername);
    }

    public void loginInfo() {
        sendKeyElement(By.id("L-UserNameField"), email);
        waitSeconds(2);
        sendKeyElement(By.id("L-PasswordField"), password);
        waitSeconds(2);
        WebElement buttonLogin=findByElement(By.id("gg-login-enter"));
        clickJavaScript(buttonLogin);
        waitSeconds(2);
    }

}
