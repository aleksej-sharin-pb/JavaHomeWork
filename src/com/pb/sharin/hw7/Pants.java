package com.pb.sharin.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{

    protected Gender gender;
    private String material;

    public Pants(Size size, String material, String color, float price, Gender gender) {
        super(size, color, price);
        setName("Штаны");
        this.gender = gender;
        this.material = material;
    }

    @Override
    public String toString() {
        return  this.gender + " " + super.toString();
    }

    public String Info() {
        return  this.name +
                " (" + this.gender.getAgeCategory()  + ", " + this.gender.getGender()+ ")" +
                ", Размер: " + this.size + " (" + this.size.getEuroSize() + ")" +
                ", Цвет: " + this.color +
                ", Материал: " + this.material +
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
