package com.pb.sharin.hw5;

/*
Класс Reader хранит такую информацию о пользователе библиотеки:
- ФИО
- номер читательского билета
- факультет
- дата рождения
- телефон
Типы полей выбирать на свое усмотрение.
Имеет перегруженные методы takeBook(), returnBook():
 */
public class Reader {
    private static int readerCount = 0;
    //===================================================
    //Переменные класса
    //===================================================
    public String idCard;     //номер читательского билета
    public String fio;        //ФИО
    public String dateBirth;  //дата рождения
    public String number;     //телефон
    public String department; //факультет
    //===================================================
    //поля для хранения инф. по взятым или возвращенным данных
    //===================================================
    public int qtyTakeBook;   //кол-во взятых книг
    public int qtyReturnBook; //кол-во возвращенных книг
    //===================================================
    //Методы класса, по внесению данных
    //===================================================
    public Reader() {
        this.idCard        = new String();
        this.fio           = new String();
        this.dateBirth     = new String();
        this.number        = new String();
        this.department    = new String();
        this.qtyTakeBook   = 0;
        this.qtyReturnBook = 0;
    }
    //===================================================
    public Reader(String idCard, String fio, String dateBirth, String number, String department) {
        this.idCard        = idCard;
        this.fio           = fio;
        this.dateBirth     = dateBirth;
        this.number        = number;
        this.department    = department;
        this.qtyTakeBook   = 0;
        this.qtyReturnBook = 0;
        readerCount++;
    }
    //===================================================
    public Reader(String idCard, String fio) {
        this.idCard = idCard;
        this.fio    = fio;
        this.dateBirth     = new String();
        this.number        = new String();
        this.department    = new String();
        this.qtyTakeBook   = 0;
        this.qtyReturnBook = 0;
    }
    //===================================================
    public Reader(String idCard, String fio, String dateBirth) {
        this.idCard    = idCard;
        this.fio       = fio;
        this.dateBirth = dateBirth;
        this.number        = new String();
        this.department    = new String();
        this.qtyTakeBook   = 0;
        this.qtyReturnBook = 0;
    }
    //===================================================
    public Reader(String idCard, String fio, String dateBirth, String number) {
        this.idCard    = idCard;
        this.fio       = fio;
        this.dateBirth = dateBirth;
        this.number    = number;
        this.department    = new String();
        this.qtyTakeBook   = 0;
        this.qtyReturnBook = 0;
    }
    //===================================================
    //Методы по получению информации о пользователе
    //===================================================
    public static int getReaderCount() {
        return readerCount;
    }
    //===================================================
    public String getIdCard() {
        return this.idCard;
    }
    //===================================================
    public String getFio() {
        return this.fio;
    }
    //===================================================
    public String getDateBirth() {
        return this.dateBirth;
    }
    //===================================================
    public String getNumber() {
        return this.number;
    }
    //===================================================
    public String getDepartment() {
        return this.department;
    }
    //===================================================
    //Методы по установке значений пользователя
    //===================================================
    public void setFio(String fio) {
        this.fio = fio;
    }
    //===================================================
    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    //===================================================
    public void setNumber(String number) {
        this.number = number;
    }
    //===================================================
    public void setDepartment(String department) {
        this.department = department;
    }
    //===================================================
    //Вывод данных
    //===================================================
    public void printAll() {
        System.out.println("Информиция о читателе:");
        System.out.println("Номер читательского билета:"+this.idCard);
        System.out.println("ФИО:                       "+this.fio);
        if (this.dateBirth.length() > 0) {
            System.out.println("Дата рождения:             " + this.dateBirth);
        } else System.out.println("Дата не указана.");
        ;
        if (this.number.length() > 0) {
            System.out.println("Tелефон:                   " + this.number);
        } else System.out.println("Tелефон не указан.");
        ;
        if (this.department.length() > 0) {
            System.out.println("Факультет:                 " + this.department);
        } else System.out.println("Факультет не указан.");
        ;
        if(this.qtyTakeBook > 0 ) {
            System.out.println("На руках :  "     +this.qtyTakeBook   + " книг.");
            System.out.println("Возвращено :"     +this.qtyReturnBook + " книг.");
        }
        System.out.println("На руках нет книг.");
    }
    //===================================================
    //Методы по взятию и возврату книг
    //===================================================
    public void takeBook(int takeBook) {
        this.qtyTakeBook = this.qtyTakeBook + takeBook;
        getFio(); System.out.print("взял " + takeBook + " книги.");
    }
    //===================================================
    public void returnBook(int returnBook) {
        this.qtyReturnBook = returnBook;
        getFio(); System.out.print(" вернул " + returnBook + " книг.");
    }
}
