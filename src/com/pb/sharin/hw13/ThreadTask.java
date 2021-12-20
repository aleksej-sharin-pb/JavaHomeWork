package com.pb.sharin.hw13;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class ConsoleColors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}


public class ThreadTask {
    //==============================================================================
    //Класс для потока Писателя (производитель)
    //==============================================================================
    static class Writer implements Runnable {

        private final List<Integer> buffer; //массив буфер
        private long timeSleep = 1000;      //время сна по дефолту
        private String color;               //цвет потока

        //конструктор для потока
        public Writer(List<Integer> buffer, long Pause, String color) {
            this.buffer = buffer;
            this.timeSleep = Pause;
            this.color = color;
        }

        //запуск
        public void run() {
            String threadName = Thread.currentThread().getName();
            synchronized (buffer) {  //синхронизация по работе с буфером
                try {
                    int qty = 0;
                    while (qty <= 10) { //кол-во итераций по формированию данных или ожиданию
                        int seconds = new Random().nextInt(10);

                        int prov = -1; //параметр для проверки есть ли место в буфере
                        for (int i = 0; i < buffer.size(); i++) {
                            if (buffer.get(i) == 0) {
                                buffer.set(i, (int) (Math.random() * 100)); //генерируем число
                                prov = 1; //меняем признак что в буфере есть место и данные внесены
                                //сообщение что внесли значение и вывод буфера
                                System.out.println(color + threadName + " записал значение: " + ConsoleColors.ANSI_WHITE + buffer.get(i));
                                System.out.println(ConsoleColors.ANSI_BLUE + buffer);
                                break;
                            }
                        }
                        //если параметр не менялся - буфер полон ждем поток для Читателя
                        if (prov == -1) {
                            System.out.println(color + "Буфер полон, Производитель " + ConsoleColors.ANSI_PURPLE + "ждет 3 сек.");

                            buffer.notify();
                            buffer.wait(4000);
                        } else {
                            Thread.sleep(seconds * timeSleep);
                            buffer.wait(timeSleep);
                        }
                        qty++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //По завершении работы выводим сообщение об окончании работы Писателя-Производителя
                    System.out.println(color + threadName + ConsoleColors.ANSI_RED + " процесс завершен.");
                }
            }
        }
    }

    //==============================================================================
    //Класс для потока Читателя (потребитель)
    //==============================================================================
    static class Reader implements Runnable {

        private final List<Integer> buffer; //массив буфер
        private long timeSleep = 1000;      //время сна по дефолту
        private String color;               //цвет потока

        //конструктор для потока
        public Reader(List<Integer> buffer, long Pause, String color) {
            this.buffer = buffer;
            this.timeSleep = Pause;
            this.color = color;
        }

        //описание работы потока
        public void run() {
            String threadName = Thread.currentThread().getName();
            synchronized (buffer) { //синхронизируемся по работе с буфером
                try {
                    int qty = 0;
                    while (qty <= 10) { //кол-во циклов "жизни" потока
                        int seconds = new Random().nextInt(10);

                        int prov = -1; //переменная для проверки есть ли значения или буфер пустой
                        for (int i = 0; i < buffer.size(); i++) {
                            if (buffer.get(i) != 0) {
                                //если значение есть выводим сообщение со значением и буфер
                                System.out.println(color + threadName + " считал значение: " + ConsoleColors.ANSI_GREEN + buffer.get(i));
                                buffer.set(i, 0);
                                prov = 1;
                                System.out.println(ConsoleColors.ANSI_CYAN + buffer);
                                break;
                            }
                        }
                        //если параметр не менялся - значений нет - буфер пустой, ждем поток Писателя (производителя)
                        if (prov == -1) {
                            System.out.println(color + "Буфер пустой, Читатель " + ConsoleColors.ANSI_PURPLE + "ждет 3 сек.");
                            buffer.notify();
                            buffer.wait(2000);
                        } else {
                            Thread.sleep(seconds * timeSleep);
                            buffer.wait(timeSleep);
                        }
                        qty++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //По завершению работы сообщение что процесс Читателя (потребителя) завершил работу
                    System.out.println(color + threadName + ConsoleColors.ANSI_RED + " процесс завершен.");
                }
            }
        }
    }

    //==============================================================================
    //Основной метод для демонстрации работы потоков Писателя (производителя) и Читателя (потребителя)
    //==============================================================================
    public static void main(String[] args) {

        //буффер для работы Производителя и Потребителя
        //Создаем массив из 5-ти елементов
        List<Integer> buffers = Arrays.asList(0, 0, 0, 0, 0);

        //Печатаем значения пустого буфера
        System.out.println("Наш пустой буффер: " + buffers);

        //Создаем процессы Читателя (потребителя) и Писателя (производителя)
        Thread reader = new Thread(new Reader(buffers, 800, ConsoleColors.ANSI_YELLOW));
        Thread writer = new Thread(new Writer(buffers, 100, ConsoleColors.ANSI_GREEN));

        //запускаем процессы
        writer.start();
        reader.start();

        //сообщение что процессы стартовал, а программа отработала
        System.out.println("Стартовали" + ConsoleColors.ANSI_GREEN + " <Производитель> " + ConsoleColors.ANSI_RESET + "и" + ConsoleColors.ANSI_YELLOW + " <Потребитель>");
    }
}
