package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CommonPage;
import page.HomePage;
import page.LoginPage;
import page.temudokter.DokterSpesialisPage;
import page.temudokter.TemuDokterPage;

public class TemuDokterTest extends BaseWebTest{

    @BeforeClass
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();

    }
    @Test
    public void verifyFilterOnFaskesPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        Thread.sleep(2000);
        homePage.clickTemuDokter();
        TemuDokterPage temuDokterPage = new TemuDokterPage(driver,explicitWait);
        temuDokterPage.clickBtnShowMore();
        Assert.assertTrue(temuDokterPage.btnShowLessIsDisplayed());
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.scrollUp();
        temuDokterPage.clickDokterGigi();
        DokterSpesialisPage dokterSpesialisPage = new DokterSpesialisPage(driver,explicitWait);
        dokterSpesialisPage.clickAllLocation();
        dokterSpesialisPage.findLocation("Kota Jakarta Selatan");
        Assert.assertTrue(dokterSpesialisPage.verifyJakselLocation());
        dokterSpesialisPage.filterLocation(DokterSpesialisPage.Location.JAKSEL);
        dokterSpesialisPage.clickBtnResetOnPopupLabel();
        Assert.assertFalse(dokterSpesialisPage.verifySelectedLocation());
        dokterSpesialisPage.filterLocation(DokterSpesialisPage.Location.JAKSEL);
        dokterSpesialisPage.clickBtnConfirmOnPopupLabel();
        Thread.sleep(2000);
        dokterSpesialisPage.clickDocter();
//        String location = dokterSpesialisPage.verifyTxtLocation();
//        Assert.assertTrue(location.contains("Jakarta Selatan"));
    }

    @Test
    public void temuDokterBuatJanji() throws InterruptedException {
        HomePage homePage = new HomePage(driver,explicitWait);
        Thread.sleep(2000);
        homePage.clickTemuDokter();
        TemuDokterPage temuDokterPage = new TemuDokterPage(driver,explicitWait);
        temuDokterPage.clickBtnShowMore();
        Assert.assertTrue(temuDokterPage.btnShowLessIsDisplayed());
        CommonPage commonPage = new CommonPage(driver,explicitWait);
        commonPage.scrollUp();
        temuDokterPage.clickDokterGigi();
        homePage.searchGlobal("Drg Puti","dokter");
        Thread.sleep(5000);




    }
}
