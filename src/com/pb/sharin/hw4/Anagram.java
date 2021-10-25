package com.pb.sharin.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    //===========================================================================
    //Методы для работы приложения
    //===========================================================================
    //Метод для вывода меню и выбора пользователя
    //===========================================================================
    static int startMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("--============================================--");
        System.out.println("1. Ввод предложений для проверки на анаграмму - нажмите \"1\".");
        System.out.println("2. Демонстрация анаграммы на примере          - нажмите \"2\".");
        System.out.println("3. Выход из приложения                        - нажмите \"0\".");
        System.out.println("Сделайте Ваш выбор:");

        String userСhoice = scan.next();

        int y = 0;
        try {
            y = Integer.parseInt(userСhoice);
        } catch (Exception e) {
            System.out.println("Вы ввели не число (" + userСhoice + ")");
            userСhoice = "0";
        }
        return Integer.parseInt(userСhoice);
    }

    //===========================================================================
    //Метод для вывода предложений, передаем номер ввода, результат возвращаем
    //===========================================================================
    static String userVvod(int numStr) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите " + numStr + " предложение:");
        String userStr = new String();
        userStr = scan.nextLine();
        return userStr;
    }

    //===========================================================================
    //Метод для преобразавания строк и проверки их на анаграмму
    //===========================================================================
    static boolean provAnagram(String str1, String str2) {
        //System.out.println("Детализация по работе метода по проверке Анаграмы:");
        //убираем знаки пунктуации и переводим в нижний регистр
        String strM1 = str1.replaceAll("\\p{Punct}", "").toLowerCase();
        String strM2 = str2.replaceAll("\\p{Punct}", "").toLowerCase();

        //убираем пробелы
        strM1 = strM1.replaceAll(" ", "");
        strM2 = strM2.replaceAll(" ", "");

        //Вывод стоки без учета регистра
            //System.out.println(strM1);
            //System.out.println(strM2);

        //проверяем строки на кол-во символов
        if (strM1.length() != strM2.length()) {
            return false;
        }
        //переводим строки в массив сиволов
        char[] arrM1 = strM1.toCharArray();
        char[] arrM2 = strM2.toCharArray();
        //сортируем массивы символов
        Arrays.sort(arrM1);
        Arrays.sort(arrM2);
        //=================================================================
        //вариант 1 - проверкой строк
        //=================================================================
        //возвращаем массивы в строки
            strM1 = Arrays.toString(arrM1);
            strM2 = Arrays.toString(arrM2);
        //проверяем методом для сравнения строк
            //System.out.println(strM1.compareToIgnoreCase(strM2));
        //выводим строки для наглядности
            //System.out.println(strM1);
            //System.out.println(strM2);
        //=================================================================
        //вариант 2 - проверяем массивы
        //=================================================================
        return Arrays.equals(arrM1, arrM2);
        //=================================================================
    }

    //===========================================================================
    //Оснвной блок программы
    //===========================================================================
    public static void main(
            String[] args) {
        //======================================================================
        System.out.println("hw4 \"Anagram\"");
        System.out.println("Методы и строки");
        //======================================================================
        int provMenu = 0; //переменная для условия работы приложения
        int provСhoice = 0; //выбор пользователя
        //======================================================================
        while (provMenu == 0) {
            //получаем значение из метода для вывода меню и выбора пользователя
            provСhoice = startMenu(); //меню выводим 1 раз, для экономии экрана

            if (provСhoice == 3) {//Выходи из цикла и программы
                provMenu = 3;
                System.out.println("Bыход.");
                break;
            }
            if (provСhoice == 1) { //вызов метода для ввода предложения,а в нем вызываем метод для перевода в верхний регистр
                int num1 = 1;
                int num2 = 2;

                String userStr1, userStr2 = new String();

                userStr1 = userVvod(num1);
                userStr2 = userVvod(num2);

                boolean res = provAnagram(userStr1, userStr2);
                System.out.println((res) ? "Анаграмма" : "Не Анаграмма");
                continue;
            }
            if (provСhoice == 2) {
                System.out.println("Демонстрация:");
                String primer1 = "Аз есмь строка, живу я, мерой остр.";
                String primer2 = "За семь морей ростка я вижу рост.";
                System.out.println("Предложение №1: " + primer1);
                System.out.println("Предложение №2: " + primer2);
                boolean res = provAnagram(primer1, primer2);
                System.out.println((res) ? "Анаграмма" : "Не Анаграмма");
                continue;
            }
            System.out.println("Желаете продолжить работу?");
            continue;
        }
    }
}
