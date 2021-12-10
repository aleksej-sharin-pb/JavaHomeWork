package com.pb.sharin.hw10;

public class Main {
    public static void main(String[] args) {
        System.out.println("hw10 \"Generic\"");
        //==============================================================
        //Демонстрация работы с Generic - Integer
        System.out.println("--================== " +
                           " NumBox<Integer>" +
                           " ==================--");
        NumBox<Integer> intBox = new NumBox(10); //создаем массив на 4 элемента
        intBox.print(); //выводим массив - а он пустой
        System.out.println("Кол-во елементов: " + intBox.length());

        int int1 = 2;
        int int2 = 5;
        int int3 = 3;
        int int4 = 6;

        try {
            System.out.println("Вывод 2-го елемента в пустом массиве: " + intBox.get(1));
            System.out.println("--------------------------------------------------------");
            intBox.add(int1);
            intBox.add(int2);
            System.out.println("Кол-во елементов: " + intBox.length());
            System.out.println("--------------------------------------------------------");
            System.out.println("Вывод 2-го елемента: " + intBox.get(1));
            System.out.println("Вывод 1-го елемента: " + intBox.get(0));
            intBox.add(int3);
            intBox.add(int4);
        } catch (Exception e1) {
            System.out.println("Ошибка добавления. Сообщение: " + e1);
        }
        System.out.println("Кол-во елементов: " + intBox.length());
        intBox.print();
        System.out.println("--------------------------------------------------------");
        System.out.println("maxValue: " + intBox.max());
        System.out.println("avgValue: " + intBox.average());
        System.out.println("--------------------------------------------------------");
        //==============================================================
        //Демонстрация работы с Generic - Float
        System.out.println("--================== " +
                " NumBox<Float>" +
                " ==================--");
        NumBox<Float> floatBox = new NumBox(2);
        float float1 = 11;
        float float2 = 55;
        float float3 = 33;

        try {
            System.out.println("Вывод 2-го елемента в пустом массиве: " + floatBox.get(1));
            System.out.println("--------------------------------------------------------");
            floatBox.add(float1);
            floatBox.add(float2);
            floatBox.print();
            System.out.println("Кол-во елементов: " + floatBox.length());
            System.out.println("--------------------------------------------------------");
            System.out.println("Вывод 3-го елемента, кот. нет (если нет выведется 0-й): " + floatBox.get(3));
            System.out.println("Хотим добавить 3-й елемент в 2-х размерный массив. ");
            floatBox.add(float3);
        } catch (Exception e1) {
            System.out.println("Ошибка добавления. Сообщение: " + e1);
        }

    }
}
