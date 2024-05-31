package com.kevinolarte.lib;

import net.datafaker.Faker;

public class LibConf {
    @SuppressWarnings("deprecation")
    public static Faker faker= new Faker(new java.util.Locale("es"));
    //Faker fakerEs = new Faker(new java.util.Locale("es"));
    public static void sleep(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
