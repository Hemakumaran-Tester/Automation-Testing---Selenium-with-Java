package com.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;


public class chrometest extends browser {

    WebDriver driver = this.drive();
    xpath element;
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

    public chrometest() throws IOException {
       element = new xpath (driver);
    }


    @Given("Open Application")
    @Test(testName = "Launching application", priority = 1)
    public void launch(){

        driver.get(pro.getProperty("url"));
        driver.manage().window().maximize();
        String title =  driver.getTitle();

        if(pro.getProperty("title").trim() == title.trim()){
            soft.assertTrue(true,"Title - OrangeHRM");}
        else{
            soft.fail("Title not matched");
            }
    }

    @When("Login without credentials")
    @Test(testName = "Login without credentials", priority = 2)
    public void without_Credentials() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(element.loginbtn()));
        element.loginbtn().click();
        System.out.println(driver.getCurrentUrl());
        if (pro.getProperty("dashboard_url") == driver.getCurrentUrl()){
            soft.fail("Application logged in without credentials");
        }
        else {
            wait.until(ExpectedConditions.visibilityOf(element.required()));
            soft.assertEquals(element.required().getText(), "Required");
        }
        Thread.sleep(5000);
    }

    @And("Login with invalid credentials")
    @Test(testName = "login with invalid credentials", priority = 3)
    public void invalid_credentials() throws IOException, InterruptedException {

        String invalid_usrnm = pro.getProperty("invalid_username");
        System.out.println(element.usernamefld().getAttribute("placeholder"));
        wait.until(ExpectedConditions.visibilityOf(element.usernamefld()));

        element.usernamefld().sendKeys("NO_ONE");

        Thread.sleep(5000);

        String invalid_pswrd = pro.getProperty("invalid_password");
        wait.until(ExpectedConditions.visibilityOf(element.passwordfld()));
        element.passwordfld().sendKeys("NONE");
        element.loginbtn().click();

        wait.until(ExpectedConditions.visibilityOf(element.invalid_Credentials()));
        boolean cred_alert = element.invalid_Credentials().isDisplayed();

        if (cred_alert == true){
            System.out.println("Validation image displayed - " + cred_alert);}
        else{
            soft.fail("Invalid credentials alert is not displayed");
        }
    }

    @Then("Login with valid credentials")
    @Test(testName = "Login with valid credentials", priority = 4)
    public void valid_credentials() throws InterruptedException {

        String valid_usrnm = pro.getProperty("valid_username");
        wait.until(ExpectedConditions.visibilityOf(element.usernamefld()));
        Thread.sleep(5000);

        element.usernamefld().sendKeys("Admin");

        String valid_pswrd = pro.getProperty("vaild_password");
        wait.until(ExpectedConditions.visibilityOf(element.passwordfld()));

        element.passwordfld().sendKeys("admin123");

        element.loginbtn().click();

        wait.until(ExpectedConditions.visibilityOf(element.bannerimg()));

        if (element.bannerimg().isDisplayed()){
            System.out.println("Login successfully - " + element.bannerimg().isDisplayed());
        }
        else{
            System.out.println("Banner image displayed - - " +element.bannerimg().isDisplayed());
            soft.fail("Test failed");
        }
    }


    @AfterClass
    public void teardown() {
//          driver.quit();
    }
}