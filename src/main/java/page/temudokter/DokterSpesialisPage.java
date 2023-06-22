package page.temudokter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.BasePage;

import java.util.List;

public class DokterSpesialisPage extends BasePage {

    public DokterSpesialisPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    @FindBy(css = ".cursor-pointer.fs-16")
    WebElement btnReset;

    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Reset')]")
    WebElement btnResetOnModalBody;

    @FindBy(xpath = "//span[normalize-space()='Konfirmasi']")
    WebElement btnConfirmOnModalBody;

    @FindBy(xpath = "//span[contains(text(),'Lihat Semua')]")
    WebElement lihatSemuaLokasi;

    @FindBy(xpath = "//input[@value='Kota Jakarta Selatan']")
    WebElement lokasiJakSel;

    @FindBy(xpath = "//label[@class='ant-checkbox-wrapper fs-14 text-neutral-5 SeQaZeS0']/span[.='Kota Jakarta Selatan']")
    WebElement searchResultJaksel;

    @FindBy(xpath = "//input[@value='Kota Semarang']")
    WebElement lokasiSemarang;

    @FindBy(xpath = "//input[@value='Kota Banda Aceh']")
    WebElement lokasiBandaAceh;

    @FindBy(xpath = "//input[@class='ant-input']")
    WebElement cariLokasi;

    @FindBy(xpath = "//span[.='Di bawah 5 thn']")
    WebElement dibawahLimaTahun;

    @FindBy(xpath = "//span[.='5 - 10 thn']")
    WebElement limaSampaiSepuluhThn;

    @FindBy(xpath = "//span[.='Di atas 10 thn']")
    WebElement diatasSepuluhThn;

    @FindBy(xpath = "//span[.='Rumah Sakit']")
    WebElement rumahSakit;

    @FindBy(xpath = "//span[.='Klinik']")
    WebElement klinik;

    @FindBy(xpath = "//span[.='Lab']")
    WebElement lab;

    @FindBy(xpath = "//input[@placeholder='Terendah']")
    WebElement minHarga;

    @FindBy(xpath = "//input[@placeholder='Tertinggi']")
    WebElement maxHarga;

    @FindAll({@FindBy(xpath = "//div[contains(text(),'Rp')]")})
    List<WebElement> txtHarga;

    @FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
    WebElement btnNextPage;

    @FindAll({@FindBy(xpath = "//div[contains(text(),'dr')]")})
    List<WebElement> chooseDokter;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/section[1]/section[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]")
    WebElement txtVerifyLocation;

    @FindBy(xpath = "//span[contains(text(),'0') and contains(text(),':')]")
    WebElement scheduleBuatJanji;

    @FindBy (xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-lg __6We6GVun w-100']/span[.='Buat Janji']")
    WebElement btnBuatJanji;

    public void clickBtnReset(){
        doClick(btnReset);
    }

    public void clickAllLocation(){
        doClick(lihatSemuaLokasi);
    }

    public void findLocation(String location){
        doClick(cariLokasi);
        clear(cariLokasi);
        doSetText(cariLokasi,location);
    }

    public boolean verifyJakselLocation(){
        waitForElementPresent(searchResultJaksel);
        return searchResultJaksel.isDisplayed();
    }

    public void clickDocter(){
        waitForElementPresent(chooseDokter.get(0));
        doClick(chooseDokter.get(0));
    }

    public void filterLocation(Location location){
    switch (location){
        case JAKSEL:
            doClick(searchResultJaksel);
            break;
        case SEMARANG:
            doClick(lokasiSemarang);
            break;
        case BANDA_ACEH:
            doClick(lokasiBandaAceh);
            break;
        }
    }

    public void clickBtnResetOnPopupLabel(){
        waitForElementPresent(btnResetOnModalBody);
        btnResetOnModalBody.click();
    }

    public void clickBtnConfirmOnPopupLabel(){
        waitForElementPresent(btnConfirmOnModalBody);
        btnConfirmOnModalBody.click();
    }

    public boolean verifySelectedLocation(){
        return searchResultJaksel.isSelected();
    }

    public String verifyTxtLocation(){
//        System.out.println(doGetText(txtVerifyLocation));
        waitForElementPresent(txtVerifyLocation);
        System.out.println(txtVerifyLocation.getText());
       return doGetText(txtVerifyLocation);
    }

    public void cekShceduleBuatJanji(){

    }

    public void filterExperience(Experience experience){
        switch (experience){
            case LESS_THEN_5YEARS:
                doClick(dibawahLimaTahun);
                break;
            case FROM_5YEARS_to_10YEARS:
                doClick(limaSampaiSepuluhThn);
                break;
            case MORE_THAN_10YEARS:
                doClick(diatasSepuluhThn);
                break;
        }
    }

    public void filterByFaskes(Fasilitas fasilitas){
        switch (fasilitas){
            case RUMAH_SAKIT:
                doClick(rumahSakit);
                break;
            case KLINIK:
                doClick(klinik);
                break;
            case LAB:
                doClick(lab);
                break;
        }
    }

    public void verifyFilterByPrice(Integer minPrice, Integer maxPrice) {
        doClick(minHarga);
        clear(minHarga);
        doSetText(minHarga, String.valueOf(minPrice));
        doClick(maxHarga);
        clear(maxHarga);
        doSetText(maxHarga, String.valueOf(maxPrice));
        for (int i = 0; i < txtHarga.size(); i++) {
            waitForElementPresent(txtHarga.get(i));
            Integer doctorPrice = Integer.parseInt(txtHarga.get(i).getText().replace("Rp", ""));
            if ((doctorPrice >= minPrice) && (doctorPrice <= maxPrice)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    public enum Location{
    BANDA_ACEH,
    SEMARANG,
    JAKSEL,
    }

    public enum Experience{
        LESS_THEN_5YEARS,
        FROM_5YEARS_to_10YEARS,
        MORE_THAN_10YEARS,
    }

    public enum Fasilitas{
        RUMAH_SAKIT,
        KLINIK,
        LAB,
    }

}
