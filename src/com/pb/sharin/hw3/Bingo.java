package com.pb.sharin.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(
            String[] args) {
        //======================================================================
        System.out.println("hw3 \"Bingo\"");
        System.out.println("Игра \"Bingo\" - угадай число от 0 до 100.");
        //======================================================================
        Scanner scan = new Scanner(System.in);
        int provMenu = 0;
        int provСhoice = 0;
        //======================================================================
        // Меню для пользователя
        //======================================================================
        while (provMenu == 0) {
            System.out.println("1. Новая игра    - нажмите \"1\".");
            System.out.println("2. Выход из игры - нажмите \"2\".");
            System.out.println("Сделайте Ваш выбор:");
            String userСhoice = scan.next();
            provСhoice = Integer.parseInt(userСhoice);

            if (provСhoice == 2) {
                provMenu = 2;
                System.out.println("Bыход.");
                break;
            }
            if (provСhoice == 1) {

                int hiddenNumber, checkedNumber;
                int qtyStep = 0;
                int provNumber = 0;

                Random random = new Random();
                hiddenNumber = random.nextInt(101);
                System.out.println(hiddenNumber);
                System.out.println("Старт игры. Число загадано (от 0 до 100).\nОтгадайте его как можно быстрее!!!");
                System.out.println("Для прекращения отгадывания введите \"-1\".");
                System.out.println("Введите значение:");

                for (; ; qtyStep++) {
                    String userСhoiceGame = scan.next();
                    checkedNumber = Integer.parseInt(userСhoiceGame);
                    if (checkedNumber == -1) {
                        System.out.println("Отгадывание прекращено. Количество попыток: " + qtyStep);
                        break;
                    }
                    if (hiddenNumber == checkedNumber) {
                        System.out.println("Вы отгадали число. Количество попыток: " + (qtyStep+1));
                        break;
                    }
                    provNumber = Math.abs(hiddenNumber - checkedNumber);
                    //System.out.println(provNumber);
                    //================================================================================
                    // Проверяем имеющиеся диапазоны
                    //================================================================================
                    String podskazka = new String();
                    if (51 <= provNumber && provNumber <= 100) podskazka = "\"Очень Холодно\" -";
                    if (30 <= provNumber && provNumber <= 50)  podskazka = "\"Холодно\" -";
                    if (15 <= provNumber && provNumber <= 29)  podskazka = "\"Тепло\" -";
                    if ( 6 <= provNumber && provNumber <= 14)  podskazka = "\"Гаряче\" -";
                    if ( 1 <= provNumber && provNumber <= 5)   podskazka = "\"Жарко\" -";
                    //================================================================================
                    // Добавляем подсказку число кот. ввел пользователь больше или меньше
                    //================================================================================
                    if (hiddenNumber > checkedNumber) {
                        podskazka = podskazka + " загаданное число Больше.";
                    } else
                        podskazka = podskazka + " загаданное число Меньше.";
                    System.out.println(podskazka);
                    continue;
                }
                //break;
                System.out.println("Желаете сыграть еще? :)");
            }
            continue;
        }

        /*
        System.out.println("");
        Scanner scan = new Scanner(System.in);
        int operand1, operand2, qtyStep;
        qtyStep = 0;

        Random random = new Random();
        operand1 = random.nextInt(101);

        System.out.println(x);

        int[] a1 = new int[]{1, 2, 3};
        int[] a2 = new int[]{1, 2, 3};
        int[] a3 = a1;

        boolean isEq12 = a1 == a2;
        boolean isEq13 = a1 == a3;
        System.out.println(isEq12);
        System.out.println(isEq13);

         */
    }
}

