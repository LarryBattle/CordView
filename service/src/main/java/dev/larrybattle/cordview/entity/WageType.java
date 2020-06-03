package dev.larrybattle.cordview.entity;

public enum WageType {
    HOURLY("H"),
    ANNUALLY("A");

    private final String name;

    WageType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
