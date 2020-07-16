package StepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.AdminPage;
import pageObjects.LoginPage;

import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AdminPage ad;
    public static Logger logger;
    public Properties configProp;


    public static String RandomString(){
        String generateRandomString = RandomStringUtils.randomAlphanumeric(6);
        return (generateRandomString);
    }
}
