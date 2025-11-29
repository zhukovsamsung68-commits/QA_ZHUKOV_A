package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlineTopUpPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final String URL = "https://www.mts.by/";

    private final By blockTitle = By.xpath("//*[self::h1 or self::h2][contains(.,'Онлайн пополнение без комиссии')]");
    private final By blockSection = By.xpath("//section[contains(.,'Онлайн пополнение без комиссии')]");
    private final By moreInfoLink = By.xpath("//a[contains(.,'Подробнее о сервисе')]");

    private final By phoneInput = By.xpath("//input[contains(@placeholder,'Номер телефона')]");
    private final By amountInput = By.xpath("//input[contains(@placeholder,'Сумма')]");
    private final By emailInput = By.xpath("//input[contains(@placeholder,'E-mail') or contains(@placeholder,'E-mail для отправки чека')]");
    private final By continueButton = By.xpath("//button[contains(.,'Продолжить')]");

    // iframe с формой оплаты
    private final By paymentFrame = By.tagName("iframe");

    // элементы в окне оплаты
    private final By confirmAmountText = By.xpath("//div[contains(text(),'BYN')]");
    private final By confirmPhoneText = By.xpath("//*[contains(text(),'Оплата: Услуги связи Номер')]");
    private final By confirmAmountOnButton = By.xpath("//button[contains(.,'Оплатить') and contains(.,'BYN')]");

    private final By cardNumberInput = By.xpath("//input[@placeholder='Номер карты']");
    private final By cardExpiryInput = By.xpath("//input[contains(@placeholder,'Срок действия') or contains(@placeholder,'ММ/ГГ')]");
    private final By cardCvcInput = By.xpath("//input[contains(@placeholder,'CVC') or contains(@placeholder,'CVV')]");
    private final By cardHolderInput = By.xpath("//input[contains(@placeholder,'Имя и фамилия на карте') or contains(@placeholder,'Держатель')]");

    private final By paymentSystemIcons = By.xpath("//img[contains(@src,'visa') or contains(@src,'master') or contains(@src,'mir') or contains(@src,'belkart')]");

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isBlockTitleDisplayed() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return title.isDisplayed();
    }

    public boolean hasPaymentLogos() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(blockSection));
        List<WebElement> imgs = section.findElements(By.tagName("img"));
        return !imgs.isEmpty();
    }

    public void clickMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        link.click();
    }

    public void waitUrlNotEquals(String before) {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(before)));
    }

    public void openServicesTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
    }

    public String getServicesPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput))
                .getAttribute("placeholder");
    }

    public String getServicesAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput))
                .getAttribute("placeholder");
    }

    public String getServicesEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput))
                .getAttribute("placeholder");
    }

    public void fillServicesForm(String phone, String amount, String email) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        phoneField.clear();
        phoneField.sendKeys(phone);

        WebElement amountField = driver.findElement(amountInput);
        amountField.clear();
        amountField.sendKeys(amount);

        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public boolean isContinueButtonEnabled() {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        return btn.isEnabled();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    // переключение в iframe оплаты
    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
    }

    public String getConfirmAmountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmAmountText)).getText();
    }

    public String getConfirmAmountOnButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmAmountOnButton)).getText();
    }

    public String getConfirmPhoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPhoneText)).getText();
    }

    public String getCardNumberPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberInput))
                .getAttribute("placeholder");
    }

    public String getCardExpiryPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryInput))
                .getAttribute("placeholder");
    }

    public String getCardCvcPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcInput))
                .getAttribute("placeholder");
    }

    public String getCardHolderPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderInput))
                .getAttribute("placeholder");
    }

    public boolean arePaymentSystemIconsVisible() {
        List<WebElement> icons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentSystemIcons));
        return !icons.isEmpty();
    }
}
