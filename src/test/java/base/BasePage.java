package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {
    protected static WebDriver driver = BaseTest.driver;
    protected JavascriptExecutor jse = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);

    protected WebElement findByElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> findByElements(By by) {
        return driver.findElements(by);
    }

    protected void logMessage(String text) {
        System.out.println(text);
    }

    protected void clickElement(By by) {
        findByElement(by).click();
        logMessage(findByElement(by).getText() + " butonuna tıklandı.");
    }

    protected void controlURL(String expectingUrl) {
        if (driver.getCurrentUrl().contentEquals(expectingUrl)) {
            System.out.println("URL bilgisi doğru: " + expectingUrl);
        } else {
            System.out.println("Gelen URL bilgisi yanlış gözükmektedir.");
        }
    }

    protected void controlHeaderElements(String[] expectingHeaderElement, List<WebElement> actualHeaderElement) {
        if (!actualHeaderElement.isEmpty()) {
            for (int i = 0; i < actualHeaderElement.size(); i++) {
                checkCategoryElement(expectingHeaderElement, actualHeaderElement, i);
            }
        } else {
            logMessage("Kategori Menüsü boş gelmektedir.");
        }

    }

    protected void checkCategoryElement(String[] expectingHeaderElement, List<WebElement> actualHeaderElement, int i) {
        if (actualHeaderElement.get(i).getText().equals(expectingHeaderElement[i])) {
            logMessage("Olan Kategori: " + actualHeaderElement.get(i).getText() + ", Beklenen Kategori: " + expectingHeaderElement[i]);
        }
    }

    protected void sendKeyElement(By by, String text) {
        findByElement(by).sendKeys(text);
    }

    protected void scrollPage(WebElement element) {
        //Element görünene kadar sayfayı scroll eder.
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    protected void clickJavaScript(WebElement element){
        //Elemente tıklanır.
        jse.executeScript("arguments[0].click();",element);
    }
    protected void isEnabledElement(WebElement element){
        if(element.isEnabled()){
            mouseClick(element);
        }
    }

    protected void isDisplayedElement(WebElement element){
        if(element.isDisplayed()){
            logMessage(element.getText()+ "'ine tıklandı");
            element.click();
        }
    }

    protected void checkTrue(String expecting, String actual) {
        if (actual.equals(expecting)) {
            logMessage("Olunan : " + actual + ", Beklenen : " + expecting);
        } else {
            logMessage("Yanlış girildi.");
        }
    }

    protected void waitSeconds(int seconds) {
        try {
            logMessage(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logMessage(e.getMessage());
        }
    }

    protected void mouseOn(WebElement element) {
        action.moveToElement(element).build().perform();
        logMessage(element.getText() + " inin üzerine gelindi.");
    }

    protected void mouseClick(WebElement element) {
        action.moveToElement(element).click().build().perform();
        logMessage(element.getText() + " e tıklandı.");
    }
    protected void hoverElement(WebElement wrapper,WebElement buttonClick){
        if (wrapper.isDisplayed()) {
            mouseOn(wrapper);
            waitSeconds(4);
            scrollPage(buttonClick);
            isDisplayedElement(buttonClick);
        }
    }
}
