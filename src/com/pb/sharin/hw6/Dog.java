package com.pb.sharin.hw6;

import java.util.Objects;

public class Dog extends Animal {

    private String dogName;   //кличка
    private String dogBreed;  //порода
    private String dogСollar; //ошейник

    public Dog(String petName, String dogBreed, String dogСollar) {
        this.dogName  = petName;
        this.dogBreed = dogBreed;
        this.dogСollar = dogСollar;
        this.setPet("Собака");
        this.setFood("кормом для собак");
        this.setNoise("ГАФ-ГАФ");
        this.setLocation("вальер для собак");
    }

    @Override
    public void makeNoise() {
        System.out.println(getPet() + " " + getDogName() + " лает: \""  + getNoise() + "\"");
    }

    @Override
    public void eat() {
        System.out.println(getPet() + " " + getDogName() + " кушает " + getFood());
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogСollar() {
        return dogСollar;
    }

    public void setDogСollar(String dogСollar) {
        this.dogСollar = dogСollar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(dogName, dog.dogName) && Objects.equals(dogBreed, dog.dogBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogName, dogBreed, dogСollar);
    }

    @Override
    public String toString() {
        return "Пес/Собака (" +
                "кличка:'" + dogName + '\'' +
                ", порода:'" + dogBreed + '\'' +
                ", ошейник:'" + dogСollar + '\'' +
                ')';
    }
}
