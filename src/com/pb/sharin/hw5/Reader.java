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
    private String idCard;     //номер читательского билета
    private String fio;        //ФИО
    private String dateBirth;  //дата рождения
    private String number;     //телефон
    private String department; //факультет
    //===================================================
    //поля для хранения инф. по взятым или возвращенным данных
    //===================================================
    public int qtyTakeBook;   //кол-во взятых книг
    public int qtyReturnBook; //кол-во возвращенных книг

    //===================================================
    //Методы класса, по внесению данных
    //===================================================
    public Reader() {
        this.idCard = new String();
        this.fio = new String();
        this.dateBirth = new String();
        this.number = new String();
        this.department = new String();
        this.qtyTakeBook = 0;
        this.qtyReturnBook = 0;
    }

    //===================================================
    public Reader(String idCard, String fio, String dateBirth, String number, String department) {
        this.idCard = idCard;
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.number = number;
        this.department = department;
        this.qtyTakeBook = 0;
        this.qtyReturnBook = 0;
        readerCount++;
    }

    //===================================================
    public Reader(String idCard, String fio) {
        this.idCard = idCard;
        this.fio = fio;
        this.dateBirth = new String();
        this.number = new String();
        this.department = new String();
        this.qtyTakeBook = 0;
        this.qtyReturnBook = 0;
    }

    //===================================================
    public Reader(String idCard, String fio, String dateBirth) {
        this.idCard = idCard;
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.number = new String();
        this.department = new String();
        this.qtyTakeBook = 0;
        this.qtyReturnBook = 0;
    }

    //===================================================
    public Reader(String idCard, String fio, String dateBirth, String number) {
        this.idCard = idCard;
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.number = number;
        this.department = new String();
        this.qtyTakeBook = 0;
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
    public void printInfo() {
        String info = new String();

        if (this.fio.length() > 0) {
            //info = this.name +" ("+this.author+" "+ this.year + "г."+")";
            info = this.fio;
        }
        ;
        if (this.idCard.length() > 0) {
            info = info + " ( idCard:" + this.idCard;
        } else info = info + " ( idCard - нет";
        ;
        if (this.dateBirth.length() > 0) {
            info = info + ", " + this.dateBirth;
        } else  info = info + ", даты рождения - нет";
        ;
        if (this.number.length() > 0) {
            info = info + ", " + this.number;
        } else  info = info + ", телефон - нет";
        ;
        if (this.department.length() > 0) {
            info = info + ", " + this.department;
        } else  info = info + " ф-т - нет";
        ;
        if (this.qtyTakeBook > 0) {
            info = info + ", Книг на руках: " + this.qtyTakeBook;
        };
        if (this.qtyReturnBook > 0) {
            info = info + ", Возвращено книг:  " + this.qtyReturnBook;
        };
        info = info + ".)";
        System.out.print(info);
    }
    //===================================================
    //Методы по взятию и возврату книг
    //===================================================
    public void takeBook(int takeBook) {
        this.qtyTakeBook = this.qtyTakeBook + takeBook;
        System.out.println("---------------------------");
        System.out.println("takeBook QTY взятие " + takeBook +" книг:");
        System.out.print(getFio());
        System.out.println(" взял " + takeBook + " книги.");
    }
    //===================================================
    public void takeBook(String... nameBooks) {
        int qty = nameBooks.length;
        //проставляем кол-во взятых книг
        this.qtyTakeBook = this.qtyTakeBook + qty;
        //выводим сообщение 
        int i = 1; //переменная для проставления запятых
        System.out.println("---------------------------");
        System.out.println("takeBook NAME взятие " + qty +" книг:");
        System.out.print(getFio());
        System.out.print(" взял книги:");
        for (String nameBook : nameBooks) {
            System.out.print(" "+nameBook);
            //проверяем кол-во и в середине отделяем запятой
            if (i < qty) {
                System.out.print(",");
                i++;
            } else System.out.println(".");
        }
    }
    //===================================================
    public void takeBook(Book... books) {
        int qty = books.length;
        //проставляем кол-во взятых книг
        this.qtyTakeBook = this.qtyTakeBook + qty;
        //выводим сообщение
        int i = 1; //переменная для проставления запятых
        System.out.println("---------------------------");
        System.out.println("takeBook BOOKS взятие " + qty +" книг:");
        System.out.print(getFio());
        System.out.print(" взял книги:");
        for (Book book : books) {
            System.out.print(" ");
            book.printInfo();
            //проверяем кол-во и в середине отделяем запятой
            if (i < qty) {
                System.out.print(",");
                i++;
            } else System.out.println(".");
        }
    }
    //===================================================
    //Методы по возврату книг
    //===================================================
    public void returnBook(int qtyBook) {
        //проставляем кол-во возвращенных книг
        if (this.qtyTakeBook < qtyBook )
            System.out.println("\tВнимание!!!\nКол-во возвращенных книг больше чем взятых.");
        if (this.qtyTakeBook > 0 && qtyBook >0 && this.qtyTakeBook >= qtyBook ) {
            this.qtyReturnBook = qtyBook;
            this.qtyTakeBook   = this.qtyTakeBook - qtyBook;
        };
        System.out.println("---------------------------");
        System.out.println("returnBook QTY возврат " + qtyBook +" книг:");
        System.out.print(getFio());
        System.out.println(" вернул " + qtyBook + " книги.");
    }
    //===================================================
    public void returnBook(String... nameBooks) {
        int qty = nameBooks.length;
        //проставляем кол-во возвращенных книг
        if (this.qtyTakeBook < qty )
            System.out.println("\tВнимание!!!\nКол-во возвращенных книг больше чем взятых.");
        if (this.qtyTakeBook > 0 && qty >0 && this.qtyTakeBook >= qty ) {
            this.qtyReturnBook = qty;
            this.qtyTakeBook   = this.qtyTakeBook - qty;
        };
        //выводим сообщение
        int i = 1; //переменная для проставления запятых
        System.out.println("---------------------------");
        System.out.println("returnBook NAME возврат " + qty +" книг:");
        System.out.print(getFio());
        System.out.print(" вернул книги:");
        for (String nameBook : nameBooks) {
            System.out.print(" "+nameBook);
            //проверяем кол-во и в середине отделяем запятой
            if (i < qty) {
                System.out.print(",");
                i++;
            } else System.out.println(".");
        }
    }
    //===================================================
    public void returnBook(Book... books) {
        int qty = books.length;
        //проставляем кол-во возвращенных книг
        if (this.qtyTakeBook < qty )
            System.out.println("\tВнимание!!!\nКол-во возвращенных книг больше чем взятых.");
        if (this.qtyTakeBook > 0 && qty >0 && this.qtyTakeBook >= qty ) {
            this.qtyReturnBook = qty;
            this.qtyTakeBook   = this.qtyTakeBook - qty;
        };
        //выводим сообщение
        int i = 1; //переменная для проставления запятых
        System.out.println("---------------------------");
        System.out.println("returnBook BOOKS возврат" + qty +" книг:");
        System.out.print(getFio());
        System.out.print(" вернул книги:");
        for (Book book : books) {
            System.out.print(" ");
            book.printInfo();
            //проверяем кол-во и в середине отделяем запятой
            if (i < qty) {
                System.out.print(",");
                i++;
            } else System.out.println(".");
        }
    }

}
