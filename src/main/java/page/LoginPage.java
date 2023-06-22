package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='Masuk']")
    WebElement loginButton;
    @FindBy(xpath = "//input[@id='auth-form_phoneNumber']")
    WebElement phoneNumber;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement nextButton;
    @FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
    WebElement pin1;
    @FindBy(xpath = "//input[@aria-label='Digit 2']")
    WebElement pin2;
    @FindBy(xpath = "//input[@aria-label='Digit 3']")
    WebElement pin3;
    @FindBy(xpath = "//input[@aria-label='Digit 4']")
    WebElement pin4;
    @FindBy(xpath = "//input[@aria-label='Digit 5']")
    WebElement pin5;
    @FindBy(xpath = "//input[@aria-label='Digit 6']")
    WebElement pin6;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }


    public void goToLoginPage(){
//        waitForElementPresent(loginButton);
//        loginButton.click();
        doClick(loginButton);
    }

    public void inputPhoneNumber(String phnNumb){
//        waitForElementPresent(phoneNumber);
//        phoneNumber.sendKeys(phnNumb);
        doSetText(phoneNumber,phnNumb);
//        nextButton.click();
        doClick(nextButton);
    }

    public void inputPin(String pinSatu,String pinDua,String pinTiga,String pinEmpat,String pinLima,String pinEnam){
//        waitForElementPresent(pin1);
//        pin1.sendKeys(pinSatu);
//        pin2.sendKeys(pinDua);
//        pin3.sendKeys(pinTiga);
//        pin4.sendKeys(pinEmpat);
//        pin5.sendKeys(pinLima);
//        pin6.sendKeys(pinEnam);
        doSetText(pin1,pinSatu);
        doSetText(pin2,pinDua);
        doSetText(pin3,pinTiga);
        doSetText(pin4,pinEmpat);
        doSetText(pin5,pinLima);
        doSetText(pin6,pinEnam);
    }

    public void clickSubmtBtn(){
//        waitForElementPresent(submitButton);
//        submitButton.click();
        doClick(submitButton);
    }
    
    public void login() throws InterruptedException {
        goToLoginPage();
        inputPhoneNumber("081283768422");
        Thread.sleep(2000);
        inputPin("1","1","1","1","1","1");
        clickSubmtBtn();
    }

}
