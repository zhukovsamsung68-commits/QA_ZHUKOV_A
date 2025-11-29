package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.OnlineTopUpPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    WebDriver driver;
    WebDriverWait wait;
    OnlineTopUpPage page;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        page = new OnlineTopUpPage(driver);
        page.open();
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
        assertTrue(page.isBlockTitleDisplayed());
    }

    @Test
    void checkPaymentLogos() {
        assertTrue(page.hasPaymentLogos());
    }

    @Test
    void checkMoreInfoLink() {
        String before = page.getCurrentUrl();
        page.clickMoreInfoLink();
        page.waitUrlNotEquals(before);
        assertNotEquals(before, page.getCurrentUrl());
    }

    @Test
    void checkContinueButton() {
        page.openServicesTab();
        page.fillServicesForm("297777777", "10", "test@test.com");
        assertTrue(page.isContinueButtonEnabled());
        page.clickContinue();
    }

    @Test
    void checkPlaceholdersForAllVariants() {
        page.openServicesTab();
        assertTrue(page.getServicesPhonePlaceholder().contains("Номер телефона"));
        assertTrue(page.getServicesAmountPlaceholder().contains("Сумма"));
        assertTrue(page.getServicesEmailPlaceholder().contains("E-mail"));
    }

    @Test
    void checkServicesPaymentConfirmWindow() throws InterruptedException {
        page.openServicesTab();

        String phone = "297777777";
        String amount = "10";
        String email = "test@test.com";

        page.fillServicesForm(phone, amount, email);
        page.clickContinue();

        Thread.sleep(5000);

        assertFalse(driver.findElements(By.tagName("iframe")).isEmpty());

        String html = driver.getPageSource().toLowerCase();

        assertTrue(html.contains("10.00 byn"));
        assertTrue(html.contains("услуги связи номер"));
        assertTrue(html.contains(phone));
    }
}
