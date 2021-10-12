package com.pb.sharin.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(
            String[] args) {

        Scanner scan = new Scanner(System.in);
        int operand1, operand2;
        float result = 0;

        String sign, error;

        System.out.println("hw2 \"Calculator\"");
        error = "N"; //меняем значение при Делении на ноль и если введена кривая операция
        //================================================================================
        // Блок ввода данных пользователем
        //================================================================================
        System.out.println("Введите 1-е целое число:");
        String s = scan.next();
        operand1 = Integer.parseInt(s);

        System.out.println("Введите 2-е целое число:");
        operand2 = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите арфметическую операцию (+,-,*,/):");
        sign = scan.next();
        //================================================================================
        // Проверяем и обрабатываем операцию
        //================================================================================
        switch (sign) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = (float) operand1 / operand2;
                } else {
                    error = "Y"; // указываем признак о наличии ошибки
                    System.out.println("Ошибка. Деление на ноль.");
                }
                break;
            // блок по дефолту используем если введена некорректная операция
            default: {
                error = "Y";
                System.out.println("Ошибка. Введена ошибочная операция.");
            }
        }
        //================================================================================
        // Проверяем были ли ошибки, если нет выводим результат
        //================================================================================
        if (error == "N")
            System.out.println("Результат: " + operand1 + " \"" + sign + "\" " + operand2 + " = " + result);

        System.out.println("Выход. Спасибо за использование.");
    }
}
