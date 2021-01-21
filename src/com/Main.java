package com;


public class Main {

    public static void main(String[] args) {

        // Instantiation of LoginCredentials Class
    LoginCredentials loginCredentials = new LoginCredentials();

    AdminPage adminPage = new AdminPage(loginCredentials.getLoginInfo());

    }

}