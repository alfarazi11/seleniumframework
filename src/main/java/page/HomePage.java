package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='/tanya-dokter']//img[@alt='Image']")
    WebElement tanyaDokter;
    @FindBy(xpath = "//a[@href='/temu-dokter']//img[@alt='Image']")
    WebElement temuDokter;
    @FindBy(xpath = "//img[@alt='User Avatar']")
    WebElement profileImage;
    @FindBy(className = "GM3csmdo")
    WebElement profileText;
    @FindBy(xpath = "//input[@name='search']")
    WebElement inputSearchGlobal;
    @FindBy(xpath = "//div[@id='rc-tabs-0-tab-Dokter']")
    @CacheLookup
    WebElement tabDokter;

//     @FindBy(xpath = "/html/body/div[1]/section/header/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[2]/div")
    @FindBy(xpath = "//div[@class='ant-tabs-tab']/div[.='Faskes']")
    WebElement tabFaskes;
    @FindBy(xpath = "//div[@class='ant-tabs-tab']/div[.='Layanan']")
    WebElement tabLayanan;
    @FindBy(xpath = "(//img[@alt='KlikDokter'])[1]")
    WebElement iconKlikDokter;

    public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    public void clickTanyaDokter(){
        doClick(tanyaDokter);

    }

    public void clickTemuDokter(){
        doClick(temuDokter);
    }

    public void clickProfileImg(){
        doClick(profileImage);
    }

    public void getTextProfile(){
        doGetText(profileText);
    }


    public void searchGlobal(String keyword, String tipe) {
        doClick(inputSearchGlobal);
        doSetText(inputSearchGlobal,keyword);
        if(tipe.equals("dokter")){
            doClick(tabDokter);
            explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sLuUJAAS']")));
            List<WebElement>  resultGlobalSearch = driver.get().findElements(By.xpath("//span[@class='sLuUJAAS']"));
            for(int i=0; i<resultGlobalSearch.size(); i++) {
                String txtResult = resultGlobalSearch.get(i).getText();
                Assert.assertTrue(txtResult.contains(keyword));
            }
                resultGlobalSearch.get(1).click();
//                String dokterName = doGetText(dokterDetail);
//                Assert.assertTrue(dokterName.contains(keyword));

        } else if (tipe == "faskes") {
            doClick(tabFaskes);
            explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sLuUJAAS']")));
            List<WebElement>  resultGlobalSearch = driver.get().findElements(By.xpath("//span[@class='sLuUJAAS']"));
            for(int i=0; i<resultGlobalSearch.size(); i++) {
                String txtResult = resultGlobalSearch.get(i).getText();
                Assert.assertTrue(txtResult.contains(keyword));
            }
                resultGlobalSearch.get(0).click();
//                String labName = doGetText(labDetail);
//                Assert.assertTrue(labName.contains(keyword));
        }
        else if (tipe == "layanan"){
            doClick(tabLayanan);

//            if(driver.get().findElement(By.xpath("(//span[@class='sLuUJAAS']")).isDisplayed()==true){
//                doClick(iconKlikDokter);
//
//            }else {
//                explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sLuUJAAS']")));
//                resultGlobalSearch.get(0).click();
//            }

        }
    }

    public void backToHome(){
//        waitForElementPresent(iconKlikDokter);
        doClick(iconKlikDokter);
    }

}
