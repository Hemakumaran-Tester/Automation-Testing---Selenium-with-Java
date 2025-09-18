package com.example;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class change_password extends browser{

    xpath element;
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public change_password() throws IOException {
        element = new xpath (driver);
    }

    @Given("checking landing page and buttons")
    @Test(testName = "landing page and button", priority = 5)
    public void landing_page(){

        wait.until(ExpectedConditions.visibilityOf(element.profilebtn()));
        element.profilebtn().click();

        wait.until(ExpectedConditions.visibilityOf(element.pro_menu()));
        if (element.pro_menu().isEnabled()) {
            soft.assertEquals(element.aboutbtn().isDisplayed(), "true");
            soft.assertEquals(element.sprtbtn().isDisplayed(), "true");
            soft.assertEquals(element.cp_menu_btn().isDisplayed(), "true");
            soft.assertEquals(element.logout_btn().isDisplayed(), "true");
        }

    }

}
