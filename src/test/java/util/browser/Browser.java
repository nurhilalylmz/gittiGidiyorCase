package util.browser;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Set;

public class Browser {
    protected final Logger logger= LogManager.getLogger(Browser.class);
    WebDriver webDriver;
    public static void setBrowser(String url) {
        //chrome driver dizinini belirttik.
        System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver.exe");
       // System.setProperty("","properties\\driver\\geckodriver.exe");
        //Browser ayarları
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Chrome ayarlarını yapmak için yeni bir obje nesnesi oluşturulur.
        ChromeOptions chromeOptions = new ChromeOptions();
        //Browser'ı test modunda çalıştırma.
        chromeOptions.addArguments("test-type");
//        //Dil çevirme penceresini kapattırma.
        chromeOptions.addArguments("disable-translate");
        //Browser tam ekranda gösterilir.
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        //Driver'ımızı setliyoruz.
        BaseTest.setDriver(new ChromeDriver(chromeOptions));
        //URL'e gidilir.
        BaseTest.getDriver().navigate().to(url);

    }
    }

