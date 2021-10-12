package com.pb.sharin.work1;

import java.util.Scanner;

public class practis {
    public static void main(
            String[] args) {
        /* char a = 'A';
        int d = 5;
        int b = 10;
        int c = 20;

        System.out.println("c == b " + (c == b)); //инкремент

        System.out.println("char a " + a + (d++)); //инкремент
        System.out.println("d " + (d)); //инкремент
        */

/*
        String login = "Admin";
        String password = "password";

        Scanner in = new Scanner(System.in);
        System.out.println("Введите что-то: ");
        //int user_in = in.nextInt();
        String user_in = in.next();

        if(login.equals(user_in)) {
            System.out.println("Добро пожаловать");
        }
        else { System.out.println("Кто это?"); }
        System.out.println(user_in);
        */


        Scanner scan = new Scanner(System.in);
                int x, y;
        String symbol;
        System.out.println("Введите X:");
        String s = scan.next();
        x = Integer.parseInt(s);

        System.out.println("Введите Y:");
        y = scan.nextInt();
    //scan.nextLine();
        System.out.println("Введите Описание:");
        symbol = scan.next();

        System.out.println("X = " + x + " Y = " + y + " = " + (x+y) + " SYMBOL = " + symbol);

        // System.out.println("Test practis!");
    }
}
