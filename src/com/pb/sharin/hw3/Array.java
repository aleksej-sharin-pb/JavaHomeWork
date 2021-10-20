package com.pb.sharin.hw3;

import java.util.Scanner;

public class Array {
    public static void main(
            String[] args) {
        //======================================================================
        System.out.println("hw3 \"Array\"");
        System.out.println("Работа с одномерным массивом.");
        //======================================================================
        Scanner scan = new Scanner(System.in);
        int[] arrayBase = new int[10];
        int[] arrayPositive = new int[10];
        int[] arraySort = new int[10];
        //=============================================
        int provMenu = 0;
        int provСhoice = 0;
        //======================================================================
        // Меню для пользователя
        //======================================================================
        while (provMenu == 0) {
            System.out.println("--=============================================================--");
            System.out.println("1. Создать массив и внести значения в ручную    - нажмите \"1\".");
            System.out.println("2. Создать массив и внести значения рандомно    - нажмите \"2\".");
            System.out.println("3. Вывести на экран введенный массив            - нажмите \"3\".");
            System.out.println("4. Подсчитать сумму всех элементов массива      - нажмите \"4\".");
            System.out.println("5. Подсчитать и вывести кол-во \"+\" элементов    - нажмите \"5\".");
            System.out.println("6. Произвести сортировку массива                - нажмите \"6\".");
            System.out.println("7. Выход из приложения                          - нажмите \"0\".");
            System.out.println("--=============================================================--");
            System.out.println("Сделайте Ваш выбор:");
            String userСhoice = scan.next();
            provСhoice = Integer.parseInt(userСhoice);

            switch (provСhoice) {
                case 0: {
                    provMenu = 2;
                    System.out.println("Bыход.");
                    break;
                }
                case 1: {  //1. Создать массив и внести значения в ручную
                    Scanner arrInsert = new Scanner(System.in);
                    System.out.println("Введите значения массива:");
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {

                        System.out.print("для " + (qtyElem + 1) + "-го элемента ");
                        arrayBase[qtyElem] = Integer.parseInt(arrInsert.next());
                    }
                    break;
                }
                case 2: { //2. Создать массив и внести значения рандомно
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        arrayBase[qtyElem] = (int) (Math.random() * 100);
                    }
                    System.out.println("Значения массива:");
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        System.out.print(arrayBase[qtyElem] + "; ");
                    }
                    System.out.println("\n");
                    break;
                }
                case 3: { //3. Вывести на экран введенный массив
                    System.out.println("Значения массива:");
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        System.out.print(arrayBase[qtyElem] + "; ");
                    }
                    System.out.println("\n");
                    break;
                }
                case 4: { //Подсчитать сумму всех элементов массива
                    int arrSum = 0;
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        arrSum = arrSum + arrayBase[qtyElem];
                    }
                    System.out.println("Сумма всех значений:" + arrSum);
                    break;
                }
                case 5: { //Подсчитать и вывести кол-во "+" элементов
                    int qtyNewArr = 0;
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        if (0 < arrayBase[qtyElem]) qtyNewArr++;
                    }

                    int qtyNewElem = 0;
                    int[] array = new int[qtyNewArr];
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        if (0 < arrayBase[qtyElem]) {
                            array[qtyNewElem] = arrayBase[qtyElem];
                            qtyNewElem++;
                        }
                    }
                    arrayPositive = array;
                    System.out.println("Массив положительных значений состоит из:" + arrayPositive.length + " элементов, значения: ");
                    for (int qtyElem = 0; qtyElem < arrayPositive.length; qtyElem++) {
                        System.out.print(arrayPositive[qtyElem] + "; ");
                    }
                    System.out.println("\n");
                    break;
                }
                case 6: { //Произвести сортировку массива
                    // Копируем массив для сортировки
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        arraySort[qtyElem] = arrayBase[qtyElem];
                    }
                    //====================================================
                    // Сортировка пузырьковым методом
                    //====================================================
                    // i - номер прохода
                    for (int i = 0; i < arraySort.length - 1; i++) {
                        // внутренний цикл прохода
                        for (int j = arraySort.length - 1; j > i; j--) {
                            if (arraySort[j - 1] > arraySort[j]) {
                                int tmp = arraySort[j - 1];      //временное значение, для замены местами
                                arraySort[j - 1] = arraySort[j];
                                arraySort[j] = tmp;
                            }
                        }
                    }
                    //=======================================================
                    //Выводим основной и отсортерованный массив
                    //=======================================================
                    System.out.println("Значения массива:");
                    System.out.print("Было:");
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        System.out.print(arrayBase[qtyElem] + "; ");
                    }
                    System.out.print("\nСтало:");
                    for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                        System.out.print(arraySort[qtyElem] + "; ");
                    }
                    System.out.println("\n");
                    break;
                }

            }
            continue;
        }
    }
}