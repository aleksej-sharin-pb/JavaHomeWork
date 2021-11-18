package com.pb.sharin.hw8;

import java.util.Scanner;

public class OnlineShop {

    //===========================================================================
    //Метод для вывода меню и выбора пользователя
    //===========================================================================
    static int startMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("--============================================--");
        System.out.println("1. Зарегистрироваться  - нажмите \"1\".");
        System.out.println("2. Войти на сайт       - нажмите \"2\".");
        System.out.println("3. Выход из приложения - нажмите \"0\".");
        System.out.println("Сделайте Ваш выбор:");

        String userСhoice = scan.next();
        return Integer.parseInt(userСhoice);
    }

    public static void main(String[] args) throws Exception {
        //======================================================================
        System.out.println("hw8 \"Exception\"");

        Auth auth = new Auth();
        /*
        System.out.println("Проверка методов");
        //Проверка логина
        System.out.println(auth.validLogin("user1"));
        //Проверка пароля
        System.out.println(auth.validPass("qwerty_123"));
        */

        //======================================================================
        int provMenu = 0; //переменная для условия работы приложения
        int provChoice = 0; //выбор пользователя
        //======================================================================
        while (provMenu == 0) {
            provChoice = startMenu(); //получаем значение из метода для вывода меню и выбора пользователя

            if (provChoice == 0) {
                provMenu = 0;
                System.out.println("Bыход.");
                break;
            }
            if (provChoice == 1) { //регистрация
                //========================================================================
                //Вывод данных
                Scanner scan = new Scanner(System.in);
                System.out.println("Регистрация пользователя введите данные:");
                System.out.print("Логин: ");
                String login = scan.nextLine();
                System.out.print("Пароль: ");
                String password = scan.nextLine();
                System.out.print("Повторите пароль: ");
                String confirmPassword = scan.nextLine();
                //========================================================================
                //метод для проверки и регитрации пользователя
                try {
                    auth.signUp(login, password, confirmPassword);
                } catch (WrongLoginException e1) {
                    System.out.println("Измените логин. Сообщение: " + e1);
                } catch (WrongPasswordException e1) {
                    System.out.println("Измените пароль. Сообщение: " + e1);
                }
                System.out.println(auth.toString());

                continue;
            }
            if (provChoice == 2) {
                //Вывод данных
                Scanner scan = new Scanner(System.in);
                System.out.println("Вход на сайт (введите данные):");
                System.out.print("Логин: ");
                String loginIn = scan.nextLine();
                System.out.print("Пароль: ");
                String passwordIn = scan.nextLine();
                //========================================================================
                //метод для входа на сайт
                try {
                    auth.signIn(loginIn, passwordIn);
                } catch (WrongLoginException e1) {
                    System.out.println("Ошибка входа: " + e1);
                }
                continue;
            }
            System.out.println("Желаете продолжить работу?");
            continue;
        }


    }
}
