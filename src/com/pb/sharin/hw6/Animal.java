package com.pb.sharin.hw6;

public class Animal {

    private String pet;      //Домашнее животное
    private String food;     //Еда
    private String location; //Место нахождения
    private String Noise;    //Звук животного

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getNoise() {
        return Noise;
    }

    public void setNoise(String noise) {
        Noise = noise;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise(){
        System.out.println(getPet() + " издает " + Noise);
    }

    public void eat(){
        System.out.println(getPet() + " кушает" + getFood());
    }

    public void sleep(){
        System.out.println(getPet() + " спит.");
    }
}
