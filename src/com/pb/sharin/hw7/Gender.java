package com.pb.sharin.hw7;

public enum Gender {
    MAN("мужская", "На взрослого"),
    WOMAN("женская", "На взрослого"),
    BOY("на мальчика", "Детская"),
    GIRL("на девочку", "Детская");

    private String gender;
    private String ageCategory;

    Gender(String gender, String ageCategory) {
        this.gender = gender;
        this.ageCategory = ageCategory;
    }

    public String getGender() {
        return this.gender;
    }

    public String getAgeCategory() {
        return this.ageCategory;
    }

    public boolean checkMan() {
        if (this == MAN || this == BOY) return true;
        return false;
    }

    public boolean checkWoman() {
        if (this == WOMAN || this == GIRL ) return true;
        return false;
    }
}
