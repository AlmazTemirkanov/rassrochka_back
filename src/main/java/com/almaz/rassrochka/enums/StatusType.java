package com.almaz.rassrochka.enums;

public enum StatusType {
    DEFAULTER("DEFAULTER"), // Добросовестный
    EXPIRED("EXPIRED"),
    FRAUD("FRAUD"), // Аферист
    PRISONER("PRISONER"), //Подсудимый
    DONE("DONE"),
    DELAY("DELAY"), // Затягивает
    WAIT("WAIT");
    private final String value;

    StatusType (String value) {
        this.value = value;
    }

    public static StatusType getByValue(String code) {
        for (StatusType e : StatusType.values()) {
            if (e.value.equals(code)) {
                return e;
            }
        }
        return null;
    }
    public String getValue () {
        return value;
    }

}
