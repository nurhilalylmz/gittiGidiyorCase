package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import util.browser.Browser;


public class BaseTest {
    public static WebDriver driver;
    private Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Before
    public void beginTest() {
        LOGGER.info("Test Start.");
        Browser.setBrowser("https://www.gittigidiyor.com/");
    }

    @After
    public void afterTest() throws InterruptedException {
        LOGGER.info("Test finished.");
        driver.close();
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver webDriver){
        BaseTest.driver=webDriver;
    }
}


