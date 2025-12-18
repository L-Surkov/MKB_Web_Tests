package config;

import org.aeonbits.owner.ConfigFactory;
import config.TestConfig;


public enum ConfigReader {
    INSTANCE;

    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class, System.getProperties());

    public TestConfig getConfig() {
        return config;
    }
}
