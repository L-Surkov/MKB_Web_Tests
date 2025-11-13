package testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("us"));
    public String
            email = faker.options().option("Email", "emailTest@", "emailTest.ru"),
            userNumber = faker.options().option("7900", "7902785432", "9009921"),
            catalogFilterOption = faker.options().option("Готов принять риски", "Хочу зарабатывать в валюте",
                    "У меня нет опыта в инвестициях "),
            checkBoxMailing = faker.options().option("Паевые инвестиционные фонды",
                    "Информация об управляющей компании", "Расчет размера собственных средств", "Официальные сообщения"),
            checkBoxPifSelection = faker.options().option(
                    "БПИФ рыночных финансовых инструментов «МКБ – Российские Дивидендные Акции»",
                    "БПИФ рыночных финансовых инструментов «РЕГИОН – Индекс МосБиржи государственных облигаций (1-3 года)»",
                    "ЗПИФ рыночных финансовых инструментов «МКБ Золото»",
                    "ЗПИФ рыночных финансовых инструментов «МКБ Технологическая перспектива»");


    public String getPifDtFromPif(String checkBoxMailing) {
        if ("Паевые инвестиционные фонды".equals(checkBoxMailing)) {
            return faker.options().option("Документы фонда", "Информация о фонде", "Отчетность",
                    "Официальные сообщения");
        }
        return null;
    }
}
