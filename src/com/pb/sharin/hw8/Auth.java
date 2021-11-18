package com.pb.sharin.hw8;

public class Auth {

    public String login;
    public String password;

    public Auth() {
        this.login = new String();
        this.password = new String();
    }

    //=====================================================================
    //проверка логина
    //=====================================================================
    public boolean validLogin(String login) throws WrongLoginException {
        String loginP = login;
        //проверка на кол-во символов
        if (loginP.length() < 5 || loginP.length() > 20) {
            System.out.println("--============================================--");
            throw new WrongLoginException("Логин должен иметь длину от 5 до 20 символов");
        }
        //проверка на символы и цифры
        boolean onlyLatinNumber = loginP.matches("^[a-zA-Z0-9]+$");

        if (onlyLatinNumber == false) {
            System.out.println("--============================================--");
            throw new WrongLoginException("Логин должен содержать только латинские буквы или цифры.");
        }
        return true;
    }

    //=====================================================================
    //проверка пароля
    //=====================================================================
    public boolean validPass(String password) throws WrongPasswordException {
        String passwordP = password;
        //проверка на кол-во символов
        if (passwordP.length() < 5) {
            System.out.println("--============================================--");
            throw new WrongPasswordException("Пароль должен иметь длину от 5 символов");
        }
        //проверка на символы и цифры
        boolean onlyLatinNumber = passwordP.matches("^[a-zA-Z0-9_]+$");

        if (onlyLatinNumber == false) {
            System.out.println("--============================================--");
            throw new WrongPasswordException("Пароль должен содержать латинские буквы или цифры, допускается знак подчеркивания");
        }
        return true;
    }
    //===================================================================================
    //регистрация
    public void signUp(String login, String password, String confirmPassword) throws Exception {
        int i = 0;
        if (validLogin(login) == true) {
            i++;
            //System.out.println("true - validLogin " + i);
        }
        if (validPass(password) == true) {
            i++;
            //System.out.println("true - validPass " + i);
        }
        if (password.compareTo(confirmPassword) == 0) {
            i++;
            //System.out.println("true - COMPARE " + i);
        } else {
            System.out.println("--============================================--");
            throw new WrongPasswordException("Пароли НЕ совпадают.");
        }
        ;

        if (i == 3) {
            this.login = login;
            this.password = password;
            System.out.println("Пользователь \"" + login + "\" успешно зарегестрирован.");
        } else System.out.println("Пользователь \"" + login + "\" НЕ зарегестрирован.");
    }
    //===================================================================================
    //вход на сайт
    public void signIn(String login, String password) throws WrongLoginException {
        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Успешный вход!");
        } else throw new WrongLoginException("Отказано. Повторите вход.");
    }

    @Override
    public String toString() {
        return "Данны о пользователе: " +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '.';
    }
}
