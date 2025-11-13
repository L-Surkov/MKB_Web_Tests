package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.CheckComponent;
import pages.MainPage;
import testData.TestData;
import helpers.AttachForAllure;

import static io.qameta.allure.Allure.step;

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
    @Description("Проверка отображения главной страницы сайта")
    @Tag("MainPageTests")
    void positiveMainPageIsVisible() {
        step("Открыть страницу сайта МКБ Инвестиции", () -> {
            mainPage.openPage();
        });

        step("Проверить корректное отображение страницы и основого загловка", () -> {
            checkComponent.checkMainPageIsOpen();
        });
    }

    @Test
    @Description("Проверка отображения карточек продуктов при выборе чек-бокса")
    @Tag("MainPageTests")
    void CheckBoxMainPageAndProductCardIsVisible() {
        step("Открыть страницу сайта МКБ Инвестиции", () -> {
            mainPage.openPage();
        });
        step("Проскролить до блока с выбором и выбрать значение", () -> {
            mainPage.setСatalogFilter(testData.catalogFilterOption);
        });

        step("Проверить корректное отображение карточки продукта", () -> {
            checkComponent.checkProductCardWithSelection();
        });

    }

    @Test
    @Description("Проверка невозможности отправки формы с некорректным номером телефона")
    @Tag("MainPageTests")
    void NegativeTestWithConnectionFormOnMainPage() {
        step("Открыть страницу сайта МКБ Инвестиции", () -> {
            mainPage.openPage();
        });
        step("Проскролить до формы связи и ввести некорректный номер телефона", () -> {
            mainPage.setPhone(testData.userNumber);
        });
        step("Нажать на кнопку 'Связаться'", () -> {
            mainPage.submitConnect();
        });

        step("Проверить отображение текста ошибки о некорректности номера телефона", () -> {
            checkComponent.checkConnectionFormError();
        });

    }

    @Test
    @Description("Проверка невозможности отправки формы с некорректным email")
    @Tag("MainPageTests")
    void NegativeTestWithSubscribeFormOnMainPage() {
        step("Открыть страницу сайта МКБ Инвестиции", () -> {
            mainPage.openPage();
        });
        step("Проскролить до формы подписки и ввести некорректный email", () -> {
            mainPage.setEmail(testData.email);
        });
        step("Выбрать раздел для рассылки", () -> {
            mainPage.setCheckBoxForMailing(testData.checkBoxMailing);
        });
        step("Нажать кнопку 'Подписаться на рассылку'", () -> {
            mainPage.submitEmail();
        });

        step("Проверить отображение текста ошибки о некорректности email", () -> {
            checkComponent.checkSubscribeFormError();
        });

    }

    @Test
    @Description("Проверка содержания обязательной информации в футере сайта")
    @Tag("MainPageTests")
    void PositiveFutterTestWithReqInfo() {
        step("Открыть страницу сайта МКБ Инвестиции", () -> {
            mainPage.openPage();
        });
        step("Проскролить до футера, элемента раскрытия", () -> {
            mainPage.getRequiredInfoDropDown();
        });

        step("Проверить содержимое обязательной информации", () -> {
            checkComponent.checkReqInfoInFutter();
        });

    }
}