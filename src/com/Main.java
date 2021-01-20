package com;


import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

    LoginCredentials loginCredentials = new LoginCredentials();


    AdminPage adminPage = new AdminPage(loginCredentials.getLoginInfo());


    }

}