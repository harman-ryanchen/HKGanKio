package com.example.ryan.hkgankio.bean;

/**
 * Created by studio02 on 10/10/16.
 */

public class Persion {
    private String name;
    private int age;
    private String[] hobbies = new String[]{"KENDO","SWIMING","SPORTCAR"};

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }
}
