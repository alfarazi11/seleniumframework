package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class HomeTest extends BaseWebTest{

    @BeforeClass
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();

    }

    @Test
    public void globalSearch() {
        HomePage homePage = new HomePage(driver,explicitWait);
        homePage.searchGlobal("Bud","dokter");
        homePage.backToHome();
        homePage.searchGlobal("Bud","faskes");
        homePage.backToHome();
        homePage.searchGlobal("Bud","layanan");
    }

}
