package com.pb.sharin.hw6;

import java.util.Objects;

public class Horse extends Animal{

    private String horseName;
    private String horseBreed;

    public Horse(String petName, String horseBreed) {
        this.horseName  = petName;
        this.horseBreed = horseBreed;
        this.setPet("Лошадь");
        this.setFood("сухим сеном");
        this.setNoise("И-ГО-ГО");
        this.setLocation("загон для лошадей");
    }

    @Override
    public void makeNoise() {
        System.out.println(getPet() + " " + getHorseName() + " делает: \""  + getNoise() + "\"");
    }

    @Override
    public void eat() {
        System.out.println(getPet() + " " + getHorseName() + " кушает " + getFood());
    }
    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getHorseBreed() {
        return horseBreed;
    }

    public void setHorseBreed(String horseBreed) {
        this.horseBreed = horseBreed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(horseName, horse.horseName) && Objects.equals(horseBreed, horse.horseBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horseName, horseBreed);
    }

    @Override
    public String toString() {
        return "Конь/Лошадь (" +
                "кличка:'" + horseName + '\'' +
                ", порода:'" + horseBreed + '\'' +
                ')';
    }
}
