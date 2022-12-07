package enums.pages;

import lombok.Getter;

/**
 * Enum defines pages in main menu
 */
public enum MainMenuPages {
    docs("Docs");
    @Getter
    private final String value;

    MainMenuPages(String value) {
        this.value = value;
    }
}
