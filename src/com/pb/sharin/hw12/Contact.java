package com.pb.sharin.hw12;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Contact {

    public String fio;
    //Для мап и серриализации данных
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    public transient LocalDate dateOfBirth;
    public List<String> phone = new ArrayList<>();
    public String address;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private transient LocalDateTime dateOfEditing = LocalDateTime.now();

    //Конструкторы
    public Contact() {
    }

    public Contact(String fio, String address) {
        this.fio = fio;
        this.address = address;
        this.dateOfEditing = LocalDateTime.now();
    }

    public Contact(String fio, LocalDate dateOfBirth, String address) {
        this.fio = fio;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEditing = LocalDateTime.now();
    }

    public Contact(String fio,  LocalDate dateOfBirth, List<String> phone, String address) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;

    }
    public Contact(String fio,  LocalDate dateOfBirth, List<String> phone, String address, LocalDateTime dateOfEditing) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.dateOfEditing = dateOfEditing;
    }
    //Гетеры и сеттеры
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {

        this.fio = fio;
        this.dateOfEditing = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.dateOfEditing = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfEditing = LocalDateTime.now();
    }

    public String getPhone() {
        if(phone.toString() == null) {
        String str = new String("нет");
        return str.toString();
        }
        return phone.toString();
    }

    public void setPhone(String phone) {
        this.phone.add(phone);
    }

    @Override
    public String toString() {
        return "\nContact{" +
                "FIO: '" + fio + '\'' +
                ", dateOfBirth: " + dateOfBirth +
                ", phone: " + phone +
                ", address: '" + address + '\'' +
                ", dateOfEditing: " + dateOfEditing +
                "}";
    }


    //Информация по контакту
    public void print() {
        System.out.println("-------------------------------------" +
                "\n\tФИО: '" + fio + '\'' +
                ", \n\tДата рождения: " + dateOfBirth +
                ", \n\tТелефон: " + phone +
                ", \n\tАдрес: '" + address + '\'' +
                ", \n\tВремя редактирования: " + dateOfEditing +
                ".");
    }

}
