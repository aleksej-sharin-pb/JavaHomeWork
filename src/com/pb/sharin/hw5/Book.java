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
    private String name;   //название
    private String author; //автор книги
    private int    year;   //год издания
    //===================================================
    public Book() {
        this.name   = new String();
        this.author = new String();
        this.year   = 0;
    }
    //===================================================
    //Методы класса, по внесению данных
    //===================================================
    public Book(String name, String author, int year) {
        this.name   = name;
        this.author = author;
        this.year   = year;
    }
    //===================================================
    public Book(String name, String author) {
        this.name   = name;
        this.author = author;
        this.year   = year;
    }
    //===================================================
    public Book(String name) {
        this.name   = name;
        this.author = new String();
        this.year   = 0;
    }
    //===================================================
    //Методы "Гетеры"
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
    //Методы "Сетеры"
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
    //Вывод данных
    //===================================================
    public void printInfo() {
        String info = new String();
        if (this.name.length() > 0) {
            //info = this.name +" ("+this.author+" "+ this.year + "г."+")";
            info = this.name;
        }
        ;
        if (this.author.length() > 0) {
            info = info + " (" + this.author;
        } else info = info + " (Автор не указан";
        ;
        if (this.year > 0) {
            info = info + " " + this.year + "г."+")";
        } else  info = info + " Год не указан)";
        ;
        System.out.print(info);
    }
}