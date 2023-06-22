package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

    public BasePage(ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }

    public void doClick(WebElement element) {
        waitForElementPresent(element);
        element.click();

    }

    public void doSetText(WebElement element, String text) {
        waitForElementPresent(element);
        element.sendKeys(text);
    }

    protected final String doGetText(WebElement element) {
        waitForElementPresent(element);
        String actualText = driver.get().findElement((By) element).getText();
        return actualText;
    }

    public void clear(WebElement element) {
        waitForElementPresent(element);
        element.clear();
    }

    public void SelectOption(By combobox, String option) {
        WebElement element = explicitWait.get().until(ExpectedConditions.elementToBeClickable(combobox));
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public void waitForVisibility(WebElement element) {
        explicitWait.get().until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForElementPresent(WebElement element) {
        try {
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

}
