package enums.pages;

import lombok.Getter;

public enum MainMenuPages {
    docs("Docs");
    @Getter
    private final String value;

    MainMenuPages(String value) {
        this.value = value;
    }
}
