package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigReader;
import config.TestConfig;
import helpers.AttachForAllure;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.MutableCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setupEnvironment() {
        TestConfig config = ConfigReader.INSTANCE.getConfig();

        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.baseUrl = config.baseUrl();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();

        String remoteUrl = System.getProperty("remote.url", config.remoteUrl());
        if (config.remote()) {
            Configuration.remote = config.remoteUrl();
            MutableCapabilities browserOptions = new MutableCapabilities();
            browserOptions.setCapability("selenoid:options", Map.of(
                    "enableVNC", config.enableVNC(),
                    "enableVideo", config.enableVideo()
            ));
            Configuration.browserCapabilities = browserOptions;
        } else {
            Configuration.remote = null;
            Configuration.browserCapabilities = new MutableCapabilities();
        }


        System.out.println("→ Режим: " + (config.remote() ? "Удалённый" : "Локальный"));
        System.out.println("→ Browser: " + Configuration.browser);
        System.out.println("→ Base URL: " + Configuration.baseUrl);
    }

    @BeforeEach
    void addSelenideLogger() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        AttachForAllure.screenshotAs("Last screenshot");
        AttachForAllure.pageSource();
        AttachForAllure.browserConsoleLogs();
        AttachForAllure.addVideo();
        SelenideLogger.removeListener("AllureSelenide");
        closeWebDriver();
    }
}
