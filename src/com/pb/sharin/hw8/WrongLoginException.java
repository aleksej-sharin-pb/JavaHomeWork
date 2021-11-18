package com.pb.sharin.hw8;

public class WrongLoginException extends Exception{

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
        System.out.println("Ошибка регистрации или входа логина." );
    }
}
