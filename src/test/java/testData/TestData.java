package testData;

import java.util.stream.Stream;

public class TestData {
    public static final String REQUIRED_INFO_PREVIEW = "** Государственная поддержка заключается в предоставлении налогового вычета на сумму взноса на индивидуальный инвестиционный счет (максимум 52 тыс. руб. в год) или на сумму положительного финансового результата, полученного по операциям, учитываемым на индивидуальном инвестиционном счете. " +
            "Налоговый вычет предоставляется при соблюдении условий получения такого вычета, содержащихся в законодательстве Российской Федерации. ";
    public static final String CONNECTION_ERROR_TEXT = "Некорректный номер телефона";
    public static final String SUBSCRIBE_ERROR_TEXT = "Email адрес введён некорректно";
    public static final String MAIN_PAGE_TITLE = "ОПИФ рыночных финансовых инструментов «МКБ Денежный рынок»";
    public static final String COOKIE_TEXT_BANNER = "Продолжая использовать наш сайт, вы даете согласие на обработку файлов cookie, пользовательских данных (сведения о местоположении; тип и версия ОС; тип и версия Браузера; тип устройства и разрешение его экрана; источник откуда пришел на сайт пользователь; с какого сайта или по какой рекламе; язык ОС и Браузера; какие страницы открывает и на какие кнопки нажимает пользователь; ip-адрес) в целях функционирования сайта, проведения ретаргетинга и проведения статистических исследований и обзоров. Если вы не хотите, чтобы ваши данные обрабатывались, покиньте сайт.";
    public static final String[] CATALOG_FILTER_OPTIONS = {
            "Готов принять риски",
            "Хочу зарабатывать в валюте",
            "У меня нет опыта в инвестициях"
    };

    public static final String[] CHECKBOX_MAILING_OPTIONS = {
            "Информация об управляющей компании",
            "Расчет размера собственных средств",
            "Официальные сообщения"
    };

    public static Stream<String> catalogFilterOptions() {
        return Stream.of(CATALOG_FILTER_OPTIONS);
    }

    public static Stream<String> checkboxMailingOptions() {
        return Stream.of(CHECKBOX_MAILING_OPTIONS);
    }
}
