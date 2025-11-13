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
                    "Информация об управляющей компании", "Расчет размера собственных средств", "Официальные сообщения");

}
