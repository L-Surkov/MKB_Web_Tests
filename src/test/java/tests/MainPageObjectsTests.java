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


}