package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import utils.Utility;

public class LoginTest extends BaseWebTest{

    @Test
    public void validLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.login();
    }

    @Test
    public void failedLogin(){
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        loginPage.goToLoginPage();
        loginPage.inputPhoneNumber("081283768422");
        loginPage.inputPin("1","2","3","4","5","6");
        loginPage.clickSubmtBtn();
    }
}
