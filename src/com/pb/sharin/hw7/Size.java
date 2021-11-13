package com.pb.sharin.hw7;

public enum Size {
    XXS("32", "Детский размер"),
    XS("34", "Взрослый размер"),
    S("36", "Взрослый размер"),
    M("38", "Взрослый размер"),
    L("40", "Взрослый размер"),
    XL("48-50", "Взрослый размер"),
    XXL("52-54", "Взрослый размер");

    private String EuroSize;
    private String description;

    Size(String EuroSize, String description) {
        this.EuroSize = EuroSize;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEuroSize() {
        return this.EuroSize;
    }
}
