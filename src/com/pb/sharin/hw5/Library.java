package com.pb.sharin.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Приключения","Иванов И.И.", 2000);
        Book book2 = new Book("Словарь","Сидоров А.В.", 1980);
        Book book3 = new Book("Энциклопедия ","Гусев К.В.", 2010);

        book1.printAll();
        book2.printAll();
        book3.printAll();

        Reader reader1 = new Reader("001","Петров П.П.", "1986","0971234567","ФизМат");
        Reader reader2 = new Reader("002","Сидоров С.С.");
        Reader reader3 = new Reader("003","Дмитренко Д.Д.", "1987");

        reader1.printAll();
        reader2.printAll();
        reader3.printAll();
    }
}
