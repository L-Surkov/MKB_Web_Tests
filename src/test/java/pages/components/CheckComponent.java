package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {
    private SelenideElement mainTitle = $(".hero__title"),
            productCard = $(".product-card"),
            connectionFormError = $(".form-message.form-error"),
            subscribeFormError = $("#SUBSCRIBE_MAILING .form-message.sub.form-error"),
            reqInfoInFutter = $(".info-text__body p:nth-child(2)");

    public CheckComponent checkMainPageIsOpen() {
        mainTitle.shouldHave(text("ОПИФ рыночных финансовых инструментов «МКБ Денежный рынок»"));

        return this;
    }

    public CheckComponent checkProductCardWithSelection() {
        productCard.shouldBe(visible);

        return this;
    }

    public CheckComponent checkConnectionFormError() {
        connectionFormError.shouldBe(visible);
        connectionFormError.shouldHave(text("Некорректный номер телефона"));

        return this;
    }

    public CheckComponent checkSubscribeFormError() {
        subscribeFormError.shouldBe(visible);
        subscribeFormError.shouldHave(text("Email адрес введён некорректно"));

        return this;
    }

    public CheckComponent checkReqInfoInFutter() {
        reqInfoInFutter.shouldBe(visible, Duration.ofSeconds(10));
        reqInfoInFutter.shouldHave(text(
                "** Государственная поддержка заключается в предоставлении налогового вычета на сумму взноса на индивидуальный инвестиционный счет (максимум 52 тыс. руб. в год) или на сумму положительного финансового результата, полученного по операциям, учитываемым на индивидуальном инвестиционном счете. " +
                        "Налоговый вычет предоставляется при соблюдении условий получения такого вычета, содержащихся в законодательстве Российской Федерации. "));

        return this;
    }

}
