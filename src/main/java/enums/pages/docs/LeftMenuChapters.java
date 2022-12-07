package enums.pages.docs;

import lombok.Getter;

/**
 * Enum with chapters on Docs page
 */
public enum LeftMenuChapters {
    screenshots("Screenshots");

    @Getter
    private final String value;

    LeftMenuChapters(String value) {
        this.value = value;
    }
}
