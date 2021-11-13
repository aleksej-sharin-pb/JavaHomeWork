package com.pb.sharin.hw7;

public class Atelier {

    public static void dressMan(Clothes[] clothes) {
        int qty = clothes.length;
        int i = 1; //переменная для проставления разделителей
        System.out.println("Список мужской одежды:");
        for (Clothes odezhda : clothes) {

            if (odezhda instanceof Tshirt) {
                Tshirt tshirt = (Tshirt) odezhda;
                if (tshirt.gender.checkMan()) {
                    System.out.print(i + ". ");
                    tshirt.dressMan();
                    i++;
                }
            }
            if (odezhda instanceof Pants) {
                Pants pants = (Pants) odezhda;
                if (pants.gender.checkMan()) {
                    System.out.print(i + ". ");
                    pants.dressMan();
                    i++;
                }
            }
            if (odezhda instanceof Tie ) {
                Tie tie = (Tie ) odezhda;
                if (tie.gender.checkMan()) {
                    System.out.print(i + ". ");
                    tie.dressMan();
                    i++;
                }
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        int i = 1; //переменная для проставления разделителей
        System.out.println("Список женской одежды:");
        for (Clothes odezhda : clothes) {
            if (odezhda instanceof Tshirt) {
                Tshirt tshirt = (Tshirt) odezhda;
                if (tshirt.gender.checkWoman()) {
                    System.out.print(i + ". ");
                    tshirt.dressWomen();
                    i++;
                }
            }
            if (odezhda instanceof Pants) {
                Pants pants = (Pants) odezhda;
                if (pants.gender.checkWoman()) {
                    System.out.print(i + ". ");
                    pants.dressWomen();
                    i++;
                }
            }
            if (odezhda instanceof Skirt  ) {
                Skirt skirt = (Skirt) odezhda;
                if (skirt.gender.checkWoman()) {
                    System.out.print(i + ". ");
                    skirt.dressWomen();
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        //==================================================================================
        //Создание одежды
        //==================================================================================
        //Футболки
        Tshirt tshirt_01M = new Tshirt(Size.XL, "зеленый", 300, Gender.MAN);
        Tshirt tshirt_02W = new Tshirt(Size.M, "берюзовый", 400, Gender.WOMAN);
        Tshirt tshirt_03B = new Tshirt(Size.XXS, "белый", 200, Gender.BOY);
        Tshirt tshirt_04G = new Tshirt(Size.XXS, "желтый", 600, Gender.GIRL);
        //штаны
        Pants  pants_05M = new Pants(Size.XXL, "джинс", "черный",1300, Gender.MAN);
        Pants  pants_06M = new Pants(Size.S, "шелк","черный", 1970, Gender.WOMAN);
        //юбка
        Skirt skirt_07W = new Skirt(Size.M, "вечернее","красный", 1200, Gender.WOMAN);
        Skirt skirt_08G = new Skirt(Size.XXS, "мини","желтый", 800, Gender.GIRL);
        //галстук
        Tie tie_09M = new Tie(Size.XL, "темно-синий", 800, Gender.MAN);
        Tie tie_10B = new Tie(Size.XXS, "черный", 300, Gender.BOY);
        //==================================================================================
        //Демонстрация
        //==================================================================================
        System.out.println("--================================================================================--");
        System.out.println("Пример реализации метода \"getEuroSize\":");
        System.out.println(tshirt_01M.size.getEuroSize());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Пример реализации метода \"toString\":");
        System.out.println(tshirt_01M.toString());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Пример реализации метода \"dressMan\":");
        tie_09M.dressMan();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Пример реализации метода \"dressWomen\":");
        skirt_07W.dressWomen();
        System.out.println("--================================================================================--");
        //==================================================================================
        //Демострация через обработку массива одежды
        //==================================================================================
        Clothes[] clothes = new Clothes[]{  tshirt_01M, tshirt_02W, tshirt_03B, tshirt_04G,
                                            pants_05M, pants_06M,
                                            skirt_07W, skirt_08G,
                                            tie_09M, tie_10B
                                         };
        //==================================================================================
        //список мужской одежды
        dressMan(clothes);
        System.out.println("---------------------------------------------------------------------");
        //список женской одежды
        dressWomen(clothes);
        System.out.println("--================================================================================--");
    }
}
