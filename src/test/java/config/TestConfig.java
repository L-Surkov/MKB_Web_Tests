package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:${configMode}.properties"
})
public interface TestConfig extends Config {

    @Key("browser.name")
    @DefaultValue("chrome")
    String browser();

    @Key("browser.version")
    @DefaultValue("128.0")
    String browserVersion();

    @Key("remote")
    @DefaultValue("false")
    boolean remote();

    @Key("remote.url")
    @DefaultValue("")
    String remoteUrl();

    @Key("baseUrl")
    @DefaultValue("https://mkb-am.ru")
    String baseUrl();

    @Key("pageLoadStrategy")
    @DefaultValue("eager")
    String pageLoadStrategy();

    @Key("enableVNC")
    @DefaultValue("false")
    boolean enableVNC();

    @Key("enableVideo")
    @DefaultValue("false")
    boolean enableVideo();
}
