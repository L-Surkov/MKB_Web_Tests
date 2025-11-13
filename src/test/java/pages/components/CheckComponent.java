package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {
    private SelenideElement mainTitle = $("#hero__title"),
            productCard = $("#product-card"),
            connectionFormError = $("#form-message form-error"),
            subscribeFormError = $("#form-message sub form-error"),
            reqInfoInFutter = $("#info-text__body-inner");

    public CheckComponent checkMainPageIsOpen() {
        mainTitle.shouldHave(text("ОПИФ рыночных финансовых инструментов «МКБ Денежный рынок»"));

        return this;
    }

    public CheckComponent checkProductCardWithSelection() {
        productCard.shouldBe(visible);

        return this;
    }

    public CheckComponent checkConnectionFormError() {
        connectionFormError.shouldNotBe(visible);
        connectionFormError.shouldHave(text("Некорректный номер телефона"));

        return this;
    }

    public CheckComponent checkSubscribeFormError() {
        subscribeFormError.shouldNotBe(visible);
        subscribeFormError.shouldHave(text("Email адрес введён некорректно"));

        return this;
    }

    public CheckComponent checkReqInfoInFutter() {
        reqInfoInFutter.shouldHave(text(
                "Акционерное общество «Управляющая компания «МКБ Инвестиции» (АО «УК МКБ Инвестиции») " +
                        "Государственный регистрационный номер (при создании) № 055.391 от 19.04.1996, " +
                        "ОГРН 1027700590301. "));

        return this;
    }

}
