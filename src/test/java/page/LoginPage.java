package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {
    String email = "";
    String password = "";
    String username = "";
    By emailElement=By.id("L-UserNameField");
    By passElement= By.id("L-PasswordField");

    public void openLoginPage() {
        waitSeconds(2);
        WebElement wrapperClick = findByElement(By.className("afterLoginURL"));
        WebElement buttonClick = findByElement(By.xpath("//*[@id=\"SignIn\"]"));
        hoverElement(wrapperClick,buttonClick);
        waitSeconds(3);
    }

    public void login() {
        try {
            loginInfo();
            waitSeconds(3);
            checkTrueUser();
        }
        catch (Exception ex){
            logMessage(ex.getMessage());
        }

    }

    public void checkTrueUser() {
        String actualUsername = findByElement(By.className("profile-name")).getText();
        checkTrue(username, actualUsername);
    }

    public void loginInfo() {
        waitSeconds(2);
        if(findByElement(emailElement).isEnabled()){
            sendKeyElement(emailElement, email);
            waitSeconds(2);
            sendKeyElement(passElement, password);
            waitSeconds(2);
            WebElement buttonLogin = findByElement(By.id("gg-login-enter"));
            clickJavaScript(buttonLogin);
            waitSeconds(2);
        }
    }

}
