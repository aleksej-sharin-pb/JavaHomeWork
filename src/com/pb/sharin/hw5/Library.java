package com.pb.sharin.hw5;

public class Library {
    //=====================================================================
    //метод для печати всех книг
    //=====================================================================
    public static void printBooks(Book... books) {
        int qty = books.length;
        //выводим сообщение
        int i = 1; //переменная для проставления разделителей
        System.out.println("---------------------------");
        System.out.println("Список библиотчных книг (всего "+ qty + "):");

        for (Book book : books) {
            System.out.print( i +". ");
            book.printInfo();
            //проверяем кол-во и в середине отделяем запятой
            if (i < qty) {
                System.out.println(";");
                i++;
            } else System.out.println(".");
        }
    }
    //=====================================================================
    //метод для печати всех читателей
    //=====================================================================
    public static void printReaders(Reader... readers) {
        int qty = readers.length;
        //выводим сообщение
        int i = 1; //переменная для проставления разделителей
        System.out.println("---------------------------");
        System.out.println("Список пользователей (всего "+ qty + "):");

        for (Reader reader : readers) {
            System.out.print( i +". ");
            reader.printInfo();
            //проверяем кол-во и в середине отделяем запятой
            if (i < qty) {
                System.out.println(";");
                i++;
            } else System.out.println(".");
        }
    }
    //=====================================================================
    //Основная программа
    //=====================================================================
    public static void main(String[] args) {
        //Создаем книги
        Book book1 = new Book("Приключения", "Иванов И.И.", 2000);
        Book book2 = new Book("Словарь", "Сидоров А.В.", 1980);
        Book book3 = new Book("Энциклопедия", "Гусев К.В.", 2010);
        Book book4 = new Book("Сказки");
        //Создаем читателей
        Reader reader1 = new Reader("001", "Петров П.П.", "11.11.1986", "0971234567", "ФизМат");
        Reader reader2 = new Reader("002", "Сидоров С.С.");
        Reader reader3 = new Reader("003", "Дмитренко Д.Д.", "01.12.1987");
        Reader reader4 = new Reader("003", "Иванов И.И.");
        //========================================================================
        //Манипуляция с данными
        //демонстрируется работа всех вариантов методов takeBook()
        reader1.takeBook(3);
        reader2.takeBook(book1.getName(), book2.getName(), book3.getName());
        reader3.takeBook(book1, book2, book3);

        //демонстрируется работа всех вариантов методов returnBook()
        reader1.returnBook(1);
        reader2.returnBook(book1.getName(), book2.getName());
        reader3.returnBook(book1, book2, book3);
        //========================================================================
        //Печатаются все книги
        printBooks(book1, book2, book3, book4);
        //Печатаются все читатели
        printReaders(reader1,reader2,reader3,reader4);
    }
}
