package com.pb.sharin.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(
            String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;

        String result;

        System.out.println("hw2 \"Interval\"");
        result = "N";
        //================================================================================
        // Блок ввода данных пользователем
        //================================================================================
        System.out.println("Введите целое число для проверки подходящего промежутка:");
        String s = scan.next();
        operand1 = Integer.parseInt(s);
        //================================================================================
        // Проверяем имеющиеся диапазоны
        //================================================================================
        if ( 0 <= operand1 && operand1 <= 14)  result = "[0 - 14]";
        if (15 <= operand1 && operand1 <= 35)  result = "[15 - 35]";
        if (36 <= operand1 && operand1 <= 50)  result = "[36 - 50]";
        if (51 <= operand1 && operand1 <= 100) result = "[51 - 100]";
        //================================================================================
        // Проверяем есть ли диапазон и выводим результат
        //================================================================================
        if (result == "N") {
            System.out.println("Результат:");
            System.out.println("Значение " + operand1 + " НЕ попадает в имеющиеся промежутки.");
        } else {
            System.out.println("Результат:");
            System.out.println("Значение " + operand1 + " попадает в промежуток " + result + ".");
        }
    }
}
