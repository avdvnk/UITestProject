package enums.pages.docs;

import lombok.Getter;

public enum LeftMenuChapters {
    screenshots("Screenshots");

    @Getter
    private final String value;

    LeftMenuChapters(String value) {
        this.value = value;
    }
}
