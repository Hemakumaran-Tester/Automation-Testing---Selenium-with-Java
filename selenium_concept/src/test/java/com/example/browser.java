package com.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class browser {
    WebDriver driver;
    public Properties pro;
    String browserName;

    public Properties browser() throws IOException {
        pro = new Properties();
        String name = System.getProperty("user.dir") + "\\data.properties";
        FileInputStream file = new FileInputStream(name);
        pro.load(file);
        return pro;
    }

    public WebDriver drive() throws IOException {
        browser();
        browserName = pro.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
