package com.pb.sharin.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private String catName;
    private String catBreed;

    public Cat(String catName, String catBreed) {
        this.catName  = catName;
        this.catBreed = catBreed;
        this.setPet("Кошка");
        this.setFood("кормом для кошек");
        this.setNoise("МЯУ-МЯУ");
        this.setLocation("клетка для кошек");
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatBreed() {
        return catBreed;
    }

    public void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }

    @Override
    public void makeNoise() {
        System.out.println(getPet() + " " + getCatName() + " маукает: \""  + getNoise() + "\"");
    }

    @Override
    public void eat() {
        System.out.println(getPet() + " " + getCatName() + " кушает " + getFood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(catName, cat.catName) && Objects.equals(catBreed, cat.catBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catName, catBreed);
    }

    @Override
    public String toString() {
        return "Кот/Кошка (" +
                "кличка:'" + catName + '\'' +
                ", порода:'" + catBreed + '\'' +
                ')';
    }
}
