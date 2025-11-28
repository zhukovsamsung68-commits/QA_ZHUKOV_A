package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MtsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        closeCookies();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    void closeCookies() {
        try {
            WebElement cookieBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//button[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЬЭЮЯ','abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщыьэюя'),'хорошо')]" +
                                            " | //button[contains(.,'Принять')]" +
                                            " | //button[contains(.,'OK')]" +
                                            " | //button[contains(.,'Ок')]"
                            )
                    ));
            cookieBtn.click();
        } catch (Exception ignored) {}
    }

    @Test
    void checkBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[self::h1 or self::h2][contains(.,'Онлайн пополнение без комиссии')]")
        ));
        Assertions.assertTrue(title.isDisplayed());
    }

    @Test
    void checkPaymentLogos() {
        WebElement section = driver.findElement(
                By.xpath("//section[contains(.,'Онлайн пополнение без комиссии')]")
        );

        Assertions.assertFalse(
                section.findElements(By.tagName("img")).isEmpty()
        );
    }

    @Test
    void checkMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(.,'Подробнее о сервисе')]")
        ));

        String before = driver.getCurrentUrl();
        link.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(before)));

        Assertions.assertNotEquals(before, driver.getCurrentUrl());
    }

    @Test
    void checkContinueButton() {
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@placeholder,'Номер телефона')]")
        ));

        WebElement amount = driver.findElement(
                By.xpath("//input[contains(@placeholder,'Сумма')]")
        );

        WebElement button = driver.findElement(
                By.xpath("//button[contains(.,'Продолжить')]")
        );

        phone.clear();
        phone.sendKeys("297777777");

        amount.clear();
        amount.sendKeys("10");

        Assertions.assertTrue(button.isEnabled());
        button.click();
    }
}
