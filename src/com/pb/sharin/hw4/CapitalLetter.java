package com.pb.sharin.hw4;

import java.util.Scanner;

public class CapitalLetter {
    //===========================================================================
    //Методы для работы приложения
    //===========================================================================
    //Метод для вывода меню и выбора пользователя
    //===========================================================================
    static int startMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("--============================================--");
        System.out.println("1. Ввод предложения пользователем - нажмите \"1\".");
        System.out.println("2. Демонстрация работы на примере - нажмите \"2\".");
        System.out.println("3. Выход из приложения            - нажмите \"0\".");
        System.out.println("Сделайте Ваш выбор:");

        String userСhoice = scan.next();
        return Integer.parseInt(userСhoice);
    }

    //===========================================================================
    //Метод для вывода предложения
    //===========================================================================
    static void userVvod() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите предложение:");
        String userStr = new String();
        userStr = scan.nextLine();
        WordsUpper(userStr);
    }

    //===========================================================================
    //Метод для перевода 1-й буквы слов в верхний регистр
    //===========================================================================
    static void WordsUpper(String str) {
        char[] chArray = str.toCharArray();
        //перебираем все элементы массива
        for (int i = 0; i < chArray.length; i++) {
            //проверяем если первый символ не пробел - переводим в верхнем регистр
            if (chArray[0] != ' ') {
                //заменяем сивол после пробела на символ в верхнем регистре
                chArray[0] = Character.toUpperCase(chArray[0]);
            }
            if ((chArray[i] == ' ') && (chArray[i + 1] != ' ')) {
                //заменяем сивол после пробела на символ в верхнем регистре
                if ((i + 1) <= chArray.length) chArray[i + 1] = Character.toUpperCase(chArray[i + 1]);
            }
        }
        //выводим результат
        System.out.println("Было:  " + str);
        System.out.print("Стало: ");
        System.out.println(chArray);
    }
    //===========================================================================
    //Оснвной блок программы
    //===========================================================================
    public static void main(
            String[] args) {
        //======================================================================
        System.out.println("hw4 \"CapitalLetter\"");
        System.out.println("Методы и строки");
        //======================================================================
        int provMenu = 0; //переменная для условия работы приложения
        int provСhoice = 0; //выбор пользователя
        //======================================================================
        while (provMenu == 0) {
            provСhoice = startMenu(); //получаем значение из метода для вывода меню и выбора пользователя

            if (provСhoice == 3) {
                provMenu = 3;
                System.out.println("Bыход.");
                break;
            }
            if (provСhoice == 1) { //вызов метода для ввода предложения,а в нем вызываем метод для перевода в верхний регистр
                userVvod();
                continue;
            }
            if (provСhoice == 2) {
                System.out.println("Демонстрация:");
                String primer = "Истина — это то, что выдерживает проверку опытом. Эйнштейн А.";
                WordsUpper(primer); //метод для перевода в верхний регистр
                continue;
            }
            System.out.println("Желаете продолжить работу?");
            continue;
        }
    }
}
