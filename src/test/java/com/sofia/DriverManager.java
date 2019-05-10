package com.sofia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;
    private static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static final String WEB_DRIVER_NAME = "webdriver.chrome.driver";

    private DriverManager() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            System.setProperty(WEB_DRIVER_NAME, DRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }
}
