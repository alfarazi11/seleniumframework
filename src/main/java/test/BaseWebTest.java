package test;

import interfacecollection.IDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page.LoginPage;

import java.time.Duration;

public class BaseWebTest implements IDriverManager {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();


    @BeforeClass
    public void createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--disable-notifications");
//        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-error",
//                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*", "--disable-notification");
        driver.set(new ChromeDriver(options));
        driver.get().get("https://v2.klikdokter-stg.com/");
        driver.get().manage().window().maximize();
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10)));
    }

    @AfterClass
    public void quitChromeDriver() {
        driver.get().quit();

    }
}
