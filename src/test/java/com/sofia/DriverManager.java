package com.sofia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static final String WEB_DRIVER_NAME = "webdriver.chrome.driver";

    private DriverManager() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = setSettings();
        }
        return driver;
    }

    private static WebDriver setSettings() {
        System.setProperty(WEB_DRIVER_NAME, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
