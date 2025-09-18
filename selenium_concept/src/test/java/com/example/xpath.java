package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class xpath {

    WebDriver driver;

    public xpath(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //LOGIN PAGE

    @FindBy (xpath = "//input[@placeholder='Username']")
    WebElement usernamefld;

    @FindBy (xpath = "//input[@placeholder='Password']")
    WebElement passwordfld;

    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement loginbtn;


    public WebElement usernamefld() {
        return usernamefld;}
    public WebElement passwordfld() {
        return passwordfld;}
    public WebElement loginbtn() {
        return loginbtn;}


    //Dashboard
    @FindBy (xpath = "(//h6[normalize-space()='Dashboard'])[1]")
    WebElement dashheader;

    @FindBy (xpath = "//img[@alt='client brand banner']")
    WebElement bannerimg;


    public WebElement dashheader() {
        return dashheader;}
    public WebElement bannerimg() {
        return bannerimg;}


    //Profile menu
    @FindBy (xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement profilebtn;

    @FindBy (xpath = "//ul[@role='menu']")
    WebElement pro_menu;

    @FindBy (xpath = "//a[normalize-space()='About']")
    WebElement aboutbtn;

    @FindBy (xpath = "//a[normalize-space()='Support']")
    WebElement sprtbtn;

    @FindBy (xpath = "//a[normalize-space()='Change Password']")
    WebElement cp_menu_btn;

    @FindBy (xpath = "//a[normalize-space()='Logout']")
    WebElement logout_btn;

    @FindBy (xpath = "//h6[normalize-space()='Update Password']")
    WebElement update_pw_header;

    @FindBy (xpath = "//p[@class='oxd-text oxd-text--p orangehrm-user-name']")
    WebElement username;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement cur_password;

    @FindBy (xpath = "//input[@aria-autocomplete='list']")
    WebElement new_password;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement confirm_password;

    @FindBy (xpath = "//p[@class='oxd-text oxd-text--p user-password-hint']")
    WebElement pw_note;

    @FindBy (xpath = "//button[normalize-space()='Cancel']")
    WebElement change_pw_cancel;

    @FindBy (xpath = "//button[normalize-space()='Save']")
    WebElement change_pw_save;

    @FindBy (xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement required;

    @FindBy (xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalid_Credentials;



    public WebElement profilebtn() {
        return profilebtn;}
    public WebElement pro_menu() {
        return pro_menu;}
    public WebElement aboutbtn() {
        return aboutbtn;}
    public WebElement sprtbtn() {
        return sprtbtn;}
    public WebElement cp_menu_btn() {
        return cp_menu_btn;}
    public WebElement logout_btn() {
        return logout_btn;}
    public WebElement update_pw_header() {
        return update_pw_header;}
    public WebElement username() {
        return username;}
    public WebElement cur_password() {
        return cur_password;}
    public WebElement new_password() {
        return new_password;}
    public WebElement confirm_password() {
        return confirm_password;}
    public WebElement pw_note() {
        return pw_note;}
    public WebElement change_pw_cancel() {
        return change_pw_cancel;}
    public WebElement change_pw_save() {
        return change_pw_save;}
    public WebElement required() {
        return required;}

    public WebElement invalid_Credentials() {
        return invalid_Credentials;}
}
