package ru.rumter.kfr.koala.web.helper;

public enum ResponseStatusEnum {

    SUCCESS("success"),
    ERROR("error");

    private String value;

    private ResponseStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
