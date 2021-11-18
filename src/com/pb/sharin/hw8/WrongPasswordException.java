package com.pb.sharin.hw8;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
        System.out.println("Ошибка регистрации пароля.");
    }
}
