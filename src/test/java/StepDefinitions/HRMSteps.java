package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.AdminPage;
import pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class HRMSteps  extends BaseClass{
    @Before
    public void setup() throws IOException {

        logger = Logger.getLogger("CucumberWithSeleniumProject");
        PropertyConfigurator.configure("log4j.properties");
        //Reading properties file
        configProp = new Properties();
        FileInputStream configPropFile=new FileInputStream("config.properties");
        configProp.load(configPropFile);

        String projectPath= System.getProperty("user.dir");
        logger.info("Project path is-"+projectPath);
        //System.out.println("Project path is-"+projectPath);

        String br = configProp.getProperty("browser");

        if(br.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver", projectPath+"//src//test//resources//drivers//chromedriver_win32//chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver_win32//chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));

            //for headless execution===================
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);

            //=========================================
        }else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }else if(br.equals("ie")){
            System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
            driver = new InternetExplorerDriver();
        }


        logger.info("******************** Launching Browser **************************");
        //driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }




    @Given("User Launch Chrome Browser")
    public void user_Launch_Chrome_Browser() {

        lp = new LoginPage(driver);
        ad = new AdminPage(driver);
    }

    @When("User Open Orange HRM")
    public void user_Open_Orange_HRM() {
        logger.info("******************** Open Application **************************");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Then("User Verify That The Logo Present On Page")
    public void user_Verify_That_The_Logo_Present_On_Page() {
        boolean status = driver.findElement(By.xpath("//*[@id='divLogo']/img")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("User Close Browser")
    public void user_Close_Browser() {
        driver.quit();
    }

    @When("User Click On {} Button")
    public void user_Click_On_Button(String buttonName) {
        if(buttonName.equals("Logout")){
            //driver.findElement(By.xpath("//a[text()='Logout']")).click();
            lp.clickLogin();
        }else{
            driver.findElement(By.id(buttonName)).click();
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Then("User Verify {string} Text")
    public void user_Verify_Text(String textVerify) {
        lp.VerifyLoginSuccessfull(textVerify);
    }

    @And("User Enter {string} As Admin Password As {string}")
    public void userEnterAsAdminPasswordAs(String userName, String password) {
        logger.info("******************** Entering Login Details **************************");
        lp.setUserName(userName);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        lp.setPassword(password);

    }

    @And("User Click On {string} Type {string}")
    public void userClickOnType(String linkName, String fieldType) {
        driver.findElement(By.xpath("//*[@class='firstLevelMenu']/b[text()='"+linkName.trim()+"']")).click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("User able to click -"+fieldType +" and Name is-"+linkName);
    }


    @When("User  Enter {} And {}")
    public void user_Enter_LoginInfo(String userName, String password) {
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys(userName);
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys(password);
    }

    @And("User Search Employee By Name {string}")
    public void userSearchEmployeeByName(String employeeName) {
        driver.findElement(By.name("empsearch[employee_name][empName]")).clear();
        driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys(employeeName);
        driver.findElement(By.id("searchBtn")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @And("User Sees FirstName {string} displayed")
    public void userSeesFirstNameDisplayed(String employeeName) {
        String empName = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr//following-sibling::td[3]//a[text()='"+employeeName.trim()+"']")).getText();
        Assert.assertEquals(empName.trim(),employeeName.trim());
    }

    @And("User Clicks On Login Button")
    public void userClicksOnLoginButton() throws InterruptedException {
        lp.clickLogin();
        Thread.sleep(100);
    }

    @And("User Logout From Application")
    public void userLogoutFromApplication() {
        lp.clickLogoutButton();
    }

    @And("User Click On Admin Tab")
    public void userClickOnAdminTab() throws InterruptedException {
        ad.ClickOnAdminModule();
        Thread.sleep(1000);
    }

    @And("User Sets UserName {}")
    public void userSetsUserNameLindaAnderson(String userName) {
        ad.ClickOnResetButton();
        ad.SetUserNameForSearch(userName);
    }

    @And("User Clicks On Search Button")
    public void userClicksOnSearchButton() {
        ad.ClickOnSearchButton();
    }

    @Then("User Verify UserName {} displayed")
    public void userVerifyUserNameDisplayed(String userName) {
        ad.VerifySearchResultByUserName(userName);
    }

    @And("User Clicks On Job SubTittle")
    public void userClicksOnJobSubTittle() {
        ad.clickOnJob();
    }

    @Then("User Verify JobTitle {} Exist")
    public void userVerifyJobTitleJobTittleExist(String JobTittle) {
        logger.info("Verify JobTitle Exist");
        ad.VerifyJobTittle(JobTittle);
    }

    @And("User Selects Job Tittles")
    public void userSelectsJobTittles() {
        ad.ClickOnSubTittle_Job();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @And("User Clicks Add Button")
    public void userClicksAddButton() {
        ad.ClickAddButton();
    }

    @And("User Selects User Role {}")
    public void userSelectsUserRole(String userRole) {
        ad.SelectUserRole(userRole);
    }

    @And("User Types Employee Name {}")
    public void userTypesEmployeeName(String empNam) {
        ad.SetEmployeeName(empNam);
    }

    @And("User Types Username {}")
    public void userTypesUsername(String userNam) {
        ad.SetUserName(userNam+RandomString());
    }

    @And("User Selects Status {}")
    public void userSelectsStatus(String statusSelect) {
        ad.SelectStatus(statusSelect.trim());
    }

    @Then("User Clicks on Save Button")
    public void userClicksOnSaveButton() {
        ad.ClickOnSaveButton();
    }

    @And("User Verify Employee Name Created With {}")
    public void userVerifyEmployeeNameCreated(String EmpName1) {
        logger.info("******************** Verifying Records created **************************");
        boolean status = ad.verifyAddUserCreated(EmpName1);
        //Assert.assertEquals(true,status);
        Assert.assertTrue(status);
    }
}
