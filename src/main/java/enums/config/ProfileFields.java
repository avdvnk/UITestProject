package enums.config;

import lombok.Getter;

/**
 * Enum defines fields in profile to customize test run
 */
public enum ProfileFields {
    enableVNC("enableVNC"),
    enableVideo("enableVideo"),
    sessionTimeout("sessionTimeout"),
    selenoidUrl("selenoidUrl"),
    browser("browser"),
    browserVersion("browserVersion"),
    browserSize("browserSize"),
    browserPosition("browserPosition"),
    baseUrl("baseUrl"),
    startEndpoint("startEndpoint");

    @Getter
    private final String field;

    ProfileFields(String value) {
        this.field = value;
    }
}
