package com.example.demo.models;

public enum CheeseType {
    //in enums, you call the constructor using this syntax
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");


    /*
    this will enable the enum to be created with a string name which will use the display name
     */
    private final String name;

    CheeseType(String name){
        this.name = name;
    }
}
