package page.temudokter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class TemuDokterPage extends BasePage {

    public TemuDokterPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(xpath = "//span[.='Lihat Lebih Banyak']")
    WebElement btnShowMore;
    @FindBy(xpath = "//span[.='Lihat Lebih Sedikit']")
    WebElement btnShowLess;
    @FindBy(xpath = "//p[normalize-space()='Dokter Gigi']")
    WebElement imgDokterGigi;

    public void clickBtnShowMore(){
        while(!waitForElementPresent(btnShowLess)){
            waitForElementPresent(btnShowMore);
            btnShowMore.click();
        }
    }

    public boolean btnShowLessIsDisplayed(){
    waitForElementPresent(btnShowLess);
    return btnShowLess.isDisplayed();
    }

    public void clickDokterGigi(){
        doClick(imgDokterGigi);
    }


}
