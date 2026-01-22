package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage {
    private ElementsCollection catalogFilter = $$(".catalog-section__filter > div[data-section]");
    private SelenideElement
            phoneInput = $("#phone-number"),
            submitConnectButton = $("#MANAGER_FEEDBACK .form__btn.btn"),
            emailInput = $("#email"),
            checkBoxForMailing = $("#ibloks"),
            checkBoxForMailingList = $(".form__select-list"),
            submitMailButton = $("#SUBSCRIBE_MAILING .form__btn.btn"),
            cookieBanner = $(".coocke__inner"),
            acceptButton = cookieBanner.$(".coocke__btn"),
            footerBody = $(".info-text__body"),
            requiredInfoDropDown = $(".info-text__title");


    @Step("Открыть главную страницу {baseUrl}")
    public MainPage openPage() {
        open(Configuration.baseUrl);
        return this;
    }


    @Step("Выбрать категорию '{value}'")
    public MainPage setСatalogFilter(String value) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();",
                catalogFilter.find(text(value)));
        return this;
    }


    @Step("Ввести номер телефона '{value}'")
    public MainPage setPhone(String value) {
        phoneInput.scrollTo();
        phoneInput.setValue(value);
        return this;
    }


    @Step("Отправить форму связи")
    public MainPage submitConnect() {
        submitConnectButton.click();
        return this;
    }


    @Step("Ввести электронную почту '{value}'")
    public MainPage setEmail(String value) {
        emailInput.scrollTo();
        emailInput.setValue(value);
        return this;
    }


    @Step("Отправить форму подписки")
    public MainPage submitEmail() {
        submitMailButton.click();
        return this;
    }


    @Step("Выбрать раздел рассылки '{value}'")
    public MainPage setCheckBoxForMailing(String value) {
        checkBoxForMailing.click();
        checkBoxForMailingList.$(byText(value)).click();
        return this;
    }


    @Step("Получить обязательную информацию из футера")
    public MainPage getRequiredInfoDropDown() {
        System.out.println("=== ОТЛАДКА ФУТЕРА ===");
        System.out.println("1. Стиль элемента: " +
                footerBody.getAttribute("style"));
        System.out.println("2. CSS display: " +
                footerBody.getCssValue("display"));
        System.out.println("3. CSS visibility: " +
                footerBody.getCssValue("visibility"));
        System.out.println("4. CSS opacity: " +
                footerBody.getCssValue("opacity"));
        System.out.println("5. Родительский overflow: " +
                footerBody.parent().getCssValue("overflow"));
        System.out.println("6. Позиция в окне: " +
                footerBody.getRect());
        System.out.println("7. Размер окна: " +
                getWebDriver().manage().window().getSize());
        requiredInfoDropDown.scrollTo();
        executeJavaScript("arguments[0].click()", requiredInfoDropDown);
        return this;
    }

    @Step("Закрыть баннер с согласием на использование cookie")
    public MainPage closeCookieBanner() {
        if (cookieBanner.isDisplayed()) {
            acceptButton.click();
            cookieBanner.shouldNotBe(visible, Duration.ofSeconds(5));
        }
        return this;
    }

}