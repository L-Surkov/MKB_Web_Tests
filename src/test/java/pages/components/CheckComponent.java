package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {

    private final SelenideElement
            mainTitle = $(".hero__title"),
            productCard = $(".product-card"),
            connectionFormError = $("#MANAGER_FEEDBACK .form-message.form-error"),
            subscribeFormError = $("#SUBSCRIBE_MAILING .form-message.sub.form-error"),
            cookieBanner = $(".coocke__inner"),
            reqInfoInFutter = $(".info-text__body p:nth-child(2)");


    @Step("Проверить, что заголовок содержит текст '{expectedText}'")
    public CheckComponent checkMainPageIsOpen(String expectedText) {
        mainTitle.shouldHave(Condition.text(expectedText));
        return this;
    }

    @Step("Проверить отображение карточки продукта")
    public CheckComponent checkProductCardWithSelection() {
        productCard.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить сообщение об ошибке в форме связи: '{expectedError}'")
    public CheckComponent checkConnectionFormError(String expectedError) {
        connectionFormError.shouldBe(Condition.visible);
        connectionFormError.shouldHave(Condition.text(expectedError));
        return this;
    }

    @Step("Проверить сообщение об ошибке в форме подписки: '{expectedError}'")
    public CheckComponent checkSubscribeFormError(String expectedError) {
        subscribeFormError.shouldBe(Condition.visible);
        subscribeFormError.shouldHave(Condition.text(expectedError));
        return this;
    }

    @Step("Проверить обязательную информацию в футере: содержит '{expectedText}'")
    public CheckComponent checkReqInfoInFutter(String expectedText) {
        reqInfoInFutter.shouldBe(Condition.visible);
        reqInfoInFutter.shouldHave(Condition.text(expectedText));
        return this;
    }

    @Step("Проверить корректность текста в баннере Cookie")
    public CheckComponent checkCookieBannerText(String bannerText) {
        cookieBanner.shouldBe(Condition.visible);
        cookieBanner.shouldHave(Condition.text(bannerText));
        return this;
    }
}