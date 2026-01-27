package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.components.CheckComponent;
import pages.MainPage;
import testData.TestData;

public class MainPageObjectsTests extends TestBase {

    MainPage mainPage = new MainPage();
    CheckComponent checkComponent = new CheckComponent();

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка отображения баннера с корректным текстом о Cookie")
    @DisplayName("Cookie")
    @Tag("MainPageTests")
    void positiveCookieIsVisible() {
        mainPage.openPage();
        checkComponent.checkMainPageIsOpen(TestData.MAIN_PAGE_TITLE);
        checkComponent.checkCookieBannerText(TestData.COOKIE_TEXT_BANNER);
    }


    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка отображения главной страницы сайта")
    @DisplayName("Главная страница сайта")
    @Tag("MainPageTests")
    void positiveMainPageIsVisible() {
        mainPage.openPage();
        checkComponent.checkMainPageIsOpen(TestData.MAIN_PAGE_TITLE);
    }

    @ParameterizedTest(name = "Проверка карточек продуктов при выборе фильтра: {0}")
    @MethodSource("testData.TestData#catalogFilterOptions")
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка отображения карточек продуктов при разных фильтрах")
    @DisplayName("Карточки продуктов — разные фильтры")
    @Tag("MainPageTests")
    void checkBoxMainPageAndProductCardIsVisibleWithFilter(String filterOption) {
        mainPage.openPage();
        mainPage.setСatalogFilter(filterOption);
        checkComponent.checkProductCardWithSelection();
    }

    @ParameterizedTest(name = "Негативный тест: ввод невалидного телефона {0} → ожидается ошибка '{1}'")
    @CsvSource({
            "8999, " + TestData.CONNECTION_ERROR_TEXT,
            "abc, " + TestData.CONNECTION_ERROR_TEXT,
            "+7999768289, " + TestData.CONNECTION_ERROR_TEXT
    })
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка невозможности отправки формы с некорректным номером телефона")
    @DisplayName("Некорректный номер телефона")
    @Tag("MainPageTests")
    void negativeTestWithConnectionFormOnMainPage(String phone, String expectedError) {
        mainPage.openPage();
        mainPage.setPhone(phone);
        mainPage.submitConnect();
        checkComponent.checkConnectionFormError(expectedError);
    }

    @ParameterizedTest(name = "Негативный тест: ввод невалидного email {0} → ожидается ошибка '{1}'")
    @CsvSource({
            "invalid-email, " + TestData.SUBSCRIBE_ERROR_TEXT,
            "@domain.com, " + TestData.SUBSCRIBE_ERROR_TEXT,
            "user@, " + TestData.SUBSCRIBE_ERROR_TEXT,
            "plainaddress, " + TestData.SUBSCRIBE_ERROR_TEXT
    })
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка невозможности отправки формы с некорректным email")
    @DisplayName("Некорректный email")
    @Tag("MainPageTests")
    void negativeTestWithSubscribeFormOnMainPage(String email, String expectedError) {
        mainPage.openPage();
        mainPage.setEmail(email);
        mainPage.setCheckBoxForMailing(TestData.CHECKBOX_MAILING_OPTIONS[0]);
        mainPage.submitEmail();
        checkComponent.checkSubscribeFormError(expectedError);
    }

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка содержания обязательной информации в футере сайта")
    @DisplayName("Обязательная информация на странице")
    @Tag("MainPageTests")
    void positiveFutterTestWithReqInfo() {
        mainPage.openPage();
        mainPage.closeCookieBanner();
        mainPage.getRequiredInfoDropDown();
        checkComponent.checkReqInfoInFutter(TestData.REQUIRED_INFO_PREVIEW);
    }

    @ParameterizedTest(name = "Проверка выбора раздела рассылки: {0}")
    @MethodSource("testData.TestData#checkboxMailingOptions")
    @Story("Главная страница")
    @Severity(SeverityLevel.NORMAL)
    @Owner("allure8")
    @Description("Проверка выбора разных разделов в форме подписки")
    @DisplayName("Выбор раздела рассылки")
    @Tag("MainPageTests")
    void canSelectDifferentMailingOptions(String mailingOption) {
        mainPage.openPage();
        mainPage.setEmail("test@example.com");
        mainPage.setCheckBoxForMailing(mailingOption);
        mainPage.submitEmail();
    }
}