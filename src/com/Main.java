package com;


import java.io.File;

public class Main {


    public static void main(String[] args) {


        // Instantiation for ... GUI/ will come back to





        /* SAVING & LOADING DATA FILE "data.csv" INTO APPLICATION */

        File file = new File("resources\\data.csv");


        if (file.exists()) {

        } else {
            System.out.println("This is not here");
        }


    }

}