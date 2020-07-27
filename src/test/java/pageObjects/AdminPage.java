package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Helper;

import java.util.List;

public class AdminPage {
    public WebDriver Idriver;
    Helper helper = new Helper(Idriver);
    //Constructor
    public AdminPage(WebDriver rdriver){
        Idriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(id = "menu_admin_viewAdminModule")
    @CacheLookup
    WebElement adminModule;

    @FindBy(id = "resetBtn")
    @CacheLookup
    WebElement resetButton;

    @FindBy(id = "searchSystemUser_userName")
    @CacheLookup
    WebElement userNameEditBox;

    @FindBy(id = "searchBtn")
    @CacheLookup
    WebElement searchButton;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[2]/a")
    @CacheLookup
    WebElement searchResultUserName;

    // New pattern of Object Identification
    //===================================================================================
    By JobLink_Admin = By.id("menu_admin_Job");

    By Select_JobTittles = By.linkText("Job Titles");
    By Add_Button = By.name("btnAdd");

    //====================================================================================
    @FindBy(how = How.ID,using = "systemUser_userType")
    @CacheLookup
    WebElement userRole;

    @FindBy(how = How.ID,using = "systemUser_employeeName_empName")
    @CacheLookup
    WebElement empName;

    @FindBy(how = How.ID,using = "systemUser_userName")
    @CacheLookup
    WebElement userName;

    @FindBy(how = How.NAME,using = "systemUser[status]")
    @CacheLookup
    WebElement statusSelect;

    @FindBy(how = How.NAME,using = "btnSave")
    @CacheLookup
    WebElement saveButton;

    @FindBy(how = How.ID,using = "resultTable")
    @CacheLookup
    WebElement uResultTable;

    @FindBy(how = How.XPATH,using = "//*[@id='resultTable']/tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;
    @FindBy(how = How.XPATH,using = "//*[@id='resultTable']/thead/tr/th")
    @CacheLookup
    List<WebElement> tableColumns;

    @FindBy(how = How.ID,using = "systemUser_password")
    @CacheLookup
    WebElement adminPassword;

    @FindBy(how = How.ID,using = "systemUser_confirmPassword")
    @CacheLookup
    WebElement confirmPassword;

    //=========================================================================================

    public  void clickOnJob(){
        //Helper helper = new Helper(Idriver);
        //helper.WaitForElement(Idriver.findElement(JobLink_Admin),30);
        Idriver.findElement(JobLink_Admin).click();
    }
    public void ClickOnSubTittle_Job(){
        Idriver.findElement(Select_JobTittles).click();
    }

    public void VerifyJobTittle(String jobTittle){
        By JobTittle = By.xpath("//*[@id='resultTable']/tbody/tr/td//a[text()='"+jobTittle+"']");
        String  isExist = Idriver.findElement(JobTittle).getText();
        Assert.assertEquals(isExist.trim(),jobTittle.trim());
    }


    public void ClickOnAdminModule(){
        //helper.WaitForElement(adminModule,30);
        adminModule.click();
    }

    public void ClickOnResetButton(){
        resetButton.click();
    }
    public void SetUserNameForSearch(String userName){
        userNameEditBox.clear();
        userNameEditBox.sendKeys(userName);
    }
    public void ClickOnSearchButton(){
        searchButton.click();
    }

    public void VerifySearchResultByUserName(String userName){
        String expUserName = searchResultUserName.getText();
        Assert.assertEquals(expUserName.trim(),userName.trim());
    }

    public void ClickAddButton(){
        //helper.WaitForElement(Idriver.findElement(Add_Button),30);
        Idriver.findElement(Add_Button).click();
    }

    public void SelectUserRole(String userRol){
        Select optionSelect = new Select(userRole);
        optionSelect.selectByVisibleText(userRol);
    }

    public void SetEmployeeName(String empNam){
        empName.clear();
        empName.sendKeys(empNam);
    }

    public void SetUserName(String userNam){
        userName.clear();
        userName.sendKeys(userNam);
    }
    //User select status from list
    public void SelectStatus(String status){
        Select optionSelect = new Select(statusSelect);
        optionSelect.selectByVisibleText(status);
    }

    //Click on Save button
    public void ClickOnSaveButton() throws InterruptedException {
        Thread.sleep(4000);
        saveButton.click();
    }
    public int getNumberOfRows(){
        return (tableRows.size());
    }

    public int getNumberOfColumns(){
        return (tableColumns.size());
    }

    // Verify User Created in the system
    public boolean verifyAddUserCreated(String empName){
        boolean flag = false;
        for(int i=1;i<=getNumberOfRows();i++){
            String employeeName = uResultTable.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[4]")).getText();
            System.out.println(employeeName);
            if(employeeName.trim().equals(empName.trim())){
                flag = true;
            }
        }
        return flag;
    }

    public void setAdminPassword(String passwordAdmin){
        adminPassword.clear();
        adminPassword.sendKeys(passwordAdmin);
    }
    public void ReTypeAdminPassword(String reTypePassword){
        confirmPassword.clear();
        confirmPassword.sendKeys(reTypePassword);
    }
}
