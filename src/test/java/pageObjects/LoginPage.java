package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver Idriver;

    //Constructor
    public LoginPage(WebDriver rdriver){
        Idriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "txtUsername")
    @CacheLookup
    WebElement userName;

    @FindBy(id = "txtPassword")
    @CacheLookup
    WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    WebElement clickLoginButton;

    @FindBy(id = "welcome")
    @CacheLookup
    WebElement welcomeButton;

    @FindBy(xpath = "//a[text()='Logout']")
    @CacheLookup
    WebElement logoutButtun;

    public void setUserName(String uName){
        userName.clear();
        userName.sendKeys(uName);
    }

    public void setPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }
    public void clickLogin(){
        clickLoginButton.click();
    }

    public void clickLogoutButton(){
        welcomeButton.click();
        logoutButtun.click();
    }
    public void VerifyLoginSuccessfull(String titleText){
        String expTitle = welcomeButton.getText();
        if(!expTitle.trim().contains(titleText)){
            Assert.fail("Title not matched");
        }
    }

    public String getPageTittle(){
        return Idriver.getTitle();
    }
}
