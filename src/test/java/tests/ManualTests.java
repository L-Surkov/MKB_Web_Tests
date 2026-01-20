package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("Страница Раскрытие информации")
@Feature("Логин")
public class ManualTests {

    @Story("Отображение обяательной информации на странице")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка корректного отображения разделов раскрытия информации")
    @Test
    void mkbLoginTest() {
        Allure.step("Открыть главную страницу сайта МКБ Инвестиции https://mkb-am.ru/");
        Allure.step("Перейти в раздел Раскрытие информации");
        Allure.step("Проверить отображение информации в каждом разделе слева");
    }

    @Story("Отображение обяательной информации на странице")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка поиска информации на странице")
    @Test
    void mkbLoginTestFail() {
        Allure.step("Открыть главную страницу сайта МКБ Инвестиции https://mkb-am.ru/");
        Allure.step("Перейти в раздел Раскрытие информации");
        Allure.step("Ввести в форму поиска 'сообщение о выплате' и нажать enter ");
        Allure.step("Проверить отображение релевантных результатов поиска на странице");
    }
}