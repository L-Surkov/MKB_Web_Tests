package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Страница Раскрытие информации")
@Feature("Логин")
public class ManualTests {

    @Story("Отображение обязательной информации на странице")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка корректного отображения разделов раскрытия информации")
    @DisplayName("Раздел раскрытия информации")
    @Test
    @Tag("MainPageTests")
    void mkbLoginTest() {
        Allure.step("Открыть главную страницу сайта МКБ Инвестиции https://mkb-am.ru/");
        Allure.step("Перейти в раздел Раскрытие информации");
        Allure.step("Проверить отображение информации в каждом разделе слева");
    }

    @Story("Отображение обязательной информации на странице")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @DisplayName("Раздел раскрытия информации - поиск")
    @Description("Проверка поиска информации на странице раскрытия информации")
    @Test
    @Tag("MainPageTests")
    void mkbLoginTestFail() {
        Allure.step("Открыть главную страницу сайта МКБ Инвестиции https://mkb-am.ru/");
        Allure.step("Перейти в раздел Раскрытие информации");
        Allure.step("Ввести в форму поиска 'сообщение о выплате' и нажать enter ");
        Allure.step("Проверить отображение релевантных результатов поиска на странице");
    }
}