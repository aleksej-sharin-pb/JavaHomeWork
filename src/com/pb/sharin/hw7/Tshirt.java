package com.pb.sharin.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    protected Gender gender;

    public Tshirt(Size size, String color, float price, Gender pol) {
        super(size, color, price);
        setName("Футболка");
        this.gender = pol;
    }

    @Override
    public String toString() {
        return  this.gender.getAgeCategory()  + ", " + this.gender.getGender() + " " + super.toString();
    }

    public String Info() {
        return  this.name +
                " (" + this.gender.getAgeCategory()  + ", " + this.gender.getGender()+ ")" +
                ", Размер: " + this.size + " (" + this.size.getEuroSize() + ")" +
                ", Цвет: " + this.color +
                ", Цена: " + this.price + " грн.";
    }

    @Override
    public void dressMan() {
        if(this.gender.checkMan()) System.out.println(this.Info());
    }

    @Override
    public void dressWomen() {
        if(this.gender.checkWoman()) System.out.println(this.Info());
    }
}
