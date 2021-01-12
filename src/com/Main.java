package com;



public class Main {


    public static void main(String[] args) {

    LoginCredentials loginCredentials = new LoginCredentials();



    AdminPage adminPage = new AdminPage(loginCredentials.getLoginInfo());

    }

}