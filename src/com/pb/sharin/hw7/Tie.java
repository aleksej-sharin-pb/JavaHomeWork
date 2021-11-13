package com.pb.sharin.hw7;

public class Tie extends Clothes implements ManClothes{
    protected Gender gender;

    public Tie(Size size, String color, float price, Gender gender) {
        super(size, color, price);
        setName("Галстук");
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  this.gender + " " + super.toString();
    }

    public String Info() {
        return  this.name +
                " (" + this.gender.getAgeCategory()+ ")" +
                ", Размер: " + this.size +
                ", Цвет: " + this.color +
                ", Цена: " + this.price + " грн.";
    }

    @Override
    public void dressMan() {
        if(this.gender.checkMan()) System.out.println(this.Info());
    }
}
