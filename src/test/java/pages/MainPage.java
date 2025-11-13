package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement
            catalogFilter = $("#catalog-section__filter"),
            phoneInput = $("#phone-number"),
            submitConnectButton = $(".form__btn.btn").shouldHave(text("Свяжитесь с нами")),
            emailInput = $("#email"),
            checkBoxForMailing = $("#ibloks"),
            checkBoxSelectPif = $("#select_pif"),
            checkBoxSelectPifDt = $("#select_dt_pif"),
            submitMailButton = $(".form__btn.btn").shouldHave(text("Подписаться на рассылку")),
            requiredInfoDropDown = $("#info-text__title");


    public MainPage openPage() {
        open(Configuration.baseUrl);

        return this;
    }

    public MainPage setСatalogFilter(String value) {
        catalogFilter.setValue(value);

        return this;
    }

    public MainPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public MainPage submitConnect() {
        submitConnectButton.click();

        return this;
    }

    public MainPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public MainPage submitEmail() {
        submitMailButton.click();

        return this;
    }

    public MainPage setCheckBoxForMailing(String value) {
        checkBoxForMailing.$(byText(value)).click();

        return this;
    }

    public MainPage getRequiredInfoDropDown() {
        requiredInfoDropDown.click();

        return this;
    }


    public MainPage setCheckBoxSelectPif(String value) {
        checkBoxSelectPif.$(byText(value)).click();

        return this;
    }


    public MainPage setCheckBoxSelectPifDt(String value) {
        checkBoxSelectPifDt.$(byText(value)).click();

        return this;
    }

}