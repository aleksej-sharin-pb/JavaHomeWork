package com.pb.sharin.hw7;

public class Skirt extends Clothes implements WomenClothes{

    protected Gender gender;
    private   String style;

    public Skirt(Size size, String style, String color, float price, Gender gender) {
        super(size, color, price);
        setName("Юбка");
        this.gender = gender;
        this.style = style;
    }

    @Override
    public String toString() {
        return  this.gender + " " + super.toString();
    }

    public String Info() {
        return  this.name +
                " (" + this.gender.getAgeCategory()+ ")" +
                ", Фасон: " + this.style +
                ", Размер: " + this.size +
                ", Цвет: " + this.color +
                ", Цена: " + this.price + " грн.";
    }

    @Override
    public void dressWomen() {
        if(this.gender.checkWoman()) System.out.println(this.Info());
    }
}
