package com.sofia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class SendEmailTest {
    private static final Logger LOG = LogManager.getLogger(SendEmailTest.class);
    private static final String SIGN_IN_PAGE = "https://mail.google.com";
    private static final String TEST_USERNAME = "sonyachanter@gmail.com";
    private static final String TEST_PASSWORD = "sonichka13";
    private static final String RECEIVER_EMAIL = "sophiepredko@gmail.com";
    private static final String EMAIL_TEXT = "This is test email :)";
    private static final String EMAIL_SUBJECT = "Test Email";

    private WebDriver driver = DriverManager.getInstance();

    @BeforeTest
    public void setObjects() {
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void logInAndSendEmail() {
        driver.get(SIGN_IN_PAGE);
        WebElement signInEmail = driver.findElement(By.xpath("//input[@id='identifierId']"));
        signInEmail.sendKeys(TEST_USERNAME);
        signInEmail.sendKeys(Keys.ENTER);

        WebElement activeEmailUser = driver.findElement(By.id("profileIdentifier"));
        assertEquals(activeEmailUser.getAttribute("innerHTML"), TEST_USERNAME);
        LOG.info("Username Correct");

        WebElement signInPassword = driver.findElement(By.name("password"));
        signInPassword.sendKeys(TEST_PASSWORD);
        signInPassword.sendKeys(Keys.ENTER);

        LOG.info("Sign in successfully!");

        WebElement writeEmailButton = driver.findElement(By.xpath("//div[text()='Написати']"));
        writeEmailButton.click();

        WebElement toPersonTextArea = driver.findElement(By.name("to"));
        toPersonTextArea.click();
        toPersonTextArea.sendKeys(RECEIVER_EMAIL);

        WebElement themeArea = driver.findElement(By.name("subjectbox"));
        themeArea.click();
        themeArea.sendKeys(EMAIL_SUBJECT);

        WebElement writeEmailTextArea = driver.findElement(By.xpath("//div[@role='textbox']"));
        writeEmailTextArea.click();
        writeEmailTextArea.sendKeys(EMAIL_TEXT);

        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Надіслати']"));
        sendButton.click();

        LOG.info("Sent successfully");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

}
