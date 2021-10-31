package com.pb.sharin.hw5;

/*
Класс Book хранит такую информацию о книге:
- название
- автор книги
- год издания
 */
public class Book {

    //===================================================
    //Переменные класса
    //===================================================
    public String name;   //название
    public String author; //автор книги
    public int    year;      //год издания
    public String idCard; //номер читательского билета, кто взял книгу

    //===================================================
    public Book() {
        this.name   = new String();
        this.author = new String();
        this.year   = 0;
        this.idCard = new String();
    }
    //===================================================
    //Методы класса, по внесению данных
    //===================================================
    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year  = year;
        this.idCard = new String();
    }
    //===================================================
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.year  = year;
        this.idCard = new String();
    }
    //===================================================
    public Book(String name) {
        this.name = name;
        this.author = new String();
        this.year   = 0;
        this.idCard = new String();
    }
    //===================================================
    //Методы по получению информации
    //===================================================
    public String getName() {
        return name;
    }
    //===================================================
    public String getAuthor() {
        return author;
    }
    //===================================================
    public int getYear() {
        return year;
    }
    //===================================================
    public String getIdCard() {
        return idCard;
    }
    //===================================================
    //Методы по установке значений
    //===================================================
    public void setName(String name) {
        this.name = name;
    }
    //===================================================
    public void setAuthor(String author) {
        this.author = author;
    }
    //===================================================
    public void setYear(int year) {
        this.year = year;
    }
    //===================================================
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    //===================================================
    //Вывод данных
    //===================================================
    public void printAll() {
        System.out.println("Информиция по книге:");
        if (this.name.length() > 0) {
            System.out.println("Название:" + this.name);
        }
        ;
        if (this.author.length() > 0) {
            System.out.println("Автор:" + this.author);
        } else System.out.println("Автор не указан.");
        ;
        if (this.year > 0) {
            System.out.println("Год:  " + this.year + "г.");
        } else System.out.println("Год не указан.");
        ;
        if (this.idCard.length() > 0) {
            System.out.println("Находится у пользователя с номером читательского :" + this.idCard);
        }
        System.out.println("Находится на полке.");
    }
}