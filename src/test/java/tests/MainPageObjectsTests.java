package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.CheckComponent;
import pages.MainPage;
import testData.TestData;
import helpers.AttachForAllure;

public class MainPageObjectsTests extends TestBase {

    MainPage mainPage = new MainPage();
    CheckComponent checkComponent = new CheckComponent();
    TestData testData = new TestData();

    @AfterEach
    void addAttachments() {
        AttachForAllure.screenshotAs("Last screenshot");
        AttachForAllure.pageSource();
        AttachForAllure.browserConsoleLogs();
        AttachForAllure.addVideo();
    }

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка отображения главной страницы сайта")
    @DisplayName("Проверка отображения главной страницы сайта")
    @Tag("MainPageTests")
    void positiveMainPageIsVisible() {
        mainPage.openPage();
        checkComponent.checkMainPageIsOpen();
    }

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка отображения карточек продуктов при выборе чек-бокса")
    @DisplayName("Проверка отображения карточек продуктов при выборе чек-бокса")
    @Tag("MainPageTests")
    void checkBoxMainPageAndProductCardIsVisible() {
        mainPage.openPage();
        mainPage.setСatalogFilter(testData.catalogFilterOption);
        checkComponent.checkProductCardWithSelection();
    }

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка невозможности отправки формы с некорректным номером телефона")
    @DisplayName("Проверка невозможности отправки формы с некорректным номером телефона")
    @Tag("MainPageTests")
    void negativeTestWithConnectionFormOnMainPage() {
        mainPage.openPage();
        mainPage.setPhone(testData.userNumber);
        mainPage.submitConnect();
        checkComponent.checkConnectionFormError();
    }

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка невозможности отправки формы с некорректным email")
    @DisplayName("Проверка невозможности отправки формы с некорректным email")
    @Tag("MainPageTests")
    void negativeTestWithSubscribeFormOnMainPage() {
        mainPage.openPage();
        mainPage.setEmail(testData.email);
        mainPage.setCheckBoxForMailing(testData.checkBoxMailing);
        mainPage.submitEmail();
        checkComponent.checkSubscribeFormError();
    }

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка содержания обязательной информации в футере сайта")
    @DisplayName("Проверка содержания обязательной информации в футере сайта")
    @Tag("MainPageTests")
    void positiveFutterTestWithReqInfo() {
        mainPage.openPage();
        mainPage.closeCookieBanner();
        mainPage.getRequiredInfoDropDown();
        checkComponent.checkReqInfoInFutter();
    }

}