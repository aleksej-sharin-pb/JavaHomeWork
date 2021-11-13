package com.pb.sharin.hw7;

public abstract class Clothes {
    protected String name;
    protected Size   size;
    protected String color;
    protected float  price;

    public Clothes(Size size, String color, float price) {
        this.size  = size;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "одежда (" +
                " " + name +
                ", Размер: " + size +
                ", Цвет: " + color +
                ", Цена: " + price + " грн.)";
    }
}
